import java.util.Scanner;

public class TokenRing {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n;

        System.out.print("Enter number of processes: ");
        n = sc.nextInt();

        int process[] = new int[n];

        // Input process IDs
        System.out.println("Enter process IDs:");

        for (int i = 0; i < n; i++) {

            process[i] = sc.nextInt();
        }

        // Initial token holder
        int token;

        System.out.print("\nEnter process holding token initially: ");
        token = sc.nextInt();

        int choice = 1;

        while (choice == 1) {

            // Critical section execution
            System.out.println("\nProcess "
                    + token
                    + " has token.");

            System.out.println("Process "
                    + token
                    + " entering Critical Section.");

            System.out.println("Process "
                    + token
                    + " leaving Critical Section.");

            // Find next process in ring
            int index = -1;

            for (int i = 0; i < n; i++) {

                if (process[i] == token) {

                    index = i;
                    break;
                }
            }

            int next = process[(index + 1) % n];

            // Pass token
            System.out.println("Token passed from Process "
                    + token
                    + " to Process "
                    + next);

            token = next;

            // Continue?
            System.out.print("\nContinue execution? (1 = Yes / 0 = No): ");
            choice = sc.nextInt();
        }

        System.out.println("\nExecution Completed.");
    }
}






































/*



Aim

To implement the Token Ring Mutual Exclusion Algorithm for distributed systems.

Theory

In the Token Ring Algorithm:

Processes are arranged in a logical ring.
A special message called a token circulates in the ring.
Only the process holding the token can enter the critical section.
After completing execution, the token is passed to the next process.

This guarantees mutual exclusion because only one token exists.

Algorithm Steps
Arrange processes in a logical ring.
Initialize token with one process.
Process holding token enters critical section.
After completion, token is passed to next process.
Process without token waits.

















Advantages
Prevents deadlock
Fair access to critical section
No starvation
Simple logical structure
Disadvantages
Token loss can stop system
Ring failure affects communication
Token passing overhead
Viva Questions & Answers
What is mutual exclusion?

Mutual exclusion ensures only one process accesses the critical section at a time.

What is a token in Token Ring Algorithm?

A special permission message required to enter the critical section.

Why is Token Ring deadlock-free?

Because only one token exists and processes execute sequentially.

What happens if token is lost?

System execution stops until token is regenerated.

What is the critical section?

The part of program where shared resources are accessed.

Applications
Distributed systems
Network communication
Shared resource management
Distributed databases

*/