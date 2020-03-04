/*
    Author:     Edmund Trinh, edmund.trinh@gmail.com
    Date:       Mar 3, 2020
    Update:     Mar 3, 2020
    Problem:    1351. Count Negative Numbers in a Sorted Matrix
    Difficulty: Easy
    Source:     https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
    
    Notes:
        Given a m * n matrix grid which is sorted in non-increasing order both row-wise and column-wise. 
        Return the number of negative numbers in grid.
        
    Constraints:
        m == grid.length
        n == grid[i].length
        1 <= m, n <= 100
        -100 <= grid[i][j] <= 100
        
    Examples:
    1.
        Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
        Output: 8
        Explanation: There are 8 negatives number in the matrix.
    
    2.
        Input: grid = [[3,2],[1,0]]
        Output: 0 
    
    3.
        Input: grid = [[1,-1],[-1,-1]]
        Output: 3
    
    4.
        Input: grid = [[-1]]
        Output: 1
    
*/

public class Solution {
    public int countNegatives(int[][] grid) {
        /*
        // Brute Force Method
        // Simply searches linearly (O(N)) through m, n, increases counter 
        int negatives = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] < 0) {
                    negatives++;
                }
            }
        }
        return negatives;
        */
        
        /*
        // Brute Force (Backwards): Trick - considering reverse sorted
        int negatives = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = grid[i].length - 1; j >= 0; j--) {
                if (grid[i][j] < 0) {
                    negatives++;
                } else {
                    break;
                }
            }
        }
        return negatives;
        */
        
        // Binary Search Method
        int negatives = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        // for each row, find last negative using binary search
        for (int i = 0; i < rows; i++) {
            // check edge cases - if first element is < 0, all elements in row are negative
            if (grid[i][0] < 0) {
                negatives += cols;
                continue;
            }
            // if last element is positive (assume all left are larger), then no negative numbers in row
            // last element = grid[i].length - 1
            else if (grid[i][cols - 1] >= 0) {
                // none to add
                continue;
            } else {
                // binary search returns first negative #
                negatives += cols - binarySearch(grid[i]);
            }
        }
        return negatives;
    }
    
    private int binarySearch(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = (right  - left) / 2 + left;
            
            //if mid is negative, move right to one left of current mid
            if (arr[mid] < 0) {
                right = mid - 1;
            } else
                left = mid + 1;   
            }
        
        return left;
    }
}