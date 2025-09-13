#include <stdio.h>  //I/O library
#include <stdlib.h> //standard library (exit)
#include <unistd.h> //unix functions (fork, sleep, pause)
#include <sys/types.h> //data types for system calls (pid_t)
#include <sys/wait.h> // For wait()
#include <ctype.h>  //lower and upper functions
#include <string.h>  //string functions (strlen)

int main() {

    //Create pipe
    int pipeID[2];
    pipe(pipeID);

    //Create child process (source process creates filter process using fork)
    pid_t pid = fork();

	if (pid == 0){   /* Child process- filter process*/
        
        //Close write end of pipe
        close(pipeID[1]);
        char buffer[1024];
        
        //Read from source process via pipe and convert the letters
        int bytesRead = read(pipeID[0], buffer, sizeof(buffer) - 1); 
        if (bytesRead > 0) {
            buffer[bytesRead] = '\0';

            //Print out original text
            printf("Original text: %s\n", buffer);

            //Letter conversion
            for(int x =  0; x < bytesRead; x++) {
                if (islower(buffer[x])) {
                    buffer[x] = toupper(buffer[x]);
                } else if (isupper(buffer[x])) {
                    buffer[x] = tolower(buffer[x]);
                }
            }

            //Print out result after letter conversion
            printf("\nConverted text: %s\n", buffer);
        }
        
        //Close read end of pipe
        close(pipeID[0]);

    } else { /* Parent process- source process */
        
        //Close read end of pipe
        close(pipeID[0]); 

        //Open file
        FILE* fh = fopen("testText.txt", "r");

        //Read input from file and write to the pipe
        char line[1024];  //buffer for each line read
        while(fgets(line, sizeof(line), fh)) {
            write(pipeID[1], line, strlen(line));
        }

        //Close the file
        fclose(fh);

        //Close write end of pipe
        close(pipeID[1]);

        wait(NULL);
	}

    return 0;
}