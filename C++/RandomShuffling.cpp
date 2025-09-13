#include <iostream>
using namespace std;

int main()
{
  srand(time(0));
  double myList[] = {1, 2, 3, 4, 5, 6};
  cout  << "Original array: ";
  for(int x=0; x < 6; x++) {
    cout << myList[x] << " ";
  }

  cout << endl;

  for (int i = 0; i < 6; i++)
  {
    // Generate an index j randomly 
    int j = rand() % 6;
   
    // Swap myList[i] with myList[j]
    double temp = myList[i];
    myList[i] = myList[j]; 
    myList[j] = temp;
  }

  cout  << "Shuffled array: ";
  for(int x=0; x < 6; x++) {
    cout << myList[x] << " ";
  }

  cout << endl;

  return 0;
}
