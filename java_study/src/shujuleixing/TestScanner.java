package shujuleixing;
import java.util.Scanner;//记得引入包
public class TestScanner{
    public static void main(String[] args) {
        //增加程序的互动性
        Scanner sc=new Scanner(System.in); //传入一个流对象
        System.out.println("名字");//1.字符的话这里输入时候不用加""2.别的的话也都会当字符串处理
        String name=sc.nextLine();//调用这个对象的方法
        System.out.println("年龄");
        int age=sc.nextInt();

        System.out.println("姓名是"+":"+name);
        System.out.println("年龄是"+":"+age);
    }
}