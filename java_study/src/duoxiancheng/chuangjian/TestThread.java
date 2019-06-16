package duoxiancheng.chuangjian;
public class TestThread{
    public static void main(String[] args) {
    test ts=new test();
    ts.start();
    for(int n=0;n<=1000;n++){//当循环次数太少时 可能感受不线程的变化
        System.out.println("musicing");
    }
    }
}
class test extends Thread{
    public void run(){
        for(int i=0;i<=1000;i++){//i需要赋初值
            System.out.print(Thread.currentThread().getName()+"-->");//这个生成方法也可以用这个
            System.out.println("coding");
        }
    }
}