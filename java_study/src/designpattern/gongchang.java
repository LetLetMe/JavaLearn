package designpattern;
public class gongchang{
    public static void main(String[] args) {
        changzi cz=new changzi();
        car ad=cz.getcar("audi");//子类引用不能接收父类对象
        car bm=cz.getcar("baoma");//这里必须用父类对象接收
        ad.qidong();
        bm.qidong();
    }
}
class car {
    public void qidong(){
        System.out.println("qidong");
    }
}
class audi extends car{
    public void qidong(){
        System.out.println("奥迪 qidong");
    }
}
class baoma extends car{
    public void qidong(){
        System.out.println("宝马 qidong");
    }
}
class changzi{
    private String name;
    
    public car  getcar(String carname){  //当定义了类型以后需要显式的返回 否则编译通不过
        //这里定义成void即可 ! 这样也不行！！ 返回值是什么必须用什么样的值接受！构造函数必须用原对象接受
        this.name=carname;
        if (this.name=="audi") {
            return new audi();

        }else if(this.name=="baoma"){
            return new baoma();
        }else{
            return null;//结构一定要严谨 各个地方都要有返回值 返回的对象可以为null
        }
       //当然这个工厂不止可以生产car
    }

  

}