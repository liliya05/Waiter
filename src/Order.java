import java.util.ArrayList;

public class Order {
    public String date;
    public String time;
    public Tables table;
    public ArrayList<String> meals;
    public String status;

    Order(String date, String time, Tables table, ArrayList<String> meals, String status) {
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
