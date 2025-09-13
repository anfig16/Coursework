#include <iostream>
using namespace std;

int main() {
    int number;
    int count[100] = {};
    
    cout << "Enter the integers between 1 and 100: ";
    
    cin >> number;
    
    while(number != 0) {
      if(number >= 1 && number <= 100) {
        count[number-1]++;
        cin >> number;
      }
    }
    
    for(int x=0; x<100; x++) {
      if(count[x] >= 1) {
        cout << (x+1) << " occurs " << count[x];
        if(count[x] > 1) {
          cout << " times" << endl;
        } else {
          cout << " time " << endl;
        }
      }
    }
    
    return 0;
}
