package shujuleixing;
public class zhuanhuan{
    private int a;
    public static void main(String[] args) {
        char c1= 20;
        byte b1=10;//不超范围也可以自动转
        float f1=1000L;//可能会有精度损失

        double d1=3.14;
        int n1=(int)d1;//不是简单的四舍五入
        Print(n1);

        long L1=314L*10000;//表达式要有一个long值 提前转成long
        
        
    }
    public static void Print(int a){
    System.out.println(a);
    }
    public static void Print(double a){
        System.out.println(a);
    }
    public static void Print(float a){
        System.out.println(a);
    }
    public static void Print(long a){
        System.out.println(a);
    }
}