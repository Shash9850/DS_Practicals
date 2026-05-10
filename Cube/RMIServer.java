import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class RMIServer{
	

	public static void main(String args[]){

	try{
	CubeImpl obj = new CubeImpl();

	Registry registry = LocateRegistry.createRegistry(1099);

	registry.rebind("CubeService",obj);

	System.out.println("RMI Server is running...");
	
	}
	catch(Exception e){

	System.out.println("Server Error : "+e.getMessage());
	}
}



	}