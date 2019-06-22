package duoxiancheng.xianchengtongxun;

public class guanchengfa2 {
    public static void main(String[] args) {
        gundao gd = new gundao();
        pushPerson psp1 = new pushPerson(gd);
        pushPerson psp2 = new pushPerson(gd);
        popPerson pop1 = new popPerson(gd);
        popPerson pop2 = new popPerson(gd);
        pop1.start();
        pop2.start();
        psp1.start();
        psp2.start();
    }
}

class ziyuan {
}

class gundao {
    ziyuan[] zy = new ziyuan[10];// 这是对象中的成员对象 也属于对象
    // synchronized会锁住this的一切对象
    int index = 0;

    public void push() {// 资金的方法调用自己的东西就没必要传参
        synchronized (zy) {// 这个例子中用俩种方法都可以
            while (index == zy.length) {
                System.out.println("满了");
                try {
                    zy.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            index++;
            zy.notify();
            System.out.println("push产生了一次资源");
        }
    }

    public void pop() {
        synchronized (zy) {
            while (index == 0) {
                System.out.println("空了");
                try {
                    zy.wait();// 这里的用法和锁方法的用法不一样
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            index--;
            zy.notify();
            System.out.println("pop      消耗了一次资源");
        }
    }

}

class pushPerson extends Thread {
    gundao gd;

    public pushPerson(gundao gd) {
        this.gd = gd;
    }

    public void run() {
        for (int i = 0;; i++) {// 中间那个省略的话可以搞成死循环
            gd.push();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class popPerson extends Thread {
    gundao gd;

    public popPerson(gundao gd) {
        this.gd = gd;
    }

    public void run() {
        for (int i = 0;; i++) {
            gd.pop();
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}