class Solution {

    public int maxConsecutiveAnswers(String answerKey, int k) {

        int low = 1;
        int high = answerKey.length();
        int ans = 0;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (possible(answerKey, k, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean possible(String s, int k, int len) {

        int countT = 0;
        int countF = 0;

        // First window
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'T') {
                countT++;
            } else {
                countF++;
            }
        }

        // Can this window become all T or all F?
        if (countT <= k || countF <= k) {
            return true;
        }

        // Sliding window of fixed length
        for (int right = len; right < s.length(); right++) {

            // Add right character
            if (s.charAt(right) == 'T') {
                countT++;
            } else {
                countF++;
            }

            // Remove left character
            int left = right - len;

            if (s.charAt(left) == 'T') {
                countT--;
            } else {
                countF--;
            }

            // We can make this window all T or all F
            if (countT <= k || countF <= k) {
                return true;
            }
        }

        return false;
    }
}