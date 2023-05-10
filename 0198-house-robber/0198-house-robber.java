class Solution {
    HashMap<Integer,Integer> memo = new HashMap<>();
    public int rob(int[] nums) {
        return robHouse(0,nums);
    }
    
    public int robHouse(int pos, int[] nums){
        if(pos >= nums.length){
            return 0;
        }
        
        
        if(memo.containsKey(pos)) return memo.get(pos);
        
        int sum1= robHouse(pos + 1,nums);
        int sum2 = robHouse(pos + 2,nums)+nums[pos];
        int max = Math.max(sum1,sum2);
        memo.put(pos,max);
        return memo.get(pos);
    }
}