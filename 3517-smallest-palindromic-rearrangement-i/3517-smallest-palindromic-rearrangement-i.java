class Solution {
    public String smallestPalindrome(String s) {

        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        StringBuilder left = new StringBuilder();
        String middle = "";

        for (int i = 0; i < 26; i++) {

            int half = freq[i] / 2;

            while (half-- > 0) {
                left.append((char)(i + 'a'));
            }

            if (freq[i] % 2 == 1) {
                middle = String.valueOf((char)(i + 'a'));
            }
        }

        String right = new StringBuilder(left).reverse().toString();

        return left.toString() + middle + right;
    }
}