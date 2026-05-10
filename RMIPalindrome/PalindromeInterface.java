import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PalindromeInterface extends Remote {

    public boolean isPalindrome(String str)
            throws RemoteException;
}