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
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode front = head;
        
        while(head != null){
            stack.push(head.val);
            head = head.next;
        }
        
        while(front != null){
            if(stack.peek() == front.val){
                stack.pop();
            }
            front = front.next;
        }
        
        return stack.isEmpty();
    }
}