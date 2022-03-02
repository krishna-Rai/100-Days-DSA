class Solution{
    static int dp[][];
    static int subsetSum(int N,int arr[],int sum){
        if(sum==0){
            return 1;
        }
        if(N==0){
            return 0;
        }
        if(dp[N][sum]!=-1){
            return dp[N][sum];
        }
        if(arr[N-1]<=sum)
            return dp[N][sum] =  (subsetSum(N-1,arr,sum-arr[N-1]) + subsetSum(N-1,arr,sum));
        else
            return dp[N][sum] = subsetSum(N-1,arr,sum);
    }
    static Boolean isSubsetSum(int N, int arr[], int sum){
        dp = new int[N+1][sum+1];
        for(int r[]:dp){
            Arrays.fill(r,-1);
        }
        return subsetSum(N,arr,sum)==0?false:true;
    }
}
