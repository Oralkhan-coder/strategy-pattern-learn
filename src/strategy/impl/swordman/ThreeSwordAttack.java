package strategy.impl.swordman;

import strategy.AttackStrategy;

public class ThreeSwordAttack implements AttackStrategy {
    @Override
    public void attack() {
        System.out.println("There will be three sword style");
    }
}
