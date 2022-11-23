public class Tables {
    protected int tableNumber;
    protected String status;

    Tables() {
        this.tableNumber = 1;
        this.status = "free";
    }

    Tables(int tableNumber, String status) {
        this.tableNumber = tableNumber;
        this.status = status;
    }


    @Override
    public String toString() {
        return "Tables{" +
                "tableNumber=" + tableNumber +
                ", status='" + status + '\'' +
                '}';
    }
}
