#include <cstdio>
#include <cstring>
#include <cmath>
#include <cstdlib>
void printBin(short n);
#define set(N,pos) N = N | (1 << pos)
//void set(short &n,int position);
void clear(short &n,int position);
#define check(N,pos) (N & (1 << pos))

int main(){
	short a = 0;
	printBin(a);
	set(a,4);
	printBin(a);
	set(a,2);
	printBin(a);
	set(a,3);
	printBin(a);
	clear(a,4);
	printBin(a);
	return 0;
}

void printBin(short n){
	int i = 8;
	for(int i = 0 ; i < 8 ; i++){
		if(check(n,i)) printf("1");
		else printf("0");
	}
	printf("\n");
}
//void set(short &n,int position){
//	n = (n | (1 << position));
//}
void clear(short &n, int position){
	n = (n & ~(1 << position));
}