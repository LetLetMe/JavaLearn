package myclass;
public class myClass{
    int id;
    String name;//当你定义变量而不赋初值时候 java会帮你赋初值

    String pwd;//这些是一般变量 不是静态的 是对象的属性
    static String WRITERNAME="huyitao";
    /**
     * 1.静态变量和一般变量都是变量 不能重名！ 只要是作用域一样就不能重名(根源)
     * 2.static 要小写
     */
    /**
     * @param pwd
     * @param id
     * @param name
     * 这样会自动生成一个文件？
     */
    public myClass(int id,String name){
        this.id=id;
        this.name=name;
    }
    public myClass(int id,String name,String pwd){//构造方法的重载
        this(id,name);
        this.pwd=pwd;
    }
    public void Fa(myClass m){
        m.name="2";//这里是会改变对象的属性的
    }
    //形式参数形式不同会有不同结果！！
    public void Fc( int id){
        System.out.println(id-1);
        id=1;//这里是不会改变对象的id属性的
        System.out.println(id);
    }
    void Fb(myClass m,int id,String name){//要给形参数起个名字
        m=new myClass(id,name);//这里这个m创建以后 除了方法就被销毁了？
                                //或者会一直存在？
    }
    public static void main(String[] args) {
        myClass m1=new myClass(11,"1");
        m1.Fa(m1);//一般方法需要生成对象，静态方法可以直接用
        //明白什么时候需要加包名！
        System.out.println(m1.name);
        m1.Fb(m1, 12, "3");
        m1.Fc(m1.id);
        System.out.println(m1.id);
    }
    static{
        System.out.println("static");
        /**
         * 一般语句(除了赋值语句以外)的位置：{
         *          1.方法中 不管是main方法还是别的方法
         *          2.语句块中
         * }
         */
    }
    {
        System.out.println("2");//这个语句块中1内容也是会按顺序执行的！！
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
    // }
    //俩种方式
    private static DesignPatternDanliLanhan  dpdllh=new DesignPatternDanliLanhan();//都要搞成静态的
    public static DesignPatternDanliLanhan getInstance(){
        return dpdllh;
        
    }
}