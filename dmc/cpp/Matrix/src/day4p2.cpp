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

class Matrix
{
	 int row , col;
	 int **ptr ;
public :
	 Matrix(int row ,int col):row(row),col(col)
{
	init();
}
private: void init(){
	 		 this-> ptr= new int* [ this->row ];
	 		 	for (int i = 0;i<this->row;++i){
	 		 			this->ptr [i]= new int [this->col];
	 		 		}
	 	 }
public :
Matrix(Matrix & obj){
	this->col=obj.col;
	this->row= obj.row;
this->ptr=obj.ptr;// all  the elements of the array  are copied in side the new element

}
void acceptValues(){
	for (int r =0;r <row ;r++){
			for (int c=0 ;c<col;c++){
				cout<<"Enter element :";
						cin>>ptr[r][c];
			}
		}
}
 void printMatrix(){
	for (int i =0 ;i<row ;++i){
		for (int j = 0 ;j<col;++j){
			cout<<"\t"<<ptr [i][j];
		}cout<<endl;
	}
	}

 void freememory(){
		for (int i = 0;i<this->row;++i){
		 		 			delete[] ptr[i];
		 		 		}
		delete [] ptr;
		ptr =NULL;
		cout<< "memory Released \n ";
 }
 ~Matrix(){
	 freememory();
 }
};
	int main(){
		int x,y;
cout <<"Matrix  class xample \n";
cout<<"Enter row & col  for matrix ";
cin>> x>>y;
Matrix m1(x,y);
m1.acceptValues();
m1.printMatrix();
Matrix y1 = m1;
//y1.acceptValues();
y1.printMatrix();
		return 0;
	}
