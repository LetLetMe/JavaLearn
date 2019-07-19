// package StringClass; 这里包名种有大写字母的话会标红
package stringclass;
public class TestStringBuilder{
    public static void main(String[] args) {
        StringBuilder sb1=new StringBuilder("aaaaa");
        for (int i=0;i<=10;i++){
            sb1.append(i);
        }
        System.out.println(sb1);
    }
}
