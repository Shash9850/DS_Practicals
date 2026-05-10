import OddEvenApp.*;
import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

class OddEvenServer {

    public static void main(String args[]) {

        try {

            // Initialize ORB
            ORB orb = ORB.init(args, null);

            // Get RootPOA reference
            POA rootpoa =
                    POAHelper.narrow(
                            orb.resolve_initial_references("RootPOA"));

            rootpoa.the_POAManager().activate();

            // Create servant
            OddEvenImpl oddEvenImpl =
                    new OddEvenImpl();

            oddEvenImpl.setPOA(rootpoa);

            // Get object reference
            org.omg.CORBA.Object ref =
                    rootpoa.servant_to_reference(oddEvenImpl);

            OddEven href =
                    OddEvenHelper.narrow(ref);

            // Get naming context
            org.omg.CORBA.Object objRef =
                    orb.resolve_initial_references("NameService");

            NamingContextExt ncRef =
                    NamingContextExtHelper.narrow(objRef);

            // Bind object reference
            String name = "OddEven";

            NameComponent path[] =
                    ncRef.to_name(name);

            ncRef.rebind(path, href);

            System.out.println("OddEven Server Ready...");

            orb.run();

        } catch (Exception e) {

            System.out.println("Server Error: " + e);
        }
    }
}