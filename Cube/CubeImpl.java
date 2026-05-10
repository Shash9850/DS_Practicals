import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class CubeImpl extends UnicastRemoteObject implements CubeInterface{

	CubeImpl() throws RemoteException{
		super();
	}

	public int cube(int num) throws RemoteException{

		System.out.println("Request Handled by Thread : "+Thread.currentThread().getName());

		return num*num*num;
	}
}