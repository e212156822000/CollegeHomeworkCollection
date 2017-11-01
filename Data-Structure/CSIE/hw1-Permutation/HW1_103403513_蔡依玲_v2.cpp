#include<bits/stdc++.h>
#include<vector>
using namespace std;
map<char, int> mp;
vector<char> v;
void choice(string,int);
void initialize_map(string);
string initialize_reference_string(string);

int main(){
	string input;
	string ref_input;
	//����Ū��J 
	while(printf("Please input: ") && cin >> input ){
		initialize_map(input);
		ref_input = initialize_reference_string(input);
		choice(ref_input,input.length());
		printf("\n");
	}
	
}
//�N�öê�input�ܦ��@��²�檺�����C�� 
string initialize_reference_string(string input){
	string reference_string;
	reference_string.clear();
	for(int i=0; i<input.length() ;i++){
		//�p�G�����ƴN���[�J�C�� 
		if(reference_string.find(input.at(i),0) != -1) continue;
		else reference_string += input.at(i);
	}
	return reference_string;
}
//�إߥi�ΦC�� 
void initialize_map(string input){
	v.clear();
	mp.clear();
	for(int i=0; i<input.length() ;i++){
		mp[input.at(i)] ++;
	}
}

void choice(string input,int len){
	for(int i=0; i<input.length() ;i++){ //�T�wloop
		if( mp[input.at(i)] <= 0) continue;
		v.push_back(input.at(i));
		mp[input.at(i)] --; //�ϥα��F 
		choice(input,len);
		v.pop_back();
		mp[input.at(i)] ++; //�ϥΧ��F 
	}
	//�쩳�F 
	if(v.size() == len){
		for(int i = 0;i<v.size();i++){
			printf("%c",v[i]);
		}
		printf("\n");
	}
}


