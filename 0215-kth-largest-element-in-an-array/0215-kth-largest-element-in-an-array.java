class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>((a,b)->(b-a));
        for(int i = 0; i < nums.length;i++){
            pQueue.add(nums[i]);
        }
        
        int ans = 0;
        for(int i = 0; i < k;i++){
            ans = pQueue.poll();
        }
        
        return ans;
    }
}