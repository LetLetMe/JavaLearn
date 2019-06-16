package duotai;
public class DuoTai{
    public static void main(String[] args) {
    
    Animal d=new Dog();//3.父类引用指向子类 这样其实就是为了多态方便
    Animal c=new Cat();

    Shot(d);
    Shot(c);

    Dog d2=(Dog)d;//1.这样强制转型以后d才能用dog的方法 否则编译通不过
                  //2.这里的d2不能和d重名！即使你想要覆盖也不行

    }
    static void Shot(Animal a){//多态就是这样用的 在主方法中写一个调用父类的方法！
        a.shot();
    }
}
class Animal{
    protected int age;
    protected String name;
    
    public void shot(){
        System.out.println("i am animal");
    }
    final void dong(){//final 方法不能被重写
        System.out.println("dongyixia");
    }
}
class Person{
    public void shot(){
        System.out.println("i am person");
    }
}
final class Man extends Person{//男人再不会有子类了 可以写成最终类
    public void shot(){//但是设置访问控制符的目的是为了安全
        System.out.println("i am man");
    }
}


class Dog extends Animal{//1.继承
    public void shot(){
        System.out.println("i am dog");
    }
    
}
class Cat extends Animal{
    public void shot(){//2.重写
        System.out.println("i am cat");
    }
}