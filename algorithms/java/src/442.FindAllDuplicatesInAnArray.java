/*
    Author:     Edmund Trinh, edmund.trinh@gmail.com
    Date:       Dec 12, 2019
    Update:     Feb 4, 2020
    Problem:    442. Find All Duplicates in an Array
    Difficulty: Easy
    Source:     https://leetcode.com/problems/find-all-duplicates-in-an-array/
    
    Notes:
        Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
        Find all the elements that appear twice in this array.
        Could you do it without extra space and in O(n) runtime?
        
    Examples:
        1.
            Input:
            [4,3,2,7,8,2,3,1]

            Output:
            [2,3]
        
    Solution:
        Use counting sort to see which index has 2 counts (remember: indexAt(i) = i - 1):)
        Add i+1 to ArrayList twice if counts[i] == 2
        Return twice
        
*/

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int[] counts = new int[nums.length];
        List<Integer> twice = new ArrayList<Integer>();
        // Increment counts - one less than value of nums[i]
        for (int i = 0; i < nums.length; i++) {
            counts[nums[i] - 1]++;
        }
        for (int i = 0; i < counts.length; i++) {
            // If counts[i] is twice, add i + 1 to twice list
            if (counts[i] == 2) {
                twice.add(i + 1);
            }
        }
        return twice;
    }
}