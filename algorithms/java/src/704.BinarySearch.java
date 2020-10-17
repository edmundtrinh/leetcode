/*
    Author:     Edmund Trinh, edmund.trinh@gmail.com
    Date:       Oct 16, 2020
    Update:     Oct 16, 2020
    Problem:    704. Binary Search
    Difficulty: Easy
    Source:     https://leetcode.com/problems/binary-search/
    
    Description:
        Given a sorted (in ascending order) integer array nums of n elements and a target value,
        write a function to search target in nums. If target exists, then return its index, otherwise return -1.
        
    Examples:
    1.  
        Input: nums = [-1,0,3,5,9,12], target = 9
        Output: 4
        Explanation: 9 exists in nums and its index is 4
          
    2.
        Input: nums = [-1,0,3,5,9,12], target = 2
        Output: -1
        Explanation: 2 does not exist in nums so return -1
    
    Note:
        You may assume that all elements in nums are unique.
        n will be in the range [1, 10000].
        The value of each element in nums will be in the range [-9999, 9999].
*/

class Solution {
    public int search(int[] nums, int target) {
        // if nums == null or size == 0, then return -1
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // if only one value, compare with target and return 0 if same value, -1 if diff value
        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            }
            else {
                return -1;
            }
        }
        // start from the middle index, compare target value to middle value, then adjust bounds
        int left = 0;
        int right = nums.length - 1;
        return helpSearch(nums, target, left, right);
    }
    
    private int helpSearch(int[] nums, int target, int left, int right) {
        int mid = (left + right) / 2;
        // if middle value = target, return middle index
        // if left and right is same index, (left + right) / 2 is same index
        if (target == nums[mid]) {
            return mid;
        }
        if (target > nums[mid]) {
            left = mid + 1;
        }
        if (target < nums[mid]) {
            right = mid - 1;            
        }
        if (left > right || right < left) {
            return -1;
        }
        // if target > middle, set left value to middle and recurse
        // if target < middle, set right value to middle and recurse
        // repeat/recurse until target is found, or return -1 if not found
        return helpSearch(nums, target, left, right);
    }
}