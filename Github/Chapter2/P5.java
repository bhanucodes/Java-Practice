import java.util.Scanner;

abstract class DesertItem {
    abstract int getCost();
}

class Candy extends DesertItem {
    int candies;

    int addCandies(int count) {
        this.candies += count;
        return this.candies;
    }

    @Override
    int getCost() {
        return candies * 60;
    }
}

class Cookie extends DesertItem {
    int cookies;

    int addCookies(int count) {
        this.cookies += count;
        return this.cookies;
    }

    @Override
    int getCost() {
        return cookies * 70;
    }
}

class IceCream extends DesertItem {
    int icecreams;

    int addIceCreams(int count) {
        this.icecreams += count;
        return this.icecreams;
    }

    @Override
    int getCost() {
        return icecreams;
    }
}

public class P5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Candy candy = new Candy();
        Cookie cookie = new Cookie();
        IceCream iceCream = new IceCream();

        while (true) {
            System.out.print("\nRole (owner/customer/exit): ");
            String role = sc.nextLine().toLowerCase();

            if (role.equals("owner")) {
                System.out.println("1. Add Candy");
                System.out.println("2. Add Cookie");
                System.out.println("3. Add Ice Cream");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();

                System.out.print("Enter quantity: ");
                int qty = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        candy.addCandies(qty);
                        System.out.println("Candies added. Total: " + candy.candies);
                        break;
                    case 2:
                        cookie.addCookies(qty);
                        System.out.println("Cookies added. Total: " + cookie.cookies);
                        break;
                    case 3:
                        iceCream.addIceCreams(qty);
                        System.out.println("Ice Creams added. Total: " + iceCream.icecreams);
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }

            } else if (role.equals("customer")) {
                System.out.println("1. Order Candy");
                System.out.println("2. Order Cookie");
                System.out.println("3. Order Ice Cream");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        System.out.println("Cost of Candy: ₹" + candy.getCost());
                        break;
                    case 2:
                        System.out.println("Cost of Cookie: ₹" + cookie.getCost());
                        break;
                    case 3:
                        System.out.println("Cost of Ice Cream: ₹" + iceCream.getCost());
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }

            } else if (role.equals("exit")) {
                System.out.println("Exiting program.");
                break;
            } else {
                System.out.println("Invalid input. Please enter 'owner', 'customer', or 'exit'.");
            }
        }

        sc.close();
    }
}
