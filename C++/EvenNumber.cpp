#ifndef EVENNUMBER_H
#define EVENNUMBER_H

class EvenNumber {
    public:
        EvenNumber();
        EvenNumber(int value);
        int getValue();
        EvenNumber getNext();
        EvenNumber getPrevious();
    private:
        int value;
};
#endif

EvenNumber::EvenNumber() {
    value = 0;
}

EvenNumber::EvenNumber(int val) {
    value = val;
}

int EvenNumber::getValue() {
    return value;
}

EvenNumber EvenNumber::getNext() {
    return EvenNumber(value+2);
}

EvenNumber EvenNumber::getPrevious() {
    return EvenNumber(value-2);
}

#include <iostream>
using namespace std;

int main() 
{
    EvenNumber num(16);
    int nextEven = num.getNext().getValue();
    int prevEven = num.getPrevious().getValue();
    cout << nextEven << endl;
    cout << prevEven << endl;
    return 0;
}
