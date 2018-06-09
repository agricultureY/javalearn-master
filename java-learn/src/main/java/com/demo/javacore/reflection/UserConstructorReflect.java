package com.demo.javacore.reflection;

import java.lang.reflect.Constructor;

/**
 * 利用反射通过构造器创建一个实例
 * @author ycn
 */
public class UserConstructorReflect {
	
	public static void main(String[] args) throws Exception {
		Class<?> userClass = User.class;//获取user类型
		Constructor<?> constructor = userClass.getConstructor();//获取默认构造器
		Constructor<?> intConstructor = userClass.getConstructor(int.class);//获取ID构造器
		Constructor<?> bothConstructor = userClass.getConstructor(int.class,String.class);//含参构造器
		System.out.println(((User) constructor.newInstance()).toString());
		System.out.println(((User) intConstructor.newInstance(1)).toString());
		System.out.println(((User) bothConstructor.newInstance(2,"admin")).toString());
	}
}

class User{
	private int id;
	private String name;
	
	// 无参构造器（默认构造器）
	public User() {
	}

	public User(int id) {
		this.id = id;
	}

	public User(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
}
