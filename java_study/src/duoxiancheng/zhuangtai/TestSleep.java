package duoxiancheng.zhuangtai;

public class TestSleep {
    public static void main(String[] args) {
        ts t=new ts();
        Thread ts1=new Thread(t);
        ts1.start();
    }
}

class ts implements Runnable {
    private int a;

    public void run() {// 重写这个函数时不能加参数
        final int i = 1;// 方法内部的属性？ java8新的特性 方法内部只能定义常量 用final修饰
        // 而且这个常量不能被方法外部访问
        // 方法内定义的东西{内部类 常量}都是限于本方法？
        for (a = 0; a <= 20; a++) {
            try {
                Thread.sleep(1000);//占有锁的时候才会影响别的 否则只是自己阻塞
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(""+(20-a));//要加""？
            System.out.println(20-a);//可以不加"" 直接输出数字的！
            

        }
    }
}