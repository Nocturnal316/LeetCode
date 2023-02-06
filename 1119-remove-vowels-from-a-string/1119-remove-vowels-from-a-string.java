class Solution {
    public String removeVowels(String s) {
       HashSet<Character> vowels = new HashSet<>();
       vowels.add('a');
       vowels.add('e');
       vowels.add('i');
       vowels.add('o');
       vowels.add('u');

        StringBuilder sb  = new StringBuilder();

        for(char c : s.toCharArray()){
            if(!vowels.contains(c)){
                sb.append(c);
            }
        }

        return sb.toString();
    }
}