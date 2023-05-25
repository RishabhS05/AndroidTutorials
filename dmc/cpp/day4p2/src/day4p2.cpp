//============================================================================
// Name        : day4p2.cpp
// Author      : denise richy
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>

using namespace std;

class Complex{
public :
	Complex(){
		cout<< "constructor \n";
	}
	 class Conplex2 {
	 public : int x  =123;
	 };
	~Complex(){
cout<<"\ndestructor";
	}
} ;

int main5 (){
	int **ptr =(int **) new int [2];
	for (int i = 0;i<2;i++){
		ptr [i]= new int [3];
	}
	for (int row =0;row <2;row++){
		for (int col=0 ;col<3 ;col++){
			cout<<"Enter element :";
					cin>>ptr[row][col];
		}
	}
	for (int row =0;row <2;row++){
		for (int col=0 ;col<3 ;col++){
			cout<<ptr[row][col]<<" ";
		}
		cout<<endl;
	}
	return 0 ;
}
	int main3 (){
	Complex *cptr= new Complex();
	//delete cptr;
	cptr->~Complex();
		return 0;
	}
	int main4 (){
	Complex *cptr= (Complex *)malloc(sizeof (Complex)) ;
	  free(cptr);

		return 0;
	}
//-------------------------------------------------------
int main1() {
	try{
	int count = 100000000;
	int *ptr = (int *)malloc(count*sizeof (int ));
	if (ptr !=NULL){
		cout <<ptr<<endl;
		free(ptr);
		ptr= NULL;
	}
	cout << "" << endl; // prints or bhai
	} catch (bad_alloc &ex){
		cout<< ex.what()<<endl;
	}
	return 0;
}

//--------------------------------------
int main2() {
	try{
	int count = 100000000;
	int *ptr = (int *)new int [count];
	if (ptr !=NULL){
		cout <<ptr<<endl;
		free(ptr);
		ptr= NULL;
	}
	cout << "" << endl; // prints or bhai
	} catch (bad_alloc &ex){
		cout<< ex.what()<<endl;
	}
	return 0;
}

#define size 3
class Array {
	private : int arr[size];
	int xds;
public :
	Array(int xds):xds(xds)
{cout <<this->xds;}
	Array(){
		for (int i =0 ;i<size ;i++)
			this->arr[i]=0;
	 }
	 void innerClass(){
		 int d;
			 class Inner {
			  int xy;
			 public :
			  Inner (int x ):xy(x)
			 {
cout<< "call inner class \n "<<this->xy;
			  }
			  int  Xy(){
				 return xy;
			 }
				 void setXy(int x ){
						 this -> xy=x;
						 }
			 };
		cout << "enter element";
		cin>>d;
		Inner in(d);

		 }
	void acceptRecord (){
		for (int i=0;i<size ;i++)
		{	cout <<"enter element";
		cin >> this->arr[i];
		}
	}
	void printRecord (){
		for (int i=0;i<size ;i++)
		{	cout << this->arr[i];}
	}
};

	int main(){
		Array  a ;
//		a.acceptRecord();
//		a.printRecord();
		a.innerClass();
	Complex ::Conplex2 c ;
	cout<<c.x;
		return 0;
	}
