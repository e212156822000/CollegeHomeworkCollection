#include<iostream>
#include<vector>
using namespace std;
vector< vector<int> > vectorA;  // 2D array
vector< vector<int> > vectorB;  // 2D array
vector< vector<int> > vectorC(3,vector<int>(5));
int main(){
	string input;	
	vector<int> row;
	while(1){
		cin >> input;
		if(input == "|") break;
		row.push_back(stoi(input));
		if(cin.get() == '\n'){
			vectorA.push_back(row);
			row.clear();
			continue;
		}
	}
	for(int i = 0;i< vectorA[0].size();i++){
		for(int j = 0;j< vectorA.size();j++){
			cin >> input;
			row.push_back(stoi(input));
		}
		vectorB.push_back(row);
		row.clear();
	}
	int temp;
	for(int i = 0;i< 3;i++){
		for(int j = 0;j< 5;j++){
			for(int k = 0;k< 4;k++){
				vectorC[i][j] += vectorA[i][k] * vectorB[k][j];
			}
		}
	}
	cout << "Vector B: "<<endl;
	for(int i = 0;i< vectorB.size();i++){
		for(int j = 0;j< vectorB[i].size();j++){
			cout << vectorB[i][j] << " ";
		}
		cout << "\n"; 
	}
	cout << "Vector C: "<<endl;
	for(int i = 0;i< vectorC.size();i++){
		for(int j = 0;j< vectorC[i].size();j++){
			cout << vectorC[i][j] << " ";
		}
		cout << "\n";
	}
}
