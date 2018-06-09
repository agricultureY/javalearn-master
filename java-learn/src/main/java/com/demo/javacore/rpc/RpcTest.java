package com.demo.javacore.rpc;

import java.net.InetSocketAddress;

/**
 * Rpc测试类
 * @author ycn
 */
public class RpcTest {

	public static void main(String[] args) {
		//启动服务提供者
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					RpcExporter.exporter("localhost",8088);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
		//创建本地服务代理
		RpcImporter<EchoService> importer = new RpcImporter<>();
		//从本地服务代理获取服务对象类
		EchoService echoService = importer.importer(EchoServiceImpl.class, new InetSocketAddress("localhost", 8088));
		System.out.println(echoService.echo("are you ok?"));
	}
}
