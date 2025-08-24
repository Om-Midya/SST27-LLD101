public class OrderService implements IOrderService {
    IEmailClient email;
    IOrderRepository repository;

    double taxRate = 0.18;
    OrderService(IEmailClient email, IOrderRepository repository){
        this.email = email;
        this.repository = repository;
    }

    double totalWithTax(double subtotal) {
        return subtotal + subtotal * taxRate;
    }
    public void checkout(String customerEmail, double subtotal) {
        double total = totalWithTax(subtotal);
        email.send(customerEmail, "Thanks! Your total is " + total);
        repository.storeOrder(customerEmail, total);
    }
}