class Solution {
    public List<List<Integer>>  res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates,target,0,new ArrayList<>(),0);
        return res;
    }
    
    public void dfs(int[] candidates, int target,int curSum,List<Integer> combo, int curPos ){
        if(curSum == target){
            res.add(new ArrayList<>(combo));
            return;
        }
        
        for(int i = curPos; i < candidates.length;i++){
            int num = candidates[i];
            if(curSum + num  <= target){
                combo.add(num);
                dfs(candidates,target,curSum+num,combo,i);
                combo.remove(combo.size()-1);
            }
            
        }
    }
}