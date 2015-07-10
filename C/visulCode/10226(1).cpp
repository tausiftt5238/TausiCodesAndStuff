#include <cstdio>
#include <map>
using namespace std;

int main(){
	int test;
	scanf("%d",&test);
	while(test--){
		map <char*,int> m;
		char name[40];
		while(scanf("%s",name) == 1){
			m[name]++;
		}
	}
}