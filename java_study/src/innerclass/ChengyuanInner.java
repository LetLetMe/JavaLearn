package innerclass;
public class ChengyuanInner{
    public static void main(String[] args) {
        //生成一般的内部类
        outer.inner in=new outer(1).new inner(2);

        outer ou=new outer(2);//不管怎么样 原理都是在外部类的基础上创建
        outer.inner in1=ou.new inner(3);//不管怎么创建 不管是不是静态 内部类对象的引用都是一样的
        
        in.Fa();
        //生成静态内部类
        outer.inner2 in2=new outer.inner2(1,"2");//调用静态内部类不需要调用外部类的构造方法

    }
}
class outer{
    public outer(int ar){
        this.outer_int=ar;
    }

    private int outer_int;
    //一般内部类
    class inner{
        private int inner_int;
        public inner(int ar){//构造方法不管在哪格式都是一样的
            this.inner_int=ar;
        }
        public void Fa(){
            System.out.println(outer.this.outer_int);
            System.out.println(this.inner_int);
        }
    }
    //静态内部类
    static class inner2{
        private int a;//里边不用再声明是静态的也会默认了？
        private static String s;
        public inner2(int a,String b){
            this.a=a;
            this.s=b;
        }
        public void Fb(){
            System.out.println(a);
            System.out.println(s);
        }
    }
}