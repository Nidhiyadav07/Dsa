class Solution {
    public int longestPalindrome(String s) {
        int[] freq = new int[52];

    for (char ch : s.toCharArray()) {
        if (ch >= 'a' && ch <= 'z') {
            freq[ch - 'a']++;
        } else {
            freq[ch - 'A' + 26]++;
        }
    }
        int length=0;
        boolean odd=false;
        for(int i=0;i<52;i++){
            length+=(freq[i]/2)*2;
            if(freq[i]%2==1){
                odd=true;
            }
        }
        if(odd){
            length++;
        }return length;
    }
}