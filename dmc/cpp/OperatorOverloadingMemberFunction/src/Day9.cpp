#include<iostream>
using namespace std;
class Complex
{
private:
	int real;
	int imag;
public:
	Complex( void )
	{
		this->real = 0;
		this->imag = 0;
	}
	Complex( int real, int imag )
	{
		this->real = real;
		this->imag = imag;
	}
	//Complex *const this = &c1;
	Complex operator+(Complex &obj){
		this->real +=obj.real;
		this->imag+=obj.imag;
		return *this;
	}	//Complex *const this = &c1;

	Complex operator-(Complex &obj){
		this->real -=obj.real;
				this->imag-=obj.imag;
				return *this;
	}
	Complex operator*(Complex &obj ){
		this->real *=obj.real;
						this->imag*=obj.imag;
						return *this;
	}
	Complex operator++(){
			this->real +=1;
							this->imag+=1;
							return *this;
		}
	Complex operator--(){
		this->real -=1;
								this->imag-=1;
								return *this;
	}
	Complex operator++(int ){
			this->real +=1;
							this->imag+=1;
							return *this;
		}
	Complex operator--(int ){
		this->real -=1;
								this->imag-=1;
								return *this;
	}
	bool operator==(Complex &obj){
		if (this->real ==obj.real&&this->imag==obj.imag)return true;
		else return false;
	}
	void printRecord( void )
	{
		cout<<"Real	:	"<<this->real<<endl;
		cout<<"Imag	:	"<<this->imag<<endl;
	}
};
//
//int main( void )
//{
//	Complex c1( 10, 20 );
//	//Complex c2 = ++ c1;	//c2 = c1.operator++( )
//	Complex c3 = c1 ;	//c3 = c1.operator++( 0 )
//	c1.printRecord();
//	return 0;
//}
//int main3( void )
//{
//	Complex c1( 10,20);
//	Complex c2( 10,20);
//	if( c1 == c2 )	//c1.operator==( c2 )
//		cout<<"Equal"<<endl;
//	else
//		cout<<"Not Equal"<<endl;
//	return 0;
//}
//int main2( void )
//{
//	Complex c1( 10, 20 );
//	//Complex c2 = c1 + 5;	//c2 = c1.operator+( 5 )
//	//Complex c2 =  5 + c1;	//c2 = 5.operator+( c1 )
//	//c2.printRecord();
//	return 0;
//}
int main( void )
{
	Complex c1( 10, 20 );
	Complex c2( 30, 40 );
	Complex c3;
	c3 = c1 + c2;	//c3 = c1.operator+( c2 )
	Complex c4(100,30),c5;
	c5= c4-c2;
	c1*c3;
	c3.printRecord();
	c5.printRecord();
    c1.printRecord();
    ++c1;
   -- c2;
   c1.printRecord();
   c2.printRecord();
   c1++;
   c2--;
   c1.printRecord();
      c2.printRecord();
      if (c1==c2){
    	  cout << true;
      }else cout<< false ;
	return 0;
}
