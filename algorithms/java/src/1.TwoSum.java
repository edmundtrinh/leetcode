/*
    Author:     Edmund Trinh, edmund.trinh@gmail.com
    Date:       Aug 8, 2019
    Update:     Feb 4, 2020
    Problem:    1. Two Sum
    Difficulty: Easy
    Source:     https://leetcode.com/problems/two-sum/
    
    Notes:
        Given an array of integers, return indices of the two numbers such that they add up to a specific target.
        You may assume that each input would have exactly one solution, and you may not use the same element twice.
        
    Example:
        Given nums = [2, 7, 11, 15], target = 9,

        Because nums[0] + nums[1] = 2 + 7 = 9,
        return [0, 1].
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // int[] complements = new int[nums.length];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        // Put all the keys and values in a map
        // key = actual number, value = index of that number
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        // Check if complement of each value is in map, then return that pair of indices
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                // Assuming there is exactly one solution
                return new int[] {i, map.get(complement)};
            }    
        }
        
        return null;
    }
}