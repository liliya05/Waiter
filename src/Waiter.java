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
        menu.remove(numberOfMeal - 1);
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
        Path path = Paths.get("orders.txt");
        int lines = 0;
        try {
            lines = (int) Files.lines(path).count() + 1;
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileWriter fStream = new FileWriter("orders.txt", true);
            BufferedWriter menuFile = new BufferedWriter(fStream);
            for (String s : order.meals) {
                if (menu.containsAll(order.meals) && order.table.status.equalsIgnoreCase("free")) {
                    System.out.println("Order for table " + order.table.tableNumber + ": " + order.meals);
                    order.table.status = "waiting for order to be served";
                    menuFile.write("Order " + lines + ": " + order.meals + " on table - " + order.table + ". Added on: "
                            + order.time + ", " + order.date + "\n");
                    menuFile.close();
                } else if (!order.table.status.equalsIgnoreCase("free")) {
                    System.out.println("An order was already made.");
                } else if (!menu.contains(s)) {
                    System.out.println(s + " isn't on the menu.");
                }
            }
            try {
                FileWriter fileWriter = new FileWriter("orders.txt", true);
                BufferedWriter ordersFile = new BufferedWriter(fileWriter);
                ordersFile.write((order) + "\n");
                ordersFile.close();
            } catch (Exception e) {
                System.out.println("Error while writing to file: " +
                        e.getMessage());
            }
        } catch (Exception e) {
            System.err.println("Error while writing to file: " +
                    e.getMessage());
        }
    }

    @Override
    public void changeTheOrder() {

    }
}
