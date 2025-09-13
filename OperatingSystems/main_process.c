#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

void *count_lines(void *arg);

int main() {
    //Open data.txt file, file handler fh
    FILE* fh;
    fh = fopen("data.txt", "r");

    //Declare my_thread and num_lines
    pthread_t my_thread;
    int *num_lines;

    //Create thread that will find num of lines in file, wait until thread is finished and join
    pthread_create(&my_thread, NULL, count_lines, fh);
    pthread_join(my_thread, (void **)&num_lines);

    //Output number of lines in data.txt found in thread process
    printf("Number of lines in data.txt: %d\n", *num_lines);

    return 0;
}