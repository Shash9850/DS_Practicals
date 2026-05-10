import java.util.Scanner;

public class BullyElection {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n;

        System.out.print("Enter number of processes: ");
        n = sc.nextInt();

        int process[] = new int[n];
        boolean active[] = new boolean[n];

        // Input process IDs
        System.out.println("Enter process IDs:");

        for (int i = 0; i < n; i++) {

            process[i] = sc.nextInt();
            active[i] = true;
        }

        // Display active processes
        System.out.println("\nProcesses are:");

        for (int i = 0; i < n; i++) {

            System.out.println("Process "
                    + process[i] + " is Active");
        }

        // Current coordinator
        int coordinator = process[n - 1];

        System.out.println("\nCurrent Coordinator is Process "
                + coordinator);

        // Fail coordinator
        int failed;

        System.out.print("\nEnter coordinator process to fail: ");
        failed = sc.nextInt();

        for (int i = 0; i < n; i++) {

            if (process[i] == failed) {

                active[i] = false;

                System.out.println("Process "
                        + failed + " has failed.");
            }
        }

        // Election initiator
        int initiator;

        System.out.print("\nEnter process initiating election: ");
        initiator = sc.nextInt();

        System.out.println("\nElection Started by Process "
                + initiator);

        int newCoordinator = initiator;

        // Send election messages
        for (int i = 0; i < n; i++) {

            if (process[i] > initiator && active[i]) {

                System.out.println("Election message sent from Process "
                        + initiator + " to Process "
                        + process[i]);

                System.out.println("Process "
                        + process[i]
                        + " responds OK");

                if (process[i] > newCoordinator) {

                    newCoordinator = process[i];
                }
            }
        }

        // New coordinator announcement
        System.out.println("\nProcess "
                + newCoordinator
                + " becomes New Coordinator");
    }
}



/*

Aim

To implement the Bully Algorithm for leader election in a distributed system.

Theory

In the Bully Algorithm:

Every process has a unique process ID.
The process with the highest ID becomes the coordinator.
If the coordinator fails:
A process starts an election.
It sends election messages to all higher-ID processes.
Higher-ID processes respond with “OK”.
The highest active process becomes the new coordinator.

The process with the highest ID “bullies” others and becomes leader.

Algorithm Steps
Detect coordinator failure.
Initiator sends election messages to higher-ID processes.
Higher-ID active processes respond.
Highest active process declares itself coordinator.
Coordinator message is sent to all processes.
*/