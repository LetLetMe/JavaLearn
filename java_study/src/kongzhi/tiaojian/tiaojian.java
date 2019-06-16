package kongzhi.tiaojian;//注意多层嵌套时候包的写法
public class tiaojian{
    public static void main(String[] args) {
        //1.if(){}  if(){}else{}  if(){} else if(){} else{}
        int i=3;
        int n=0;
        if(i==1){
            System.out.println(i);
        }

        if(i==2){
            System.out.println(i);
        }else{
            System.out.println(i);
        }

        if(i==2){
            System.out.print(i+"\t");
        }else if(i==1){
            System.out.print(i+"\t");//不换行而是加个制表符 这样写优雅一点
        }else{
            System.out.println("瞎写的");
        }
        //2.switch
        switch (i) {
            case 1:
                System.out.println(i);
                break;
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.print("[2-5]");
            default:
                break;
        }
    }
}