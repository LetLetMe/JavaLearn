package meiju;
public class meiju{
    public static void main(String[] args) {
        System.out.println(Season.Spring);//返回的也就是哪个Spring

        Season s=Season.Spring;//创建枚举对象要这样创建
    }
}
enum Season{//枚举中直接定义常量 不能赋值
    //枚举中只能定义字符串常量 而且不用双引号
    //枚举其实就是限制了一个常量的可选范围
    Spring,Summer
}
