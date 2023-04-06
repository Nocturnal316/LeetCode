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
        
        
        ListNode mergedHead = head;
        ListNode midPoint = head;
        ListNode endPoint = head;
        
        while(endPoint != null && endPoint.next != null){
            midPoint = midPoint.next;
            endPoint = endPoint.next.next;
        }
        
        ListNode prev = null;
        ListNode cur = midPoint.next;
        midPoint.next = null;
        
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        
        while(prev != null){
            ListNode temp = mergedHead.next;
            ListNode temp2 =  prev.next;
            mergedHead.next = prev;
            mergedHead.next.next = temp;
            mergedHead = mergedHead.next.next;
            prev = temp2;
            
        }
        
    
    }
}