package 实验九;

import java.sql.DriverManager;
import java.sql.*;
import java.sql.*;
/*实验名称：《实验九 JDBC数据库操作的应用》时间：2022.6.2
实验地点：信控楼406+412机房
实验目的及要求：掌握JDBC连接数据库的方法
实验内容：
1、创建一个名为OrderBook的数据库(Access或MySQL)，数据库中有一个表BookList，表结构如下： 2、参照课本404页例14.6，
编写一个Query类来查询数据库(Access或MySQL)。
3、参照课本404页例14.6，编写主类，主类运行时用户从命令行输入数据库名和表名，应用Query类查询表中所有数据，程序将查询到的信息显示在屏幕上。
*/


public class TestConSQL {
    public static void main(String[] args) {
    Query("D:\\.doc\\试验.accdb","BookList");
       
    }
    static void Query(String a,String b) {
    try {
        Class.forName("com.hxtt.sql.access.AccessDriver");//导入Access驱动文件，本质是.class文件
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    try {
        Connection con = DriverManager.getConnection("jdbc:Access:///"+a,"","");
        //与数据库建立连接，getConnection()方法第一个参数为jdbc:Access:///+文件总路径,第二个参数是用户名，第三个参数是密码（Access是没有用户名和密码此处为空字符串）
        Statement sta = con.createStatement();
        ResultSet res = sta.executeQuery("select * from "+b);
        //向数据库发送executeQuery()方法的数据库语句，对数据库返回的结果放到ResultSet里面
        //注意一定要保证数据库语句的正确性
        while(res.next()){//不断的移动光标到下一个数据
            System.out.println(res.getString(1)+"  "+res.getString(2)+"  "+res.getString(3)+"  "+res.getString(4)+" "+res.getString(5));
            //注意如果年龄为数值，需要getInt()
        }
        con.close();//关闭数据库连接
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }
}
