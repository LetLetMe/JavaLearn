package jdbc;
/*学习数据库操作之----事务处理
*/
import java.sql.*;
public class jdbc_shiwu_6{
    public static void main(String[] args){
        Connection conn=null;
        PreparedStatement ps1=null;
        PreparedStatement ps2=null;//可以使用这种方法先生成一个空的引用！！
        try{Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("driver the mysql driver success!");
        //get the connection next
        //when you use the musql5+ you must add the timezone into the url
        
        String url="jdbc:mysql://localhost:3306/fanqi"+"?serverTimezone=UTC";
        conn=DriverManager.getConnection(url,"root","password");
        conn.setAutoCommit(false);
        ps1=conn.prepareStatement("insert into fanqi2(q,i) values(?,?)");

        // the function is less an "d"
        ps1.setObject(1,2);//别的不需要引号 字符串需要
        ps1.setObject(2,3);
        ps1.execute();
        System.out.println("success for add the first data");
        try {Thread.sleep(3000);
        } catch (InterruptedException inter_e) {
                System.out.println(inter_e);
        }
        ps2=conn.prepareStatement("insert into fanqi2(q,i) values(?,?)");
        ps2.setObject(1,3);
        ps2.setObject(2,3.3);
        ps2.execute();//每次要记得提交查询 这里tmd别提交错了 草泥马的！
        System.out.println("success for add the second data");

        conn.commit();



        }catch(ClassNotFoundException cle){
            System.out.println("class doesn't found");
            System.out.println("cle");
            try{
                conn.rollback();
            }catch(SQLException SQLe){
                System.out.println(SQLe);

            }
        }catch(SQLException sqle){// get all the exceptions in sql sever coonection
            System.out.println(sqle);
            //捕获错误时候尽量打印原版错误
            try{
                conn.rollback();
            }catch(SQLException SQLe){//理论上必要的错误前边都要加rollback？
                System.out.println(SQLe);
                
            }

        }finally{
            try {
                if(ps1!=null){
                    ps1.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
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