#include <stdio.h>  //I/O library
#include <stdlib.h> //standard library (exit)
#include <unistd.h> //unix functions (fork, sleep, pause)
#include <signal.h>  //signals
#include <sys/types.h> //data types for system calls (pid_t)


//Functions defining the actions associated with signals
void SIGHUP_function (int signal_num) {
    printf("I have received SIGHUP\n");
}
void SIGINT_function (int signal_num) {
    printf("I have received SIGINT\n");
}
void SIGQUIT_function (int signal_num) {
    printf("I have received SIGQUIT\n");
    exit(0);
}


int main (void)
{
    //Create child process
    pid_t pid = fork();

	if (pid == 0){   /* Child process */
        //Set signal handler function for each signal
	    signal(SIGHUP, SIGHUP_function);
	    signal(SIGINT, SIGINT_function);
        signal(SIGQUIT, SIGQUIT_function);

        //Infinite loop, waiting for signals
        for(;;)
            pause();
    } else { /* Parent process */
        //Allow time for child process to set up signal handlers
        sleep(1);

        //Send SIGHUP to the child process
        kill(pid, SIGHUP);
        sleep(5);
        //Send SIGINT to the child process
        kill(pid, SIGINT);
        sleep(5);
        //Send SIGQUIT to the child process
        kill(pid, SIGQUIT);
        sleep(5);

	}

    return 0;
} 