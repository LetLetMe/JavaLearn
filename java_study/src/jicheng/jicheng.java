package jicheng;
public class jicheng{
    public static void main(String[] args) {
    Student s=new Student();
    Person p= new Person();
    Person p1=new Student();//这样编译可以通过
    
    System.out.println(s.age);
    System.out.println(s.name);
    s.shot();
    
    }
}
class Person{
    public int age;
    public String name;
    public Person(){
        System.out.println("person");
    }

    protected void shot(){//定义方法是要加括号的
        System.out.println("我是人");
    }

}
class Student extends Person{
    public Student(){
        System.out.println("Student");
    }
    public  void shot(){//子类成员的范围不能小于父类
        System.out.println("我是学生");//方法的重写
    }
}