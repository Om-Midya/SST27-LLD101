public class OrderController {
    OrderRepository repo;

    OrderController(OrderRepository repo){
        this.repo = repo;
    }
    void create(String id){
        repo.save(id);
        System.out.println("Created order: " + id);
    }
}