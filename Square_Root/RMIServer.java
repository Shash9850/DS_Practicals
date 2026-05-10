
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {

    public static void main(String[] args) {

        try {

            // Create remote object
            SqrtImpl obj = new SqrtImpl();

            // Create RMI registry
            Registry registry =
                    LocateRegistry.createRegistry(1099);

            // Bind object with name
            registry.rebind("SqrtService", obj);

            System.out.println("RMI Server is running...");

        } catch (Exception e) {

            System.out.println("Server Error: " + e);
        }
    }
}