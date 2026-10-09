/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/import java.util.*;

class Solution {
    public Node flatten(Node head) {

        if (head == null) {
            return head;
        }

        Stack<Node> s = new Stack<>();
        Node curr = head;

        while (curr != null) {

            // If child exists
            if (curr.child != null) {

                // Save next node
                if (curr.next != null) {
                    s.push(curr.next);
                }

                // Connect current node to child
                curr.next = curr.child;
                curr.child.prev = curr;

                // Remove child pointer
                curr.child = null;
            }

            // If current list ends, take saved node
            if (curr.next == null && !s.isEmpty()) {

                Node next = s.pop();

                curr.next = next;
                next.prev = curr;
            }

            curr = curr.next;
        }

        return head;
    }
}