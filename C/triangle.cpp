#include <cstdio>
#include <cstring>
#include <vector>
using namespace std;
int src;

int input[102][102];
int dp[102][102];
void takeInput(int n){
	int summation = (n*(n+1))/2;
	int i,j,k;
	int limit = 1;
	int count = 0;
	for(i = j = k = 0; i< summation; i++){
		scanf("%d",&input[j][k]);
		count++;k++;
		if(count == limit){
			limit++;
			count = 0;
			j++;
			k = 0;
		}
	}
}
int DP(int i,int j){
	if(dp[i][j] != -1) return dp[i][j];
	if(input[i][j] == -1) return 0;
	int sum1 = input[i][j] + DP(i+1,j);
	int sum2 = input[i][j] + DP(i+1,j+1);
	if(sum1 > sum2) return dp[i][j] = sum1;
	else return dp[i][j] = sum2;
}

int main(){
	int n;
	memset(input,-1,sizeof(input));
	memset(dp,-1,sizeof(dp));
	scanf("%d",&n);
	takeInput(n);
	printf("%d\n",DP(0,0));
	return 0;
}