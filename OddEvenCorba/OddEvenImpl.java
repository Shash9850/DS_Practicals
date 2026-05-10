import OddEvenApp.*;
import org.omg.PortableServer.POA;

class OddEvenImpl extends OddEvenPOA {

    private POA poa;

    public void setPOA(POA poa) {

        this.poa = poa;
    }

    // Remote method
    public String checkNumber(int num) {

        if (num % 2 == 0) {

            return num + " is EVEN";

        } else {

            return num + " is ODD";
        }
    }
}