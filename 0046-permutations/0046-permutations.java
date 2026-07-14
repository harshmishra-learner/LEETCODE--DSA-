import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        solve(0, nums, result);
        return result;
    }

    private void solve(int index, int[] nums, List<List<Integer>> result) {
        // Base Case: If index reaches the end, a full permutation is ready
        if (index == nums.length) {
            List<Integer> currentPermutation = new ArrayList<>();
            for (int num : nums) {
                currentPermutation.add(num);
            }
            result.add(currentPermutation);
            return;
        }

        // Loop through all available elements to place at the current 'index' position
        for (int i = index; i < nums.length; i++) {
            // 1. Swap the element at 'i' into our target 'index' position
            swap(nums, index, i);

            // 2. Recurse to solve permutations for the remaining positions
            solve(index + 1, nums, result);

            // 3. Backtrack: Swap back to clean up state for the next loops
            swap(nums, index, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}