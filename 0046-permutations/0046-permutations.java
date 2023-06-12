class Solution {
    public List<List<Integer>> ans = new ArrayList<>();
    public HashSet<Integer> set = new HashSet<>();
    public List<List<Integer>> permute(int[] nums) {
        dfs(nums, new ArrayList<>());
        return ans;
        
    }
    
    public void dfs(int[] nums, List<Integer> curPerm){
        if(curPerm.size() >= nums.length){
            ans.add(new ArrayList<>(curPerm));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])) continue;
            curPerm.add(nums[i]);
            set.add(nums[i]);
            dfs(nums,curPerm);
            set.remove(nums[i]);
            curPerm.remove(curPerm.size()-1);
         
        }
      
        

    }
}