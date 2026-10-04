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
        Stack<Integer> s=new Stack();
        Stack<Integer> s2=new Stack();
        ListNode dummy=new ListNode(0);
        ListNode prev=dummy;

        while(l1!=null){
            s.push(l1.val);
            l1=l1.next;
        }
        while(l2!=null){
            s2.push(l2.val);
            l2=l2.next;
        }int carry=0;
        while (!s.isEmpty() || !s2.isEmpty() || carry != 0){
            int val1 = s.isEmpty() ? 0 : s.pop();
            int val2 = s2.isEmpty() ? 0 : s2.pop();
            int val=val1+val2+carry;
            
             int sum = val % 10;
            carry = val / 10;

            ListNode node = new ListNode(sum);
                node.next = dummy.next;
                dummy.next = node;
        }return dummy.next;

    }
}