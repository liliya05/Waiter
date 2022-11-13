import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Login {

    Login(){

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
    public void loginChef(){

        System.out.println("Login for chef -");
        // Ask for info
        System.out.print("Enter your name: ");
        String userName = read.next();
        System.out.print("Enter your password: ");
        String userPassword = read.next();

        // Write info in text file
        fileWriter.println("Chef info: " + userName + ", " + userPassword);

    }

    public void loginWaiter(){
        // Ask for info
        System.out.print("Enter your name: ");
        String userName = read.next();
        System.out.print("Enter your password: ");
        String userPassword = read.next();

        // Write info in text file
        fileWriter.println("Waiter info: " + userName + ", " + userPassword);

        fileWriter.close();
    }


}
