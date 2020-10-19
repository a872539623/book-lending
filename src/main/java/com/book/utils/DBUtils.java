package com.book.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {
    private static String className = null;
    private static String url = null;
    private static String username = null;
    private static String password = null;

    static{
        try {
            //给className，url，username，password进行赋值
            Properties properties = new Properties();
            properties.load(DBUtils.class.getClassLoader().getResourceAsStream("jdbc.properties"));
            className = properties.getProperty("className");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //获取连接对象
    public static Connection getConnection(){
        Connection conn = null;
        try {
            //1.加载驱动
            Class.forName(className);
            //2.通过 DriverManager 获取 Connection 对象
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    //释放资源
    public static void closeAll(AutoCloseable ... closeables){
        for (AutoCloseable closeable:closeables) {
            if(closeable != null){
                try {
                    closeable.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}