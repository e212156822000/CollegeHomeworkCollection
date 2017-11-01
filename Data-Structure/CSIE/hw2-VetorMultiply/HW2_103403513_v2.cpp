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
vector<sparce> transform_and_transpose_sparce_col_major(int,int,vector<vector<int>>,vector<sparce>);

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
		for(int j = 0;j< vectorA.size();j++){
			for(int k = 0;k< vectorB.size();k++){
				vectorC[i][j] += vectorA[i][k] * vectorB[k][j];
			}
		}
	}	
	
	sparceA = transform_sparce_row_major(vectorA.size(),vectorA[0].size(),vectorA,sparceA);
	sparceB = transform_and_transpose_sparce_col_major(vectorB.size(),vectorB[0].size(),vectorB,sparceB);
	sparceC = transform_sparce_row_major(vectorA.size(),vectorB[0].size(),vectorC,sparceC);
	
	cout << "Sparce Vector C:" <<endl;
	for(int i = 0;i< sparceC.size();i++){
		cout << sparceC[i].row << " " << sparceC[i].col << " " << sparceC[i].val << endl;
	}
	
//	for(int i = 0;i< sparceA[0].row ;i++){
//		for(int j = 0;j< sparceB[0].col ;j++){
//			for(int k = 0;k< vectorB[i].size();k++){
//				if(sparceA[k].row == i)
//				if(sparceA[k].row == i)
//				vectorC[i][j] += vectorA[i][k] * vectorB[k][j];
//			}
//		}		
//	}
	
	
	int row = 0; // < vectorA.size() 
	int col = 0; // < vectorB[0].size() 
	int sum = 0;
	for(int i = 1;i<sparceA[0].val;i++){
		//從B中找出可以乘的元素 
		for(int j = 0; sparceA[i] == row && j<sparceB[0].val; j++){
			if(sparceB[j].col == col && sparceB[j].row == row){
				sum += sparceA[i].val * sparceB[j].val;
			}
		}
	}
		
		
		for(int j = i;sparceA[i].row == sparceB[j].col && j < sparceB[0].val ;j++){
			if(sparceA[i].col == sparceB[j].row){
				temp += sparceA[i].val * sparceB[i].val;
				break;
			}
		}
		if(sparceA[i].row != col){
			col++;
			cout << temp << " ";
			temp = 0;
		}
	}
	
	


	cout << "Sparce Vector A:" <<endl;
	for(int i = 0;i< sparceA.size();i++){
		cout << sparceA[i].row << " " << sparceA[i].col << " " << sparceA[i].val << endl;
	}
	cout << "Sparce Vector and transpose B:" <<endl;
	for(int i = 0;i< sparceB.size();i++){
		cout << sparceB[i].row << " " << sparceB[i].col << " " << sparceB[i].val << endl;
	}

	/*
	cout << "Vector B: "<<endl;
	for(int i = 0;i< vectorB.size();i++){
		for(int j = 0;j< vectorB[i].size();j++){
			cout << vectorB[i][j] << " ";
		}
		cout << "\n"; 
	}
*/	
}
vector<sparce> transform_sparce_row_major(int rowLen,int colLen,vector< vector<int> > v,vector<sparce> sv){
	sparce data;
	//預留一個位置放標題 
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
	//第一列的資料：原矩陣col數, 原矩陣row數, 原矩陣有值的數量
	sv[0].row = rowLen;
	sv[0].col = colLen;
	sv[0].val = sv.size()-1;
	return sv;
}
vector<sparce> transform_and_transpose_sparce_col_major(int rowLen,int colLen,vector< vector<int> > v,vector<sparce> sv){
	sparce data;
	//預留一個位置放標題 
	sv.push_back(data);
	for(int i = 0;i< colLen;i++){
		for(int j = 0;j< rowLen;j++){
			if(v[j][i] != 0){
				data.col = j; // 轉置 
				data.row = i; // 轉置 
				data.val = v[j][i];
				sv.push_back(data);
			}
		}
	}
	//第一列的資料：原矩陣col數, 原矩陣row數, 原矩陣有值的數量
	sv[0].row = colLen;
	sv[0].col = rowLen;
	sv[0].val = sv.size()-1;
	return sv;
}
