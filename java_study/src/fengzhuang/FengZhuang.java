package fengzhuang;
public class FengZhuang{
    public static void main(String[] args) {
        Person p=new Person();
        p.setAGE(10);
        System.out.println(p.getAGE());
    }
}
class Person{
    private int Age;
    private String Name;
    final int THISTIME=20190610;
    
    public int getAGE(){
        return this.Age;//直接写AGE编译是会通过的 但是调用时候可能有问题？
    }//深刻理解this关键字
    public boolean setAGE(int age){//直接void也行 但是这样写严谨一点 虽然我也不知道会有什么错误

        try {
            this.Age=age;
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}