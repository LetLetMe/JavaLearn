package exception;//根据java命民规则 包名都要小写

public class Exception_unchecked {//类名应该大写
    public static void main(String[] args) {
        System.out.println("hellow java");
        int a,b=1,c=0;//变量的声明要在语句块外边
        if (c==0) {/*解决unchecked exception
            if(conn!=null){}这个是同理
            if后边可以不加else的 
            如果conn是个空引用的话就不关闭了*/
            System.out.println("除数为0了");
        } else {
            a=b/c;
            System.out.println(a);
        }

    }
}