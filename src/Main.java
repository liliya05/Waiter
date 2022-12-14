import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void giveBill() {

    }

    public static void removeFromTheMenu(ArrayList<String> menu, Waiter waiter) {

    }
    public static void addToTheMenu(ArrayList<String> menu, Waiter waiter) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Meal's name: ");
        String meal = scan.next();
        System.out.println("Meal's price: ");
        double price = scan.nextDouble();
        waiter.addToTheMenu(menu, meal, price);
        System.out.println("Do you want to add anything else?");
        String ans = scan.next();
        if (ans.equalsIgnoreCase("yes")) {
            addToTheMenu(menu, waiter);
        }
        if (ans.equalsIgnoreCase("no")) {
            chooseForWaiter(menu);
        }
    }

    public static void changeMenu(ArrayList<String> menu, Waiter waiter) {
        Scanner scan = new Scanner(System.in);
        System.out.println("What do you want to do?");
        System.out.println("1. Add to the menu");
        System.out.println("2. Remove from the menu");
        int ans = scan.nextInt();
        if (ans == 1) {
            addToTheMenu(menu, waiter);
        }
        if (ans == 2) {
            removeFromTheMenu(menu, waiter);
        }
        while (ans < 1 || ans > 2) {
            System.out.println("Enter a valid option.");
            ans = scan.nextInt();
            if (ans == 1) {
                addToTheMenu(menu, waiter);
            }
            if (ans == 2) {
            }
        }
    }

    public static void makeOrders(Waiter waiter, ArrayList<String> menu, ArrayList<String> mealsOrder) {
        Scanner scan = new Scanner(System.in);
        Tables table1 = new Tables();
        Tables table2 = new Tables(2, "free");
        Tables table3 = new Tables(3, "free");

        System.out.print("Make an order for table: ");
        int tableNumber = scan.nextInt();
        System.out.print("Enter date: ");
        String date = scan.next();
        System.out.print("Enter time: ");
        String time = scan.next();

        switch (tableNumber) {
            case 1:
                System.out.println("Order for table " + table1.tableNumber + ":");
                String meals = scan.next();
                addMealsToOrder(menu, meals, mealsOrder);
                waiter.makeAnOrder(menu, new Order(date, time, table1, mealsOrder, "ordered"));
                break;
            case 2:
                System.out.println("Order for table " + table2.tableNumber + ":");
                meals = scan.next();
                addMealsToOrder(menu, meals, mealsOrder);
                waiter.makeAnOrder(menu, new Order(date, time, table2, mealsOrder, "ordered"));
                break;
            case 3:
                System.out.println("Order for table " + table3.tableNumber + ":");
                meals = scan.next();
                addMealsToOrder(menu, meals, mealsOrder);
                waiter.makeAnOrder(menu, new Order(date, time, table3, mealsOrder, "ordered"));
                break;
            default:
                System.out.println("Such a table doesn't exist.");
        }
    }

    public static void cook(Chef chef) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Cook an order for table ");
        int tN = scan.nextInt();
    }

    public static void finishCooking() {

    }
    public static void chooseForChef() {
        Chef chef = new Chef();
        Scanner scan = new Scanner(System.in);
        System.out.println("What do you want to do?");
        System.out.println("1. Cook an order");
        System.out.println("2. Finish cooking an order");
        int ans = scan.nextInt();
        if (ans == 1) {
        }
        if (ans == 2) {
        }
        while (ans < 1 || ans > 2) {
            System.out.println("Enter a valid option.");
            ans = scan.nextInt();
            if (ans == 1) {
            }
            if (ans == 2) {
            }
        }
    }
    public static void chooseForWaiter(ArrayList<String> menu) {
        Waiter waiter = new Waiter();
        ArrayList<String> mealsOrder = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("What do you want to do?");
        System.out.println("1. Make an order");
        System.out.println("2. Change the menu");
        int ans = scan.nextInt();
        if (ans == 1) {
            makeOrders(waiter, menu, mealsOrder);
        }
        if (ans == 2) {
            changeMenu(menu, waiter);
        }
        while (ans < 1 || ans > 2) {
            System.out.println("Enter a valid option.");
            ans = scan.nextInt();
            if (ans == 1) {
                makeOrders(waiter, menu, mealsOrder);
            }
            if (ans == 2) {
                changeMenu(menu, waiter);
            }
        }
    }

        public static void addMealsToOrder (ArrayList<String> menu, String meal, ArrayList <String> mealsOrder){
            Scanner scan = new Scanner(System.in);
            mealsOrder.add(meal);
            while (!meal.equalsIgnoreCase("0")) {
                meal = scan.next();
                mealsOrder.add(meal);
                if (meal.equalsIgnoreCase("0")) {
                    mealsOrder.remove("0");
                    chooseForWaiter(menu);
                }
            }
        }

        public static void loginUsers () {
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

        public static void main (String[]args){
            loginUsers();
            ArrayList<String> menu = new ArrayList<>();
            chooseForWaiter(menu);

        }
    }
