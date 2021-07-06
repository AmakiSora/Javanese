package designpattern.prototype;

/**
 * 原型模式 测试
 */
public class Prototype {
    public void test(){
        Sheep firstSheep = new ConcreteSheep("芬兰多塞特母绵羊");
        System.out.println(firstSheep.toString());
        Sheep Dolly = firstSheep.cloneOne();
        System.out.println(Dolly.toString());
    }
}
