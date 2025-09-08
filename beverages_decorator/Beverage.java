package beverages_decorator;

public abstract class Beverage
{
    public abstract int cost();

    public String getDescription()
    {
        return this.getClass().getSimpleName();
    }
}