package strategy.impl.swordman;

import strategy.AttackStrategy;

public class OneSwordAttack implements AttackStrategy {
    @Override
    public void attack() {
        System.out.println("There will be One Sword Style Attack");
    }
}
