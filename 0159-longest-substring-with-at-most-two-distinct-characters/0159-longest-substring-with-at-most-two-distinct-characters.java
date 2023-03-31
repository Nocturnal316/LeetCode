class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        int max = 0;
        for(char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
            while(map.size()>2){
                char key = s.charAt(l);
                map.put(key,map.get(key)-1);
                if(map.get(key) <= 0){
                    map.remove(key);
                }
                l++;
            }
            max = Math.max(max,r+1-l);
            r++;
        }
        return max;
    }
}