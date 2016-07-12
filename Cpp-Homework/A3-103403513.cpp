/************************************************
程式會請使用者輸入一個數字，
然後輸出該數量的費伯那契數。 
************************************************/
#include<iostream>
using namespace std;
int main(){
	int counter, n0 = 1 , n1 = 1 , n2 , n =0;//index starts at 0
	cout << "Please input the number:";
	cin >> counter;
	if( counter < 1 ){
		cout << "Number can't be less than 1";
	}
	else{		
		while( n != counter){
			//to show n0 and n1 at first
			if(n==0){
				cout << n0 << " ";
			}
			if(n==1){
				cout << n1 << " ";
			}
			//rest of them
			if(n>=2){
				n2 = n0 + n1;
				n0 = n1;
				n1 = n2;
				cout<< n2 << " ";
			}
			n++;
		}
	}
}
