class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode before = dummy;

        for (int i = 1; i < left; i++) {
            before = before.next;
        }

     
        ListNode prev = null;
        ListNode curr = before.next;
        ListNode next;

        for (int i = 0; i <= right - left; i++) {
             next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;
        }

        
        ListNode leftNode = before.next;

        before.next = prev;
        leftNode.next = curr;

        return dummy.next;
    }
}