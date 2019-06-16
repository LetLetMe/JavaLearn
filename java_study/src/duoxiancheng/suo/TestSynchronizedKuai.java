package duoxiancheng.suo;
public class TestSynchronizedKuai{
    public static void main(String[] args) {
        Account a1=new Account(10, "HYT的账户");

        Drawing draw1=new Drawing(12, a1);
        Drawing draw2=new Drawing(14, a1);
        //创建线程的顺序并不等于执行的顺序！
        //因为cpu调度顺序不一定 线程的执行顺序不一定
        //同时单项操作还好 但是也会有不确定性 比如剩余钱的数量
        //同时双向操作问题会大一点 即结果与你操作的时机相关性大
        //所以并发事件可能有多种结果 
        //对于单个线程来讲结果有不确定性

        draw1.start();
        draw2.start();

        Runnable rn1=new cunqian(1,a1);
        Runnable rn2=new cunqian(2,a1);
        // 因为是

        new Thread(rn1,"wo").start();
        new Thread(rn2,"ni").start();
    }
}
class Account{
    int money;//根据显示的情况抽象合适的属性！

    //根据实际用途抽象类是很重要的！
    String aname;
    public Account(int money,String aname){
        super();//??为啥？ 其实构造器会自动调用父类构造器 不写这个也行的
        this.money=money;
        this.aname=aname;
    }
}
/**
 * 模拟取款操作  这个类是模拟的操作！
 */
class Drawing extends Thread{
    int drawingNum;
    Account account;
    int expenceTotal;
    public Drawing(int drawingNum,Account account){
        super();//构造方法中局部变量直接搞成和成员变量一样的名字 然后里边用this即可 这个固定形式也挺好
        this.drawingNum=drawingNum;
        this.account=account;
    }
    public void run(){
        draw();
    }
    void draw(){
        synchronized(account){//account 是传入的一个实际的对象 而不是形参！  想锁的话必须线程类中定义 然后传入
            if(account.money-drawingNum<0){//account 的属性
                // System.out.println(this.getName()+"取款余额不足");
                System.out.println("取款："+account.aname+"取款余额不足");
                return;
            }
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            account.money-=drawingNum;
            expenceTotal+=drawingNum;
        }
        //只要是继承了Thread类 就有getname()方法
        System.out.println(this.getName() + "--账户余额：" + account.money);
        //因为这里直接继承了Thread类 就可以直接用this
        //如果是实现runnable接口 则要用哪个Thread.current****()静态方法返回当前线程本身！
        System.out.println(this.getName() + "--总共取了：" + expenceTotal);
    }
}
class cunqian implements Runnable{
    int money;
    Account account;
    cunqian(int money,Account account){//构造方法定义成包内可用的话 
        //包外的即使导入了这个类也无法用？
        //即相当于在包外无法创建这个对象了
        this.money=money;
        this.account=account;
    }
    public void run(){
        cunqian();
    }
    void cunqian(){
        if (money<=0) {
            System.out.println("存入金额错误！");
        } else {
            synchronized(account){//这就是方法块了 里边直接写语句
                account.money+=money;
                System.out.println("存款："+Thread.currentThread().getName()+"一共存了"+money);
                System.out.println(account.aname+"账户余额为"+account.money);
            }
            // System.out.println(account.aname+"账户余额为"+account.money); 写在同步快内外性能不一样 为了正确还是尽量都写在里边吧！
            //如果写在外边的话可能  先打印“一共存了”那一行 然后屏幕给了下一个线程 再然后才打印 “账户余额”
            //这样倒是不会影响实际执行 但会影响打印顺序

            //给屏幕加锁就相当于一个线程所有的打印操作都执行完了才给别的线程
            //

            //当内部调用变量时候 如果存在 那个近用哪个 形参中定义的也算
            //外部调用方法内的是不可以的！

            // if(this.money==money){
            //     System.out.println("true");
            // }
        }
    }

}