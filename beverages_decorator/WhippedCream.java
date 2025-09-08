package beverages_decorator;

public class WhippedCream extends BeverageDecorator {

    private final int creamCost;

    public WhippedCream(Beverage beverage) {
        this(beverage, 7);
    }

    public WhippedCream(Beverage beverage, int creamCost) {
        super(beverage);
        this.creamCost = creamCost;
    }

    @Override
    public int cost() {
        return beverage.cost() + creamCost;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", WhippedCream";
    }
}