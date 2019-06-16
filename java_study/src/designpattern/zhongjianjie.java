package designpattern;
public class zhongjianjie{
    public static void main(String[] args) {
        computer cm=new computer();
        phone ph =new phone();
        String info = cm.connect(new shipeiqi(ph));
        System.out.println(info);
    }
}
interface usb{
    String usbinfo();
}
interface typec{
    String  typecinfo();
}
class phone implements typec{
    public String typecinfo(){
        return "wo shi phone";//想用这种方法的话这里不能是void 而要有返回值
        //在以后的开发中尽量写上返回值
    }
}
class computer implements usb{
    public String usbinfo(){
        return "woshi computer";
    }
    public String  connect(usb sb){
        //当实参是一个接口时 其实就是要用它的方法而已
        //你只要写个中间件使得调用元对象返回的值对了即可！！！！！
        //数据传递方向
        //typec-->usb-->coonect-->computer
        return sb.usbinfo();
    }
}
class shipeiqi implements usb{
    private typec tpc1;
    public shipeiqi(typec tpc){
        this.tpc1=tpc;
    }
    public String usbinfo(){//其实所谓的接口就是调用那几个方法 
        return this.tpc1.typecinfo();//调用另一个对象的方法返回需要的值 实现转化    


    }
}
