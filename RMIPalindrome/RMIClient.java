import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class RMIClient {

    public static void main(String[] args) {

        try {

            // Connect to registry
            Registry registry =
                    LocateRegistry.getRegistry("localhost", 1099);

            // Lookup remote object
            PalindromeInterface stub =
                    (PalindromeInterface)
                            registry.lookup("PalindromeService");

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter a string: ");

            String str = sc.nextLine();

            // Remote method call
            boolean result = stub.isPalindrome(str);

            if (result) {

                System.out.println(str
                        + " is a Palindrome.");

            } else {

                System.out.println(str
                        + " is NOT a Palindrome.");
            }

        } catch (Exception e) {

            System.out.println("Client Error: " + e);
        }
    }
}