package innerclass;
public class niminginner{
    public static void main(String[] args) {
        new niminginner().inter(new outer(){ public void outer(){System.out.println("outer");}});
        //重写方法时候一定要加public
    }
    public void inter(outer ot){
        ot.outer();
    }
}
interface outer{
    void outer();
}