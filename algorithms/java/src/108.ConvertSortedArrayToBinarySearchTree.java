/*
    Author:     Edmund Trinh, edmund.trinh@gmail.com
    Date:       Mar 18, 2020
    Update:     Mar 18, 2020
    Problem:    108. Convert Sorted Array to BST
    Difficulty: Easy
    Source:     https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
    
    Description:
        Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
        For this problem, a height-balanced binary tree is defined as a binary tree in which the depth
        of the two subtrees of every node never differ by more than 1.
    
    Notes:
        
    Examples:
        Given the sorted array: [-10,-3,0,5,9],

        One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

              0
             / \
           -3   9
           /   /
         -10  5
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
    public TreeNode sortedArrayToBST(int[] nums) {
        // Base Cases
        if (nums.length == 0 || nums == null) {
            return null;
        }
        
        // Use helper method to create BST
        TreeNode root = makeBST(nums, 0, nums.length - 1);
        return root;
    }
    
    private TreeNode makeBST(int[] nums, int low, int high) {
        // Stop when low > high
        if (low > high) {
            return null;
        }
        
        // find mid point
        int mid = (high - low) / 2 + low;
        TreeNode curr = new TreeNode(nums[mid]);
        // recurse on left
        curr.left = makeBST(nums, low, mid - 1);
        // recurse on right
        curr.right = makeBST(nums, mid + 1, high);
        return curr;
    }
}