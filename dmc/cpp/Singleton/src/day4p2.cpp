//============================================================================
// Name        : day4p2.cpp
// Author      : denise richy
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================
//Singleton class
#include <iostream>

using namespace std;

class Single{
	Single (){
cout<<"in constor\n";
	}
	Single (const Single &obj){
cout<<"copy Constor";
	}

public :
	 int x =1033;
	static Single &getInstance (){
		static Single single ;
	return single;
	}
};
	int main(){
cout <<"Singleton class xample \n";
Single &x1= Single::getInstance();
Single &x2= Single::getInstance();
Single &x3= Single::getInstance();
//cout <<Single ::getInstance().x;
cout <<x1.x<<" Address :"<<&x1<<endl;
cout <<x3.x<<" Address"<<&x2<<endl;
cout <<x2.x<<" Address"<<&x3<<endl;
		return 0;
	}
