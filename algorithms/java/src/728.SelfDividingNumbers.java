/*
    Author:     Edmund Trinh, edmund.trinh@gmail.com
    Date:       Dec 12, 2019
    Update:     Feb 4, 2020
    Problem:    728. Self Dividing Numbers
    Difficulty: Easy
    Source:     https://leetcode.com/problems/self-dividing-numbers/
    
    Notes:
        A self-dividing number is a number that is divisible by every digit it contains.
        For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
        Also, a self-dividing number is not allowed to contain the digit zero.
        Given a lower and upper number bound, output a list of every possible self dividing number,
        including the bounds if possible.space.        
        
        The boundaries of each input argument are 1 <= left <= right <= 10000.
        
    Examples:
        1.
            Input: 
            left = 1, right = 22
            Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
        
    Solution:
        % 10 to get each digit
        if it's 0 -> false
        if % digit != 0 -> false (there is a remainder)
        return true if passes ^ tests
*/

class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<Integer>();
        // Loop from left bound to right bound (inclusive)
        for (int i = left; i <= right; i++) {
            if (isSelfDividing(i)) {
                result.add(i);
            }
        }
        return result;
    }
    
    // Helper method to determine if number is self dividing
    public boolean isSelfDividing(int n) {
        // Make copy of n for bit manipulation
        int copy = n;
        while (copy > 0) {
            int digit = copy % 10;
            copy /= 10;
            // False if digit is 0 or mod digit is not 0
            if (digit == 0 || n % digit != 0) {
                return false;
            }
        }
        // Must be true at this point
        return true;
    }
}