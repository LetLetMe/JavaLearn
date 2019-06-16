package arrays;
public class Array{
    public static void main(String[] args) {
        int[] ia;
        ia=new int[3];
        String[] sa=new String[5];

        Person[] pa=new Person[5];
        pa[0]=new Person(5);//索引用的是[]

        Double[] la ={1.2,1.3,1.4};//里边不能存整数 
        //除了在传参的过程中 别的地方是不会给你转换的
        //int不属于double 当你不加小数点时候就默认int

        for (int temp : ia) {//这种格式叫foreach for的加强版
            System.out.println(temp);
        }
    }
}
class Person{
    public Person(int age){
        this.age=age;//this的另一个作用 跨越作用域
    }
    private int age;
}