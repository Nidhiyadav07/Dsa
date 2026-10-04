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
    public int[] nextLargerNodes(ListNode head){
        ArrayList<Integer> a=new ArrayList<Integer>();
        ListNode prev=head;
        while(prev!=null){
            a.add(prev.val);
            prev=prev.next;
        }
         int[] ans = new int[a.size()];
        Stack<Integer> s=new Stack<>();
        for(int i=a.size()-1;i>=0;i--){
            while (!s.isEmpty() && s.peek() <= a.get(i)) {
                s.pop();
            }

            if (s.isEmpty()) {
                ans[i] = 0;
            } else {
                ans[i] = s.peek();
            }

            s.push(a.get(i));
        }

        return ans;
    }
}