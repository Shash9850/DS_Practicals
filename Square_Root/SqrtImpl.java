

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class SqrtImpl extends UnicastRemoteObject
        implements SqrtInterface {

    // Constructor
    protected SqrtImpl() throws RemoteException {
        super();
    }

    // Remote method implementation
    public double squareRoot(double number)
            throws RemoteException {

        // Display current thread name
        System.out.println("Request handled by Thread: "
                + Thread.currentThread().getName());

        return Math.sqrt(number);
    }
}