/*
    Author:     Edmund Trinh, edmund.trinh@gmail.com
    Date:       Dec 12, 2019
    Update:     Feb 4, 2020
    Problem:    11. Container With Most Water
    Difficulty: Medium
    Source:     https://leetcode.com/problems/container-with-most-water/
    
    Notes:
        Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
        n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
        Find two lines, which together with x-axis forms a container, such that the container contains the most water.

        You may not slant the container and n is at least 2.

        The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
        In this case, the max area of water (blue section) the container can contain is 49.
        
    Examples:
        1.
            Input: [1,8,6,2,5,4,8,3,7]
            Output: 49
*/

class Solution {
    public int maxArea(int[] height) {
        
        // Set default max area = 0
        int maxarea = 0;
        // Initialize left and right to first and last elements
        int left = 0;
        int right = height.length - 1;
        
        // Size of rectangle determined by shorter height * length of sub-array
        while (left < right) {
            maxarea = Math.max(maxarea, Math.min(height[left], height[right]) * (right - left));
            // Increase index of left if shorter
            if (height[left] < height[right]) {
                left++;
            // Decrease index of right if shorter
            } else {
                right--;
            }
        }
        return maxarea;
    }
}