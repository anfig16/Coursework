#include <iostream>
#include <string>
using namespace std;

#if_n_def FLOWER_H
#def FLOWER_H

class Flower {
 public:
 Flower();
 Flower(string, string, double);
 int DiscountRate();
 string getType();
 string getColor();
 double getPrice();
 void setType(string);
 void setColor(string);
 void setPrice(double);

 private:
 string type;
 string color;
 double price;

};

#end_if


Flower::Flower() {
}

Flower::Flower(string type2, string color2, double price2) {
 type = type2;
 color = color2;
 price = price2;
}

int Flower::DiscountRate() {
  return 0;
}

string Flower::getType() {
 return type;
}

string Flower::getColor() {
 return color;
}

double Flower::getPrice() {
  return price;
}

void Flower::setType(string type2) {
  type = type2;
}

void Flower::setColor(string color2) {
  color = color2;
}

void Flower::setPrice(double price2) {
  price = price2;
}



#if_n_def ROSE_H
#def ROSE_H

class Rose : class Flower {
  public:
  Rose();
  Rose(int);
  int getNumPerBouquet();
  void setNumPerBouquet(int);

  private:
  int NumberPerBouquet;
};

#end_if


Rose::Rose(){
}

Rose::Rose(int numOfRoses) {
  NumberPerBouquet = numOfRoses;
}

int Rose::getNumPerBouquet() {
  return NumberPerBouquet;
}

void Rose::setNumPerBouquet(int num) {
  NumberPerBouquet = num;
}

int Rose::DiscountRate() {
  return (price*0.10);
}

int main() {
  Rose rose1(12);
  rose1.setColor("blue");

  cout << "rose1 color is: " << rose1.getColor() << endl;
  cout << "rose1 number per bouquet is: " << rose1.getNumPerBouquet() << endl;

  Rose rose2();
  rose2.setPrice(20.0);

  cout << "rose2 discount amount is: " << rose2.DiscountRate() << endl;

  
  return 0;
}
