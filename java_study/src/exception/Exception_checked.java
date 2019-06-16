package exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Exception_checked {//class不能抛出异常
    public static void main(String[] args) {//什么都不写的话就是一个空方法

    }
    String open() throws FileNotFoundException,IOException{//只有方法才能抛出异常
        //抛出的话不能抛出超过超过父类声明范围的异常    这个是指在重写方法中！
        //调用方法内
        FileReader reader=new FileReader("");
        char c=(char)reader.read();
        System.out.println(c);
        return ""+c;
    }

}
