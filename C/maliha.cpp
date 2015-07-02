#include<stdio.h>
int size[2001];
int value[2001];
int s,n;
long long int dp[2001][2001];
long long int vacation(int sz,int i)
{
    if(i==n)
    {
        if(size[i]<=sz)
            return value[i];
        else
            return 0;
    }
    if(dp[sz][i]!=0)
        return dp[sz][i];
    if(size[i]<=sz)
    {
        long long temp1 =vacation(sz-size[i],i+1) + value[i];
        long long temp2 =vacation(sz,i+1);
        if(temp1 > temp2)
           dp[sz][i] = temp1;
        else
            dp[sz][i] = temp2;
        return dp[sz][i];
    }
    else
    {
        dp[sz][i]=vacation(sz,i+1);
        return dp[sz][i];
    }
}
int main()
{
    int i;
    long long int j;
    scanf("%d%d",&s,&n);
    for(i=1;i<=n;i++)
        scanf("%d%d",&size[i],&value[i]);
    j=vacation(s,1);
    printf("%lld\n",j);
    return 0;
}