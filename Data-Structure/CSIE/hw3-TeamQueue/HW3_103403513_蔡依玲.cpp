#include<bits/stdc++.h>
#define MAX_ELEMENT 5
using namespace std;
int last_element = -1; //皚程竚临⊿じ
int realloc_memory = 1;
map<int, int> mp;
void enqueue(int*,int);
void dequeue(int*);
void print_queue(int*);
int main(){
	string instrcution;
	int data_temp = 0, total_team_number = 0,scenario_number = 1;
	int *ar = (int*)malloc(MAX_ELEMENT * sizeof *ar);
	char filename[30];//"input1-1.txt"
	cout << "Please input filename: " << endl; 
	cin >> filename;
	ifstream fin(filename);
	if(!fin){
		cout<<"can't find the file.Please make sure your filename is correct.";
	}
	while(fin >> instrcution){ 
		if(instrcution == "ENQUEUE"){
			fin >> data_temp;
			enqueue(ar,data_temp);
		}else if(instrcution == "DEQUEUE"){
			dequeue(ar);
		}else if(instrcution == "STOP"){
			//do nothing
		}else{//盎代计
			if(!stoi(instrcution)){//STOP 计 0 
				break;
			}
			//initalize
			cout << "Scenario #" << scenario_number <<endl;
			scenario_number++;
			mp.clear();
			last_element = -1;
			realloc_memory = 1;
			fill(ar,ar+MAX_ELEMENT*realloc_memory, 0);
			print_queue(ar);
			//use new map
			total_team_number = stoi(instrcution);//材︽琌team羆计
			for(int i = 0; i < total_team_number ; i++){
				int team_element = 0;//teamΤ碭element
				fin >> team_element;
				for(int j = 0; j < team_element ;j++){
					fin >> data_temp;
					mp[data_temp] = i;
				}
			}
		}
	}
	free(ar);
}
void enqueue(int* ar,int data){
	int team_of_data = mp[data];
	int i = 0,temp = 0;
	for(;i <= last_element ;i++){
		if(mp[ar[i]] == team_of_data){//т舱 
			while(mp[ar[i]] == team_of_data){//рi﹚舱程竚+1 
				i++;
			}
			break;
		}
	}
	last_element++;
	
	if(last_element-1 >= MAX_ELEMENT*realloc_memory){//ノЧ 
		realloc_memory++;
		ar = (int*)realloc(ar,MAX_ELEMENT*realloc_memory*sizeof(*ar));
	}
	if (i > last_element)  i = last_element;//逼程 
	for(;i <= last_element;i++){
		temp = ar[i];
		ar[i] = data;
		data = temp;
	}
}
void dequeue(int* ar){
	cout << ar[0] <<endl;
	//move toward
	for(int i = 1;i <= last_element;i++){
		ar[i-1] = ar[i];
	}
	last_element--;
}
void print_queue(int* ar){
	for(int i = 0;i<= last_element;i++){
		cout << ar[i] << " ";
	}
}
