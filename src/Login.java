import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Login {

    Login() {

    }

    // Create a PrintStream instance
    PrintStream fileWriter;

    {
        try {
            fileWriter = new PrintStream("userInfo.txt");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Scanner read = new Scanner(System.in);

    public void loginChef(Chef chef, String userName, String userPassword) {
        System.out.println("Login for chef -");
        // Ask for info
        System.out.print("Enter your name: ");
        userName = read.next();
        System.out.print("Enter your password: ");
        userPassword = read.next();

        if (chef.userName.equals(userName) && chef.userPassword.equals(userPassword)) {
            // Write info in text file
            fileWriter.println("Chef info: " + userName + ", " + userPassword);
        }
        else {
            while (!chef.userName.equals(userName) || !chef.userPassword.equals(userPassword)) {
                System.out.println("Wrong username or password.");
                System.out.print("Enter your name: ");
                userName = read.next();
                System.out.print("Enter your password: ");
                userPassword = read.next();
            }
        }
    }

    public void loginWaiter(Waiter waiter, String userName, String userPassword) {
        System.out.println("Login for waiter -");
        // Ask for info
        System.out.print("Enter your name: ");
        userName = read.next();
        System.out.print("Enter your password: ");
        userPassword = read.next();

        // Write info in text file
        if (waiter.userName.equals(userName) && waiter.userPassword.equals(userPassword)) {
            fileWriter.println("Waiter info: " + userName + ", " + userPassword);
        }
        else {
            while (!waiter.userName.equals(userName) || !waiter.userPassword.equals(userPassword)) {
                System.out.println("Wrong username or password.");
                System.out.print("Enter your name: ");
                userName = read.next();
                System.out.print("Enter your password: ");
                userPassword = read.next();
            }
        }
        fileWriter.close();
    }
}
