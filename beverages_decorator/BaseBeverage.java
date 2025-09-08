package beverages_decorator;

// Simple beverage used as a base when no specific coffee type is given.
public class BaseBeverage extends Beverage {
	private final int baseCost;

	public BaseBeverage() {
		this.baseCost = 0;
	}

	public BaseBeverage(int baseCost) {
		this.baseCost = baseCost;
	}

	@Override
	public int cost() {
		return baseCost;
	}

	@Override
	public String getDescription() {
		return "Beverage";
	}
}
