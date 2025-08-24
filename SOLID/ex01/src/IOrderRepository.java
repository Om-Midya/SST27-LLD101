public interface IOrderRepository {
    void storeOrder(String customerEmail, double total);
}
