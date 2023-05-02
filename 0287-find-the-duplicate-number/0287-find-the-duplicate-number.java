class Solution {
    public int findDuplicate(int[] nums) {
        int lo = 0;
        int hi = nums.length-1;
        int dup =  -1;
        
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            int count = 0;
            
            for (int num : nums) {
                if(num <= mid)
                    count++;
            }
            
            if (count > mid) {
                dup = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        
        return dup;
    }
}