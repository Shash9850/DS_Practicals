import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class StringEqualImpl extends UnicastRemoteObject
        implements StringEqualInterface {

    // Constructor
    protected StringEqualImpl() throws RemoteException {
        super();
    }

    // Remote method implementation
    public boolean checkEqual(String str1, String str2)
            throws RemoteException {

        // Display thread handling request
        System.out.println("Request handled by Thread: "
                + Thread.currentThread().getName());

        // Compare strings
        return str1.equals(str2);
    }
}