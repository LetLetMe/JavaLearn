package suanfa;

import java.util.Arrays;

//二分法查找 根据值返回相应的索引
//列表必须要提前排好序 值必须在列表中才能找到 不能是介于列表范围内的一个数
public class erfenfa {
    public static void main(String[] args) {
        int[] in2 = new int[10];
        for (int i = 0; i <= 9; i++) {
            in2[i] = i;
        }
        System.out.println(Arrays.toString(in2));

        erfen(in2, 3);// 有返回值时候不用变量接收也行
        int jieguo = erfen(in2, 2);// 自己类中的静态方法可以直接调用
        System.out.println(jieguo);
        new erfenfa().chengyuan();// 自己类中的成员方法也必须这样用？
    }

    public static int erfen(int[] arr, int in1) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;// 这里会自动取整
            if (in1 == arr[mid]) {
                return mid;
            } else if (in1 < arr[mid]) {
                high = mid - 1;
            } else if (in1 > arr[mid]) {
                low = mid + 1;
                // }else{
                // return -1;
                // } 这样定义返回值不行
            }
        }
        return -1;// 必须在方法最后强制加上最终的返回值
        // 注意这里是设计判断逻辑的 不是随便乱加的
        // 当上边循环都没找到时候 返回-1
    }

    public void chengyuan() {
        System.out.println("chengyuanfangfa");
    }

    public void chengyuan2() {
        this.chengyuan();// 非静态调用非静态可以用this
    }

}