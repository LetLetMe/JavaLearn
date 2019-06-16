package designpattern;
public class daili{
    public static void main(String[] args) {
        new marrycompeny(new me()).heppymarry();
    }
}
interface marry{
    void heppymarry();
}

class me implements marry{//真实角色
    public void heppymarry(){
        System.out.println("wo jiehun le");
    }
}

class marrycompeny implements marry{//代理角色
    private me m1;
    public marrycompeny(me m1){//构造方法一定需要方法体
        this.m1=m1;
    };
    public void heppymarry(){
        this. Fa();
        m1.heppymarry();
        marrycompeny.Fb();
    }
    public void Fa(){
        System.out.println("zhunbei");
    }
    public static void Fb(){
        System.out.println("shoushi");
    }
}