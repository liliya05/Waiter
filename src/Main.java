import java.util.ArrayList;

public class Main {

    public static void loginUsers(){
        // Logging users in
        Login login = new Login();

        try {
            login.loginChef();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            login.loginWaiter();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        loginUsers();
        ArrayList<String> menu = new ArrayList<>();
        Waiter waiter = new Waiter();
        waiter.addToTheMenu(menu, "chicken nuggets", 5.4);
        waiter.addToTheMenu(menu, "apple juice", 1);
        waiter.addToTheMenu(menu, "cheesecake", 3.65);
        waiter.addToTheMenu(menu, "cake", 6);

        // test
        System.out.println(menu.toArray().length);

        Tables table1 = new Tables();
        Tables table2 = new Tables(2, "free");
        System.out.println(table1.status);
        waiter.makeAnOrder(menu, new Order("12.11.22", "14:31", table1, "cake"));
        System.out.println(table1.status);
        waiter.makeAnOrder(menu, new Order("12.11.22", "15:00", table2, "steak"));
        waiter.makeAnOrder(menu, new Order("12.11.22", "15:00", table2, "apple juice"));
        waiter.makeAnOrder(menu, new Order("12.11.22", "15:00", table2, "chicken nuggets"));

    }
}
