import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.util.*;


public class RMIClient{

	public static void main(String args[]){

	try{

		Registry registry = LocateRegistry.getRegistry("localhost",1099);
		CubeInterface stub = (CubeInterface) registry.lookup("CubeService");
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Num : ");
		int num = sc.nextInt();
		int result = stub.cube(num);
		System.out.println("Cube of "+num+" is "+result);

	}
	catch(Exception e){

		System.out.println("Client Error : "+e.getMessage());
	}
}


}