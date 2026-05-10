import CalculatorApp.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

class CalculatorServer {

    public static void main(String args[]) {

        try {

            // Initialize ORB
            ORB orb = ORB.init(args, null);

            // Get reference to RootPOA
            POA rootpoa =
                    POAHelper.narrow(
                            orb.resolve_initial_references("RootPOA"));

            rootpoa.the_POAManager().activate();

            // Create servant
            CalculatorImpl calcImpl = new CalculatorImpl();

            calcImpl.setPOA(rootpoa);

            // Get object reference
            org.omg.CORBA.Object ref =
                    rootpoa.servant_to_reference(calcImpl);

            Calculator href =
                    CalculatorHelper.narrow(ref);

            // Get naming context
            org.omg.CORBA.Object objRef =
                    orb.resolve_initial_references("NameService");

            NamingContextExt ncRef =
                    NamingContextExtHelper.narrow(objRef);

            // Bind object reference in naming
            String name = "Calculator";

            NameComponent path[] =
                    ncRef.to_name(name);

            ncRef.rebind(path, href);

            System.out.println("Calculator Server Ready...");

            // Wait for client calls
            orb.run();

        } catch (Exception e) {

            System.out.println("Server Error: " + e);
        }

        System.out.println("Server Exiting...");
    }
}