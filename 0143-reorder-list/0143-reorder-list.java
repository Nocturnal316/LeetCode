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
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode mid = head;
        ListNode prev = head;
        
        while(fast!=null && fast.next != null){
            prev = mid;
            fast = fast.next.next;
            mid = mid.next;
        }
        
        prev.next = null;
        prev = null;
        ListNode next;
        while(mid != null ){
            next = mid.next;
            mid.next = prev;
            prev = mid;
            mid = next;
        }
        
        ListNode l1 = head;
        ListNode l2 = prev;
        
        while(l1!= null & l2 !=null){
            ListNode temp = l1.next;
            ListNode temp2 = l2.next;
            l1.next = l2;
            l2 = temp2;
            l1 = l1.next;
            l1.next = temp;
            if(l1.next == null){
                l1.next = l2;
                break;
            }
            l1 = l1.next;
        
            
        }
 
    }
}