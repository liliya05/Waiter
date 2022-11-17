import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintStream;
import java.util.ArrayList;

public class Waiter extends User implements Serveable, Payable, MenuManagement {

    @Override
    public void addToTheMenu(ArrayList<String> menu, String meal, double price) {
        menu.add(meal+ " - " + price);
        // add to menu without overwriting file
        try{
            int mealCount = 1;
            FileWriter fstream = new FileWriter("menu.txt",true);
            BufferedWriter menuFile = new BufferedWriter(fstream);
            menuFile.write(mealCount + ". " + meal + ", price: " + price + "\n");
            // TODO: Make mealCount go up for every meal added to the menu
            menuFile.close();
        }catch (Exception e){
            System.err.println("Error while writing to file: " +
                    e.getMessage());
        }

    }

    @Override
    public void removeFromTheMenu(ArrayList<String> menu, int index) {
        //TODO: Make menu items get removed w/o getting menu file overwritten
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
}
