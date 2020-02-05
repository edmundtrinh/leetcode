/*
    Author:     Edmund Trinh, edmund.trinh@gmail.com
    Date:       Dec 12, 2019
    Update:     Feb 4, 2020
    Problem:    448. Find All Numbers Disappeared in an Array
    Difficulty: Easy
    Source:     https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
    
    Notes:
        Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array),
        some elements appear twice and others appear once.
        Find all the elements of [1, n] inclusive that do not appear in this array.
        Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.        
    Examples:
        1.
            Input:
            [4,3,2,7,8,2,3,1]

            Output:
            [5,6]
        
    Solution:
        Add to list if number is not found in nums
        Ex: if nums[0] = 4 -> appeared[3]++;
        If at the end, if appeared[i] == 0, that means it wasn't found and therefore a disappeared number
        Add those to final list and return
*/

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        /*
        List<Integer> result = new ArrayList<Integer>();
        // Create array with size of Max value from nums
        int[] count = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if 
        }
        // Create 
        */
        
        // n is size of array and max value
        int[] appeared = new int[nums.length];
        // Add to list if number not found in nums
        List<Integer> disappearedNumbers = new ArrayList<Integer>();
        // Increase index for each number found in nums
        // Index is one lower than the number that appears -> = nums[i] - 1
        for (int i = 0; i < nums.length; i++) {
            // If nums[0] = 4: appeared[3]++; 
            appeared[nums[i] - 1]++;
        }
        for (int i = 0; i < appeared.length; i++) {
            // If appeared[i] == 0; then i + 1 is a "disappeared" number
            if (appeared[i] == 0) {
                disappearedNumbers.add(i + 1);
            }
            
        }
        return disappearedNumbers;
        // 
        
        
    }
}