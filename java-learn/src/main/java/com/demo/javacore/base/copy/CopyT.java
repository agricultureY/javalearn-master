package com.demo.javacore.base.copy;
/**
 * java拷贝  深度拷贝与浅拷贝
 * @author yy
 */
public class CopyT {

	public static void main(String[] args) {
		Family family = new Family();
        family.setName("Jeff Family");
        
        Student student1 = new Student();
        student1.setFamily(family);
        student1.setName("Jeff");
        Student student2 = (Student) student1.clone();
        student2.setName("Jeff2");
        student2.getFamily().setName("Jeff2 Family");
        
        System.out.println(student1.getName() + " -- " + student1.getFamily().getName());
        System.out.println(student2.getName() + " -- " + student2.getFamily().getName());
	}
}

class Family implements Cloneable{
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 深度克隆
	 */
	/*@Override
	protected Object clone() {
		Object o = null;
        try {
            o = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return o;
	}*/
}

class Student implements Cloneable{
	private String name;
	private Family family;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Family getFamily() {
		return family;
	}
	public void setFamily(Family family) {
		this.family = family;
	}
	
	/**
	 * 深度克隆
	 */
	/*@Override
	protected Object clone(){
		Student o = null;
		try {
			o = (Student) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		o.family = (Family) family.clone();
		return o;
	}*/
	
	/**
	 * 浅拷贝 对其对象的引用却没有拷贝
	 */
	@Override
	protected Object clone() {
		Object o = null;
		try {
			o = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return o;
	}
}
