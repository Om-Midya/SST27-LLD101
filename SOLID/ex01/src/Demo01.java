

public class Demo01 {
    public static void main(String[] args) {
        IEmailClient emailClient = new EmailClient();
        IOrderRepository orderRepository = new OrderRepository();
        new OrderService(emailClient, orderRepository).checkout("a@shop.com", 100.0);
    }
}
