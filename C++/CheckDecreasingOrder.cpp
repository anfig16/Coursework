#include <iostream>
#include <string>

using namespace std;

template<typename T>
bool decrease(const T list[], int size) {

 T thing = list[0];
 for(int x=1; x<size; x++) { 
   if(thing > list[x]) {
     thing = list[x];
   } else {
     return false;
  }
 }
  
 return true;
}


int main() {

 int intArr[] = {3, 2, 1};
 string strArr[] = {"C", "B", "A"};
 double doubleArr[] = {1.0, 2.2, 3.4};

 cout << "int array decreasing? " << decrease(intArr, 3) << endl;
 cout << "string array decreasing? " << decrease(strArr, 3) << endl;
 cout << "double array decreasing? " << decrease(doubleArr, 3) << endl;

 return 0;

}
