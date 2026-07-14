import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Tracking array to know which elements are currently inside our path
        boolean[] visited = new boolean[nums.length];
        
        backtrack(nums, new ArrayList<>(), visited, result);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> currentList, boolean[] visited, List<List<Integer>> result) {
        // Base Case: If the temporary list matches the size of nums, we found a permutation
        if (currentList.size() == nums.length) {
            result.add(new ArrayList<>(currentList)); // Deep copy the list
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // If the element at index i is already used, skip it
            if (visited[i]) continue;

            // 1. Take the element
            visited[i] = true;
            currentList.add(nums[i]);

            // 2. Move down the decision tree
            backtrack(nums, currentList, visited, result);

            // 3. Backtrack (Undo the choice)
            currentList.remove(currentList.size() - 1);
            visited[i] = false;
        }
    }
}