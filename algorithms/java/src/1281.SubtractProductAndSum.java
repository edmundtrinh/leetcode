/*
    Author:     Edmund Trinh, edmund.trinh@gmail.com
    Date:       Dec 4, 2019
    Update:     Feb 4, 2020
    Problem:    1281. Subtract the Product and Sum of Digits of an Integer
    Difficulty: Easy
    Source:     https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
    
    Notes:
        Given an integer number n, return the difference between the product
        of its digits and the sum of its digits.
        
    Examples:
    1.
    Input: n = 234
    Output: 15 
    Explanation: 
    Product of digits = 2 * 3 * 4 = 24 
    Sum of digits = 2 + 3 + 4 = 9 
    Result = 24 - 9 = 15
    
    2.
    Input: n = 4421
    Output: 21
    Explanation: 
    Product of digits = 4 * 4 * 2 * 1 = 32 
    Sum of digits = 4 + 4 + 2 + 1 = 11 
    Result = 32 - 11 = 21
    
    Constraints:
    1 <= n <= 10^5
*/

public class Solution {
    public int subtractProductAndSum(int n) {
        // 1 <= n <= 10^5
        // Product will not be 0
        int product = 1;
        int sum = 0;
        
        int digit = 0;
        
        while (n != 0) {
            // % to get the last digit
            digit = n % 10;
            product *= digit;
            sum += digit;
            // / to remove that digit from number
            n /= 10;
        }
        
        return product - sum;
    }
}