/************************************
�{���|��X�@��BMI�������A���۽ШϥΪ̿�J
1)ID(�H�N��J) �C
2)�魫
3)����
���۵{���|�p��X�A��BMI�ȡC(�p���I�@��) 
************************************/
#include<iostream>
#include<iomanip>
using namespace std;
int main(){
	//defin variables
	int ID,Hcm,w;
	double Hm,BMI;
	//saving data
	cout<<"BMI=Weight/(Height^2)\n\n";
	cout<<"Please input your ID:";
	cin>>ID;
	cout<<"Please input your weight:";
	cin>>w;
	cout<<"Please input your height(CM):";
	cin>>Hcm;
	//calculate
	Hm=(float)Hcm/100;
	BMI=(float)w/(Hm*Hm);
	cout<<endl<<"Hi! "<<ID<<" Your BMI: "<<fixed<<setprecision(1)<<BMI;
} 
