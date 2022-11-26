import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Order {
    public String[] meals;
    public String date;
    public String time;
    public Tables table;

    Order(String date, String time, Tables table, String[] meals) {
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
