//============================================================================
// Name        : NameSpace.cpp
// Author      : denise richy
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;
namespace first
{
int value =1200;
}

namespace second
{int value = 1300;}
using namespace first ;
using namespace second;
using namespace std;
int value=1440;
int main() {
	int value =90;
	cout << "value on first namspace is :" <<first::value << "Address  is :"<<&first::value<<endl; // prints
	cout << "value on second  namspace " <<second ::value << "Address  is :"<<&second::value<< endl; // prints
	cout << "value on  gobal variable " <<::value << "Address  is :"<<&::value<< endl; // prints
		cout << "value on local variable  " <<value<< "Address  is :"<<&value << endl; // prints
	return 0;
}
