#include <cstdio>

int N[102][102];
int DP[102][102];
int dp();

int main(){
	int n;
	scanf("%d",&n);
	int i,j;
	for(i = 1; i <= n ; i++){
		for( j = 1 ; j <= n ; j ++){
			int temp;
			scanf("%d",&temp);
			N[i][j] = temp;
			DP[i][j] = DP[i-1][j] + N[i][j];
		}
	}
	int max = N[1][1];
	int k;
	for(i = 1;i <= n; i++){
		for(j = i; j<=n ; j++){
			int summation = 0;
			for(k = 1; k<=n; k++){
				summation += DP[j][k] - DP[i-1][k];
				if(summation < 0) summation = 0;
				if(max < summation ) max = summation;
			}
		}
	}
	printf("%d\n",max);
	return 0;
}