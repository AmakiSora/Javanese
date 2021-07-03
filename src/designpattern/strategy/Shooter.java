package designpattern.strategy;

/**
 * 枪手类
 */
public class Shooter {
    private ShootWay shootWay;
    public void shootSomebody(){
        if (shootWay != null){
            shootWay.shoot();
        }
    }

    public void setShoot(ShootWay shootWay) {
        this.shootWay = shootWay;
    }
}
