package io;
import java.io.*;
import java.util.Arrays;


public class File_1234{
    public static void main(String[] args) {
        //1.构造路径
        String File_path="c:"+File.separator+"Users"+File.separator+"Desktop";
        /**
         * 这里的类名不能是file 否则io里边的file类没法用了
         * separator是一个静态变量 调用的时候要用类名
         */
        File_path="c:/Users/Vincent/Desktop";
        //推荐这样写 windows和linux都可以识别


        //2.构造file对象
        /**
         * 相对路径与绝对路径构造 File对象
         * 1、相对路径
            File(String parent, String child)  ==>File("E:/xp/test","2.jpg")
            File(File parent, String child)     ==> File(new File("E:/xp/test"),"2.jpg")
            2、绝对路径
            File(String name);
        */
        File file=new File(File_path,"io.txt");//1

        File file1=new File(File_path);//2
        file=new File(file1,"io.txt");//3
        file=new File(File_path+File.separator+"io.txt");//4 注意这里直接加的话记得加一个分隔符"/"
        System.out.println(file.getName());

        //3.file对象常用方法
            /**
             * 常用方法:
            1、文件名
            getName() 文件名、路径名
            getPath()路径名
            getAbsoluteFile() 绝对路径所对应的File对象
            getAbsolutePath() 绝对路径名
            getParent() 父目录 ,相对路径的父目录，可能为null 如. 删除本身后的结果
            2、判断信息
            exists()
            canWrite()
            canRead()
            isFile()
            isDirectory()
            isAbsolute()：消除平台差异，ie以盘符开头，其他以/开头
            3、长度 字节数  不能读取文件夹的长度
            length()
            4、创建、删除
            createNewFile() 不存在创建新文件,存在返回false
            delete() 删除文件
            static createTempFile(前缀3个字节长，后缀默认.temp) 默认临时空间
            staticcreateTempFile(前缀3个字节长，后缀默认.temp,目录)
            deleteOnExit() 退出虚拟机删除,常用于删除临时文件
            */
        
        try {//这里就理解了为什么file一开始只是建立了连接
            boolean res=file.createNewFile();//file对象创建的时候就把文件名字也写进去了
            System.out.println(res?"成功":"失败");//这里的写法注意
            boolean res1=file.delete();
            System.out.println(res1?"成功":"失败");
            File temp=File.createTempFile("aaa", ".txt",file1);//创建临时文件
            //这里要区分开文件名与文件夹名 这个在io类里很重要
            //	createTempFile(String prefix, String suffix, File directory) 注意这个directory
            long len=file.length();
            System.out.println(""+len);
            Thread.sleep(0);//调用这个记得捕获异常
            temp.deleteOnExit(); //退出即删除
            System.out.println(file.exists());//是否存在  文件/文件夹
            System.out.println(file.canRead());//是否可读  文件/文件夹  这里要理解可读和可写的意思(可操作性)
            System.out.println(file.canWrite());//是否可写  文件/文件夹


            System.out.println(file.getName()); //返回名称
            System.out.println(file.getPath()); //如果是绝对路径，返回完整路径，否则相对路径
            System.out.println(file.getAbsolutePath());//返回绝对路径
            System.out.println(file.getParent());//返回上一级目录，如果是相对，返回null
            //这里要注意！！
            //虽然实际文件不存在 但是依然可以返回名字和路径！
            //相当于那个路径只是在java中建立的
            //区分建立联系和操作


        //4.递归
            /**
             * 输出子孙级目录|文件的名称(绝对路径)
             * 1、listFiles()  使用方法见下边
             * 2、递归
             * 3、static listRoots() 根路径  ？？
             */
        File[] roots=File.listRoots();
        System.out.println(Arrays.toString(roots));
        System.out.println(file1.listFiles());//返回一个file对象 不要直接打印 要调用它的方法
        if(file1.isDirectory()){ //循环打印文件夹下的所有内容  文件/文件夹
			for(File sub:file1.listFiles()){ //返回的是一个可迭代的对象
				System.out.println(sub.getName());
			}
		}
                    

        } catch (IOException e) {
            e.printStackTrace();
        }catch(InterruptedException e){
            e.printStackTrace();
        }catch(SecurityException e){
            e.printStackTrace();
        }
   
    }
}//这里其实写成main主类的一个方法就行 没必要再定义新类
// class FileOrDirctory{
//     private String path=null;
//     File file=null;
//     public FileOrDirctory(String path){
//         this.path=path;
//         file=new File(path);
//     }
    // public void listFiles(){
    // }
// }
