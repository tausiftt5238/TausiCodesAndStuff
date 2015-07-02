#include <cstdio>
#include <cstring>
#include <cstdlib>
int N;
int banana[200][200];
int DP[200][200];
int dp(int i,int j){
	if(i == 2 * N - 1) return 0;
	if(DP[i][j] != -1) return DP[i][j];
	int temp1 = banana[i][j] + dp(i+1,j);
	int temp2 = banana[i][j] + dp(i+1,j+1);
	return DP[i][j] = temp1 > temp2 ? temp1 : temp2;
}
int main(){
	int test;
	scanf("%d",&test);
	for(int cases = 1 ; cases <= test ; cases++){
		int i,j;
		scanf("%d",&N);
		memset(banana,0,sizeof(banana));
		memset(DP,-1,sizeof(DP));
		for(i = 0 ; i < 2 * N - 1 ; i++){
			if( i < N ){
				for(j = 0 ; j <= i ; j++){
					scanf("%d",&banana[i][j]);
				}
			}
			else{
				for(j = i - N + 1 ; j < N ; j++){
					scanf("%d",&banana[i][j]);
				}
			}
		}
		printf("Case %d: %d\n",cases,dp(0,0));
	}
	return 0;
}