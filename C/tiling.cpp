#include <cstdio>
#include <cstring>

int dp(int n,int b);
int DP[40][3];
int main(){
	int n;
	while(scanf("%d",&n)==1){
		if( n == -1) break;
		memset(DP,-1,sizeof(DP));
		if(n%2){
			printf("0\n");
		}
		else{
			printf("%d\n",dp(n,0));
		}
	}
	return 0;
	
}

int dp(int n,int b){
	//if(n <= 2) return 1;
	//printf("n = %d b = %d\n",n,b);
	if(DP[n][b] != -1) return DP[n][b];
	if(n == 0 && b == 0 || n == 1 && b == 1) return 1;
	else if(n <= 1) return 0;
	//if(n == 1) return 0;
	//if(n == 0) return 1;
	if(b == 0){
		return DP[n][b] =  dp(n-2,0) + 2*dp(n-1,1);// + 2*dp(n-2,2);
	}
	if(b == 1){
		return DP[n][b] =  dp(n-1,2) + dp(n-1,0);
	}
	if(b == 2){
		return DP[n][b] =  dp(n-1,1);
	}
}