package innerclass;
public class fangfaiinner{
    public static void main(String[] args) {
        outer ou=new outer();
        ou.fangfa();
    }
}
class outer{
    public void fangfa(){
        class inner{//方法内部类其实就是提供一个较好的封装
            public int a;
            public static final int b=2;
            public void inner(){
                System.out.println("inner");
            }
        }
        new inner().inner();
        System.out.println(new inner().b);
    }

}