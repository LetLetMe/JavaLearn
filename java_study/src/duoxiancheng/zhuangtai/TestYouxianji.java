package duoxiancheng.zhuangtai;
import duotai.DuoTai;;//这样写没法导入包 除非你把包移到这个下边
//java包机制
//1.javac -d 的话会根据包名在当前文件夹下创建文件夹 
//2.当class的源文件有包名时 java必须加上包名 即得在源文件相同的目录下运行！
//3.import 导入的时候会在classpath中搜寻 class中有三个{1和2都和jdk有关 3是当前文件夹}所以一切要以当前文件夹为准
//你把源文件都放在一个目录下不就行了！
public class TestYouxianji{
    public static void main(String[] args) {
        xc1 _xc1=new xc1();
        Thread th1=new Thread(_xc1);//重写runnable接口时是通过这种方式产生多个线程的
        Thread th2=new Thread(_xc1);
        Thread th3=new Thread(_xc1);
        Thread th4=new Thread(_xc1);
       
        th1.setPriority(1);
        th2.setPriority(Thread.MAX_PRIORITY);
        th3.setPriority(4);
        th4.setPriority(Thread.NORM_PRIORITY);

        th1.start();
        th2.start();
        th3.start();
        th4.start();
        
    }
}
class xc1 implements Runnable{
    public void run(){
        System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());
    }
}
