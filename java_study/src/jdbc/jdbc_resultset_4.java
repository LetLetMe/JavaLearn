package jdbc;
import java.sql.*;
public class jdbc_resultset_4{
    public static void main(String[] args) {
        Connection conn = null;
		PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/fanqi"+"?serverTimezone=UTC";
            conn=DriverManager.getConnection(url,"root","password");
            String sq1="select q,i from fanqi2 where q>?";
            ps=conn.prepareStatement(sq1);//先生成ps对象
            ps.setObject(1, 0);//填写参数
            
            rs=ps.executeQuery(); //再生成resultset对象
            //光提交 和返回resultset对象所使用的方法不一样

            while(rs.next()){//这里相当于用指针来写循环 要明白next()方法原理
                System.out.println(rs.getInt(1)+"---"+rs.getDouble(2));
                //这里还是会自动换行的
            }

        }  catch(ClassNotFoundException e){
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