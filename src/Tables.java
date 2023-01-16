public class Tables implements CharSequence {
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
    public int length() {
        return 0;
    }

    @Override
    public char charAt(int index) {
        return 0;
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return null;
    }

    @Override
    public String toString() {
        return "Tables{" +
                "tableNumber=" + tableNumber +
                ", status='" + status + '\'' +
                '}';
    }
}

