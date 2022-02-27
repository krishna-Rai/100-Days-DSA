class Solution {
    public List<List<Integer>> solve(int nums[],int start,int end,List<Integer> op,List<List<Integer>> ans){
        if(start>end){
            ans.add(new ArrayList<Integer>(op));
            return ans;
        }
        int k=1;
        while(start<end && nums[start]==nums[start+1]){
            start++;
            k++;
        }
        for(int i=0;i<=k;i++){
            for(int j=1;j<=i;j++){
                op.add(nums[start]);
            }
            solve(nums,start+1,end,op,ans);
            for(int j=1;j<=i;j++){
                op.remove(op.size()-1);
            }
        }
        return ans;
        
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        return solve(nums,0,nums.length-1,new ArrayList<>(),new ArrayList<List<Integer>>());
    }
}
