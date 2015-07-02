#include <cstdio>
#include <cstdlib>

int keep[302][302];
int dp[302][32];
int V,P;
int village[302];

void keepMake(){
	int i,j,k;
	for( i = 0 ; i < V; i ++){
		for( j = i+1 ; j < V ; j ++){
			for( k = i ; k <= j ; k++){
				int temp1 = abs(village[i] - village[k]);
				int temp2 = abs(village[j] - village[k]);
				keep[i][j] = keep[j][i] = temp1 < temp2 ? temp1:temp2;
			}
		}
	}
}
int DP(int cur,int prev,int left);
int main(){
	scanf("%d%d",&V,&P);
	int i,j;
	for(i = 0 ; i < V ; i ++){
		scanf("%d",&village[i]);
	}
	keepMake();
	printf("%d\n",DP(0,0,P));
	return 0;
}

int DP(int cur,int prev,int left){
	if(cur > V) return 0;
	if(left < 0) return 0;
	int temp1 = keep[cur][prev] + keep[cur][V-1] + DP(cur+1,cur,left-1);
	int temp2 = DP(cur+1,prev,left);
	return temp1 < temp2 ? temp1 :temp2;
}