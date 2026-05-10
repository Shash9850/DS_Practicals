import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {

    public static void main(String[] args) {

        try {

            // Create remote object
            StringEqualImpl obj = new StringEqualImpl();

            // Create RMI registry
            Registry registry =
                    LocateRegistry.createRegistry(1099);

            // Bind remote object
            registry.rebind("StringEqualService", obj);

            System.out.println("RMI Server is running...");

        } catch (Exception e) {

            System.out.println("Server Error: " + e);
        }
    }
}