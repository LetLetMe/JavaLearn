package jdbc;
import java.sql.*;
public class jdbc_batch_5{//batch就是批处理的意思
    public static void main(String[] args) {
    Connection conn=null;
    Statement stmt=null;
    ResultSet re=null;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/fanqi"+"?serverTimezone=UTC";
        conn=DriverManager.getConnection(url, "root", "password");
        conn.setAutoCommit(false);

        stmt=conn.createStatement();
        for(int i=0;i<10;i++){
            String sq1="insert into fanqi2(q,i) values("+i+",1)";
            stmt.addBatch(sq1);    
        }
        stmt.executeBatch();
        conn.commit();//提交事务
    } catch(ClassNotFoundException e){
        e.printStackTrace();
    }catch(SQLException e){
        e.printStackTrace();
    }finally{
        try{
            if(conn!=null){
                conn.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        try{
            if(stmt!=null);{
                stmt.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    }
}