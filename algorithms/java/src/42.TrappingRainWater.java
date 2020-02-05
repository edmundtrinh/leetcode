/*
    Author:     Edmund Trinh, edmund.trinh@gmail.com
    Date:       Jan 4, 2020
    Update:     Feb 4, 2020
    Problem:    42. Trapping Rain Water
    Difficulty: Hard
    Source:     https://leetcode.com/problems/trapping-rain-water/
    
    Notes:
        Given n non-negative integers representing an elevation map where the width of each bar is 1,
        compute how much water it is able to trap after raining.
        
    Examples:
        1.
            Input: [0,1,0,2,1,0,1,3,2,1,2,1]
            Output: 6
        
        Look on source link for image.
        
    Solution:
        leftMax = the maximum between the height[i] and the previous max before (1 index on left)
        rightMax = the maximum between the height[i] and the max afterwards (1 index on right)
        totalWater += minimum of leftMax/rightMax (the shorter max) - height[i] (the black squares)
        
*/

class Solution {
    public int trap(int[] height) {
        if(height.length < 3)  {
            return 0;
        }
        
        int totalWater = 0;
        // int length = height.length;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        // Default left max to 0th index of height[]
        leftMax[0] = height[0];

        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        // Default right max to last index of height[]
        rightMax[height.length - 1] = height[height.length - 1];

        for (int i = height.length - 2; i>= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        for (int i = 1; i < height.length - 1; i++) {
            totalWater += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return totalWater;
        
    }
}