class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         int T[][] = new int[n+1][W+1];
         for(int i=0;i<=n;i++){
             T[i][0]=0;
         }
         for(int i=0;i<=W;i++){
             T[0][i]=0;
         }
         for(int i=1;i<=n;i++){
             for(int j=1;j<=W;j++){
                 if(wt[i-1]<=j){
                     T[i][j]=Math.max(val[i-1]+T[i-1][j-wt[i-1]],T[i-1][j]);
                 }else{
                     T[i][j]=T[i-1][j];
                 }
             }
         }
         return T[n][W];
    } 
}
