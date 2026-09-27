class Solution {

    class Result {
        String str;
        int index;

        Result(String str, int index) {
            this.str = str;
            this.index = index;
        }
    }

    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder();

        Result r = reverse(s, sb, 0);

        return r.str;
    }

    public Result reverse(String s, StringBuilder sb, int i) {

        if (i == s.length()) {
            return new Result(sb.toString(), i);
        }

        if (s.charAt(i) == '(') {

            Result r = reverse(s, new StringBuilder(), i + 1);

            sb.append(new StringBuilder(r.str).reverse());

            return reverse(s, sb, r.index);

        } else if (s.charAt(i) == ')') {

            return new Result(sb.toString(), i + 1);

        } else {

            sb.append(s.charAt(i));

            return reverse(s, sb, i + 1);
        }
    }
}