package strategy.impl.sniper;

import strategy.AttackStrategy;

public class SlingshotShoot implements AttackStrategy {
    @Override
    public void attack() {
        System.out.println("Here hero will be shoot by Slingshot");
    }
}
