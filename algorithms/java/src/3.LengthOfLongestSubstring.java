/*
    Author:     Edmund Trinh, edmund.trinh@gmail.com
    Date:       Feb 23, 2020
    Update:     Feb 26, 2020
    Problem:    3. Longest Substring Without Repeating Characters
    Difficulty: Medium
    Source:     https://leetcode.com/problems/longest-substring-without-repeating-characters/
    
    Notes:
        Given a string, find the length of the longest substring without repeating characters.
        
    Examples:
    1.
    Input: "abcabcbb"
    Output: 3 
    Explanation: The answer is "abc", with the length of 3. 
    
    2.
    Input: "bbbbb"
    Output: 1
    Explanation: The answer is "b", with the length of 1.
    
    3.
    Input: "pwwkew"
    Output: 3
    Explanation: The answer is "wke", with the length of 3. 
                 Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
    
*/

public class Solution {
    /*
    // Brute Force
    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        for (int i = 0; i < s.length(); i++) {    
            for (int j = i + 1; j <= s.length(); j++) {
                if (allUnique(s, i, j)) {
                    longest = Math.max(longest, j - i);
                }
            }
        }
        return longest;
    }
    
    public boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<Character>();
        for (int i = start; i < end; i++) {
            if (set.contains(s.charAt(i))) {
                return false;
            }
            set.add(s.charAt(i));
        }
        return true;
    }
    */
    
    
    // Sliding Window
    public int lengthOfLongestSubstring(String s) {
        Set<Character> uniqueChars = new HashSet<Character>();
        int i = 0;
        int j = 0;
        int longest = 0;
        
        while (i < s.length() && j < s.length()) {
            // check if set contains s[j]
            if (!uniqueChars.contains(s.charAt(j))) {
                // if not, then add s[j]
                uniqueChars.add(s.charAt(j));
                j++;
                longest = Math.max(longest, j - i);
            } else {
                uniqueChars.remove(s.charAt(i));
                i++;
            }
        }
        // return new max
        return longest;
    }
}