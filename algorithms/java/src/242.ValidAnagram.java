/*
    Author:     Edmund Trinh, edmund.trinh@gmail.com
    Date:       Mar 2, 2020
    Update:     Mar 2, 2020
    Problem:    242. Valid Anagram
    Difficulty: Easy
    Source:     https://leetcode.com/problems/longest-substring-without-repeating-characters/
    
    Notes:
        Given two strings s and t , write a function to determine if t is an anagram of s.
        
        You may assume the string contains only lowercase alphabets.
        
        Follow up:
        What if the inputs contain unicode characters? How would you adapt your solution to such case?
        Answer: Change size of counter array, or make it user input for character set(?)
        
    Examples:
    1.
    Input: s = "anagram", t = "nagaram"
    Output: true
    
    2.
    Input: s = "rat", t = "car"
    Output: false    
*/

class Solution {
    public boolean isAnagram(String s, String t) {
        // Hash Table Method (Increment character index for s, decrement character index for t)
        if (s.length() != t.length()) {
            return false;
        }
        
        // Create counter array for each letter of alphabet
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        // If any count is not 0 (meaning there was a character in one word but not the other), means false
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] != 0) {
                return false;
            }
        }
        // Must be true if all counters are 0
        return true;
    }
}