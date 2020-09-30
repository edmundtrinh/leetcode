/*
    Author:     Edmund Trinh, edmund.trinh@gmail.com
    Date:       Sep 29, 2020
    Update:     Sep 29, 2020
    Problem:    105. Construct Binary Tree from Preorder and Inorder Traversal
    Difficulty: Medium
    Source:     https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
    
    Description:
        Given preorder and inorder traversal of a tree, construct the binary tree.
        
    Examples:
    1.  
        preorder = [3,9,20,15,7]
        inorder = [9,3,15,20,7]
        
        
        Return the following binary tree [3,9,20,null,null,15,7],
             3
            / \
           9  20
             /  \
            15   7

    Note:
        You may assume that duplicates do not exist in the tree.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }
    
    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        // Check if boundaries of each tree are valid
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        
        // Set root to preorder's first index
        TreeNode root = new TreeNode(preorder[preStart]);
        
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) { // <= because inEnd already 0 index
            if (root.val == inorder[i]) { // make sure values match
                inIndex = i;
            }
        }
        
        // recurse on left and right nodes
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        
        return root;
    }
}