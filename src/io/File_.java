package io;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * File类的使用
 */
public class File_ {
    /**
     * File类的构造方法
     * 构造方法生成的对象为抽象对象，不一定实际存在
     * 路径名可以为绝对路径，也可以为相对路径
     */
    private void fileConstructor(){
        System.out.println("----构造方法演示----");
        File f1 = new File("D:\\cosmos\\test\\test.txt");//路径名
        System.out.println(f1);
        File f2 = new File("D:\\cosmos\\test","test.txt");//父路径,子路径
        System.out.println(f2);
        File f3 = new File("D:\\cosmos\\test");
        File f4 = new File(f3,"test.txt");//父路径为f3的路径
        System.out.println(f4);
    }
    /**
     * 文件的创建
     * createNewFile()；如果文件存在，则不创建文件，并返回false
     *                   如果文件不存在，则创建文件，并返回true
     *                   如果父目录不存在会抛出异常
     * 注意事项：如果目录名和文件名同名则创建文件失败(返回false)
     */
    private void fileCreate() throws IOException {
        System.out.println("----创建文件演示----");
        File f = new File("D:\\cosmos\\test\\test.txt");
        System.out.println(f.createNewFile());
    }
    /**
     * 目录的创建
     * mkdir()；如果目录存在，则不创建目录，并返回false
     *           如果目录不存在，则创建目录，并返回true
     *           如果父目录不存在会返回false，即不可创建多级目录
     * mkdirs()：用于创建多级目录
     * 注意事项：如果创建的目录带.txt此类的后缀名，但还是会创建目录，不会创建文件
     */
    private void directoryCreate(){
        System.out.println("----创建目录演示----");
        File f = new File("D:\\cosmos\\test");
        System.out.println(f.mkdir());
        System.out.println(f.mkdirs());
    }

    /**
     * 文件的删除
     * delete()：如果为文件或空目录，则删除，并返回true
     *            如果文件不存在或者目录里有内容，则返回false
     */
    private void fileDelete(){
        System.out.println("----删除文件演示----");
        File f = new File("D:\\cosmos\\test");
        System.out.println(f.delete());
    }

    /**
     * 文件的判断
     * isDirectory():判断该路径是否为文件夹，是true，否false
     * isFile():判断该路径是否为文件，是true，否false
     * exists():判断该路径是否存在，是true，否false
     */
    private void fileJudge(){
        System.out.println("----判断文件演示----");
        File f = new File("D:\\cosmos\\test");
        System.out.println(f.isDirectory());
        System.out.println(f.isFile());
        System.out.println(f.exists());
    }

    /**
     * 获取文件信息
     * getAbsolutePath():返回此抽象路径名的绝对路径名字符串
     * getAbsoluteFile():返回File对象
     * getCanonicalPath():返回抽象路径名的规范路径名字符串(系统不同输出不同)
     * getPath():返回此对象的路径名字符串(相对路径/绝对路径)
     * getName():返回此对象的名称
     * getParent():返回上一层目录名
     * getParentFile():返回上一层目录的File对象
     * getFreeSpace():返回由此抽象路径名命名的分区中未分配的字节数
     * getTotalSpace():返回由此抽象路径名命名的分区的大小
     * getUsableSpace()返回此抽象路径名命名的分区上此虚拟机可用的字节数
     */
    private void fileGet() throws IOException {
        System.out.println("----获取文件信息演示----");
        File f = new File("test\\t.txt");
        System.out.println(f.getAbsolutePath());
        File f2 = f.getAbsoluteFile();
        System.out.println(f.getCanonicalPath());
        System.out.println(f.getPath());
        System.out.println(f.getName());
        System.out.println(f.getParent());
        File f3 = f.getParentFile();
        System.out.println(f.getFreeSpace());
        System.out.println(f.getTotalSpace());
        System.out.println(f.getUsableSpace());
    }

    /**
     * 遍历文件夹
     * list():获取文件夹里所有的文件名
     * listFiles():获取文件夹里所有的文件对象
     */
    private void fileList(){
        System.out.println("----遍历文件夹演示----");
        File f = new File("D:\\cosmos\\test");
        System.out.println(Arrays.toString(f.list()));
        File[] files = f.listFiles();
    }
    public void test() throws IOException {
        fileConstructor();
        fileCreate();
        directoryCreate();
        fileDelete();
        fileJudge();
        fileGet();
        fileList();
    }
}
