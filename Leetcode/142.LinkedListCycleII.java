/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        boolean isCyclePresent = false;
        while(slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                isCyclePresent = true;
                break;
            }  
        }

        if(!isCyclePresent) return null;
        
        fast = head;

        while(fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}