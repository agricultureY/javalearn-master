package com.demo.javacore.rpc;
/**
 * RPC服务发布者
 * @author ycn
 */

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class RpcExporter {

	//创建线程池
	static Executor executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
	
	public static void exporter(String hostName,int port) throws IOException{
		ServerSocket socket = new ServerSocket();
		socket.bind(new InetSocketAddress(hostName, port));
		try {
			/*
			 * 监听client的TCP连接,将其封装成Task,有线程执行
			 */
			while (true) {
				executor.execute(new ExecutorTask(socket.accept()));
			}
		} finally {
			socket.close();
		}
	}
	
	/**
	 * 线程Task
	 * 1、将客户端发送的二进制流反序列化成对象，反射调用服务实现着，获取执行结果
	 * 2、将执行结果反序列化，通过Socket发送给客户端
	 * 3、远程服务调用完成之后，释放Socket等连接资源，防止句柄泄露
	 * @author ycn
	 */
	private static class ExecutorTask implements Runnable{

		Socket client = null;
		public ExecutorTask(Socket accept) {
			this.client = accept;
		}
		
		@Override
		public void run() {
			ObjectInputStream ois = null;
			ObjectOutputStream oos = null;
			try {
				//对象输入流
				ois = new ObjectInputStream(client.getInputStream());
				//获取接口名
				String interfaceName = ois.readUTF();
				//获取方法名
				String methodName = ois.readUTF();
				//获取方法的参数数组
				Class<?>[] paramTypes = (Class<?>[]) ois.readObject();
				//获取传入参数对象数组
				Object[] arguments = (Object[]) ois.readObject();
				//获取服务对象类
				Class<?> service = Class.forName(interfaceName);
				//获取服务方法
				Method method = service.getMethod(methodName, paramTypes);
				//获取服务返回对象
				Object result = method.invoke(service.newInstance(), arguments);
				//对象输出流
				oos = new ObjectOutputStream(client.getOutputStream());
				oos.writeObject(result);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				 // 关闭流的操作
                if (oos != null) {
                    try {
                        oos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (ois != null) {
                    try {
                        ois.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (client != null) {
                    try {
                        client.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
			}
		}
		
	}
}
