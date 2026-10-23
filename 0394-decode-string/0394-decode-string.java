
import java.util.*;

class Solution {
    public String decodeString(String s) {
        Stack<Integer> st = new Stack<>();
        Stack<String> c = new Stack<>();

        StringBuilder curr = new StringBuilder();
        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } 
            else if (ch == '[') {
                st.push(num);
                c.push(curr.toString());

                num = 0;
                curr = new StringBuilder();
            } 
            else if (ch == ']') {
                int count = st.pop();
                StringBuilder ans = new StringBuilder(c.pop());

                for (int j = 0; j < count; j++) {
                    ans.append(curr);
                }

                curr = ans;
            } 
            else {
                curr.append(ch);
            }
        }

        return curr.toString();
    }
}
