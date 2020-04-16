/*
    Author:     Edmund Trinh, edmund.trinh@gmail.com
    Date:       Apr 15, 2020
    Update:     Apr 16, 2020
    Problem:    202. Happy Number
    Difficulty: Easy
    Source:     https://leetcode.com/problems/happy-number/
    
    Description:
        Write an algorithm to determine if a number n is "happy".

        A happy number is a number defined by the following process: Starting with any positive integer,   
        replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1
        (where it will stay), or it loops endlessly in a cycle which does not include 1.
        Those numbers for which this process ends in 1 are happy numbers.

        Return True if n is a happy number, and False if not.
        
    Examples:
    1.
        Input: 19
        Output: true
        Explanation: 
        12 + 92 = 82
        82 + 22 = 68
        62 + 82 = 100
        12 + 02 + 02 = 1
*/

public class Solution {
    public boolean isHappy(int n) {
        // Base Case
        if (n < 0) {
            return false;
        }
        // Keep track of all "happy" numbers
        Set<Integer> checked = new HashSet<Integer>();
        checked.add(n);
        while (n != 1) {
            int sum = 0;
            while (n != 0) {
                sum += Math.pow(n % 10, 2);
                n /= 10;
            }
            if (checked.contains(sum)) {
                // Means we've run across a number that didn't sum of squares = 1
                return false;
            }
            checked.add(sum);
            n = sum;
        }
        return true;
    }
    
    /*
    // Why is this solution wrong?? I also tried with a private helper method too, but still got a similar error when I did "happyNumbers.contains(n))" why did it overflow?
    // Base Case
        if (n < 0) {
            return false;
        }
        // Keep track of all "happy" numbers
        Set<Integer> happyNumbers = new HashSet<Integer>();
        // Temp val to modify n
        int curr = n;
        // If n already in the set, then true
        if (happyNumbers.contains(n)) {
            return true;
        } else {
            int sum = 0;
            while (curr != 0) {
                sum += Math.pow(curr % 10, 2);
                curr /= 10;
            }
            if (sum == 1) {
                happyNumbers.add(n);
                return true;
            } else {
                return isHappy(sum);
            }
        }
    }
    */
    
}