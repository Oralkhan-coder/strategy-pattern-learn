package strategy.impl.sniper;

import strategy.AttackStrategy;

public class GunShoot implements AttackStrategy {

    @Override
    public void attack() {
        System.out.println("Here sniper will be strike by gun!");
    }
}
