#include <cstdio>
#include <cstring>

int letters[28]; // here space will be 26th index and fullstop will be 27th.

struct data
{
	char ch;
	int frequency;
}letter[28];
struct node
{
	char ch;
	int freq;
	node *left;
	node *right;
}*n[28];
void sort(){
	int i,j;
	for(i = 0 ; i < 28  ; i++){
		for(j = 0 ; j < 27 ; j ++){
			if(letter[j].frequency > letter[j+1].frequency){
				data temp = letter[j];
				letter[j] = letter[j+1];
				letter[j+1] = temp;
			}
		}
	}
}
void manualCount(){
	char a[] = "eerie eyes seen near lake.";
	for(int i = 0; i < 26; i++){
		if(a[i] >= 'a' && a[i] <= 'z')
			letters[a[i] - 'a']++;
		else if(a[i] == ' ')
			letters[26]++;
		else if(a[i] == '.')
			letters[27]++;
	}
	for(int i = 0; i < 28;i++){
		letter[i].frequency = letters[i];
		if(i == 26) letter[i].ch = ' ';
		else if(i == 27) letter[i].ch = '.';
		else
			letter[i].ch = i + 'a';
	}
}
void letterCount()
{
	char ch;
	memset(letters,0,sizeof(letters));
	while(scanf("%c",&ch)!=EOF){
		if(ch >= 'a' && ch <= 'z')
			letters[ch - 'a']++;
		else if(ch == ' ')
			letters[26]++;
		else if(ch == '.')
			letters[27]++;
	}
	for(int i = 0; i < 28;i++){
		letter[i].frequency = letters[i];
		if(i == 26) letter[i].ch = ' ';
		else if(i == 27) letter[i].ch = '.';
		else
			letter[i].ch = i + 'a';
	}
}


void huffman()
{
	int count = 0;
	for(int i = 0; i < 28 ; i++){
		if(letter[i].frequency){
			n[count] = new node;
			n[count]->ch = letter[i].ch;
			n[count]->freq = letter[i].frequency;
			n[count]->left = NULL;
			n[count]->right = NULL;
			count++;
		}
	}
	/*for(int i = 0 ; i < 28; i++){
		printf("%c %d\n",n[i]->ch,n[i]->freq);
	}*/
	node *now;
	int lastPosition = count;
	for(int i = 0 ; i < count-1; i++){
		now = new node;
		now->ch = NULL;
		now->freq = n[0]->freq + n[1]->freq;
		now->left = n[0];
		now->right = n[1];
		for(int j = 0 ; j < lastPosition-2; j++){
			n[j] = n[j+2];
			n[j+1] = n[j+3];
		}
		n[lastPosition-2] = now;
		lastPosition--;
		for(int l = 0 ; l < lastPosition; l++){
			for(int k = 0 ; k < lastPosition-1; k++){
				if(n[k]->freq > n[k+1]->freq){
					node *temp = n[k];
					n[k] = n[k+1];
					n[k+1] = temp;
				}
			}
		}
	}
}
char CodeArray[28][100];
//node *temp = n[0];
char code[100];
void traversal(node *t){
	if(t == NULL){
		return;
	}
	strcat(code,"0");
	//puts(code);
	traversal(t->left);
	code[strlen(code)-1] = 0;
	if(t->ch >= 'a' && t->ch <= 'z')
		strcat(CodeArray[t->ch - 'a'],code);
	else if(t->ch == ' ')
		strcat(CodeArray[26],code);
	else if(t->ch = '.')
		strcat(CodeArray[27],code);
	strcat(code,"1");
	traversal(t->right);
	code[strlen(code)-1] = 0;
	/*if(t->ch >= 'a' && t->ch <= 'z')
		strcat(CodeArray[t->ch - 'a'],code);*/
}

int main()
{
	letterCount();
	sort();
	huffman();
	for(int i = 0 ; i < 28; i++){
		printf("%c %d\n",letter[i].ch,letter[i].frequency);
	}
	traversal(n[0]);
	for(int i = 0;i < 26;i++){
		printf("%c %s\n",i+'a',CodeArray[i]);
	}
	printf("  %s\n",CodeArray[26]);
	FILE *fp;
	char ch;
	fp = fopen("source.txt","r");
	FILE *fp1;
	fp1 = fopen("out.txt","w");
	while(fscanf(fp,"%c",&ch)!=EOF){
		if(ch == ' '){
			fprintf(fp1,"%s",CodeArray[26]);
		}
		else
			fprintf(fp1,"%s",CodeArray[ch - 'a']);
	}
	fclose(fp);
	fclose(fp1);
	return 0;
}
