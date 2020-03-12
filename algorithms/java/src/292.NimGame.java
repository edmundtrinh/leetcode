/*
    Author:     Edmund Trinh, edmund.trinh@gmail.com
    Date:       Mar 11, 2020
    Update:     Mar 11, 2020
    Problem:    292. Nim Game
    Difficulty: Easy
    Source:     https://leetcode.com/problems/nim-game/
    
    Notes:
        You are playing the following Nim Game with your friend:
        There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones.
        The one who removes the last stone will be the winner.
        You will take the first turn to remove the stones.
        
        Both of you are very clever and have optimal strategies for the game.
        Write a function to determine whether you can win the game given the number of stones in the heap.
        
    Examples:
        1.
            Input: 4
            Output: false 
            Explanation: If there are 4 stones in the heap, then you will never win the game;
                         No matter 1, 2, or 3 stones you remove, the last stone will always be 
                         removed by your friend.
        
    Solution:
        You can win if n % 4 != 0.
        The opponent has the advantage when n is a multiple of 4 as you can't remove more than 3 at a time.
*/

class Solution {
    public boolean canWinNim(int n) {
        if (n <= 0) {
            // less than 0 means impossible
            return false;
            // mod 4 != 0 means not a multiple of 4
        } else {
            return n % 4 != 0;
        }
    }
}