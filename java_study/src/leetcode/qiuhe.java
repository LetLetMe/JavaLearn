package leetcode;
public class qiuhe{
    public static void main(String[] args) {
        Solution so=new Solution();
        int[] slu=null;
        int[] num={1,2,3,4,5,6};//数组直接赋值的方式
        int[] num1=new int[]{1,2,3,4,5,6};//这样生成数组也可以


         System.out.println(num1.toString());
        slu=so.twoSum(num,5);
        System.out.println(slu[0]);
        System.out.println(slu[1]);
        //具体的值
        System.out.println(num[slu[0]]);
        System.out.println(num[slu[1]]);

    }
}
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int myTarget;
        int[] myNums=null;
        for (int i=0;i<nums.length;i++){
            for ( int j=i+1;j<nums.length;j++){
                myTarget=nums[i]+nums[j];
                if(myTarget==target){
                    myNums=new int[2];
                    myNums[0]=i;
                    myNums[1]=j;
                    return myNums;
                }
            }
        }
        return myNums;
    }
}
    