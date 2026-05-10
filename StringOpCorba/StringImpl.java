import StringApp.*;
import org.omg.PortableServer.POA;

class StringImpl extends StringOperationPOA {

    private POA poa;

    public void setPOA(POA poa) {

        this.poa = poa;
    }

    // Length operation
    public int length(String str) {

        return str.length();
    }

    // Reverse operation
    public String reverse(String str) {

        return new StringBuilder(str)
                .reverse()
                .toString();
    }

    // Uppercase operation
    public String uppercase(String str) {

        return str.toUpperCase();
    }

    // Lowercase operation
    public String lowercase(String str) {

        return str.toLowerCase();
    }
}