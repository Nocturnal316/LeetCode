class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] pref = nums.clone();
        
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int ans = 0;
        
        for(int i = 1; i<pref.length;i++){
           pref[i] += pref[i-1];
        }
    
        for(int i = 0; i<pref.length;i++){
            //we have seen the compliment already
            //which means we found the segment we can remove
            // a[n]= a[compliment] + a[...n]
            // a[6]= range[0,1]+ range[2,6]
            ans+= map.getOrDefault(pref[i]-k,0); 
            
                //
            map.put(pref[i],map.getOrDefault(pref[i],0)+1);
        }
        
        return ans;
        
    }
}