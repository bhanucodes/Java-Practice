import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Input {
    public static void main(String[] args) throws IOException {

        // This is how Input were taken before 1.5 version 
        System.out.print(" Enter a Number(old way): ");

        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader bf = new BufferedReader(in);

        int num = Integer.parseInt(bf.readLine());

        System.out.println("The number you entered is: "+ num);
        

        // After version 1.5 update - Scanner came into existence
        
        System.out.print(" Enter a Number(new way): ");
        
        Scanner sc = new Scanner(System.in);
        int numm = sc.nextInt();
       System.out.println("The number you entered is: "+ numm);


       bf.close();// .close() should be at the end
    }
}
