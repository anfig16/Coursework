#include <stdio.h>
#include <stdlib.h>

void *count_lines(void *arg) {
    //File handler
    FILE *fh =  (FILE *)arg;
    //Variable to keep track of line count
    int *num_lines = malloc(sizeof(int));
    *num_lines = 0;

    char line[256];  //buffer for each line read
    /*As each line is read, num_lines increases by one (actual line content is ignored, 
    only need to find how many total lines exist in data.txt) */
    while(fgets(line, sizeof(line), fh)) {
        (*num_lines)++;
    }

    //Close the file
    fclose(fh);

    //Return number of lines in file
    return num_lines;
}