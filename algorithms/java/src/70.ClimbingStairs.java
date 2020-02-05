/*
    Author:     Edmund Trinh, edmund.trinh@gmail.com
    Date:       Jan 4, 2020
    Update:     Feb 4, 2020
    Problem:    70. Climbing Stairs
    Difficulty: Easy
    Source:     https://leetcode.com/problems/climbing-stairs/
    
    Notes:
        You are climbing a stair case. It takes n steps to reach to the top.
        Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
        Given n will be a positive integer.
        
    Examples:
        1.
            Input: 2
            Output: 2
            Explanation: There are two ways to climb to the top.
            1. 1 step + 1 step
            2. 2 steps
            
        2.
            Input: 3
            Output: 3
            Explanation: There are three ways to climb to the top.
            1. 1 step + 1 step + 1 step
            2. 1 step + 2 steps
            3. 2 steps + 1 step
        
    Solution:
        Dynamic Programming.
        Create a HashMap and helper method to create a tree to count
        Use HashMap to remember previous solutions (dynamic programming)
        
*/

class Solution {
    public int climbStairs(int n) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        return countingFunction(n, map);
    }
    
    public int countingFunction(int stairsRemaining, Map<Integer, Integer> savedResults) {
        if (stairsRemaining < 0) {
            return 0;
        }
        
        if (stairsRemaining == 0) {
            return 1;
        }
        
        if (savedResults.containsKey(stairsRemaining)) {
            return savedResults.get(stairsRemaining);
        }
        
        savedResults.put(stairsRemaining, (countingFunction(stairsRemaining - 1, savedResults)) + (countingFunction(stairsRemaining - 2, savedResults)));
                                            
        return savedResults.get(stairsRemaining);
    }
    
}