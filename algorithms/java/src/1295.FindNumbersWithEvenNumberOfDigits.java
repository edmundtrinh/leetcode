/*
    Author:     Edmund Trinh, edmund.trinh@gmail.com
    Date:       Jan 4, 2020
    Update:     Feb 4, 2020
    Problem:    1295. Find Numbers with Even Number of Digits
    Difficulty: Easy
    Source:     https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
    
    Notes:
        Given an array nums of integers, return how many of them contain an even number of digits.
        
    Constraints:
        1 <= nums.length <= 500
        1 <= nums[i] <= 10^5
    
    Examples:
        1.
            Input: nums = [12,345,2,6,7896]
            Output: 2
            Explanation: 
            12 contains 2 digits (even number of digits). 
            345 contains 3 digits (odd number of digits). 
            2 contains 1 digit (odd number of digits). 
            6 contains 1 digit (odd number of digits). 
            7896 contains 4 digits (even number of digits). 
            Therefore only 12 and 7896 contain an even number of digits.
            
        2.
            Input: nums = [555,901,482,1771]
            Output: 1 
            Explanation: 
            Only 1771 contains an even number of digits.
        
    Solution:
        Count # of digits while curr /= 10
        If # of digits % 2 == 0 -> even number of digits -> counter++
        return evens counter
*/

class Solution {
    public int findNumbers(int[] nums) {
        // Number of Even Numbers
        int evens = 0;
        // Loop to count digits
        for (int i = 0; i < nums.length; i++) {
            // Number of Digits per Number
            int digits = 0;
            int curr = nums[i];
            while (curr != 0) {
                curr /= 10;
                digits++;
            }
            // Increment if # Digits is Even
            if (digits % 2 == 0) {
                evens++;
            }
            digits = 0;
        }
        return evens;
        
        /*
        // toString Version
        // Number of Even Numbers
        int evens = 0;
        // Loop to count digits
        for (int i = 0; i < nums.length; i++) {
            // Number of Digits per Number
            String curr = Integer.toString(nums[i]);
            if (curr.length() % 2 == 0) {
                evens++;
            }
        }
        return evens;
        */
            
    }
}