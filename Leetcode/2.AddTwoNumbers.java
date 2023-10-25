
class Solution {
    private ListNode solve(ListNode l1, ListNode l2, int carry) {
        if(l1 == null && l2 == null && carry == 0) return null;
        int total = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
        return new ListNode(total%10, solve(l1 != null ? l1.next : l1, l2 != null ? l2.next : l2, total/10));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return solve(l1, l2, 0);
    }
}