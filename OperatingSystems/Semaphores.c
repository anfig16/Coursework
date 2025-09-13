#include <stdio.h>  //I/O library
#include <stdlib.h> //standard library
#include <unistd.h> //unix functions (fork, sleep, pause)
#include <pthread.h> //threads
#include<semaphore.h> //semaphore


int counter = 0; //shared int between t1 and t2
sem_t mutex; //semaphore
int quit = 0; //stops threads on user input

//Thread t1; increases the value of counter by 1 when t1 is scheduled
void* t1_thread(void* arg)
{
	while(!quit) {
        //P operation
		sem_wait(&mutex);

		counter++;
		printf("t1 counter value: %d\n", counter);

		//V operation
        sem_post(&mutex);

        sleep(1);
	}
}

//Thread t2; decreases the value of counter by 1 when t2 is scheduled
void* t2_thread(void* arg)
{
	while(!quit) {
		//P operation
		sem_wait(&mutex);

		counter--;
        printf("t2 counter value: %d\n", counter);

		//V operation
        sem_post(&mutex);

        sleep(1);
	}
}

int main()
{
	//Create semaphore, initialized with 1 for mutual exclusion (only allows 1 process at a time)
    sem_init(&mutex, 0, 1);

	//Create t1, t2 threads
    pthread_t t1, t2;
    pthread_create(&t1, NULL, t1_thread, NULL);
    pthread_create(&t2, NULL, t2_thread, NULL);

    //Wait for user input then sets quit=1 to stop the threads
    //(press enter to stop output)
    getchar();
    quit = 1;

    //Join threads
    pthread_join(t1, NULL);
    pthread_join(t2, NULL);

	//Destroy semaphore
    sem_destroy(&mutex);

    return 0;
}

