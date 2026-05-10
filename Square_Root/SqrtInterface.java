//SqrtInterface




import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SqrtInterface extends Remote {

    public double squareRoot(double number) throws RemoteException;
}