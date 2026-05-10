import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class PalindromeImpl extends UnicastRemoteObject
        implements PalindromeInterface {

    // Constructor
    protected PalindromeImpl() throws RemoteException {
        super();
    }

    // Remote method implementation
    public boolean isPalindrome(String str)
            throws RemoteException {

        // Display thread handling request
        System.out.println("Request handled by Thread: "
                + Thread.currentThread().getName());

        // Convert string to lowercase
        str = str.toLowerCase();

        // Reverse string
        String reverse = new StringBuilder(str)
                .reverse()
                .toString();

        // Check palindrome
        return str.equals(reverse);
    }
}