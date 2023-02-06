class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int a:  nums){
            if(set.contains(a)) return true;
            set.add(a);
        }
        return false;
    }
}