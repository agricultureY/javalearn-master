package com.demo.javacore.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * mysql数据库连接测试
 * @author ycn
 */
public class MySqlConnection {
	
	//数据库连接驱动
	private static String driver = "com.mysql.jdbc.Driver";
	//数据库链接地址
	private static String url = "jdbc:mysql://localhost:3306/test?useSSL=false";
	//用户名
	private static String userName = "root";
	//密码
	private static String pwd = "root";
	
	/**
	 * 获取connection对象
	 * @return
	 */
	public static Connection getConnection() throws Exception {
		//声明connection对象
		Connection conn = null;
		//加载驱动
		Class.forName(driver);
		//连接数据库
		conn = DriverManager.getConnection(url, userName, pwd);
		return conn;
	}
	
	/**
	 * 获取statement对象
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public static Statement getStatement(Connection conn) throws Exception {
		return conn.createStatement();
	}
	
	/**
	 * 关闭connection连接
	 * @param conn
	 * @throws Exception
	 */
	public static void closeConnection(Statement statement,Connection conn) throws Exception{
		if(null != statement)
			statement.close();
		if(null != conn)
			conn.close();
	}

	public static void main(String[] args) {
		
	}
}
