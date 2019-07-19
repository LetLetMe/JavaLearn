package packclass;
public class IntegerClass{
    public static void main(String[] args) {
        Integer a=new Integer(5);
        Integer b=Integer.valueOf(5);

        int c =a.intValue();
        double d= a.doubleValue();//同一个包装类对象可以转为不同的类型

        Integer e=new Integer("999");
        Integer f=Integer.parseInt("11111");

        String str =f.toString();

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
    }
}