#include<bits/stdc++.h>
using namespace std;
int main(){
	int *a = (int*)malloc(5 * sizeof *a);
	for(int i = 0;i<5;i++){
		a[i] = i;
	}
//	for(int i = 0;i<5;i++){
//		cout <<a[i]<<" ";
//	}
	a = (int*)realloc(a,10*sizeof *a);
	for(int i = 5;i<10;i++){
		a[i] = i+10;
	}
	a = (int*)realloc(a,20*sizeof *a);
	for(int i = 0;i<20;i++){
		cout <<a[i]<<" ";
	}
	free(a);
}
