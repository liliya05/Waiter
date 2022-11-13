import java.io.FileNotFoundException;

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

    }
}
