
#include <iostream>
using namespace std;
class A {
	int num1;
public :
//	int num1 ;
	A(){
		this->num1= 10;
	}
	A(int num1){this->num1=num1;}
void print(){
	cout<<"A::print";
this->showRecords();
}
protected :
void showRecords(){
	cout<<"num1  "<<this->num1<<endl;
}
};
class B : virtual public A
{	int num2;
public :
	B(){
		this->num2=20 ;}
	B(int num2){this->num2=num2;}
	B(int num1,int num2):A(num1)
	{this->num2=num2;}
	void print(){
		cout<<"B::print \n";
		A::showRecords();
		this->showRecords();
	}
protected :
void showRecords(){
	cout<<"num2  "<<this->num2<<endl;
}
};
class C : virtual public A
{
int num3;
public:
C(){this->num3=80;}
C(int num3){this->num3=num3;}
	C(int num3,int num1):A(num1),num3(num3)
{}
	void print(){
		cout<<"C::print";
		A::showRecords();
				this->showRecords();
	}
protected :
	void showRecords(){
		cout<<"NUM3  "   <<this->num3<<endl;
	}
	};
class D :public B,public C
{int num4;
public :
D()
{this->num4=90;}
D(int num1,int num2 ,int num3, int num4  ):A(num1),B(num2),C(num3),num4(num4)
{}
void print(){
	cout<<"D::print";
	A::showRecords();// ‘A’ is an ambiguous base of ‘D’
	B::showRecords();
	C::showRecords();
	this->showRecords();
}
protected :
void showRecords(){
	cout<<"num4    "<<this->num4<<endl;
}
};
int main(){
D d(100,200,300,400);//using virtual keyword the diamond problem is solved
d.print();
	return 0;
}
int main3(){
C c(100,200);
c.print();
	return 0;
}



int main2(){
A a(100);
a.print();

	return 0;
}



int main1() {
	B b;
	b.print();
	b.A::print();
	b.B::print();
///b.A::showRecords();‘void A::showRecords()’ is protected within this context
//	cout<<b.A::num1<< endl; // prints or bhai
//	cout<<b.num1<< endl;
//	cout<<b.B::num1<< endl;
	return 0;
}





























