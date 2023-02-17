class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int x = 0;
        Arrays.sort(nums);
        HashSet<List<Integer>> set = new HashSet<>();
        
        while(x < nums.length-2){
            int y = x+1;
            int z = nums.length-1;
            while(y < z){
                int sum = nums[x]+nums[y]+nums[z];
                if(sum < 0){
                    y++;
                }else if( sum > 0){
                    z--;
                }else{
                    set.add(Arrays.asList(nums[x],nums[y],nums[z]));
                    y++;
                    z--;
                }
            }
            x++;
        }
        
         List<List<Integer>> resList = new ArrayList();
        
         for (List<Integer> r : set){
            resList.add(r);
        }
         return resList;
    }
}