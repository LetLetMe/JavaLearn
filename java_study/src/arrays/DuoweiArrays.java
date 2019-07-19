package arrays;

import java.util.Arrays;

public class DuoweiArrays{
    public static void main(String[] args) {
        int[][] int_outer=new int[3][];
        int[] int_inner_1={1,2,3};
        int[] int_inner_3={1,2,3};
        int[] int_inner_2={1,2,3};
        int_outer[0]=int_inner_1;
        int_outer[1]=int_inner_2;//注意这个索引值的定义
        int_outer[2]=int_inner_3;

        //遍历二维数组 
        //注意for each各个量填啥
        for (int[] temp:int_outer){
            System.out.println(Arrays.toString(temp));
        }
    }
}
