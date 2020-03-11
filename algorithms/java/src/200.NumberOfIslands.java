/*
    Author:     Edmund Trinh, edmund.trinh@gmail.com
    Date:       Mar 10, 2020
    Update:     Mar 11, 2020
    Problem:    200. Number of Islands
    Difficulty: Medium
    Source:     https://leetcode.com/problems/number-of-islands/
    
    Notes:
        Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
        An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
        You may assume all four edges of the grid are all surrounded by water.
        
    Examples:
    1.
        Input:
        11110
        11010
        11000
        00000

        Output: 1
    
    2.
        Input:
        11000
        11000
        00100
        00011

        Output: 3
*/

class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        if (grid.length > 0) {
            // Make a copy of grid to leave original grid intact
            // char[][] copy = Arrays.copyOf(grid.length, grid[0].length); // How to make a deep copy of a 2D Array?
        }
        
        // Traverse through g[i][j]
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // put original data in copy
                // copy[i][j] = grid[i][j];
                // if land, increase count;
                if (grid[i][j] == '1') {
                    count++;
                    clearRestOfLand(grid, i, j);
                }
            }
        }
        
        return count;
    }
    
    private void clearRestOfLand(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        clearRestOfLand(grid, i+1, j);
        clearRestOfLand(grid, i-1, j);
        clearRestOfLand(grid, i, j+1);
        clearRestOfLand(grid,i, j-1);
        return;
    }

    // Notes
    // Check this solution for BFS + DFS: https://leetcode.com/problems/number-of-islands/discuss/56338/Java-DFS-and-BFS-solution
}