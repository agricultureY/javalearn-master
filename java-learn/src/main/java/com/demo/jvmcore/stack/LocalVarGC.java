package com.demo.jvmcore.stack;
/**
 * 打印GC信息
 * 	-XX:+PrintGCDetails
 * 
 * @Package: com.demo.jvmcore.stack
 * @author: ycn
 * @date: 2018年7月27日 下午2:20:27
 */
public class LocalVarGC {

    public void localVarGc1(){
        byte[] bytes = new byte[ 6 * 1024 * 1024];
        System.gc();
    }

    public void localVarGc2(){
        byte[] bytes = new byte[ 6 * 1024 * 1024];
        bytes = null;
        System.gc();
    }

    public void localVarGc3(){
        {
            byte[] bytes = new byte[ 6 * 1024 * 1024];
        }
        System.gc();
    }

    public void localVarGc4(){
        {
            byte[] bytes = new byte[ 6 * 1024 * 1024];
        }
        int a = 4;
        System.gc();
    }

    public void localVarGc5(){
        localVarGc1();
        System.gc();
    }

    public static void main(String[] args) {
        LocalVarGC ins = new LocalVarGC();
//      ins.localVarGc1();
//      ins.localVarGc2();
//      ins.localVarGc3();
//      ins.localVarGc4();
        ins.localVarGc5();
    }
}
