import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Waiter extends User implements Serveable, Payable, MenuManagement, Orderable {
    protected String userName;
    protected String userPassword;


    Waiter() {
        this.userName = null;
        this.userPassword = null;
    }

    Waiter(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }


    @Override
    public void addToTheMenu(ArrayList<Meal> menu) {
        File menuFile = new File("menu.txt");
        try {
            FileWriter fileWriter = new FileWriter(menuFile);
            for (Meal meal : menu) {
                fileWriter.write(meal + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void removeFromTheMenu(ArrayList<String> menu, int numberOfMeal) {
        menu.remove(numberOfMeal - 1);
        //TODO: Remove the meal from the txt file too
    }

    @Override
    public void giveBill() {

    }

    @Override
    public void serveTable(Order order) {
        if (order.status.equalsIgnoreCase("cooked")) {
            order.status = "served";
        }
        if (order.status.equalsIgnoreCase("ordered")) {
            System.out.println("The order isn't ready yet.");
        } else if (order.table.status.equalsIgnoreCase("free")) {
            System.out.println("This table doesn't have an order yet.");
        }
    }

    @Override
    public void writeOrders(ArrayList<Meal> menu, ArrayList<Order> orders) {
        File ordersFile = new File("orders.txt");
        try {
            FileWriter fileWriter = new FileWriter(ordersFile, true);
            Order order = orders.get(orders.size() - 1);
            order.table.status = "waiting to be served";
            fileWriter.write(order + "\n");
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void changeTheOrder() {
    }

    @Override
    void switchRoles(int ans) {

    }
}

