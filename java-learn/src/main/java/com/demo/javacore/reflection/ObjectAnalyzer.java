package com.demo.javacore.reflection;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/**
 * 反射对象分析工具类
 * @author yy
 */
public class ObjectAnalyzer {
	private static ArrayList<Object> visited = new ArrayList<>();

    public static String toString(Object obj){
        if (obj == null) return "null";
        if (visited.contains(obj)) return "...";
        visited.add(obj);

        // 获取Class对象
        Class cl = obj.getClass();
        if (cl == String.class) return (String)obj;
        // 如果对象是一个数组类
        if (cl.isArray()){
            // 获取数组组件
            String r = cl.getComponentType() + "[]{";
            for (int i = 0; i < Array.getLength(obj); i++) {
                if (i > 0) r += ",";
                Object val = Array.get(obj,i);
                // 是否是一个基本类型
                if (cl.getComponentType().isPrimitive())
                    r += val;
                else  r += toString(val);
            }
            return r + "}";
        }

        String r =cl.getName();
        do {
            r += "[";
            Field[] fields = cl.getDeclaredFields();
            AccessibleObject.setAccessible(fields,true);
            for (Field f : fields){
                if (!Modifier.isStatic(f.getModifiers())){
                    r += f.getName() + "=";
                    try {
                        Class t = f.getType();
                        Object val = f.get(obj);
                        if (t.isPrimitive())
                            r += val;
                        else
                            r +=toString(val);
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
            r += "]";
            cl = cl.getSuperclass();
        } while (cl != null);

        return r;
    }
}
