package duoxiancheng.suo;

public class TestSuo {
    public static void main(String[] args) {
        shuju js = new shuju(5);
        new xiancheng(js).start();
        new xiancheng2(js).start();
        js.setShuju(10);
    }
}

class shuju {
    private int a;

    public shuju(int a) {
        this.a = a;
    }

    public synchronized int getShuju() {
        return this.a;
    }

    public synchronized void setShuju(int _a) {// 这个方法加锁是不会影响上边方法的调用的
        System.out.println("我被锁着了");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.a=_a;
    }

    public synchronized void setShuju1(int _a){
        System.out.println("我也在设置");
        this.a=_a;
        // while(Thread.interrupted()){
        //     System.out.println("排队了");
        // }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class xiancheng extends Thread{
    shuju sj;
    private static int a;
    public xiancheng(shuju sj){
        this.sj=sj;
    }
    private static void setInt(int a){
        xiancheng.a=a;//这里或者改名字 或者这样用类名. 也可以
    }
    public void run(){
        for(int i=0;i<=1000;i++){
            System.out.println(sj.getShuju());
        }
        // setInt(5);//类中调用本类的静态方法时候 用不用类名都行
        // xiancheng.setInt(5);//在线程体中的操作是按顺序执行的
        // System.out.println(a);
    }
}
class xiancheng2 extends Thread{
    shuju sj;
    public xiancheng2(shuju sj){
        this.sj=sj;
    }
    public void run(){
            sj.setShuju1(12);
    }
}