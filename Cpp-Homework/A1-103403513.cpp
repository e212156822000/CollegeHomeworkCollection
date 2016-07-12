/************************************
程式會輸出一個BMI的公式，接著請使用者輸入
1)ID(隨意輸入) 。
2)體重
3)身高
接著程式會計算出你的BMI值。(小數點一位) 
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
