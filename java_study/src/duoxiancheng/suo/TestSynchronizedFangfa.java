package duoxiancheng.suo;

public class TestSynchronizedFangfa {
    public static void main(String[] args) {
        Web12306 wb = new Web12306(100);

        Thread th1 = new Thread(new QiangPiao(10, wb), "hyt");
        Thread th2 = new Thread(new QiangPiao(10, wb), "fq");//采用runnable接口 所有的相关操作都要加倍！

        th1.start();
        th2.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(wb.tkNum);//写在主方法中也算个独立的线程 
        //个个线程是独立的 先后顺序不一定
        //主线程中不能写别的线程结束后的相关内容
        
    }
}
// abstract class Web{
//     protected int tkNum;
//     public Web(){//构造方法不能声明为abstract
//         this.tkNum=tkNum;
//     }
// }因为这个系统就是给12306写的 别的网站抢票不会调用它的方法！没必要写抽象类
class Web12306 {
    int tkNum;
   //构造方法不会继承
   public Web12306(int tkNum){
       this.tkNum=tkNum;
   }
}
class QiangPiao implements Runnable{//给抢票行为定义个类
    Web12306 web1;
    int tkNum;
    public QiangPiao(int tkNum,Web12306 web1){
        this.web1=web1;
        this.tkNum=tkNum;
    }
    public void run(){
        qiangP();//这里没必要传参 线程体内都是调用本类内部的方法
    }



    // public synchronized void qiangP(){
    //     if(this.tkNum>web1.tkNum){//方向别反了！
    //         //方法锁 里边会锁别的对象吗？ 应该是锁了吧
    //         //锁了方法的话 是不会帮你锁别的对象的！

    //         System.out.println("票不够");
    //     }else{
    //         web1.tkNum-=this.tkNum;
    //         System.out.println(Thread.currentThread().getName()+"抢票成功");
    //         System.out.println(Thread.currentThread().getName()+"强了"+this.tkNum+"张票");
    //         System.out.println("现在还剩"+web1.tkNum+"张票");
    //     }
    // }
    public  void qiangP(){
        synchronized(web1){
        if(this.tkNum>web1.tkNum){//方向别反了！
            //方法锁 里边会锁别的对象吗？ 应该是锁了吧
            //锁了方法的话 是不会帮你锁别的对象的！
            System.out.println("票不够");
        }else{
            web1.tkNum-=this.tkNum;
            System.out.println(Thread.currentThread().getName()+"抢票成功");
            System.out.println(Thread.currentThread().getName()+"强了"+this.tkNum+"张票");
            System.out.println("现在还剩"+web1.tkNum+"张票");
        }
        }
    }

}
