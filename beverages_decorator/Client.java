package beverages_decorator;

public class Client
{

    public static void main(String[] args)
    {
        Beverage order1 = new Cappuccino();
        order1 = new Milk(order1);
        order1 = new Sugar(order1);

        printOrder(order1);

        Beverage order2 = new Latte();
        order2 = new Chocolate(order2);
        order2 = new Milk(order2);
        order2 = new WhippedCream(order2);

        printOrder(order2);

        Beverage order3 = new BaseBeverage(5);
        order3 = new Milk(order3, 3);
        printOrder(order3);
    }

    private static void printOrder(Beverage beverage)
    {
        System.out.println("Order: " + beverage.getDescription());
        System.out.println("Cost: " + beverage.cost() + " units");
        System.out.println("---");
    }

}