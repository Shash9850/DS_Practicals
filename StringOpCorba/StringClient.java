import StringApp.*;
import org.omg.CosNaming.*;
import org.omg.CORBA.*;

import java.util.Scanner;

class StringClient {

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
            String name = "StringOperation";

            StringOperation strObj =
                    StringOperationHelper.narrow(
                            ncRef.resolve_str(name));

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter a string: ");

            String str = sc.nextLine();

            System.out.println("\nString Length = "
                    + strObj.length(str));

            System.out.println("Reverse String = "
                    + strObj.reverse(str));

            System.out.println("Uppercase = "
                    + strObj.uppercase(str));

            System.out.println("Lowercase = "
                    + strObj.lowercase(str));

        } catch (Exception e) {

            System.out.println("Client Error: " + e);
        }
    }
}