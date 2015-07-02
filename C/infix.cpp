#include <cstdio>
#include <cstring>
#include <cstdlib>
#define MAX 100
struct stack
{
    char a[MAX][100];
    int tos;
    stack()
    {
        tos = -1;
    }
    void push(char x[])
    {
        if(tos == MAX-1)
        {
            printf("Stack overflow\n");
            return;
        }
        tos++;
        strcpy(a[tos],x);
        //a[++tos] = x;
    }
    char* pop()
    {
        if(tos < 0)
        {
            printf("Stack underflow\n");
            return 0;
        }
        return a[tos--];
    }
    char* top()
    {
        if(tos < 0 && tos >= MAX)
            return 0;
        return a[tos];
    }
    int isempty()
    {
        if(tos < 0)
            return 1;
        else return 0;
    }
    int isfull()
    {
        if(tos >= MAX)
            return 1;
        else return 0;
    }
    void display_stack()
    {
        for(int i = 0 ; i <= tos;i++)
            printf("%s ",a[i]);
        printf("\n");
    }
};

int main()
{
    stack P,Q,S,R;
    int i,j,k;
    char input[100];
    gets(input);
    char split[100][100];
    char temp[100];
    int length = strlen(input);
    for(i=0,j = 0,k=0;i<=length;i++)
    {
        if(input[i] == 0)
        {
            temp[j] = 0;
            j = 0;
            strcpy(split[k++],temp);
        }
        if(input[i]!= ' ')
        {
            temp[j++] = input[i];
        }
        else if(input[i] == ' ')
        {
            temp[j] = 0;
            j = 0;
            strcpy(split[k++],temp);
        }
    }
    for(i=0;i<k;i++)
    {
        if(split[i][0]>='0' && split[i][0] <= '9')
            P.push(split[i]);
        else if(split[i][0] == '+' ||split[i][0] == '-' ||split[i][0] == '*' ||split[i][0] == '/')
        {
            while(split[i][0] == '+' || split[i][0] == '-')
            {
                if(!strcmp(S.top(),"*")||!strcmp(S.top(),"/")|| !strcmp(S.top(),"+") || !strcmp(S.top(),"-"))
                {
                    P.push(S.pop());
                }
                else
                {
                    S.push(split[i]);
                    break;
                }
            }
            while(split[i][0] == '*')
            {
                if(!strcmp(S.top(),"/"))
                {
                    P.push(S.pop());
                }
                else
                {
                    S.push(split[i]);
                    break;
                }
            }
			if(split[i][0] == '/')
				S.push(split[i]);
        }
        else if(split[i][0] == '(')
        {
            S.push("(");
        }
        else if(split[i][0] == ')')
        {
            while(strcmp(S.top(),"("))
            {
                P.push(S.pop());
            }
            S.pop();
        }
    }
    while(!S.isempty())
        P.push(S.pop());
    P.display_stack();
	while(!P.isempty())
	{
		Q.push(P.pop());
	}
	while(!Q.isempty())
	{
		char temp[10];
		strcpy(temp,Q.top());
		if(temp[0] >= '0' && temp[0] <= '9')
		{
			Q.pop();
			R.push(temp);
		}
		else if(temp[0] == '+'||temp[0] == '-'||temp[0] == '*'||temp[0] == '/')
		{
			Q.pop();
			char op2[10],op1[10],result[10];
			int r;
			strcpy(op2,R.pop());
			strcpy(op1,R.pop());
			if(temp[0] == '+')
			{
				r = atoi(op1) + atoi(op2);
			}
			else if(temp[0] == '-')
			{
				r = atoi(op1) - atoi(op2);
			}
			else if(temp[0] == '*')
			{
				r = atoi(op1) * atoi(op2);
			}
			else if(temp[0] == '/')
			{
				r = atoi(op1) / atoi(op2);
			}
			sprintf(result,"%d",r);
			R.push(result);
		}
		
	}
	printf("%s",R.top());
	getchar();
	getchar();
    return 0;
}