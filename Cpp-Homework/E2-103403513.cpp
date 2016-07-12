/******************************************
該程式會請使用者輸入三個數字， 代表三角形的邊長。
1)利用「兩邊加起來大於第三邊 」判定是否為三角形。
2)判斷是否為等腰三角形還是直角三角形。 
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
