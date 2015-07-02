#include <cstdio>
#include <cstring>
#include <cstdlib>
char A[2002];
char B[2002];
int DP[2002][2002];
int a_length,b_length;
int dp(int i,int j);
int main(){
	int test;
	scanf("%d",&test);
	while(test--){
		memset(DP,-1,sizeof(DP));
		scanf("%s%s",A,B);
		a_length = strlen(A);
		b_length = strlen(B);
		printf("%d\n",dp(0,0));
	}
	return 0;
}
int dp(int a,int b){
	//printf("%c %c\n",A[a],B[b]);
	if(DP[a][b] != -1) return DP[a][b];
	if(a == a_length && b == b_length){
		if(A[a] == B[b])
			return DP[a][b] = 0;
		else return DP[a][b] = 1;
	}
	if(a == a_length) return DP[a][b] = 1 + a - b;
	if(b == b_length) return DP[a][b] = 1 + b - a;
	
	if(A[a] == B[b]) return DP[a][b] = dp(a+1,b+1);
	int insert,del,replace;
	insert = 1 + dp(a+1,b);
	del = 1 + dp(a, b+1);
	replace = 1 + dp(a+1, b+1);
	int min = insert;
	if(min > del) min = del;
	if(min > replace) min = replace;
	return DP[a][b] = min;
}