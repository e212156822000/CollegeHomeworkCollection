#include<bits/stdc++.h>
#include<vector>
using namespace std;
map<char, bool> mp;
vector<char> v;
void choice(string);
void initialize_map(string);

int main(){
	string input;
	//����Ū��J 
	while(printf("Please input: ") && cin >> input ){
		initialize_map(input);
		choice(input);
		printf("\n");
	}
	
}
//�إߥi�ΦC�� 
void initialize_map(string input){
	v.clear();
	mp.clear();
	for(int i=0; i<input.length() ;i++){
		mp[input.at(i)] = false;
	}
}

void choice(string input){
	for(int i=0; i<input.length() ;i++){ //�T�wloop
		if( mp[input.at(i)] ) continue;
		v.push_back(input.at(i));
		mp[input.at(i)] = true;
		choice(input);
		v.pop_back();
		mp[input.at(i)] = false;
	}
	//�쩳�F 
	if(v.size() == input.length()){
		for(int i = 0;i<v.size();i++){
			printf("%c",v[i]);
		}
		printf("\n");
	}
}


