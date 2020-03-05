/*
    Author:     Edmund Trinh, edmund.trinh@gmail.com
    Date:       Mar 4, 2020
    Update:     Mar 4, 2020
    Problem:    111. Minimum Depth of Binary Tree
    Difficulty: Easy
    Source:     https://leetcode.com/problems/maximum-depth-of-binary-tree/
    
    Notes:
        Given a binary tree, find its minimum depth.
        The minimum depth is the number of nodes along the shortest path
            from the root node down to the nearest leaf node.
        A leaf is a node with no children.
        
    Examples:
    1.
        Given binary tree [3,9,20,null,null,15,7],
            3
           / \
          9  20
            /  \
           15   7
       return its depth = 2.
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
    public int minDepth(TreeNode root) {
       // Base case: root is null -> return depth = 0
        if (root == null) {
            return 0;
        }
        // 
        if (root.left == null) {
            return 1 + minDepth(root.right);
        }
        // 
        if (root.right == null) {
            return 1 + minDepth(root.left);
        }
        // Otherwise: add 1 (current node) + the current min depth between left side vs right side
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}