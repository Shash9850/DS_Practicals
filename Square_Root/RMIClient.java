
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
            SqrtInterface stub =
                    (SqrtInterface) registry.lookup("SqrtService");

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter a number: ");

            double num = sc.nextDouble();

            // Remote method call
            double result = stub.squareRoot(num);

            System.out.println("Square Root of "
                    + num + " is: " + result);

        } catch (Exception e) {

            System.out.println("Client Error: " + e);
        }
    }
}