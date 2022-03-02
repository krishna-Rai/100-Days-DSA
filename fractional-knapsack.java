class Solution 
{ 
    static int dp[][];
    //Function to return max value that can be put in knapsack of capacity W.
    static int findMax(int W,int wt[],int val[],int n){
        if(W==0 || n==0){
            return 0;
        }
        if(dp[W][n]!=-1)
            return dp[W][n];
        if(wt[n-1]<=W){
            return dp[W][n]= Math.max(val[n-1]+findMax(W-wt[n-1],wt,val,n-1),findMax(W,wt,val,n-1));
        }else{
            return dp[W][n] = findMax(W,wt,val,n-1);
        }
    }
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here
         dp = new int[W+1][n+1];
         for(int row[]:dp)
            Arrays.fill(row,-1);
         return findMax(W,wt,val,n);
    } 
