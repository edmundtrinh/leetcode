/*
    Author:     Edmund Trinh, edmund.trinh@gmail.com
    Date:       Aug 8, 2019
    Update:     Feb 4, 2020
    Problem:    9. Palindrome Number
    Difficulty: Easy
    Source:     https://leetcode.com/problems/palindrome-number/
    
    Notes:
        Determine whether an integer is a palindrome.
        An integer is a palindrome when it reads the same backward as forward.
        
    Examples:
        1.
            Input: 121
            Output: true
        
        2.
            Input: -121
            Output: false
            Explanation: From left to right, it reads -121.
            From right to left, it becomes 121-. Therefore it is not a palindrome.
        
        3.
            Input: 10
            Output: false
            Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
*/

class Solution {
    public boolean isPalindrome(int x) {
        // False if negative -- impossible
        if (x < 0) {
            return false;
        }
        int num = x;
        int reversed = 0;
        while (num != 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        return reversed == x;
    }
}