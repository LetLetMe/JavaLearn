package suanfa;

import java.util.Arrays;

public class maopao{
    public static void main(String[] args) {
        int[] in1={9,8,7,6,5,4,3};
        int[] in2=paixu(in1);
        System.out.println(Arrays.toString(in2));
    }
    public static int[] paixu(int[] ar){
        int temp;//这是一个交换变量
        for (int i=0;i<ar.length-1;i++){
            boolean flag = true;
            for (int j=0;j<ar.length-1-i;j++){
                if (ar[j]>ar[j+1]){
                    temp=ar[j+1];
                    ar[j+1]=ar[j];
                    ar[j]=temp;
                }
                flag=false;
            }
            if (flag){
                break;
            }
        }
        return ar;
    }
}