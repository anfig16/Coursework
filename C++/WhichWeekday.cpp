#include <iostream>
using namespace std;

int main() {
    cout << "Enter year: (e.g., 2012): ";
    int year;
    cin >> year;
    cout << "Enter month: 1-12: ";
    int month;
    cin >> month;
    if(month == 1) {
        month = 13;
        year--;
    }
    if(month == 2) {
        month = 14;
        year--;
    }
    cout << "Enter the day of the month: 1-31: ";
    int dayOfMonth;
    cin >> dayOfMonth;
    
    int k = year%100;
    int j = year/100;
    
    int h = (dayOfMonth + (26*(month + 1))/10 + k + k/4 + j/4 + 5*j) % 7;
    
    switch(h) {
        case 0: cout << "Day of the week is Saturday"; break;
        case 1: cout << "Day of the week is Sunday"; break;
        case 2: cout << "Day of the week is Monday"; break;
        case 3: cout << "Day of the week is Tuesday"; break;
        case 4: cout << "Day of the week is Wednesday"; break;
        case 5: cout << "Day of the week is Thursday"; break;
        case 6: cout << "Day of the week is Friday"; break;
    }
}
