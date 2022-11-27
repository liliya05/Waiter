public class Chef extends User implements Preparation {

    Chef() {

    }

    @Override
    public void cook(Order order) {
        if (order.status.equalsIgnoreCase("ordered")) {
            order.status = "cooking";
        }
    }

    @Override
    public void finishCooking(Order order) {
        if (order.status.equalsIgnoreCase("cooking")) {
            order.status = "cooked";
        }
    }

    @Override
    void switchRoles() {

    }
}
