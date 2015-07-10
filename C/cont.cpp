#include <cstdio>
#include <cstring>
#include <cstdlib>
#include <cmath>
int binSearch(int vessel[],int n,int m);
bool verify(int vessel[], int mid,int n,int m);
int summation;
int max;
int main(){
	int test;
	int n,m;
	int vessel[1002];
 	scanf("%d",&test);
	for(int cases = 1 ; cases <= test ; cases++){
        summation = 0;
		max = 0;
		scanf("%d%d",&n,&m);
		for(int i = 0 ; i < n ; i++){
			scanf("%d",&vessel[i]);
			summation += vessel[i];
			if(max < vessel[i]) max = vessel[i];
		}
		int ans = binSearch(vessel,n,m);
		printf("Case %d: %d\n",cases,ans);
	}
}
bool verify(int vessel[], int mid,int n,int m){
	int i;
	int sum = 0;
	int part = 1;
	for(i = 0 ; i < n; i++){
        sum += vessel[i];
		if(sum > mid){
			sum = vessel[i];
			part++;
		}
		//printf("mid = %d part = %d\n",mid,part);
	}
	return part <= m;
}

int binSearch(int vessel[],int n,int m){
	int lo = max;
	int hi = summation;
	int mid;
	while(lo < hi){
		mid = (hi + lo) >> 1;
		bool test = verify(vessel,mid,n,m);
		if(test){
			hi = mid;
		}
		else lo = mid + 1;
	}
	return hi;
}
