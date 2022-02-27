class Solution {
    public List<List<Integer>> solve(int nums[],int start,int end,List<List<Integer>> ans,List<Integer> op){
        if(start>end){
            ans.add(new ArrayList<Integer>(op));
            return ans;
        }
        op.add(nums[start]);
        solve(nums,start+1,end,ans,op);
        op.remove(op.size()-1);
        solve(nums,start+1,end,ans,op);
        return ans;
    }
    public List<List<Integer>> subsets(int[] nums) {
        return solve(nums,0,nums.length-1,new ArrayList<List<Integer>>(),new ArrayList<>());
    }
}
