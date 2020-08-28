/*
    Author:     Edmund Trinh, edmund.trinh@gmail.com
    Date:       July 28, 2020
    Update:     July 28, 2020
    Problem:    1079. Letter Tile Possibilities
    Difficulty: Medium
    Source:     https://leetcode.com/problems/letter-tile-possibilities/
    
    Description:
        You have a set of tiles, where each tile has one letter tiles[i] printed on it.
        Return the number of possible non-empty sequences of letters you can make.
        
    Examples:
    1.
        Input: "AAB"
        Output: 8
        Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
        
    2.
        Input: "AAABBC"
        Output: 188
*/

// input: String of characters, uppercase English letters, length 1 <= input <= 7
// output: Number of possible empty sequences of letters using input string characters

class Solution {
    int numSequences = 0;
    
    public int numTilePossibilities(String tiles) {
        // turn String into char array
        char[] charArr = tiles.toCharArray();
        // sort array to remove duplicates
        Arrays.sort(charArr);
        
        // return count using helper traverse method
        traverse(charArr, new boolean[charArr.length]);
        return numSequences;
    }
    
    // helper method to traverse
    public void traverse(char[] charArr, boolean[] used) {
        for (int i = 0; i < charArr.length; i++) {
            // check if used, no duplicates, no 2 same letters in a row
            if (used[i] || (i > 0 && charArr[i] == charArr[i - 1] && !used[i - 1])) {
                // skip
                continue;
            }
            // mark as true, recurse, then mark as false
            used[i] = true;
            traverse(charArr, used);
            used[i] = false;
            numSequences++;
        }
        
    }
}