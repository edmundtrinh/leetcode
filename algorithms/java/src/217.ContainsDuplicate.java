/*
    Author:     Edmund Trinh, edmund.trinh@gmail.com
    Date:       Nov 3, 2021
    Update:     Nov 3, 2021
    Problem:    217. Contains Duplicate
    Difficulty: Easy <- definitely not an easy lol
    Source:     https://leetcode.com/problems/contains-duplicate/
    
    Description:
        Given an integer array nums, return true if any value appears at least twice in the array,
        and return false if every element is distinct.
        
    Examples:
    1.  
        Input: nums = [1,2,3,1]
        Output: true
          
    2.
        Input: nums = [1,2,3,4]
        Output: false
    3.
        Input: nums = [1,1,1,3,3,4,3,2,4,2]
        Output: true
    
    Constraints:
        * 1 <= nums.length <= 105
        * -109 <= nums[i] <= 109
*/

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
            }
            else {
                return true;
            }
        }
        return false;
    }
}