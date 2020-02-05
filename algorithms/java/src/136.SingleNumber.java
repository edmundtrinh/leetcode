/*
    Author:     Edmund Trinh, edmund.trinh@gmail.com
    Date:       Dec 12, 2019
    Update:     Feb 4, 2020
    Problem:    136. Single Number
    Difficulty: Easy
    Source:     https://leetcode.com/problems/single-number/
    
    Notes:
        Given a non-empty array of integers, every element appears twice except for one. Find that single one.
        Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
        
    Examples:
        1.
            Input: [2,2,1]
            Output: 1
            
        2.
            Input: [4,1,2,1,2]
            Output: 4
        
    Solution:
        EXOR a number with itself = 0
        Since the elements that appear twice will cancel each other out,
        the value at the end will be the only single number that appeared once.
        
*/

class Solution {
    public int singleNumber(int[] nums) {
        /* Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if !counts.containsKey(nums[i]) {
                put(nums[i], 1);
            } else {
                
            }
        }
        return 1;
        */
        int a = 0;
        for (int i = 0; i < nums.length; i++) {
            a ^= nums[i];
        }
        return a;
    }
}