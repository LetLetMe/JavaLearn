package duoxiancheng.xianchengtongxun;
public class guanchengfa{
    public static void main(String[] args) {
        huanchongqu hc =new huanchongqu();
        xiaofeizhe xfz=new xiaofeizhe(100, hc);
        shenchanzhe scz =new shenchanzhe(100,hc);
        xfz.start();
        scz.start();
        
    }
}
class xiaofeizhe extends Thread{
    huanchongqu hc =null;
    int num;
    public xiaofeizhe(int num,huanchongqu hc){
        this.hc=hc;
        this.num=num;
    }
    @Override
    public void run(){
        for(int i=0;i<=this.num;i++){
            System.out.println("生产产品"+i);
            chanping cp1=new chanping(i);
            hc.push();
        }
    }

}
class shenchanzhe extends Thread{
    huanchongqu hc;
    int num;
    public shenchanzhe(int num,huanchongqu hc){
        this.num=num;
        this.hc=hc;
    }
    public void run(){
        for(int i=0;i<=this.num;i++){
            System.out.println("消费产品"+i);
            chanping cp=hc.pop();

        }
    }

    
}
class huanchongqu{
    int index;
    chanping[] cp = new chanping[10];

    public synchronized void push(){
        while(index == cp.length){//数组才有这个方法 这里名字相同的话会出现作用域的问题
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    this.notify();
    cp[index] = new chanping(index);
    index++;
    }
    
    public synchronized chanping pop(){
        while(index==0){
            try{
                this.wait();//暂停是暂停当前线程
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        this.notify();//启动是启动随机一个 也可能消费者启动了一个消费者
        index--;
        return cp[index];//return也要加分号
    }
}
class chanping{
    private int id;
    public chanping(int id){
        this.id=id;
    }
}
