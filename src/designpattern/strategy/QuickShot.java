package designpattern.strategy;

/**
 * 快速射击
 */
public class QuickShot implements ShootWay {
    @Override
    public void shoot() {
        System.out.println("快速射击！");
    }
}
