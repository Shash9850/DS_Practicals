import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StringEqualInterface extends Remote {

    public boolean checkEqual(String str1, String str2)
            throws RemoteException;
}