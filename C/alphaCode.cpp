#include <cstdio>
#include <cstdlib>
#include <cstring>
char str[510];
int length;
int DP[27][510];
int dp(int from, int to);

int main(){
	
	while(scanf("%s",str)==1){
		memset(DP,-1,sizeof(DP));
		length = strlen(str);
		printf("%d\n",dp(0,0));
	}
	return 0;
}

int dp(int from, int to){
	if(from >= length) return 1;
	if(DP[from][to] != -1) return 0;
	int i,j;
	char a[3];
	for(i = from, j = 0; i < to; i++,j++){
		a[j] = str[i];
	}
	a[j] = 0;	
	printf("%d %s\n",from,a);
	if(atoi(a) <= 26){
		return DP[from][to] =   dp(to, to + 1) + dp(to, to + 2);
	}
	else
		return DP[from][to] =  0;
}