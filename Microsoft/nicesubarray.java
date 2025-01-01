import java.util.HashMap;

public class nicesubarray {
    public int numberOfSubarrays(int[] nums, int k) {
        int count = 0; // Total number of valid subarrays
        int currentOddCount = 0; // Running sum of odd numbers
        HashMap<Integer, Integer> prefixCount = new HashMap<>(); // Map to store prefix sums

        // Initialize prefixCount with 0 to handle edge cases
        prefixCount.put(0, 1);

        for (int num : nums) {
            // Update currentOddCount based on whether the current number is odd
            if (num % 2 != 0) {
                currentOddCount++;
            }

            // Check if there's a prefix sum that satisfies the condition
            count += prefixCount.getOrDefault(currentOddCount - k, 0);

            // Update prefixCount with the current prefix sum
            prefixCount.put(currentOddCount, prefixCount.getOrDefault(currentOddCount, 0) + 1);
        }

        return count;
    }
}
