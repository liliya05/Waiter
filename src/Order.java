public class Order {
    protected String date;
    protected String time;
    protected Tables table;
    protected String meal;

    Order(String date, String time, Tables table, String meal) {
        this.date = date;
        this.time = time;
        this.table = table;
        this.meal = meal;
    }
}
