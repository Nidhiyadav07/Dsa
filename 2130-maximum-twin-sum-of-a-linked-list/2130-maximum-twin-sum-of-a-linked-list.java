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
    public int pairSum(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode prev=null;
        ListNode curr=slow;
        ListNode next;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;        
        }
        ListNode first = head;
        ListNode second = prev;

        int max = 0;

        while (second != null) {

            int sum = first.val + second.val;

            max = Math.max(max, sum);

            first = first.next;
            second = second.next;
        }

        return max;
    }
}