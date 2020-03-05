/*
    Author:     Edmund Trinh, edmund.trinh@gmail.com
    Date:       Mar 4, 2020
    Update:     Mar 4, 2020
    Problem:    104. Maximum Depth of Binary Tree
    Difficulty: Easy
    Source:     https://leetcode.com/problems/maximum-depth-of-binary-tree/
    
    Notes:
        Given a binary tree, find its maximum depth.
        The maximum depth is the number of nodes along the longest path 
            from the root node down to the farthest leaf node.
        A leaf is a node with no children.
        
    Examples:
    1.
        Given binary tree [3,9,20,null,null,15,7],
            3
           / \
          9  20
            /  \
           15   7
       return its depth = 3.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        // Base case: root is null -> return depth = 0
        if (root == null) {
            return 0;
        }
        // Otherwise: add 1 (current node) + the current max depth between left side vs right side
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}