package duoxiancheng.chuangjian;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestCallable {
    public static void main(String[] args) {
        callable1 cl1 = new callable1("coding");
        callable1 cl2 = new callable1("papapa");
        callable1 cl3 = new callable1("shuohua");
        ExecutorService ser = Executors.newFixedThreadPool(3);//调用这个需要导入一些包~
        Future<Boolean>result1=ser.submit(cl1);
        Future<Boolean>result2=ser.submit(cl2);
        Future<Boolean>result3=ser.submit(cl3);
        try{
            boolean r1=result1.get();
            boolean r2=result2.get();
            boolean r3=result3.get();
        }catch(Exception E){
            E.printStackTrace();
        }
        ser.shutdown();
        
    }
}
class callable1 implements Callable<Boolean>{
    private String activity;
    public callable1(String activity){
        this.activity=activity;
    }
    @Override
    public Boolean call() throws Exception {//泛型的写法和一般的数据类型写法不一样
        for(int i=0;i<200;i++){
            System.out.print(Thread.currentThread().getName()+"-->");//这里虽然不能自己设置名字了 但是可以用默认的
            System.out.println(this.activity);
        }
        return true;
    }
    
}