import java.util.ArrayList;

public interface MenuManagement {
    void addToTheMenu(ArrayList<String> menu, String meal, double price);
    void removeFromTheMenu(ArrayList<String> menu, int idex);
}
