package beverages_decorator;

public class Chocolate extends BeverageDecorator {

    private final int chocCost;

    public Chocolate(Beverage beverage) {
        this(beverage, 8);
    }

    public Chocolate(Beverage beverage, int chocCost) {
        super(beverage);
        this.chocCost = chocCost;
    }

    @Override
    public int cost() {
        return beverage.cost() + chocCost;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Chocolate";
    }
}