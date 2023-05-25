//============================================================================
// Name        : day4p2.cpp
// Author      : denise richy
// Version     :NNULLULL
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================
//Singleton class
#include <iostream>

using namespace std;


class MemberFunction{
private  :
	static int sum;

public :
	 static int addTwoNumber( int a, int b){
		sum=a+b;
		return sum;
	}
};

int MemberFunction::sum=0;
	int main(){
	static int x=MemberFunction:: addTwoNumber(10,20);
	cout <<x <<endl;
return 0;
	}
