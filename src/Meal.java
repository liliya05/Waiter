public class Meal {
    public String name;
    public double price;

    Meal() {
        this.name = null;
        this.price = 0;
    }

    Meal(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
