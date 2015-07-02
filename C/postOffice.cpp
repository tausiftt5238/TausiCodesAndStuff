#include <cstdio>
#include <cstring>
#include <cmath>
#include <cstdlib>
int V,P;
int midValue;
int village[302];
int keep[302][302];
int binSearch();
void keepMake();
int verify(int estimate);
int main(){
	scanf("%d%d",&V,&P);
	int i;
	for(i = 0 ; i < V ; i++){
		scanf("%d",&village[i]);
		//midValue += village[i];
	}
	//midValue /= V;
	keepMake();
	int mid = binSearch();
	int sum = 0;
	int ans = 0;
	int prev = 0;;
	for(i = 0 ; i < V ; i++){
		sum += village[i];
		if(sum >= mid){
			i--;
			ans += keep[prev][i] + keep[i][V-1];
			sum = 0;
		}
	}
	printf("%d\n",ans);
	return 0;
}
int verify(int e){
	int pos = 0;
	int i,j;
	int sum = 0;
	for(i = 0 ; i < V ; i++){
		sum += village[i];
		if(sum >= e){
			i--;
			sum = 0;
			pos++;
		}
	}
	if(pos < P) return 0;
	if(pos == P) return 1;
	if(pos > P) return 2;
}
int binSearch(){
	int lo = 0;
	int hi = 1000;
	int mid;
	while(lo < hi){
		mid = (hi + lo)/2;
		int temp = verify(mid);
		if(temp == 0){
			hi = mid;
		}
		else if(temp == 1){
			return mid;
		}
		else{
			lo = mid;
		}
	}
	return mid;
}
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