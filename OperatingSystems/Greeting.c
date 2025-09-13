#include <sys/wait.h>
#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>
#include <stdlib.h>


int main (void)
{
	    if (fork() == 0){   /* Child process */
	        printf("---------------------\n");
		    printf("Hello, I am a child process\n");
			printf("---------------------\n");
            sleep(20);
			exit(0);

        } else { /* Parent process */
    
	        printf("\nHello, I am a parent process\n");
	        
	        if(wait(NULL) > 0) /* Child terminating */
	            printf("Parent detects terminating child\n"); 
	    }
        printf("Parent process terminating\n\n");
}