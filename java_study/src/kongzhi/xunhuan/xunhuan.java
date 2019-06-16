package kongzhi.xunhuan;
public class xunhuan{
    public static void main(String[] args) {
        //1.嵌套循环
        for(int i=1;i<=10;i++){
            for(int n=1;n<=i;n++){//必须给n赋一个初始值
                System.out.print(i+"*"+n+"="+(i*n)+"\t");
                
                 
            }
            System.out.println();
        }
        //2.while(){}  do{}while();记得加分号结尾
        int i=0;  //设置全局变量时候尽量不要占用i！！！
        while(i<=10){
            System.out.print(i+"\t");//'\n' 和"\n"结果是不一样的 后边的才是制表符
            i++;//这里是会从根源上影响i的！！！
        }
        do{
            System.out.println(i+"\t");
        }while(i<=5);//这里的i也是全局变量！

        //3.for循环
        for(int a=1;a<=10;a++){ //当定义了全局变量以后 这里的局部变量也不能重复声明了！
            System.out.println(a);
        } 
        //3.break和cotinue
        for(int a=1;a<30;a++){
            if(a%2==0){
                System.out.print(a+"\n");
            }
            else{
                continue;
            }
        }
        for(int a=1;a<30;a++){
            if(a%2==0){
                System.out.print(a+"\n");
            }
            else{
                break;
            }  
    }
        //5.带标签的continue和break(break应该也有 只不过这里没教)
        outer:for(int b=101;b<=150;b++){
            for(int a=2;a<b/2;a++){
                if(b%a==0){
                    continue outer;
                }
                // else{ 如果只有continue的话这个else加不加结果一样
                //     continue;
                // }  
            }
            System.out.print(b+"\t");
    }
}    
}