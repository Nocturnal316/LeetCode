class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String,List> map = new HashMap<>();
        
        for(String string : strs){
            char[] temp = string.toCharArray();
            Arrays.sort(temp);
            String sortedWord =  String.valueOf(temp);
            if(!map.containsKey(sortedWord)){
                map.put(sortedWord,new ArrayList());
            }
            map.get(sortedWord).add(string);
        }
        
        
        
        return new ArrayList(map.values());
        
    }
}