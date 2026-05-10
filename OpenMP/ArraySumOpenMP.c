#include <stdio.h>
#include <omp.h>

int main() {

    int n;

    printf("Enter number of elements: ");
    scanf("%d", &n);

    int arr[n];

    printf("Enter array elements:\n");

    for(int i = 0; i < n; i++) {

        scanf("%d", &arr[i]);
    }

    int total_sum = 0;

    // Parallel region
    #pragma omp parallel
    {
        int thread_id = omp_get_thread_num();
        int num_threads = omp_get_num_threads();

        int partial_sum = 0;

        // Divide work among threads
        #pragma omp for
        for(int i = 0; i < n; i++) {

            partial_sum += arr[i];
        }

        // Display intermediate sum
        printf("Thread %d calculated partial sum = %d\n",
               thread_id, partial_sum);

        // Add partial sums safely
        #pragma omp critical
        {
            total_sum += partial_sum;
        }
    }

    printf("\nFinal Sum = %d\n", total_sum);

    return 0;
}