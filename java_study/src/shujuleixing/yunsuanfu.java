package shujuleixing;
public class yunsuanfu {
    public static void main(String[] args) {
        int a=1;
        int b=2;
        long c=a+b;//这里会自动类型转换
        // byte d=a+b; 整数相加如果没有long的话 则结果会自动转化成int
        double a1 =1.1;
        double b1=2.2;
        float c1=1.1f;
        float c3=1.1f;
        float c2=c1+c3; //都为float时结果才是float
        // float c4=c1+a1; 有一个double结果就是double了
        // if(1&2){ 逻辑运算符的操作数必须位boolean值
        // }
        // if(2){ java中别的辆是不能被识别成true或者false的
        // }

        int a3=3<<1;//位运算符  移位运算 
        System.out.println(3/2);
        System.out.println(3>>2);
        // System.out.print(3.0/2,0); print默认参数是int
        double aa=3.0/2.0;//不用加括号
        System.out.println(aa);//当这样显式的指定类型就是可以的了
    }
}
