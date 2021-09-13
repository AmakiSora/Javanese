package java_.java12;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Files新增方法(mismatch)
 * java12新特性
 * 查找并返回两个文件内容中第一个不匹配字节的位置,如果没有不匹配,则返回-1L
 * 该位置将在0L的包含范围内,直到较小文件的大小(以字节为单位)
 * 如果两个文件满足以下条件之一,则认为它们匹配：
 * 两个路径定位同一个文件,即使两个相等的路径定位一个文件不存在,或者
 * 这两个文件大小相同,第一个文件中的每个字节都与第二个文件中的相应字节相同
 * 否则两个文件不匹配,这个方法返回的值是：
 * 第一个不匹配字节的位置,或当文件大小不同且较小文件的每个字节与较大文件的相应字节相同时,较小文件的大小(以字节为单位)
 * 对于其他文件系统操作,此方法可能不是原子的
 * 此方法始终是自反的(对于Path f,mismatch(f,f)返回-1L)
 * 如果文件系统和文件保持静态,则此方法是对称的(对于两个Paths f和g , mismatch(f,g)将返回与mismatch(g,f)相同的值)
 */
public class Files_12 {
    private void java12Version() throws IOException {
        FileWriter fileWriter = new FileWriter("");
        fileWriter.write("a");
        fileWriter.write("b");
        fileWriter.write("c");
        fileWriter.close();

        FileWriter fileWriter2 = new FileWriter("");
        fileWriter2.write("a");
        fileWriter2.write("b");
        fileWriter2.write("c");
        fileWriter2.close();

//        System.out.println(Files.mismatch(Path.of(""), Path.of("")));
    }

    public void test() throws IOException {
        java12Version();
    }
}
