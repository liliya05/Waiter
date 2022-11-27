import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

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
    public void makeAnOrder(ArrayList<String> menu, Order order) {
        Path path = Paths.get("orders.txt");
        int lines = 0;
        try {
            lines = (int) Files.lines(path).count() + 1;
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            try {
                File file = new File("orders.txt");
                Scanner scanner = new Scanner(file);
                //now read the file line by line...
                int lineNum = 0;
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    lineNum++;
                    if (line.contains(order.table) && order.table.equals("waiting for order to be served")) {
                        System.out.println("This table has already made an order!");
                        return;
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println(e);
            }
            FileWriter fStream = new FileWriter("orders.txt", true);
            BufferedWriter menuFile = new BufferedWriter(fStream);
            for (String meal : order.meals) {
                if (!menu.contains(meal)) {
                    System.out.println(meal + " isn't on the menu.");
                }
            }
            if (menu.containsAll(order.meals) && order.table.status.equalsIgnoreCase("free")) {
                System.out.println("Order for table " + order.table.tableNumber + ": " + order.meals);
                order.table.status = "waiting for order to be served";
                menuFile.write("Order " + lines + ": " + order.meals + " on table " + order.table.tableNumber +
                        ", status: " + order.table.status + "; Added on: " + order.time + ", " + order.date + "\n");
                menuFile.close();
            }
            if (!order.table.status.equalsIgnoreCase("free")) {
                System.out.println("This table already has an order.");
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
