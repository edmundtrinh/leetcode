/*
    Author:     Edmund Trinh, edmund.trinh@gmail.com
    Date:       Oct 27, 2021
    Update:     Oct 27, 2021
    Problem:    94. Binary Tree Inorder Traversal
    Difficulty: Easy
    Source:     https://leetcode.com/problems/binary-tree-inorder-traversal/
    
    Description:
        Given the root of a binary tree, return the inorder traversal of its nodes' values.
        
    Examples:
    1.  
        Input: root = [1,null,2,3]
        Output: [1,3,2]
          
    2.
        Input: root = []
        Output: []
    3.
        Input: root = [1]
        Output: [1]
    4.
        Input: root = [1,2]
        Output: [2,1]
    5.
        Input: root = [1,null,2]
        Output: [1,2]
    
    Constraints:
        * The number of nodes in the tree is in the range [0, 100].
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
    public List<Integer> inorderTraversal(TreeNode root) {
        /*List<Integer> result = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        if (root != null) {
            if (root.left != null) {
                inorderTraversal(root.left);
                stack.push(root.left.val);
            }
            stack.push(root.val);
            if (root.right != null) {
                inorderTraversal(root.right);
                stack.push(root.right.val);
            }
        }
        while (stack.size() > 0) {
            result.add(stack.pop());
        }
        return result;*/
        
        // Iterative Stack Method
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }
        return result;
    }
}