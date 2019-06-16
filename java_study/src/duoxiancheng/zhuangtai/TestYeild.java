package duoxiancheng.zhuangtai;
public class TestYeild{
    public static void main(String[] args) {
        Thread th=new Thread(new YE());
        th.start();
        for(int a=0;a<=200;a++){
            System.out.println(Thread.currentThread().getName()+"-->"+a);//这个静态方法在主线程中也可
        }
    }
}
class YE implements Runnable{
    public void run(){
        for(int i=0;i<=200;i++){
            System.out.println(Thread.currentThread().getName()+"-->"+i);
            if(i%3==0){
                Thread.yield();
            }
        }
    }
}