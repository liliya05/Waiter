import java.util.ArrayList;

public class Order {
    public String date;
    public String time;
    public Tables table;
    public ArrayList<Meal> meals;
    public String status;

    Order() {
        this.date = null;
        this.time = null;
        this.table = null;
        this.meals = null;
        this.status = null;
    }

    Order(String date, String time, Tables table, ArrayList<Meal> meals, String status) {
        this.date = date;
        this.time = time;
        this.table = table;
        this.meals = meals;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", table=" + table +
                ", meals=" + meals +
                ", status='" + status + '\'' +
                '}';
    }
}
