import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

public class Waiter extends User implements Serveable, Payable, MenuManagement {

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
    public void addToTheMenu(ArrayList<String> menu, String meal, double price) {
        menu.add(meal+ " - " + price);
        PrintStream printStream = null;
        try {
            printStream = new PrintStream("menu.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        printStream.println(menu);
        printStream.close();
    }

    @Override
    public void removeFromTheMenu(ArrayList<String> menu, int index) {
        menu.remove(index);
        PrintStream printStream = null;
        try {
            printStream = new PrintStream("menu.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        printStream.println(menu);
        printStream.close();
    }
}
