public class Demo09 {
    public static void main(String[] args) {
        new OrderController(new SqlOrderRepository()).create("ORD-1");
    }
}
