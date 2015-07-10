#include <cstdio>
#include <cstdlib>
#include <cstring>
#include <map>
using namespace std;
long long dp(int N1);
map <int,long long> DP;
int main(){
	int N;
	while(scanf("%d",&N)==1){
	//memset(DP,-1,sizeof(DP));
		printf("%lld\n",dp(N));
	}
	return 0;
}
long long dp(int N){
	if(DP[N] != 0) return DP[N];
	if(!N) return N;
	long long temp1 = dp(N/2) + dp(N/3) + dp(N/4);
	return DP[N] = N > temp1 ? N : temp1;
}