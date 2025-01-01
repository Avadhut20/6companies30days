class Solution {
    public int incremovableSubarrayCount(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;

        // Precompute left and right bounds
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], nums[i - 1]);
        }

        right[n - 1] = Integer.MAX_VALUE;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.min(right[i + 1], nums[i + 1]);
        }

        // Count valid subarrays
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if ((i == 0 || left[i - 1] < nums[j]) && (j == n - 1 || nums[i] < right[j + 1])) {
                    count++;
                }
            }
        }

        return count;
    }
}
