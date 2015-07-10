#include <cstdio>
#include <cstring>
#include <cstdlib>
#include <queue>
using namespace std;
int bug,n;
queue <int> Q;
int result;
struct p{
	int fee;
	int fun;
}party[102];
int DP[502][102];
int DP_2[502][102];
int maxBug;
int dp(int fee,int i){
	if(i == n) return 0;
	if(DP[fee][i] != -1) return DP[fee][i];
	int temp1,temp2;
	temp1 = temp2 = 0;
	
	if(fee + party[i].fee <= bug){
		temp1 = party[i].fun + dp(fee + party[i].fee, i + 1);
	}
	temp2 = dp(fee,i+1);
	if(temp1 > temp2){
		Q.push(i);
		DP[fee][i] = temp1;
	}
	else{
		DP[fee][i] = temp2;
		Q.push(i);
	} 
	return DP[fee][i];
}
int dp_2(int fun,int i){
	if(fun == result) return 0;
	if(i == n){
		
		return 9999999;
	}
	
	if(DP[fun][i] != -1) return DP[fun][i];
	int temp1,temp2;
	temp1 = temp2 = 9999999;
	if(fun + party[i].fun <= result){

		temp1 = party[i].fee + dp_2(fun + party[i].fun, i + 1);
	}
	temp2 = dp_2(fun,i+1);
	if(temp1 < temp2){
		DP[fun][i] = temp1;
		//maxBug += fun + party[i].fun;
	}
	else{
		DP[fun][i] = temp2;
		//maxBug += fun;
	} 
	return DP[fun][i];
}
int main(){
	//fropen("input.txt","r",stdin);
	while(scanf("%d%d",&bug,&n) == 2){
		if( bug == 0 && n == 0) break;
		int i;
		memset(DP,-1,sizeof(DP));
		maxBug = 0;
		for(i = 0; i < n; i ++){
			scanf("%d%d",&party[i].fee,&party[i].fun);
		}
		result = dp(0,0);
		memset(DP,-1,sizeof(DP));
		maxBug = dp_2(0,0);
		printf("%d %d\n",maxBug,result);
	}
	return 0;
}
