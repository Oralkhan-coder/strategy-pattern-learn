package strategy.impl.swordman;

import strategy.AttackStrategy;

public class TwoSwordAttack implements AttackStrategy {
    @Override
    public void attack() {
        System.out.println("There will be Two Sword Style Attack");
    }
}
