class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int ans[] = new int[nums.length-k+1];
        int p=0;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        int i=0,j=0;
        while(j<nums.length){
            while(!queue.isEmpty() && queue.peekLast()<nums[j]){
                queue.pollLast();
            }
            queue.add(nums[j]);
            if(j-i+1 < k)j++;
            else
                if(j-i+1 == k){
                    ans[p++]=queue.peek();
                    if(queue.peek()==nums[i]){
                        queue.poll();
                    }
                    i++;j++;
                }
        }
        return ans;
        
    }
}
