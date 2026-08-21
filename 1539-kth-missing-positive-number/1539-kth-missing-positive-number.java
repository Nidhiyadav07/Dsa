class Solution {
    public int findKthPositive(int[] arr, int k) {
        return solve(arr, k, 0, arr.length - 1);
    }

    public int solve(int[] arr, int k, int low, int high) {

        if (low > high) {
            return low + k;
        }

        int mid = low + (high - low) / 2;

       
        int missing = arr[mid] - mid - 1;

        if (missing < k) {
            return solve(arr, k, mid + 1, high);
        } 
        else {
            return solve(arr, k, low, mid - 1);
        }
    }
}