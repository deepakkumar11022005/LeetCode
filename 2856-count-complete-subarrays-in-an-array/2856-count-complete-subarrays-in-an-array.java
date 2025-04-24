import java.util.*;

public class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        
        // Step 1: Count distinct elements in the whole array
        Set<Integer> totalDistinctSet = new HashSet<>();
        for (int num : nums) totalDistinctSet.add(num);
        int totalDistinct = totalDistinctSet.size();
        
        int count = 0;
        
        // Step 2: Use a sliding window approach
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> freq = new HashMap<>();
            for (int j = i; j < n; j++) {
                freq.put(nums[j], freq.getOrDefault(nums[j], 0) + 1);
                if (freq.size() == totalDistinct) {
                    count++;
                }
            }
        }
        
        return count;
    }
}
