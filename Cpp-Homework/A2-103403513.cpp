/********************************************************
�ШϥΪ̿�J�T�ӼƦr�A�{���|�N���̥Ѥj��p��X�C 
********************************************************/
#include<iostream>
using namespace std;
int main(){
	int n1 , n2 , n3 , holder;
	cout << "Please input three integers <press Enter to input one by one> : \n";
	cin >> n1 >> n2 >> n3;
	if( n3 > n2 ){
		holder = n3 ;
		n3 = n2;
		n2 = holder;
	}
	if( n3 > n1 ){
		holder = n3 ;
		n3 = n1;
		n1 = holder;
	}
	if( n2 > n1 ){
		holder = n2 ;
		n2 = n1;
		n1 = holder;
	}
	cout << n1 <<" > " << n2 << " > " << n3 ;
}
