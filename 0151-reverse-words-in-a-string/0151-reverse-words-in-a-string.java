class Solution {
    public String reverseWords(String s) {
        String[] st = s.trim().split("\\s+"); 
        StringBuilder str = new StringBuilder(); 
        for (int i = st.length - 1; i >= 0; i--) { 
            str.append(st[i]); 
            if (i != 0) {
                 str.append(" "); 
            }
        } return str.toString();
    }
}