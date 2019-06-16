package myabstract;//包名就直接写成 com.hyt.~~这个和文件夹是没有关系的！ 只不过作用比较像
public class AbstractJiekou{
    public static void main(String[] args) {
        Person p=new Person();
        p.huozhe();
        p.huxi(10);
        new Person().huozhe();//这种形式可以不生产引用而直接调用方法

        dongwu d=new Person();//由于这个接口继承了一个接口 所以俩个都能用 编译器不会报错
        d.huxi(10);
        d.huozhe();
        
    }
}
interface shengwu{//只要是类或者接口 声明称public 编译都通不过！
    void huozhe();
}
interface dongwu extends shengwu{
    void huxi(int a);
}
interface age{
    int age(int a);
}
class Person implements dongwu,age {
    public void huozhe(){
        System.out.println("wo shi person wo huozhe");
    }
    public void huxi(int a){
        System.out.println("wo shi person wo zai huxi");
    }
    @Override
    public int age(int a) {//实现接口的方法一定要写明 public
        return a;
    }
}