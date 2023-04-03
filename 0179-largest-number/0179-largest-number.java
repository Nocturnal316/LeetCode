class Solution {
    class CustomComparator implements Comparator<String> {
    @Override
    public int compare(String a, String b) {
        String t1 = a+b;
        String t2 = b+a;
        return t2.compareTo(t1);
    }}

    public String largestNumber(int[] nums) {
        ArrayList<String> sortedList = new ArrayList<>();
        
        for(int num:nums){
            sortedList.add(String.valueOf(num));
        }
        Collections.sort(sortedList, new CustomComparator());
        String a = sortedList.get(0);
        
        //Lead zero means everything else is zero
        if(a.equals("0")) return "0";
        
        StringBuilder sb = new StringBuilder();
        for(String s : sortedList){
            sb.append(s);
        }
        return sb.toString();
    }
    
//       public String largestNumber(int[] nums) {

//         String[] sortedList = new String[nums.length];
        
//         for(int i = 0; i < nums.length;i++){
//             sortedList[i] = String.valueOf(nums[i]);
//         }
//         Arrays.sort(sortedList, new CustomComparator());
    
//         String a = sortedList[0];
//         if(a.equals("0")) return "0";
        
//         StringBuilder sb = new StringBuilder(); 
//         for(String s : sortedList){
//             sb.append(s);
//         }
        
//         return sb.toString();
//     }
}