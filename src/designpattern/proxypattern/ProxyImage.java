package designpattern.proxypattern;

/**
 * 图片代理类
 */
public class ProxyImage implements Image{

    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if(realImage == null){//加载一次后，无需再次加载
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}