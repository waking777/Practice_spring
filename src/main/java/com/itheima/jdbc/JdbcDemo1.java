package com.itheima.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 程序的耦合
 *       耦合：程序间的依赖关系
 *         包括：
 *              类之间的依赖
 *              方法间的依赖
 *       解耦：降低程序间的依赖关系
 */
public class JdbcDemo1 {
    public static void main(String[] args) throws Exception {
        //1.注册驱动
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //2.获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice_spring", "root", "root");
        //3.获取数据库预处理对象
        PreparedStatement pstm = conn.prepareStatement("select * from account");
        //4.执行sql，得到结果集
        ResultSet rs = pstm.executeQuery();
        //5.遍历结果集
        while(rs.next()){
            System.out.println(rs.getString("name"));
        }
        //6.释放资源
        rs.close();
        pstm.close();
        conn.close();
    }
}
