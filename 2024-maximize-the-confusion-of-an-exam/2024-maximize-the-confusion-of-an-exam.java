class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(
            solve(answerKey, k, 'T'),
            solve(answerKey, k, 'F')
        );
    }

    private int solve(String s, int k, char target) {
        int left = 0;
        int changes = 0;
        int ans = 0;

        for (int right = 0; right < s.length(); right++) {

            // If current character is not target,
            // we need to change it.
            if (s.charAt(right) != target) {
                changes++;
            }

            // Too many changes -> shrink window
            while (changes > k) {
                if (s.charAt(left) != target) {
                    changes--;
                }
                left++;
            }

            // Current window is valid
            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}