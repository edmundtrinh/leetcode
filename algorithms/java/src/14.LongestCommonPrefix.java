/*
    Author:     Edmund Trinh, edmund.trinh@gmail.com
    Date:       Jan 14, 2020
    Update:     Feb 4, 2020
    Problem:    14. Longest Common Prefix
    Difficulty: Medium
    Source:     https://leetcode.com/problems/container-with-most-water/
    
    Notes:
        Write a function to find the longest common prefix string amongst an array of strings.
        If there is no common prefix, return an empty string "".
        
    Examples:
        1.
            Input: ["flower","flow","flight"]
            Output: "fl"
        2.
            Input: ["dog","racecar","car"]
            Output: ""
            Explanation: There is no common prefix among the input strings.
            
        Note: All given inputs are in lowercase letters a-z.
        
        Solution:
            Iterate through strings in array simultaneously - save the common prefix until
            there's a mismatched character, then return the substring up to that point.
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Base Cases - Null / 0 Length
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }
}