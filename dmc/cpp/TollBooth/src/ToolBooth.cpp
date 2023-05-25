
#include <iostream>
using namespace std;

class TTollBooth{
	double _totalMoneyCollected ;

	unsigned int _totalNumberOfCars ;

	unsigned int _totalNumberOfNonPayingCars ;

	unsigned int _totalNumberOfPayingCars ;
public :
	TTollBooth( void ){
		_totalNumberOfPayingCars=0;
		_totalNumberOfNonPayingCars=0;
		_totalNumberOfCars =0;
		_totalMoneyCollected =0;

	}
	void PayingCar( void ){
		_totalNumberOfPayingCars++;
		_totalNumberOfCars++;
		_totalMoneyCollected+=0.5;

	}

	void NonPayingCar( void ){
		_totalNumberOfNonPayingCars++;
		_totalNumberOfCars++;
	}

	double GetTotalMoneyCollected( void ){
		return _totalMoneyCollected;
	}

	unsigned int GetTotalNumberOfCars( void ){return _totalNumberOfCars;}

	unsigned int GetTotalNumberOfPayingCars( void ){
		return _totalNumberOfPayingCars;
	}

		unsigned intGetTotalNumberOfNonPayingCars( void ){
			return _totalNumberOfNonPayingCars;
		}
void printDetail(){
	cout<<"Total Number Of Cars                        |    "<<this-> _totalNumberOfCars<<endl;
	cout<<"Total Number Of NonPaying Cars  |     "<< this->_totalNumberOfNonPayingCars<<endl;
	cout <<"Total Number Of Paying Cars          |     "<<this->_totalNumberOfPayingCars<<endl;
	cout<<"Total Money Collected                      |      "<<this->_totalMoneyCollected<<endl;

}
};
int main() {

cout<<"=================================WellCome to Jabalpur=========================================\n";
TTollBooth tb;int num;

do{
	cout<<"Enter choice 1-5 ";
	cin>>num;
switch (num){
		case 1:tb.PayingCar();
			break;
		case 2:
			tb.NonPayingCar();
			break;
		case 3:
			tb.printDetail();
			break;
		case 4:break;
		case 5:exit (0);
		break;
		}
}while (num<5||num>0);

return 0;
}
