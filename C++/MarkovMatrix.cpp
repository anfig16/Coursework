#include <iostream>
using namespace std;

const int SIZE = 3;
//all element positive, sum in each column = 1
bool isMarkovMatrix(const double m[][SIZE]) {
    bool result1 = true;
    bool result2 = true;
    
    for(int x=0; x<3; x++) {
        for(int y=0; y<3; y++) {
            if(m[x][y] < 0) {
                result1 = false;
            }
        }
    }
    
    for(int r=0; r<3; r++) {
        double total = 0;
        for(int c=0; c<3; c++) {
            total += m[c][r];
        }
        if(total != 1) {
            result2 = false;
        }
    }
    
    if(result1 == true && result2 == true) {
        return true;
    } else {
        return false;
    }
}

int main() {
    cout << "Enter a 3-by-3 matrix row by row: " << endl;
    double m[3][3];
    for(int x=0; x<3; x++) {
        for(int y=0; y<3; y++) {
            cin >> m[x][y];
        }
    }
    
    bool result = isMarkovMatrix(m);
    
    if(result) {
        cout << "It is a Markov matrix";
    } else {
        cout << "It is not a Markov matrix";
    }
    return 0;
}
