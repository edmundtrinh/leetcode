/*
    Author:     Edmund Trinh, edmund.trinh@gmail.com
    Date:       Mar 12, 2020
    Update:     Mar 12, 2020
    Problem:    46. Minimum Depth of Binary Tree
    Difficulty: Medium
    Source:     https://leetcode.com/problems/permutations/
    
    Notes:
        Given a collection of distinct integers, return all possible permutations.
        
    Examples:
        Input: [1,2,3]
        Output:
        [
          [1,2,3],
          [1,3,2],
          [2,1,3],
          [2,3,1],
          [3,1,2],
          [3,2,1]
        ]
*/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Base Cases: null or 0 size
        if (nums == null || nums.length == 0) {
            return result;
        }
        // to check that an int has already been used in the permutation
        boolean[] seen = new boolean[nums.length];
        // a temporary ArrayList which we can build each permutation
        List<Integer> permutation = new ArrayList<>();
        // use helper method to find the permutations, and add each permutation to final result list
        findPermutations(nums, permutation, seen, result);
        return result;
    }
    
    private void findPermutations(int[] nums, List<Integer> permutation, boolean[] seen, List<List<Integer>> result) {
        if (permutation.size() == nums.length) {
            // Base case - add one permutation once all slots have been filled up = size of original array
            // Add a deep copy so you can continue to modify the temp ArrayList
            result.add(new ArrayList<>(permutation));
            return;
        }
        // 
        for (int i = 0; i < nums.length; i++) {
            // if number has already been added (marked true), then skip
            if (seen[i]) {
                continue;
            }
            // add the current int
            permutation.add(nums[i]);
            // mark as seen
            seen[i] = true;
            // recurse on the remaining ints in list
            findPermutations(nums, permutation, seen, result);
            // choose --> explore --> unchoose
            permutation.remove(permutation.size() - 1);
            // mark as unseen again for next permutation
            seen[i] = false;
        }
    }

    // Used as resource/explanation: https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
}