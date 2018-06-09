package com.demo.javacore.rpc;
/**
 * echo实现类
 * @author ycn
 */
public class EchoServiceImpl implements EchoService {

	@Override
	public String echo(String ping) {
		return ping == null?ping+"i am not ok!":"i am ok!";
	}

}
