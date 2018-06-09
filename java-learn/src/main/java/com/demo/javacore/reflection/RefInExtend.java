package com.demo.javacore.reflection;
/**
 * 反射在继承中的应用
 * @author yy
 */
public class RefInExtend {

	public static void main(String[] args) {
		Employee emp = new Employee("employee");
		Employee man = new Manager("boss");
		System.out.println(emp.getClass().getName()+"--"+emp.getName());
		System.out.println(man.getClass().getName()+"--"+man.getName());
	}
}

class Employee {
    private String name;
    public Employee(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
class Manager extends Employee {
    public Manager(String name) {
        super(name);
    }
}
