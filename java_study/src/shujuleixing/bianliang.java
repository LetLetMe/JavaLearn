package shujuleixing;
public class bianliang{
    public static void main(String[] args) {
        new TestBianliang().F();

        new TestBianliang();
        int a=750000000;
        long a1 = 740000l;
        // float f=3.14; 默认是double 如果需要float则要转换
        float f1 = 3.14f;
        boolean man=true;
        // if(man=false){学错成这样也可以通过编译
        // }
        if(man){}
        if(man==true){}//也行 但是不推荐这样写 

        char c='d';
        char d=63;
        char b='\n';//返斜杠是转意字符
        char a2='\u0000';
    }
}
class TestBianliang{
    static{//静态的是在类加载时候行动
        String a;
        System.out.println("BBB");
    }
    {//非静态的是在对象生成时行动
        String a;
        System.out.println("AAA");
    }
    public void F(){
        {
            System.out.println("fff");
        }
        System.out.println("FFF");
    }
}