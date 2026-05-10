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
            StringEqualInterface stub =
                    (StringEqualInterface)
                            registry.lookup("StringEqualService");

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter first string: ");
            String str1 = sc.nextLine();

            System.out.print("Enter second string: ");
            String str2 = sc.nextLine();

            // Remote method call
            boolean result = stub.checkEqual(str1, str2);

            if (result) {

                System.out.println("Strings are Equal.");

            } else {

                System.out.println("Strings are NOT Equal.");
            }

        } catch (Exception e) {

            System.out.println("Client Error: " + e);
        }
    }
}