package strategy.context;

public class StrategyContext {
    private SniperStrategy sniperStrategy;
    private SwordmanStrategy swordmanStrategy;

    public StrategyContext(SniperStrategy sniperStrategy, SwordmanStrategy swordmanStrategy) {
        this.sniperStrategy = sniperStrategy;
        this.swordmanStrategy = swordmanStrategy;
    }
}
