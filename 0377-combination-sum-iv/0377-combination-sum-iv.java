class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[nums.length+1];
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int total = 1; total <= target; total++){
            map.put(total,0);
            for(int num : nums){
                map.put(total,map.get(total)+map.getOrDefault(total-num,0));
            }
        }
        
        return map.get(target);
    }
}