import java.util.ArrayList;

public class Menu {
    protected ArrayList<Meal> meals;

    Menu() {
        this.meals = null;
    }

    Menu(ArrayList<Meal> meals) {
        this.meals = meals;
    }

    public ArrayList<Meal> getMeals() {
        return meals;
    }

    public void setMeals(ArrayList<Meal> meals) {
        this.meals = meals;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "meals=" + meals +
                '}';
    }
}
