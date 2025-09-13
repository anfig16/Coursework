#include <sys/wait.h>
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>


int main (void)
{
	    if (fork() == 0){   /* Child process */
            printf("\n---------------------\n");
            printf("Child process CP\n");
	        int sum = 0;
	        for(int x=1; x<=1000; x++) {
                //If odd number, add to sum
                if(x % 2 != 0) {
                    sum += x;
                }
            }
            //Output sum of odd numbers
	        printf("Sum of odd nums 1-1000: %d\n", sum);
            printf("---------------------\n\n");
			exit(0);

        } else { /* Parent process */
            printf("\nParent process\n");
            int sum = 0;
	        for(int x=1; x<=1000; x++) {
                //If even number, add to sum
                if(x % 2 == 0) {
                    sum += x;
                }
            }
            //Output sum of even numbers
	        printf("Sum of even nums 1-1000: %d\n", sum);

	        if(wait(NULL) > 0) /* Waits for child to terminate before terminating */
	            printf("Parent detects terminating child\n"); 
	    }
        printf("Parent process terminating\n\n");
}
