class Solution {
    public  final int[] allowedPrime = {2, 3, 5};
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> ansHeap = new PriorityQueue<>();
        HashSet<Long> usedNums = new HashSet<>();
        ansHeap.offer(1L);
        usedNums.add(1L);
        for (int i = 0; i < n - 1; i++) {
            Long res = ansHeap.poll();
            for (int multiplier : allowedPrime) {
                if (!usedNums.contains(res * multiplier)) {
                    ansHeap.offer(res * multiplier);
                    usedNums.add(res * multiplier);
                }
            }
        }
        return ansHeap.poll().intValue();
        
    }
}