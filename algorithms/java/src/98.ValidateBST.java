/*
    Author:     Edmund Trinh, edmund.trinh@gmail.com
    Date:       Oct 2, 2020
    Update:     Oct 2, 2020
    Problem:    98. Validate Binary Search Tree
    Difficulty: Medium
    Source:     https://leetcode.com/problems/validate-binary-search-tree/
    
    Description:
        Given a binary tree, determine if it is a valid binary search tree (BST).

        Assume a BST is defined as follows:

        The left subtree of a node contains only nodes with keys less than the node's key.
        The right subtree of a node contains only nodes with keys greater than the node's key.
        Both the left and right subtrees must also be binary search trees.
        
    Examples:
    1.  
            2
           / \
          1   3

        Input: [2,1,3]
        Output: true
          
    2.
            5
           / \
          1   4
             / \
            3   6

        Input: [5,1,4,null,null,3,6]
        Output: false
        Explanation: The root node's value is 5 but its right child's value is 4.
    
    Note:
        You may assume that duplicates do not exist in the tree.
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
    // Initialized once for the whole solution
    Stack<TreeNode> stack = new Stack<TreeNode>();
    
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        helper(root);
        
        // Check stack to make sure valid order
        TreeNode curr = stack.pop();
        System.out.println("Curr: " + curr.val);
        while (!stack.empty() && stack.peek() != null) {
            TreeNode next = stack.pop();
            System.out.println("Next: " + next.val);
            if (next.val <= curr.val) {
                return false;
            }
            // Update curr to next to iterate through BST
            curr = next;
        }
        return true;
    }
    
    public void helper(TreeNode root) {
        if (root != null) {
            // Right
            if (root.right != null) {
                helper(root.right);
            }
            // Parent
            stack.push(root);
            // Left
            if (root.left != null) {
                helper(root.left);
            }
        }
    }
    
    // Recursive Method - note: not working
    /*public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        int original = root.val;
        return helper(root, original);
    }
    
    public boolean helper(TreeNode root, int original) {
        // root is null -> true
        if (root == null) {
            return true;
        }
        // if root != null but left and right children are null -> true
        // if left child < root -> true
        // if right child > root -> true
        if (root.left == null || (root.left.val < root.val && root.left.val < original)) {
            if (root.right == null || (root.right.val > root.val && root.right.val > original)) {
                return ((helper(root.left, original) == true) && (helper(root.right, original) == true));
            }
        }
        return false;
    }*/
}