/*
    Author:     Edmund Trinh, edmund.trinh@gmail.com
    Date:       Aug 8, 2019
    Update:     Feb 4, 2020
    Problem:    7. Reverse Integer
    Difficulty: Easy
    Source:     https://leetcode.com/problems/reverse-integer/
    
    Notes:
        Given a 32-bit signed integer, reverse digits of an integer.
        
    Examples:
        1.
        Input: 123
        Output: 321
        
        2.
        Input: -123
        Output: -321
        
        3.
        Input: 120
        Output: 21
*/

class Solution {
    public int reverse(int x) {
        /*String rev = "";
        if (x < 0) {
            x *= -1;
            rev = "-";
        }
        String str = Integer.toString(x);
        for (int i = str.length() - 1; i >= 0; i--) {
            rev += str.charAt(i);
        }
        return Integer.parseInt(rev);*/
        
        long result = 0;
        while (x != 0) {
            result = (result * 10) + (x % 10);
            x /= 10;
        }
        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            return 0;
        }
        return (int)result;
    }
}