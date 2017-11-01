#include<iostream>
#include<vector>
using namespace std;
struct sparce{
	int row;
	int col;
	int val;
};
vector< vector<int> > vectorA;  // 2D array
vector< vector<int> > vectorB;  // 2D array

vector<sparce> sparceA;
vector<sparce> sparceB;
vector<sparce> sparceC;
vector<sparce> transform_sparce_row_major(int,int,vector<vector<int>>,vector<sparce>);
vector<sparce> transform_sparce_col_major(int,int,vector<vector<int>>,vector<sparce>);
//vector<sparce> transpose_sparce(vector<sparce>);
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
	
	vector< vector<int> > vectorC(vectorA.size(),vector<int>(vectorB[0].size()));  // 2D array

	for(int i = 0;i< vectorA.size();i++){
		for(int j = 0;j< vectorB[0].size();j++){
			for(int k = 0;k< vectorB.size();k++){
				vectorC[i][j] += vectorA[i][k] * vectorB[k][j];
			}
		}
	}	
	
	sparceA = transform_sparce_row_major(vectorA.size(),vectorA[0].size(),vectorA,sparceA);
	sparceB = transform_sparce_col_major(vectorB.size(),vectorB[0].size(),vectorB,sparceB);
	sparceC = transform_sparce_row_major(vectorA.size(),vectorB[0].size(),vectorC,sparceC);
	
	cout << endl <<endl;
	
	for(int i = 1;i< sparceC.size();i++){
		cout << sparceC[i].row << " " << sparceC[i].col << " " << sparceC[i].val << endl;
	}
}
vector<sparce> transform_sparce_row_major(int rowLen,int colLen,vector< vector<int> > v,vector<sparce> sv){
	sparce data;
	//箇痙竚夹肈 
	sv.push_back(data);
	for(int i = 0;i< rowLen;i++){
		for(int j = 0;j< colLen;j++){
			if(v[i][j] != 0){
				data.row = i;
				data.col = j;
				data.val = v[i][j];
				sv.push_back(data);
			}
		}
	}
	//材戈痻皚col计, 痻皚row计, 痻皚Τ计秖
	sv[0].row = rowLen;
	sv[0].col = colLen;
	sv[0].val = sv.size()-1;
	return sv;
}
vector<sparce> transform_sparce_col_major(int rowLen,int colLen,vector< vector<int> > v,vector<sparce> sv){
	sparce data;
	//箇痙竚夹肈 
	sv.push_back(data);
	for(int i = 0;i< colLen;i++){
		for(int j = 0;j< rowLen;j++){
			if(v[j][i] != 0){
				data.col = i;
				data.row = j;
				data.val = v[j][i];
				sv.push_back(data);
			}
		}
	}
	//材戈痻皚col计, 痻皚row计, 痻皚Τ计秖
	sv[0].row = rowLen;
	sv[0].col = colLen;
	sv[0].val = sv.size()-1;
	return sv;
}
