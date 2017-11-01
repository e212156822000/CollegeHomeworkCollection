#include<bits/stdc++.h>
#define MAX_ELEMENT 5
using namespace std;
struct node{
	int number = 0;
	node *ptr = NULL;
};
map<int, int> mp; 
bool insertNode(node**,node**,node**,int);
bool searchList(node*,node**,node**,int);
void enqueue(node**,node**,node**,node**,int);
void dequeue(node**,node**,node**);
void print_queue(node*);
int main(){
	//link list
	struct node head;//head
	node* pPre = NULL;
	node* pLoc = NULL;
	node* pNew = NULL;
	node* list = &head;
	node* temp = &head;
	list->number = 0;
	string instrcution;
	int data_temp = 0, total_team_number = 0,scenario_number = 1;
	char filename[30];//"input1-1.txt"
	cout << "Please input filename: " << endl; 
	cin >> filename;
	ifstream fin(filename);
	if(!fin){
		cout<<"can't find the file.Please make sure your filename is correct.";
	}
	while(1){
		fin >> instrcution;
		if(instrcution == "ENQUEUE"){
			fin >> data_temp;
			pNew = new struct node;
			enqueue(&list,&pPre,&pLoc,&pNew,data_temp);
		}else if(instrcution == "DEQUEUE"){
			dequeue(&list,&pPre,&pLoc);
		}else if(instrcution == "STOP"){
			//initalize
			mp.clear();
			pPre = NULL;
			pLoc = NULL;
			pNew = NULL;
			list->ptr = NULL;
			list->number = 0; 
			temp->ptr = NULL;
			cout << endl;
			//do nothing
		}else{//盎代计
			if(!stoi(instrcution)){//STOP 计 0
				break;
			}
			cout << "Scenario #" << scenario_number++ <<endl;
			//弄team戈籹map
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
}
void enqueue(node** list,node** pPre,node** pLoc,node** pNew,int data){
	int team_of_data = mp[data];
	searchList(*list,pPre,pLoc,team_of_data);
	insertNode(list,pPre,pNew,data);
//	print_queue(*list);
}
void dequeue(node** list,node** pPre,node** pLoc){
	if((*list)->ptr != NULL){
		cout << (*list)->ptr->number << endl;
		(*list)->ptr = (*list)->ptr->ptr;
		(*list)->number --;
	}
	if((*list)->number == 0){
		*pPre = NULL;
	}
}
bool searchList(node* list,node** pPre,node** pLoc,int team_number){
	*pLoc = list;
	bool found = false;
	if(*pPre != NULL && mp[(*pPre)->number] == team_number){//浪琩程element
		found = true;
	}
	else{
		*pPre = NULL; 
		do{
			*pPre = *pLoc;
			*pLoc = (*pLoc)->ptr;
		}while(*pLoc != NULL && team_number != mp[(*pLoc)->number]);
		if(*pLoc == NULL){
			found = false;
		}else{
			while(*pLoc != NULL && team_number == mp[(*pLoc)->number]){
				*pPre = *pLoc;
				*pLoc = (*pLoc)->ptr;
			}
			found = true;
		}	
	}
	return found;
}
void print_queue(node* temp){
	while(temp != NULL){
		cout << temp->number <<"  ";
		temp = temp->ptr;
	}
	cout << endl;
}
bool insertNode(node** list,node** pPre,node** pNew,int datain){//–Ωinsert碞р*pPre耴程 
	if(*pPre ==NULL){
		(*pNew)->ptr = (*list)->ptr;
		(*list)->ptr = *pNew;
	}
	else{
		(*pNew)->ptr = (*pPre)->ptr;
		(*pPre)->ptr = *pNew;
	}
	(*pNew)->number = datain;
	*pPre = *pNew;//程node 
	(*list)->number ++;
	return true;
}
