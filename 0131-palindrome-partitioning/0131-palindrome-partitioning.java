class Solution {
   List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(s,new ArrayList<>(),0);
        return res;
        
    }
    
    
    
       public  void dfs(String s, List<String> curPartition ,int start){
        if(start >= s.length()){
            res.add(new ArrayList<String>(curPartition));
            return;
        }
        
        for(int end = start; end < s.length(); end++){
            if(isPali(s.substring(start,end+1))){
                curPartition.add(s.substring(start,end+1));
                dfs(s,curPartition,end+1);
                curPartition.remove(curPartition.size()-1);
            }
        }
    }
    
    
     public static boolean isPali(String s){
        if(s.length() < 2 ) return true;
        
        int lo  = 0;
        int hi = s.length()-1;
        
        while(lo < hi){
            if(s.charAt(lo) != s.charAt(hi)) return false;
            lo++;
            hi--;
               
        }
        return true;
    }
}