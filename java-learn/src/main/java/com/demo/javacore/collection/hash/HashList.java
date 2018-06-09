package com.demo.javacore.collection.hash;

import java.util.ArrayList;
import java.util.List;

public class HashList {

	public static void main(String[] args) {
		List<SkuObj> reqSkuObjList = new ArrayList<>();
        List<SkuObj> existSkuObjList = new ArrayList<>();
        
        for (int i = 0 ; i < 5000; i++) {
            SkuObj skuObj = new SkuObj();
            skuObj.setId(i);
            skuObj.setName("name" + i);
            skuObj.setAge(i + 666);
            skuObj.setDesc("desc" + i);
            reqSkuObjList.add(skuObj);
        }

        for (int i = 0 ; i < 5000; i++) {
            SkuObj skuObj = new SkuObj();
            skuObj.setId(i);
            skuObj.setName("nameexist" + i);
            skuObj.setAge(i + 888);
            skuObj.setDesc("descexist" + i);
            existSkuObjList.add(skuObj);
        }
	}
}

class SkuObj{
	Integer id;

    String name;

    Integer age;

    String desc;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
