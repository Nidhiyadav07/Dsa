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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] arr=new int[2];
        
        int count=count(head,0);
        if(count<3){
            return new int[]{-1, -1};
        }
        
        ListNode prev=head;
        ListNode curr=head.next;
        ListNode fut=head.next.next;
        int first = -1;
        int last = -1;
        int min = Integer.MAX_VALUE;
        int c=1;

        while (fut != null) {

            if ((prev.val < curr.val && curr.val > fut.val) ||
                (prev.val > curr.val && curr.val < fut.val)) {

                if (first == -1) {
                    first = c;
                } else {
                    min = Math.min(min, c - last);
                }

                last = c;
            }

            prev = curr;
            curr = fut;
            fut = fut.next;

            c++;
        }
         if (first == last) {
            return new int[]{-1, -1};
        }

        int max = last - first;

        arr[0] = min;
        arr[1] = max;

        return arr;
    }
    
   public int count(ListNode p, int count) {
    if (p == null) {
        return count;
    }

    return count(p.next, count + 1);
}
}