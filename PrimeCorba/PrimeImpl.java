import PrimeApp.*;
import org.omg.PortableServer.POA;

class PrimeImpl extends PrimePOA {

    private POA poa;

    public void setPOA(POA poa) {

        this.poa = poa;
    }

    // Remote method
    public String checkPrime(int num) {

        if (num <= 1) {

            return num + " is NOT PRIME";
        }

        boolean isPrime = true;

        for (int i = 2; i <= num / 2; i++) {

            if (num % i == 0) {

                isPrime = false;
                break;
            }
        }

        if (isPrime) {

            return num + " is PRIME";

        } else {

            return num + " is NOT PRIME";
        }
    }
}