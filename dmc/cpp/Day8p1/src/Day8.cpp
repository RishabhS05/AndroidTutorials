
#include <iostream>
using namespace std;
class A {
public :
//	int num1 ;
	A(){
//		this->num1= 10;
	}
void print(){
	cout<<"A::print";
}
};
class B :public A
{
public :
//	int num1 ;
	B(){
//		this->num1=20 ;
	}
	void print(){
		cout<<"B::print";
	}
};

int main() {
	B b;
	b.print();
	b.A::print();
	b.B::print();

//	cout<<b.A::num1<< endl; // prints or bhai
//	cout<<b.num1<< endl;
//	cout<<b.B::num1<< endl;
	return 0;
}






























