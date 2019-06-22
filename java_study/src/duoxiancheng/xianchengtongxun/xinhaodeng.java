package duoxiancheng.xianchengtongxun;
public class xinhaodeng{
    public static void main(String[] args) {
        xinhaodengdeng xhd =new xinhaodengdeng();
        new yanyuan(xhd).start();
        new guanzhong(xhd).start();
    }
}
class xinhaodengdeng{
    private boolean avoliable=false;
    int index=0;
    // chanping[] cpa = new chanping[10];       信号灯法解决的是轮流的问题 不需要容器来提供管道了
    public synchronized void biaoyan(){
        while (avoliable) {
            try{
                wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("表演"+(++index));
        avoliable=!avoliable;
        notify();
    }
    
    public synchronized void guankan(){
        while (!avoliable|index==0){
            try{
                wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("观看"+index);
        avoliable=!avoliable;
        notify();
    }
}
class guanzhong extends Thread{
    xinhaodengdeng xhd;
    public guanzhong(xinhaodengdeng xhd){
        this.xhd=xhd;
    }
    @Override
    public void run(){
        for(int i=0;i<=20;i++){
            xhd.guankan();
        }

    }
}
class yanyuan extends Thread{
    xinhaodengdeng xhd;
    public yanyuan(xinhaodengdeng xhd){
        this.xhd=xhd;
    }
    @Override
    public void run(){
        for(int i=0;i<=20;i++){
            xhd.biaoyan();
        }
    }
}
