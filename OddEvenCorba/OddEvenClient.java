import OddEvenApp.*;
import org.omg.CosNaming.*;
import org.omg.CORBA.*;

import java.util.Scanner;

class OddEvenClient {

    public static void main(String args[]) {

        try {

            // Initialize ORB
            ORB orb = ORB.init(args, null);

            // Get naming context
            org.omg.CORBA.Object objRef =
                    orb.resolve_initial_references("NameService");

            NamingContextExt ncRef =
                    NamingContextExtHelper.narrow(objRef);

            // Resolve object reference
            String name = "OddEven";

            OddEven oddEvenObj =
                    OddEvenHelper.narrow(
                            ncRef.resolve_str(name));

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter a number: ");

            int num = sc.nextInt();

            // Remote method call
            String result =
                    oddEvenObj.checkNumber(num);

            System.out.println(result);

        } catch (Exception e) {

            System.out.println("Client Error: " + e);
        }
    }
}