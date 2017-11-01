#include<bits/stdc++.h>
using namespace std;
void perm(char [],int,int);
int main(){
	int len = 0 , j = 0;
	char test_case[10];
	string answer;
	int total_num = 1;
	char filename[] = "input1-1.txt";
	ifstream fin(filename);
	if(!fin){
		cout<<"can't find the file.Please make sure your filename is correct.";
	}
	while(!fin.eof()){
		fin>>test_case[len];
		if(test_case[len] == '\0') break;
		len++;
	}	
	perm(test_case,0,len-1);
} 

void perm(char list[],int start_index, int end_index){
	int j , temp;
	if(start_index == end_index){
		for(j = 0; j<=end_index ; j++){
			printf("%c",list[j]);
		}
		printf("    ");
	}
	else{
		for(j = start_index; j<=end_index ; j++){
			swap(list[start_index],list[j]);
			perm(list,start_index+1,end_index);
			swap(list[start_index],list[j]);
			
		}
	}
}
