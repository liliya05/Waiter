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
    }
}
