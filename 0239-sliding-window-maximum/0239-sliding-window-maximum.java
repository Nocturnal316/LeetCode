class Solution {
    /***
    use deq store
    */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        if(n*k == 0 ) return new int[0];
        
        int ansPos = 0;
    
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
        
            while(!deque.isEmpty() && nums[i] > nums[deque.getLast()] ){
                deque.pollLast();
            }
            
            if(!deque.isEmpty() && deque.getFirst() == i-k){
                deque.pollFirst();
            }
            
            deque.addLast(i);
            
            if(i >= k-1){
                ans[ansPos] = nums[deque.peekFirst()];
                ansPos++;
            }
    
        }
        return ans;
    }
}