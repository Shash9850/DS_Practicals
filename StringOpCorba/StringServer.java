import StringApp.*;
import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

class StringServer {

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
            StringImpl stringImpl =
                    new StringImpl();

            stringImpl.setPOA(rootpoa);

            // Get object reference
            org.omg.CORBA.Object ref =
                    rootpoa.servant_to_reference(stringImpl);

            StringOperation href =
                    StringOperationHelper.narrow(ref);

            // Get naming context
            org.omg.CORBA.Object objRef =
                    orb.resolve_initial_references("NameService");

            NamingContextExt ncRef =
                    NamingContextExtHelper.narrow(objRef);

            // Bind object reference
            String name = "StringOperation";

            NameComponent path[] =
                    ncRef.to_name(name);

            ncRef.rebind(path, href);

            System.out.println("String Server Ready...");

            orb.run();

        } catch (Exception e) {

            System.out.println("Server Error: " + e);
        }
    }
}