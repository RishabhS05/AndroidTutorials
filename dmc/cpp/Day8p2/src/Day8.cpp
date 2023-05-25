
#include <iostream>
#include <string>
using namespace std;
class Person {
	int age ;
	string name;
public :
	Person():age(0),name("")
{}
	Person(int age,string name ):age(age),name(name)
{}
void printRecord(){
	cout<<"person Class \n";
	cout<<"\nName : "<<this->name;
	cout<<"\nAge  : "<<this->age ;
	cout<<"\n_________";
}
};
class Employee :public Person
{int empid;
float salary ;
public :
	Employee():empid(0),salary(0){

	}
	Employee(string name ,int age ,int empid,float salary):Person(age,name),empid(empid),salary(salary)
	{}
	void printRecord(){
		cout<<"Employee Class \n";
		Person::printRecord();
		cout<<"\nempid  : "<<this->empid ;
		cout<<"\nSalary  : "<<this->salary;
		cout<<"\n_________";
	}
};

int main() {
	Employee emp("ABC",23,4512,25000);
		emp.printRecord( );
	return 0;
}






























