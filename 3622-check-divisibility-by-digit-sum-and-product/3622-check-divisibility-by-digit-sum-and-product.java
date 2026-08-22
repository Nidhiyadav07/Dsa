class Solution {
    public boolean checkDivisibility(int n) {
        int original = n;
        int sum = 0;
        int prod = 1;

        while (n > 0) {
            int r = n % 10;
            sum += r;
            prod *= r;
            n /= 10;
        }

        return original % (sum + prod) == 0;
    }
}