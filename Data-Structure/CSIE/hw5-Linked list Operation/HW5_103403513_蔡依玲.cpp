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
void reverseList(node**,node**);
void deleteNode(node**,node**,node**);
void printList(node*);
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
	int data_temp = 0, insert_index = 0,scenario_number = 1;
	char filename[30];//"input1-1.txt"
	cout << "Please input filename: " << endl; 
	cin >> filename;
	ifstream fin(filename);
	if(!fin){
		cout<<"can't find the file.Please make sure your filename is correct.";
	}
	while(fin >> instrcution){ 
		if(instrcution == "ADD"){
			fin >> data_temp;
			pNew = new struct node;
			insertNode(&list,&pPre,&pNew,data_temp);
		}else if(instrcution == "INSERT"){
			fin >> data_temp;
			fin >> instrcution;
			if(instrcution == "BEHIND"){
				fin >> insert_index;
				if(searchList(list,&pPre,&pLoc,insert_index)){
					pNew = new struct node;
					insertNode(&list,&pLoc,&pNew,data_temp);
				}
				else
					cout << "Insert index is out of range!!" <<endl; 
			}
			else break;//rise the error
			
		}else if(instrcution == "DELETE"){
			fin >> insert_index;
			if(searchList(list,&pPre,&pLoc,insert_index)){
				deleteNode(&list,&pPre,&pLoc);
			}else
				cout << "Insert index is out of range!!" <<endl; 
			//searchList
			//deleteNode(&list,&pPre,&pLoc);
		}else if(instrcution == "REVERSE"){
			//do nothing
			reverseList(&list,&pPre);
		}else{//������Ʀr
			cout << "something wrong with the instruction!"<<endl;
			break;
		}
		//�L�XLinked list��elements 
		printList(list->ptr);
		cout << endl;
	}
}
void deleteNode(node** list,node** pPre,node** pLoc){//pLoc �|���ۭn�R����node
	if(*pPre == NULL){
		(*list)->ptr = (*pLoc)->ptr;
	}else{
		(*pPre)->ptr = (*pLoc)->ptr;
	}
	(*list)->number --;
	//free(*pLoc);
}
void reverseList(node** list,node** pPre){
	node *trail;
	node *middle = NULL;
	node *head_temp = *list;
	int looper = (*list)->number-1;
	*list = (*list)->ptr;
	//��pPre�N���V�̫�@��(�]�N�O�ثelist���Ĥ@��)
	*pPre = *list;
	for(int i =0; i<= looper ;i++){
		trail = middle;
		middle = *list;
		*list = (*list)->ptr;
		middle->ptr = trail;
	}
	head_temp->ptr = middle;
	*list = head_temp;
}
bool searchList(node* list,node** pPre,node** pLoc,int index){
	*pLoc = list;
	//���ˬdindex���L�W�X��ڼƶq 
	if(index > list->number) return false;
	//�b�w����index�W�� 
	else{
		*pPre = NULL;
		for(int i = 1; i <= index ;i++){
			*pPre = *pLoc;
			*pLoc = (*pLoc)->ptr;
		}
	}
	return true;
}
void printList(node* temp){
	while(temp != NULL){
		cout << temp->number <<"  ";
		temp = temp->ptr;
	}
	cout << endl;
}
bool insertNode(node** list,node** pPre,node** pNew,int datain){//�C��insert�N��*pPre�k���̫᭱ 
	if(*pPre ==NULL){
		(*pNew)->ptr = (*list)->ptr;
		(*list)->ptr = *pNew;
	}
	else{
		(*pNew)->ptr = (*pPre)->ptr;
		(*pPre)->ptr = *pNew;
	}
	(*pNew)->number = datain;
	*pPre = *pNew;//���V�̫�@��node 
	(*list)->number ++;
	return true;
}
