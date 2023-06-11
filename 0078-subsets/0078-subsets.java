class Solution {
    
    public List<List<Integer>> subsets(int[] nums) {
         List<List<Integer>> res =  new ArrayList<>();
        dfs(nums,0,new ArrayList<Integer>(),res);
        return res;
    }
    
    
    public static void dfs(int[] nums, int start,List<Integer> curSet,  List<List<Integer>> res){
        res.add(new ArrayList<>(curSet));
        
        for(int i = start; i < nums.length; i++){
            curSet.add(nums[i]);
            dfs(nums,i+1,curSet,res);
            curSet.remove(curSet.size()-1);
        }
    }
}