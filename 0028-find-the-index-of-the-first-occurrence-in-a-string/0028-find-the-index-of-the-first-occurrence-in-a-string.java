class Solution {
    public int strStr(String haystack, String needle) {
        int j=0;
        StringBuilder ans=new StringBuilder();
        if (needle.length() > haystack.length()) {
            return -1;
        }
        for(int i=0;i<needle.length();i++){
             char ch=haystack.charAt(i);
             ans.append(ch);
        }
        if(ans.toString().equals(needle)){
            return 0;
        }
        for (int i = needle.length(); i < haystack.length(); i++) {
            char ch = haystack.charAt(i);
            ans.deleteCharAt(0);
            j++;
            ans.append(ch);
            
            if (ans.toString().equals(needle)) {
                return j;
            }
        }return -1;
    }
}