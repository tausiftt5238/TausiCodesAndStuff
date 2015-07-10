#include <cstdio>
#include <cstring>

char input[5002];
short DP[5002][5002];
int dp(int s,int e);

int main(){
	int N;
	memset(DP,-1,sizeof(DP));
	scanf("%d%s",&N,input);
	int sum = dp(0,N-1);
	printf("%d\n",sum);
	return 0;
}

int dp(int s,int e){
	if(DP[s][e] != -1) return DP[s][e];
	if(s >= e) return 0;
	if(input[s] == input[e]) return DP[s][e] = dp(s+1,e-1);
	if(input[s] != input[e]){
		int a = 1 + dp(s+1,e);
		int b = 1 + dp(s,e-1);
		if(a < b) return DP[s][e] = a;
		else return DP[s][e] = b;
	}
}