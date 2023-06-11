class Solution {
    
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums,0,new ArrayList<Integer>());
        return res;
    }
    
    
    public void dfs(int[] nums, int start,List<Integer> curSet){
        if(start <= nums.length){
            res.add(new ArrayList<>(curSet));
        }
        
        for(int i = start; i < nums.length; i++){
            curSet.add(nums[i]);
            dfs(nums,i+1,curSet);
            curSet.remove(curSet.size()-1);
        }
    }
}