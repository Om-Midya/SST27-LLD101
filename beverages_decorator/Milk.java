package beverages_decorator;

public class Milk extends BeverageDecorator {

    private final int milkCost;

    public Milk(Beverage beverage) {
        this(beverage, 5);
    }

    public Milk(Beverage beverage, int milkCost) {
        super(beverage);
        this.milkCost = milkCost;
    }

    @Override
    public int cost() {
        return beverage.cost() + milkCost;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    }
}