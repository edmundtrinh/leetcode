/*
    Author:     Edmund Trinh, edmund.trinh@gmail.com
    Date:       Mar 11, 2020
    Update:     Mar 11, 2020
    Problem:    461. Hamming Distance
    Difficulty: Easy
    Source:     https://leetcode.com/problems/hamming-distance/
    
    Notes:
        The Hamming distance between two integers is the number of positions
        at which the corresponding bits are different.

        Given two integers x and y, calculate the Hamming distance.

        0 ≤ x, y < 2^31.
        
    Examples:
        1.
            Input: x = 1, y = 4

            Output: 2

            Explanation:
            1   (0 0 0 1)
            4   (0 1 0 0)
                   ↑   ↑

            The above arrows point to positions where the corresponding bits are different.
        
    Solution:
        Use bitwise XOR (^) to check the difference between x and y converted to binary
        Use Integer.bitCount(int n) to convert integers to binary
            Learn how to implement this as a separate exercise!
        
*/

class Solution {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}