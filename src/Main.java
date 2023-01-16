import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void giveBill() {

    }

    public static void removeFromTheMenu(Waiter waiter, ArrayList<Meal> menu) {

    }
    public static void addToTheMenu(Waiter waiter, ArrayList<Meal> menu, ArrayList<Order> orders) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Meal's name: ");
        String mealName = scan.next();
        System.out.println("Meal's price: ");
        double mealPrice = scan.nextDouble();
        menu.add(new Meal(mealName, mealPrice));
        waiter.addToTheMenu(menu);
        System.out.println("Do you want to add anything else?");
        String ans = scan.next();
        if (ans.equalsIgnoreCase("yes")) {
            addToTheMenu(waiter, menu, orders);
        }
        if (ans.equalsIgnoreCase("no")) {
            chooseForWaiter(waiter, menu, orders);
        }
        while (!ans.equalsIgnoreCase("yes") && !ans.equalsIgnoreCase("no")) {
            System.out.println("Enter a valid input.");
            ans = scan.next();
            if (ans.equalsIgnoreCase("yes")) {
                addToTheMenu(waiter, menu, orders);
            }
            if (ans.equalsIgnoreCase("no")) {
                chooseForWaiter(waiter, menu, orders);
            }
        }
    }

    public static void changeMenu(ArrayList<Meal> menu, Waiter waiter, ArrayList<Order> orders) {
        Scanner scan = new Scanner(System.in);
        System.out.println("What do you want to do?");
        System.out.println("1. Add to the menu");
        System.out.println("2. Remove from the menu");
        int ans = scan.nextInt();
        if (ans == 1) {
            addToTheMenu(waiter, menu, orders);
        }
        if (ans == 2) {
            removeFromTheMenu(waiter, menu);
        }
        while (ans < 1 || ans > 2) {
            System.out.println("Enter a valid option.");
            ans = scan.nextInt();
            if (ans == 1) {
                addToTheMenu(waiter, menu, orders);
            }
            if (ans == 2) {
                removeFromTheMenu(waiter, menu);
            }
        }
    }

    public static void makeOrders(Waiter waiter, ArrayList<Meal> menu, ArrayList<Order> orders) {
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
                addMealsToOrder(waiter, menu, new Order(date, time, table1, new ArrayList<>(), "ordered"), orders);
                break;
            case 2:
                System.out.println("Order for table " + table2.tableNumber + ":");
                addMealsToOrder(waiter, menu, new Order(date, time, table2, new ArrayList<>(), "ordered"), orders);
                break;
            case 3:
                System.out.println("Order for table " + table3.tableNumber + ":");
                addMealsToOrder(waiter, menu, new Order(date, time, table3, new ArrayList<>(), "ordered"), orders);
                break;
        }
    }

    public static void finishCooking() {

    }

    public static void prepareAnOrder() {

    }

    public static void chooseForChef() {
        Scanner scan = new Scanner(System.in);
        System.out.println("What do you want to do?");
        System.out.println("1.Prepare an order");
        System.out.println("2.Look at the active orders");
        int ans = scan.nextInt();
        if (ans == 1) {

        }
    }

    public static void chooseForWaiter(Waiter waiter, ArrayList<Meal> menu, ArrayList<Order> orders) {
        Scanner scan = new Scanner(System.in);
        System.out.println("What do you want to do?");
        System.out.println("1. Make an order");
        System.out.println("2. Change the menu");
        System.out.println("3. Give bill");
        System.out.println("4. Serve a table");
        System.out.println("5. Switch role to chef");
        int ans = scan.nextInt();
        if (ans == 1) {
            makeOrders(waiter, menu, orders);
        }
        if (ans == 2) {
            changeMenu(menu, waiter, orders);
        }
        if (ans == 3) {
        }
        if (ans == 4) {
        }
        if (ans == 5) {

        }
        while (ans < 1 || ans > 2) {
            System.out.println("Enter a valid option.");
            ans = scan.nextInt();
            if (ans == 1) {
                makeOrders(waiter, menu, orders);
            }
            if (ans == 2) {
            }
        }
    }

    public static void addMealsToOrder(Waiter waiter, ArrayList<Meal> menu, Order order, ArrayList<Order> orders) {
        Scanner scan = new Scanner(System.in);
        String mealName;
        do {
            mealName = scan.next();
            if (!mealName.equals("0")) {
                for (Meal m : menu) {
                    if (mealName.contains(m.name)) {
                        order.meals.add(new Meal(mealName, m.price));
                    }
                }
            }
        } while (!mealName.equals("0"));
        orders.add(order);
        waiter.writeOrders(menu, orders);
        chooseForWaiter(waiter, menu, orders);
    }

    public static void loginUsers(Waiter waiter, Chef chef) {
        // Logging users in
        Login login = new Login();

        try {
            login.loginChef(chef, chef.userName, chef.userPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            login.loginWaiter(waiter, waiter.userName, waiter.userPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Chef chef = new Chef("Tosho", "t1234");
        Waiter waiter = new Waiter("Gosho", "g1234");
        loginUsers(waiter, chef);

        ArrayList<Meal> menu = new ArrayList<>();
        menu.add(new Meal("fish", 3.4));
        menu.add(new Meal("steak", 6.1));
        menu.add(new Meal("water", 1.90));
        menu.add(new Meal("juice", 2));
        menu.add(new Meal("cake", 4.20));

        System.out.println("Choose a role: ");
        System.out.println("1. Waiter");
        System.out.println("2. Chef");
        int roleNumber = scan.nextInt();
        if (roleNumber == 1) {
            ArrayList<Order> orders = new ArrayList<>();
            chooseForWaiter(waiter, menu, orders);
        }
        if (roleNumber == 2) {
            ArrayList<Order> orders = new ArrayList<>();
            waiter.writeOrders(menu, orders);
        }
    }
}
