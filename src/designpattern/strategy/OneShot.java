package designpattern.strategy;

/**
 * 开一枪
 */
public class OneShot implements ShootWay {
    @Override
    public void shoot() {
        System.out.println("一发入魂！");
    }
}
