#include <cstdio>
#include <cstring>
struct trie{
	trie* node[128];
	int endMark;
	trie(){
		memset(node,0,sizeof(node));
		endMark = 0;
	}
}*root;
void insert(char *str,int len){
	int i;
	trie *cur = root;
	for(i = 0 ; i < len ; i ++){
		char ch = str[i];
		if(cur -> node[ch] == 0){
			cur->node[ch] = new trie();
		}
		cur = cur->node[ch];
	}
	cur -> endMark++;
}

int search(char *str, int len){
	int i;
	trie *cur = root;
	for(i = 0; i < len ; i++){
		char ch = str[i];
		if(cur->node[ch] == 0) return 0;
		cur = cur->node[ch];
	}
	return cur->endMark;
}
int print(){
	trie *cur;
	for(int i = 0 ; i < 128; i++){
		if(root->node[i] != 0){
			cur = 
		}
	}
}
int main(){
	int test;
	root = new trie();
	scanf("%d",&test);
	while(test--){
		char name[50];
		while(scanf("%d",name)==1){
			insert(name,strlen(name));
		}
		
	}
	return 0;
}