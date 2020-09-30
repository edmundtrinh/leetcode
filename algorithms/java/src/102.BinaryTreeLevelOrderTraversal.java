/*
    Author:     Edmund Trinh, edmund.trinh@gmail.com
    Date:       Sep 29, 2020
    Update:     Sep 29, 2020
    Problem:    102. Binary Tree Level Order Traversal
    Difficulty: Medium
    Source:     https://leetcode.com/problems/binary-tree-level-order-traversal/
    
    Notes:
        Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
        
    Examples:
    1.
        Given binary tree [3,9,20,null,null,15,7],
             3
            / \
           9  20
             /  \
            15   7
        
        return its level order traversal as:
        [
          [3],
          [9,20],
          [15,7]
        ]


    Note:
        N/A
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // Initialize result to return at end
        List<List<Integer>> result = new ArrayList<>();
        // Check edge cases: root node not null -> return empty result
        if (root == null) {
            return result;
        }
        
        // Create queue of TreeNodes for each level
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root); // we know root exists here
        
        // Track each level with a queue
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) { // got error when I didn't save size above... wonder why? -> used queue.size() here
                // Pop first node from queue and add to list
                TreeNode current = queue.remove();
                currentLevel.add(current.val);
                // Check children nodes, add to queue if not null
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
                
            }
            
            // Add currentLevel list to result
            result.add(currentLevel);
        }
            
        return result;
    }
}