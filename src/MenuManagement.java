import java.util.ArrayList;

public interface MenuManagement {
    void addToTheMenu(ArrayList<Meal> menu);
    void removeFromTheMenu(ArrayList<String> menu, int index);
}