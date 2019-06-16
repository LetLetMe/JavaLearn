package designpattern;
public class DesignPatternDanli{
    public static void main(String[] args) {
        DesibnPatternDanliEhan dpeh=DesibnPatternDanliEhan.getInstence();
        for(int i=1;i<=5;i++){//注意循环的语法格式 1.int i 2.;(分号)3.想要循环5次要用<=
            DesibnPatternDanliEhan _dpeh=DesibnPatternDanliEhan.getInstence();
            //如果是同类中的静态方法则可以直接调用 不同类则要加类名 
            //导入也是导入的类 不是导入的方法

            if(dpeh!=_dpeh){//其实背后都是一个内存地址 可以比较
                System.out.println("不是一个对象");
            }else{
                System.out.println("是一个对象");
            }
            
        }
    }
}
class DesibnPatternDanliEhan{
    private DesibnPatternDanliEhan(){};
    private static DesibnPatternDanliEhan dpdl;
    public static DesibnPatternDanliEhan getInstence(){
        if(dpdl==null){
            dpdl=new DesibnPatternDanliEhan();
        }
        return dpdl;
    }
}
class DesignPatternDanliLanhan{
    private DesignPatternDanliLanhan(){}//这里不用加冒号
    // static {
    //     DesignPatternDanliLanhan dpdllh = new DesignPatternDanliLanhan();
    //     System.out.println("产生了一个对象");
    // }
    //俩种方式
    private static DesignPatternDanliLanhan  dpdllh=new DesignPatternDanliLanhan();//都要搞成静态的
    public static DesignPatternDanliLanhan getInstance(){
        return dpdllh;
    }
}