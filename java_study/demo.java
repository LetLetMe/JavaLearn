class Lipstick {//口红类
 
}
class Mirror {//镜子类
 
}
class Makeup extends Thread {//化妆类继承了Thread类
    int flag;
    String girl;
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();
 
    @Override
    public void run() {
        // TODO Auto-generated method stub
        doMakeup();
    }
 
    void doMakeup() {
        if (flag == 0) {
            synchronized (lipstick) {
                System.out.println(girl + "拿着口红！");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
 
            }
            synchronized (mirror) {
                System.out.println(girl + "拿着镜子！");
            }
        } else {
            synchronized (mirror) {
                System.out.println(girl + "拿着镜子！");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (lipstick) {
                System.out.println(girl + "拿着口红！");
            }
        }
    }
}
 
public class TestDeadLock {
    public static void main(String[] args) {
        Makeup m1 = new Makeup();// 大丫的化妆线程；
        m1.girl = "大丫";
        m1.flag = 0;
        Makeup m2 = new Makeup();// 小丫的化妆线程；
        m2.girl = "小丫";
        m2.flag = 1;
        m1.start();
        m2.start();
    }
}







public class TestSync {
    public static void main(String[] args) {
        Account a1 = new Account(100, "高");
        Drawing draw1 = new Drawing(80, a1);
        Drawing draw2 = new Drawing(80, a1);
        draw1.start(); // 你取钱
        draw2.start(); // 你老婆取钱
    }
}
/*
 * 简单表示银行账户
 */
class Account {
    int money;
    String aname;
    public Account(int money, String aname) {
        super();
        this.money = money;
        this.aname = aname;
    }
}
/**
 * 模拟提款操作
 * 
 * @author Administrator
 *
 */
class Drawing extends Thread {
    int drawingNum; // 取多少钱
    Account account; // 要取钱的账户
    int expenseTotal; // 总共取的钱数
 
    public Drawing(int drawingNum, Account account) {
        super();
        this.drawingNum = drawingNum;
        this.account = account;
    }
 
    @Override
    public void run() {
        draw();
    }
 
    void draw() {
        synchronized (account) {
            if (account.money - drawingNum < 0) {
                System.out.println(this.getName() + "取款，余额不足！");
                return;
            }
            try {
                Thread.sleep(1000); // 判断完后阻塞。其他线程开始运行。
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.money -= drawingNum;
            expenseTotal += drawingNum;
        }
        System.out.println(this.getName() + "--账户余额：" + account.money);
        System.out.println(this.getName() + "--总共取了：" + expenseTotal);
    }
}