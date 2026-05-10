import java.util.Scanner;

public class RingElection {

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

        // Display processes
        System.out.println("\nProcesses are:");

        for (int i = 0; i < n; i++) {

            System.out.println("Process "
                    + process[i] + " is Active");
        }

        // Coordinator failure
        int failed;

        System.out.print("\nEnter coordinator process to fail: ");
        failed = sc.nextInt();

        int failedIndex = -1;

        for (int i = 0; i < n; i++) {

            if (process[i] == failed) {

                active[i] = false;
                failedIndex = i;
                break;
            }
        }

        System.out.println("\nProcess "
                + failed + " has failed.");

        // Election initiator
        int initiator;

        System.out.print("\nEnter process initiating election: ");
        initiator = sc.nextInt();

        System.out.println("\nElection message passing:");

        int index = -1;

        for (int i = 0; i < n; i++) {

            if (process[i] == initiator) {

                index = i;
                break;
            }
        }

        int maxId = initiator;

        int i = (index + 1) % n;

        System.out.print(initiator);

        while (i != index) {

            if (active[i]) {

                System.out.print(" -> " + process[i]);

                if (process[i] > maxId) {

                    maxId = process[i];
                }
            }

            i = (i + 1) % n;
        }

        // New coordinator
        System.out.println("\n\nNew Coordinator is Process "
                + maxId);
    }
}

























/*




Aim

To implement the Ring Algorithm for electing a leader process in a distributed system.

Theory

In the Ring Algorithm:

Processes are arranged in a logical ring.
Every process has a unique process ID.
When the coordinator fails:
An election message is passed around the ring.
Active processes add their IDs to the message.
The process with the highest ID becomes the new coordinator.
Algorithm Steps
A process detects coordinator failure.
It sends an election message to the next active process.
Each active process adds its ID to the message.
After one full round:
Highest process ID is selected.
Coordinator message is circulated.

*/