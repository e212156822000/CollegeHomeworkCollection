/******************************************
�ӵ{���|�ШϥΪ̿�J�T�ӼƦr�A �N��T���Ϊ�����C
1)�Q�Ρu����[�_�Ӥj��ĤT�� �v�P�w�O�_���T���ΡC
2)�P�_�O�_�����y�T�����٬O�����T���ΡC 
******************************************/ 
#include<iostream>
using namespace std;
int main(){
    int s1,s2,s3;
    cout<<"Input your 3 numbers: ";
    cin>>s1>>s2>>s3;
    //test if it is a triangle
    if( s1+s2<=s3 || s2+s3<=s1 || s1+s3<=s2 ){
        cout<<"It's not a triangle.";
    }else if(s1==s2||s2==s3||s1==s3){
        cout<<"Isosceles triangle.";
    }else if(s1*s1+s2*s2==s3*s3||s1*s1+s3*s3==s2*s2||s3*s3+s2*s2==s1*s1){
        cout<<"rectangular triangle.";
    }else{
        cout<<"triangle.";
    }
}
