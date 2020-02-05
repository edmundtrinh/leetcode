/*
    Author:     Edmund Trinh, edmund.trinh@gmail.com
    Date:       Dec 12, 2019
    Update:     Feb 4, 2020
    Problem:    1221. Split a String in Balanced Strings
    Difficulty: Easy
    Source:     https://leetcode.com/problems/split-a-string-in-balanced-strings/
    
    Notes:
        Balanced strings are those who have equal quantity of 'L' and 'R' characters.
        Given a balanced string s split it in the maximum amount of balanced strings.
        Return the maximum amount of splitted balanced strings.
        
    Examples:
        1.
            Input: s = "RLRRLLRLRL"
            Output: 4
            Explanation: s can be split into "RL", "RRLL", "RL", "RL",
            each substring contains same number of 'L' and 'R'.
            
        2.
            Input: s = "RLLLLRRRLR"
            Output: 3
            Explanation: s can be split into "RL", "LLLRRR", "LR", each substring contains same number of 'L' and 'R'.
            
        3.
            Input: s = "LLLLRRRR"
            Output: 1
            Explanation: s can be split into "LLLLRRRR".
            
        4.
            Input: s = "RLRRRLLRLL"
            Output: 2
            Explanation: s can be split into "RL", "RRRLLRLL",
            since each substring contains an equal number of 'L' and 'R'
        
    Solution:
        Keeping a counter and iterating through the string, incrementing the final count by 1 whenever the
        temporary counter == 0 (means one balanced string found)
*/

class Solution {    
    public int balancedStringSplit(String s) {
        // Final return value
        int balanced = 0;
        // Temporary counter
        int counter = 0;
        // Can only have pairs if more than 1 characters, otherwise skip and return 0;
        if (s.length() > 1) {
            for (int i = 0; i < s.length(); i++) {
                // Increase counter for R
                if (s.charAt(i) == 'R') {
                    counter++;
                // Decrease counter for L
                } else if (s.charAt(i) == 'L') {
                    counter--;
                }
                // Increase balanced once balanced substring found
                if (counter == 0) {
                    balanced++;
                }
            }    
        }
        return balanced;
    }
}