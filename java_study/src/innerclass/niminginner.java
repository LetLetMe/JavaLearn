package innerclass;
public class niminginner{
//其实就是匿名类 没有匿名内部类这一说
    public static void main(String[] args) {
        new niminginner().inter(new outer(){ public void outer(){System.out.println("outer");}});

        new outer(){public void outer(){};};//生成匿名类的方法 直接在父类构造方法后边加方法体即可

        // new outer1(){public void outer1(){System.out.println("a");};}.outer1();;
        //子类不能重写父类的构造方法

        new outer1(2){public void outer2(){System.out.println("a");};}.outer2();;

        //重写方法时候一定要加public
    }

    public void inter(outer ot){//这里只是提供了一个使用匿名类的理由 不过也好像只有这个利用了？
        //匿名类的对象可以作为参数 可以调用他的方法
        ot.outer();
    }
}
interface outer{//接口中没必要写访问控制符
    void outer();
}
class outer1{

    outer1(int a){}//只有构造方法可以不写返回值
    //当方法名相同时候 有返回值的不是构造方法！


    void outer2(){}//当你制定了返回值时候这个就不是构造方法了
}