package beverages_decorator;

public class Sugar extends BeverageDecorator {

    private final int sugarCost;

    public Sugar(Beverage beverage) {
        this(beverage, 2);
    }

    public Sugar(Beverage beverage, int sugarCost) {
        super(beverage);
        this.sugarCost = sugarCost;
    }

    @Override
    public int cost() {
        return beverage.cost() + sugarCost;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Sugar";
    }
}