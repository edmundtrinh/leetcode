/*
    Author:     Edmund Trinh, edmund.trinh@gmail.com
    Date:       Oct 27, 2021
    Update:     Oct 27, 2021
    Problem:    700. Search in a Binary Search Tree
    Difficulty: Easy
    Source:     https://leetcode.com/problems/search-in-a-binary-search-tree/
    
    Description:
        You are given the root of a binary search tree (BST) and an integer val.

        Find the node in the BST that the node's value equals val and return the subtree
        rooted with that node. If such a node does not exist, return null.
        
    Examples:
    1.  
        Input: root = [4,2,7,1,3], val = 2
        Output: [2,1,3]
          
    2.
        Input: root = [4,2,7,1,3], val = 5
        Output: []
        Explanation: val not in BST
    
    Constraints:
        * The number of nodes in the tree is in the range [1, 5000].
<<<<<<< HEAD
        * 1 <= Node.val <= 10^7
        * root is a binary search tree.
        * 1 <= val <= 10^7
=======
        * 1 <= Node.val <= 107
        * root is a binary search tree.
        * 1 <= val <= 107
>>>>>>> 08586425e1cf2c5d5015072df76f3b172eb4d178
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
    public TreeNode searchBST(TreeNode root, int val) {
        /*
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }

        while (root != null) {
            TreeNode leftNode = searchBST(root.left, val);
            TreeNode rightNode = searchBST(root.right, val);
            if (leftNode.val == val) {
                return leftNode;
            }
            if (rightNode.val == val) {
                return rightNode;
            }
        }
        */
        
        // Since BST, in-order from left to right
        // Can compare value, determine whether less than, equal than, or greater than
        // If val = root -> return
        // If val < root -> go left
        // If val > root -> go right
        while (root != null) {
            if (val == root.val) {
                return root;
            }
            else if (val < root.val) {
                root = root.left;
            }
            else if (val > root.val) {
                root = root.right;
            }
        }
        return root;
    }
}