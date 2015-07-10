#include <cstdio>
#include <cstring>

int main(){
	int r,c;
	scanf("%d%d",&r,&c);
	int i,j;
	char cake[20][20];
	for(i = 0; i < r ; i ++){
		getchar();
		for( j = 0 ; j < c ; j ++){
			scanf("%c",&cake[i][j]);
			if(cake[i][j] == 'S'){
				cake[i][c] = 'N';
				cake[r][j] = 'N';
			}
		}
	}
	int sum = 0;
	for(i = 0; i < r; i ++){
		if(cake[i][c] == 'N') continue;
		for( j = 0 ; j < c; j++){
			if(cake[i][j] == '.'){
				sum++;
				cake[i][j] = ',';
			}
		}
	}
	for(j = 0 ; j < c ; j++){
		if(cake[r][j] == 'N') continue;
		for(i = 0; i < r; i ++){
			if(cake[i][j] == '.'){
				sum++;
				cake[i][j] = ',';
			}
		}
	}
	printf("%d\n",sum);
	return 0;
	
}