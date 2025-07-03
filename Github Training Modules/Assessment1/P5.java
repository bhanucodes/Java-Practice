import java.util.Scanner;

class Login {
    String userId = "Ajay";
    String password = "password";
    int loginAttempt = 3;

    public String loginUser(String user, String pass) {
        if (user.equals(userId) && pass.equals(password)) {
            return "Yes";
        } else {
            return "No";
        }
    }
}

public class P5 {
    public static void main(String[] args) {

        Login user1 = new Login();

        String userId;
        String password;
        int loginAttempt =0;

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter userId: ");
            userId = sc.next();
            System.out.print("Enter password: ");
            password = sc.next();

            String result = user1.loginUser(userId, password);

            if (result.equals("Yes")) {
                System.out.println("Welcome " + userId);
                break;
            } 
            else {
                loginAttempt++;
                if (loginAttempt==3) {
                    System.out.println("You have entered the wrong credentials 3 times");
                    System.out.println("Contact Admin");
                    break;
                }
                else{
                    System.out.println("You have entered the wrong credentials. Try Again!");
                    System.out.println("Attemps Left :" + (3-loginAttempt) );
                }

            }

        }

    }
}
/*
 * for (int loginAttempt = 1; loginAttempt <= 3; loginAttempt++) {
    System.out.print("Enter userId: ");
    String userId = sc.next();

    System.out.print("Enter password: ");
    String password = sc.next();

    String res = login.loginUser(userId, password);

    if (res.equals("yes")) {
        System.out.println("Welcome " + userId);
        break;  // ✅ correct login → exit loop
    } else if (loginAttempt == 3) {
        System.out.println("You have entered wrong credentials 3 times");
        System.out.println("Contact Admin");
    } else {
        System.out.println("Wrong credentials, try again.");
    }
}

 */