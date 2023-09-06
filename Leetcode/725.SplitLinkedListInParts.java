/**
 *  Given the head of a singly linked list and an integer k, split the linked list into k consecutive linked list parts.
 * The length of each part should be as equal as possible: no two parts should have a size differing by more than one. 
 * This may lead to some parts being null.
 * The parts should be in the order of occurrence in the input list, 
 * and parts occurring earlier should always have a size greater than or equal to parts occurring later.
 * Return an array of the k parts.
 * Companies - Uber | Apple | Amazon
*/

class Solution {
    private int findSize(ListNode head) {
        int count = 0;
        while(head != null) {
            count++;
            head = head.next;
        }

        return count;
    }
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode temp = head;
        ListNode[] res = new ListNode[k];
        int size = findSize(temp);
        int eleInEachPart = size/k;
        int extra = size % k;
        temp = head;
        ListNode prev = temp;
        for(int i = 0; i < k && temp != null; i++, extra--) {
            res[i] = temp;

            for(int j = 0; j < eleInEachPart + (extra > 0 ? 1 : 0); j++) {
                prev = temp;
                temp = temp.next;
            }

            if(prev != null)
                prev.next = null;
        }

        return res;
        
    }
}