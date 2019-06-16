package duoxiancheng.chuangjian;
public class TestRunnable {
    public static void main(String[] args) {
    //1
    Runnable rn=new test();//创建的是接口的引用
    new Thread(rn).start();//直接把他丢到代理对象即可 不必生成引用了
    //2
    test ts=new test();
    new Thread(ts,"a").start();//可以传入一个名字
    //3
    new Thread(new test(),"b").start();
    //主线程
    for(int n=0;n<=1000;n++){//当循环次数太少时 可能感受不线程的变化
        System.out.println("musicing");
    }
    }
}
class test implements Runnable{
    public void run(){
        for(int i=0;i<=1000;i++){
            System.out.print(Thread.currentThread().getName()+"-->");
            System.out.println("coding");
        }//后边这个括号和内容的开头对齐
    }   
}