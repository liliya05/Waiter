import java.util.ArrayList;

public class Order {
    public String date;
    public String time;
    public Tables table;
    public ArrayList<String> meals;

    Order(String date, String time, Tables table, ArrayList<String> meals) {
        this.date = date;
        this.time = time;
        this.table = table;
        this.meals = meals;
    }

    @Override
    public String toString() {
        return "Order{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", table=" + table +
                ", meals=" + meals +
                '}';
    }
}
