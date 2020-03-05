/*
    Author:     Edmund Trinh, edmund.trinh@gmail.com
    Date:       Mar 4, 2020
    Update:     Mar 4, 2020
    Problem:    387. First Unique Character in a String
    Difficulty: Easy
    Source:     https://leetcode.com/problems/first-unique-character-in-a-string/
    
    Notes:
        Given a string, find the first non-repeating character in it and return it's index.
        If it doesn't exist, return -1.
        
    Examples:
    1.
        s = "leetcode"
        return 0.

        s = "loveleetcode",
        return 2.
        
    You may assume the string contain only lowercase letters.
*/

public class Solution {
    public int firstUniqChar(String s) {
        // lowercase alphabet (constant size array) method:
        int[] counts = new int[26];
        // go through string and increment each letter count
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            counts[index]++;
        }
        // go through string again, and if the count for a character c == 1, it is the first unique character
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (counts[c] == 1) {
                return i;
            }
        }
        return -1;
        
        /*
        // HashMap Method
        // Create a counter which increments whenever a character is found,
        // then return the first key that has a value of 1
        Map<Character, Integer> counts = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!counts.containsKey(c)) {
                counts.put(c, 0);
            }
            counts.put(c, counts.get(c) + 1);
        }
        // Go through string second time, check if character is unique (s.charAt(i))
        for (int i = 0; i < s.length(); i++) {
            if (counts.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
        */
    }
}