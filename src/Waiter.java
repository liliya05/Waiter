import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Waiter extends User implements Serveable, Payable, MenuManagement, Orderable {


    @Override
    public void addToTheMenu(ArrayList<String> menu, String meal, double price) {
        menu.add(meal);

        // Check the number of line where the new meal will be added
        Path path = Paths.get("menu.txt");
        int numberOfMeal = 0;
        try {
            numberOfMeal = (int) Files.lines(path).count() + 1;
        } catch (IOException e) {
            e.printStackTrace();
        }

        // add to menu without overwriting file
        try {
            FileWriter fStream = new FileWriter("menu.txt", true);
            BufferedWriter menuFile = new BufferedWriter(fStream);
            menuFile.write(numberOfMeal + ". " + meal + ", price: " + price + "\n");
            menuFile.close();
        } catch (Exception e) {
            System.err.println("Error while writing to file: " +
                    e.getMessage());
        }
    }


    @Override
    public void removeFromTheMenu(ArrayList<String> menu, int numberOfMeal) {
        menu.remove(numberOfMeal-1);
        //TODO: Remove the meal from the txt file too
    }

    @Override
    public void giveBill() {

    }

    @Override
    void switchRoles() {

    }

    @Override
    public void serveTable() {

    }

    @Override
    public void makeAnOrder(ArrayList<String> menu, Order order) {
        //TODO: make possible ordering multiple meals and write orders in a text file
        if (order.table.status.equalsIgnoreCase("free") && menu.contains(order.meal)) {
            System.out.println("Order for table " + order.table.tableNumber + ": " + order.meal);
            order.table.status = "waiting for order to be served";
        }
        else if (!order.table.status.equalsIgnoreCase("free")) {
            System.out.println("An order was already made.");
        }
        else if (!menu.contains(order.meal)) {
            System.out.println("This meal isn't on the menu.");
        }
    }

    @Override
    public void changeTheOrder() {

    }
}
