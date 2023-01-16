import java.util.ArrayList;

public interface Orderable {
    void writeOrders(ArrayList<Meal> menu, ArrayList<Order> orders);
    void changeTheOrder();
}
