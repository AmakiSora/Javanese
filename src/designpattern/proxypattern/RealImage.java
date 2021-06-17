package designpattern.proxypattern;

/**
 * 图片实现类
 */
public class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName){
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void display() {
        System.out.println("展示图片" + fileName);
    }

    private void loadFromDisk(String fileName){
        System.out.println("加载图片" + fileName);
    }
}
