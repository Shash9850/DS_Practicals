import CalculatorApp.*;
import org.omg.PortableServer.POA;

class CalculatorImpl extends CalculatorPOA {

    private POA poa;

    public void setPOA(POA poa) {
        this.poa = poa;
    }

    public float add(float a, float b) {
        return a + b;
    }

    public float subtract(float a, float b) {
        return a - b;
    }

    public float multiply(float a, float b) {
        return a * b;
    }

    public float divide(float a, float b) {

        if (b == 0) {
            System.out.println("Division by zero not allowed.");
            return 0;
        }

        return a / b;
    }
}