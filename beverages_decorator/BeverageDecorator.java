package beverages_decorator;

public abstract class BeverageDecorator extends Beverage {
    protected final Beverage beverage;

    @Override
    public int cost() {
        return beverage.cost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription();
    }

    protected BeverageDecorator(Beverage beverage) {
        this.beverage = beverage;
    }
}