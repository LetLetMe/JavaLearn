package myabstract;//系统保留的关键字不能用 
//包名都是小写 而且连在一起 如果太长了则可以多加一个"."
public class AbstractClass{//一个源文件里边只能有一个public class 而且要和源文件名字相同
    public static void main(String[] args) {
        nanren nr=new nanren(20);
        System.out.println(nr.age);
        nr.toufa(10);
    }
}
abstract class ren{
    
    public int age;
    public void huxi(){
        System.out.println("huxi");
    }
    abstract void toufa(int a);
}
class nanren extends ren{
    public nanren(int a){
        this.age=a;
    }
    public void toufa(int a){//参数也必须要完全一样
        System.out.println("duantoufa");
    }

    // @Override 点击红色波浪线会自动补全代码 
    //1.默认访问控制符和父类相同 2.会给你加注解
	// void toufa(int a) {
		
	// }
}



