class Solution {
    class Pair{
        int sum;
        int close;
        public Pair(int sum, int close){
            this.sum = sum;
            this.close = close;
        }
        
        public String toString(){
            return "sum "+ sum + "target "+ close;
        }
    }
    
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);//logn
        PriorityQueue<Pair> queue = new PriorityQueue<>((a,b)->(a.close-b.close));
        
        if(nums.length == 3){
            return  nums[0]+nums[1]+nums[2];
        }
        
        for(int pivot = 0; pivot < nums.length-2;pivot++){
            int left = pivot+1;
            int right = nums.length-1;
            while(left < right){
                int sum = nums[pivot]+nums[left]+nums[right];
                if(target == sum){
                    return target;
                }else if(sum < target){
                    left++;
                    
                    queue.offer(new Pair(sum,(target - sum)));
                }else{
                    right--;
                    queue.offer(new Pair(sum,(sum - target)));
                }

            }
            
        }
        return queue.poll().sum;
    }
}