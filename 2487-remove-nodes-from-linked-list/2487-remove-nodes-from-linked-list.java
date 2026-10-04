class Solution {
    public ListNode removeNodes(ListNode head) {

        Stack<Integer> s = new Stack<>();

        ListNode curr = head;

        while (curr != null) {

            while (!s.isEmpty() && s.peek() < curr.val) {
                s.pop();
            }

            s.push(curr.val);
            curr = curr.next;
        }

        ListNode result = null;

        while (!s.isEmpty()) {
            ListNode node = new ListNode(s.pop());
            node.next = result;
            result = node;
        }

        return result;
    }
}