package designpattern.strategy;

public class Strategy {
    public void test(){
        Shooter shooter1 = new Shooter();
        shooter1.setShoot(new OneShot());
        System.out.print("射手1使用了策略:");
        shooter1.shootSomebody();

        Shooter shooter2 = new Shooter();
        shooter2.setShoot(new QuickShot());
        System.out.print("射手2使用了策略:");
        shooter2.shootSomebody();
    }
}
