#include <cstdio>
#include <cstring>
#include <cmath>
#include <cstdlib>
#define set(N,pos) N | (1 << pos)
#define clear(N,pos) N & ~(1 << pos)
#define check(N,pos) (N & (1 << pos))
int N;
int job[16][16];
int DP[(1 << 16)];
int dp(int n){
	if(n == (1 << N) - 1) return DP[n] = 0;
	if(DP[n] != -1) return DP[n];
	int min = 1 << 28;
	int jobNow = 0;
	for(int i = 0 ; i < N ; i++){
		if(check(n,i) == 0){
			jobNow = job[i][i];
			for(int j = 0 ; j < N ; j++){
				if(i!=j && check(n,j)!= 0){
					jobNow += job[i][j];
				}
				
			}
			int rec = dp(set(n,i)) + jobNow;
			min = rec < min ? rec : min;
		}
	}
	return DP[n] = min;
}
int main(){
	int test;
	scanf("%d",&test);
	for(int cases = 1 ; cases <= test; cases++){
		memset(DP,-1,sizeof(DP));
		scanf("%d",&N);
		int i,j;
		for(i = 0; i < N ; i++){
			for(j = 0; j < N ; j++){
				scanf("%d",&job[i][j]);
			}
		}
		printf("Case %d: %d\n",cases,dp(0));
	}
	return 0;
}