#include <cstdio>
#include <cstring>
#include <cstdlib>
int N,S;
int size[2001];
int val[2001];
int DP[2001][2001];
int dp(int index,int s);
int main(){
	memset(DP,-1,sizeof(DP));
	scanf("%d%d",&S,&N);
	int i;
	for(i = 0; i < N ; i++){
		scanf("%d%d",&size[i],&val[i]);
	}
	printf("%d\n",dp(0,0));
	return 0;
}
int dp(int index,int s){
	if( index == N) return 0;
	if(DP[index][s] != -1) return DP[index][s];
	int temp1,temp2;
	temp1 = temp2 = 0;
	if(s + size[index] <= S){
		temp1 = val[index] + dp(index+1, s + size[index]);
	}
	temp2 = dp(index+1, s);
	return DP[index][s] = temp1 > temp2? temp1 : temp2;
}
