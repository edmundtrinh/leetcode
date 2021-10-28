/*
    Author:     Edmund Trinh, edmund.trinh@gmail.com
    Date:       Oct 27, 2021
    Update:     Oct 27, 2021
    Problem:    104. Maximum Depth of Binary Tree
    Difficulty: Easy
    Source:     https://leetcode.com/problems/maximum-depth-of-binary-tree/
    
    Description:
        Given the root of a binary tree, return its maximum depth.

        A binary tree's maximum depth is the number of nodes along the longest path
        from the root node down to the farthest leaf node.
        
    Examples:
    1.  
        Input: root = [3,9,20,null,null,15,7]
        Output: 3
          
    2.
        Input: root = [1,null,2]
        Output: 2
    3.
        Input: root = []
        Output: 0
    4.
        Input: root = [0]
        Output: 1
    
    Constraints:
        * The number of nodes in the tree is in the range [0, 10^4].
        * -100 <= Node.val <= 100
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
class Solution {
    public int maxDepth(TreeNode root) {
        // If node @ current level exists, +1 to depth
        // If current depth > max depth -> max depth = curr depth
        return maxDepthHelper(root, 0);
    }
    
    public int maxDepthHelper(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        depth++;
        return Math.max(maxDepthHelper(root.left, depth), maxDepthHelper(root.right, depth));
    }
}