import java.util.Scanner;

public class BerkeleyAlgorithm {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n;

        System.out.print("Enter number of clocks: ");
        n = sc.nextInt();

        int clock[] = new int[n];

        // Input clock times
        System.out.println("Enter clock times:");

        for (int i = 0; i < n; i++) {

            System.out.print("Clock " + (i + 1) + ": ");

            clock[i] = sc.nextInt();
        }

        // Display original clocks
        System.out.println("\nOriginal Clock Times:");

        for (int i = 0; i < n; i++) {

            System.out.println("Clock "
                    + (i + 1)
                    + " = "
                    + clock[i]);
        }

        // Calculate average time
        int sum = 0;

        for (int i = 0; i < n; i++) {

            sum += clock[i];
        }

        int average = sum / n;

        System.out.println("\nAverage Time = "
                + average);

        // Synchronize clocks
        System.out.println("\nClock Adjustments:");

        for (int i = 0; i < n; i++) {

            int adjustment = average - clock[i];

            System.out.println("Clock "
                    + (i + 1)
                    + " adjustment = "
                    + adjustment);

            clock[i] = clock[i] + adjustment;
        }

        // Display synchronized clocks
        System.out.println("\nSynchronized Clock Times:");

        for (int i = 0; i < n; i++) {

            System.out.println("Clock "
                    + (i + 1)
                    + " = "
                    + clock[i]);
        }
    }
}






























/*


Aim

To implement the Berkeley Clock Synchronization Algorithm.

Theory

In the Berkeley Algorithm:

One machine acts as the master clock.
The master polls all slave systems for their clock times.
It calculates the average time difference.
The master sends adjustment values to all systems.
Each system updates its local clock.

Unlike Cristian’s algorithm, Berkeley Algorithm does not use an external UTC source.

Algorithm Steps
Master requests current time from all processes.
Slave processes send their local times.
Master computes average clock time.
Time difference for each process is calculated.
Master sends adjustment values.
All clocks synchronize.




Advantages
No external UTC clock needed
Reduces clock drift
Suitable for distributed systems
Disadvantages
Master failure affects synchronization
Network delay may introduce errors
Average may be inaccurate with faulty clocks
Viva Questions & Answers
What is clock synchronization?

Clock synchronization ensures all distributed systems maintain approximately the same time.

What is Berkeley Algorithm?

A distributed clock synchronization algorithm using a master clock and averaging technique.

Does Berkeley Algorithm use UTC?

No. It uses internal averaging among system clocks.

What is the role of master clock?

The master collects times, calculates average, and sends adjustments.

Why are adjustments needed?

Different systems experience clock drift over time.

Applications
Distributed systems
Sensor networks
Distributed databases
Network synchronization




*/