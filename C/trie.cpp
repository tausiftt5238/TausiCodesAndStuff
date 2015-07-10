#include <cstdio>
#include <cstring>
struct trie{
	trie* node[27];
	bool endMark;
	trie(){
		memset(node,0,sizeof(node));
		endMark = false;
	}
}*root;
void insert(char *str,int len){
	int i;
	trie *cur = root;
	for(i = 0 ; i < len ; i++){
		int ch = str[i] - 'a';
		if(cur->next[ch] == 0){
			cur->next[ch] = new trie();
		}
		cur = cur->next[ch];
	}
	cur->endMark = true;
}
bool search(char *str, int len){
	int i;
	trie *cur = root;
	for(i = 0 ; i < len ; i++){
		char ch = str[i] - 'a';
		if(cur->node[ch] == 0) return false;
		cur = cur->node[ch];
	}
	return cur->endMark;
}
void del(node *cur)
{        
      for(int i=0;i<26;i++)
             if(cur->next[i])
                  del(cur->next[i]) ;
          delete(cur) ;
}
int main(){
	
}