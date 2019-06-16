package jdbc;
import java.sql.*;
public class jdbc_preparestatement_3{
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/fanqi"+"?serverTimezone=UTC";
            conn=DriverManager.getConnection(url,"root","password");
            String sq1="insert into fanqi2(q,i) values(?,?)";
            ps=conn.prepareStatement(sq1);//1.都是conn的子对象 要加上conn  2.方法名和类名不一样！
            ps.setObject(1, 2);
            ps.setObject(2, 2.2);
            ps.execute();//记得提交

            // ps.setObject(3, new java.sql.Date(System.currentTimeMillis()));
            /*1.这里要加new 相当于生成一个临时的对象
            2.前边导入java.sql.*以后这里可以只用Date*/
            System.out.println("成功插入记录");
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
                if(ps!=null);{
                    ps.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
}