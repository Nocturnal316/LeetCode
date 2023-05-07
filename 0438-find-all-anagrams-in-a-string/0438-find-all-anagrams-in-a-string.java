class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        char[] sortedP  = p.toCharArray();
        Arrays.sort(sortedP);
        
        int lenP = p.length();
        for(int left = 0; left <= s.length() - lenP;left++){
            String temp = s.substring(left,left+lenP);
            char[] sortedSub = temp.toCharArray();
            Arrays.sort(sortedSub);
            if(Arrays.equals(sortedP, sortedSub)) ans.add(left);
        }
        return ans;
    }
}