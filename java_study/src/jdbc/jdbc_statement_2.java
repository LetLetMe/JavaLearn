package jdbc;

// import java.beans.Statement;//这里可能有出入？ 
// import java.sql.Connection;
// import java.sql.DriverManager;//记得导入
// import java.sql.Statement;
import java.sql.*;//直接导入全部

public class jdbc_statement_2 {
    public static void main(String[] arfs){
        Connection conn=null;
        Statement stmt=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/fanqi"+"?serverTimezone=UTC";
            conn=DriverManager.getConnection(url,"root","password");
            
            stmt=conn.createStatement();//这个不常用就是因为sql注入
            
            String id="4 or 1=1";//sql注入？？？amazing
            //这样写即使数据库没有id=4的也可以删除!!
            //这样搞那就总可以执行了
            String sq1="delete from fanqi2 where q="+id;//都是提交一个字符串
            stmt.execute(sq1); //记得提交 
            System.out.println("success excute");
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