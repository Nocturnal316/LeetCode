/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode  dummy = new ListNode(0);
        ListNode ans = dummy;
        
        ListNode c1 = l1;
        ListNode c2 = l2;
        int remainder = 0;
        
        while(c1 != null || c2 !=null || remainder != 0){
            int sum = 0;
            if(c1 != null){
                sum += c1.val;
                c1 = c1.next;
            }
            
            if(c2 != null){
                sum += c2.val;
                c2 = c2.next;
            }
            
            sum+= remainder;
            remainder = sum / 10;
            int val = sum % 10;
            ListNode cur = new ListNode(val);
            ans.next = cur;
            ans = ans.next;
            
        }
        
     return dummy.next;   
    }
}