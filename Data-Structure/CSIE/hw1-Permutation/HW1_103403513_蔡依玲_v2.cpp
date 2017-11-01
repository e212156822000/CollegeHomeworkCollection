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
	//反覆讀輸入 
	while(printf("Please input: ") && cin >> input ){
		initialize_map(input);
		ref_input = initialize_reference_string(input);
		choice(ref_input,input.length());
		printf("\n");
	}
	
}
//將亂亂的input變成一個簡單的元素列表 
string initialize_reference_string(string input){
	string reference_string;
	reference_string.clear();
	for(int i=0; i<input.length() ;i++){
		//如果有重複就不加入列表中 
		if(reference_string.find(input.at(i),0) != -1) continue;
		else reference_string += input.at(i);
	}
	return reference_string;
}
//建立可用列表 
void initialize_map(string input){
	v.clear();
	mp.clear();
	for(int i=0; i<input.length() ;i++){
		mp[input.at(i)] ++;
	}
}

void choice(string input,int len){
	for(int i=0; i<input.length() ;i++){ //固定loop
		if( mp[input.at(i)] <= 0) continue;
		v.push_back(input.at(i));
		mp[input.at(i)] --; //使用掉了 
		choice(input,len);
		v.pop_back();
		mp[input.at(i)] ++; //使用完了 
	}
	//到底了 
	if(v.size() == len){
		for(int i = 0;i<v.size();i++){
			printf("%c",v[i]);
		}
		printf("\n");
	}
}


