package jdbc;
import java.sql.*;
public class jdbc_Date_7 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        Statement stme=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/fanqi"+"?serverTimezone=UTC";
            conn=DriverManager.getConnection(url, "root", "password");
            // stme=conn.createStatement();
            // int i1=stme.executeUpdate("alter table fanqi2 add Date date");//MYSQ中date后边不加括号的

            System.out.println("更新列成功");
            
            String sql1="insert into fanqi2(q,Date) values(?,?) ";//如果没有设置自增的话这里不能不插入主键!
            ps=conn.prepareStatement(sql1);
            ps.setInt(1, 12);
            ps.setDate(2, new Date(2019, 12, 1));//这里你调用date（）方法编译器会提示参数
            /* Date = new Date();  也可以专门创建一个 然后引用
            TimeStamp tst= new TimeStamp(); 创建时间戳的方法*/

            //JDBC核心 有的地方是需要插入专有对象的！；
            ps.execute();
            System.out.println("成功插入数据");
        } catch (ClassNotFoundException e) {
            
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try {
                if(stme!=null){
                    stme.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(ps!=null){
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();//java里边给外部调用的一般是方法 要加括号
            }
            try {
                if(conn!=null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        


    }
}