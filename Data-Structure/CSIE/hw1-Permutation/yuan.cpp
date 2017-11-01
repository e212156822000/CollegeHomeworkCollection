#include<bits/stdc++.h>
#define pb push_back
using namespace std;

map<char , bool> mp;
vector<char> p;
string s;

void print(){
	for( auto z : p ) putchar( z );
	puts("");
}

void DFS( int now ){
    if( now == s.size() - 1 ){
        print();
        return;
    }
    for( auto z : s ){
        if( mp[ z ] ) continue;
        p.pb( z );
        mp[ z ] = 1;
        DFS( now + 1 );
        mp[ z ] = 0;
        p.pop_back();
    }
    return;
}

int main(){
	cin >> s;
    for( auto z : s ){
        p.pb( z );
        mp[ z ] = 1;
        DFS( 0 );
        mp[ z ] = 0;
        p.pop_back();
    }
    return 0;
}
