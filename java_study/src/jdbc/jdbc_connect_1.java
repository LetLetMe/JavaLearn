package jdbc;
import java.sql.*;
public class jdbc_connect_1{
    public static void main(String[] args) {
        Connection conn=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            long start =System.currentTimeMillis();
            //建立连接是比较耗时的！
            String url="jdbc:mysql://localhost:3306/fanqi"+"?serverTimezone=UTC";
            //加载驱动和建立连接是俩个不同的字符串
            conn=DriverManager.getConnection(url,"root","password");
            long end=System.currentTimeMillis();
            System.out.println(conn);
            System.out.println("连接耗时"+(end-start));
            /*这里如果输出时间差的话1.前边要加字符串 这样才会自动转换
            2.后边要加括号
            3.这里注意别减反了（否则得个负数）*/
        
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{/*1.都要加finally 2.记得关闭连接*/
            try{
                if(conn!=null){//注意if的语法 不需要加冒号的
                    //java都不需要加":" 只需要加大括号（语法块）
                    conn.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
}