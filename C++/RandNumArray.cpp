#include <iostream>

#include <cstdlib>

#include <ctime>

using namespace std;

int main() {
  int *entry;
  entry = new int[20];
  
  srand(time(0));
  
  for(int x=0; x<20; x++) {
    *entry[x] = rand();
  }

 return 0;
}
