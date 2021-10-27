/*
    Author:     Edmund Trinh, edmund.trinh@gmail.com
    Date:       Oct 27, 2021
    Update:     Oct 27, 2021
    Problem:    993. Cousins in Binary Tree
    Difficulty: Easy
    Source:     https://leetcode.com/problems/cousins-in-binary-tree/
    
    Description:
        Given the root of a binary tree with unique values and the values of two different nodes           of the tree x and y, return true if the nodes corresponding to the values
        x and y in the tree are cousins, or false otherwise.

        Two nodes of a binary tree are cousins if they have the same depth with different parents.

        Note that in a binary tree, the root node is at the depth 0,
        and children of each depth k node are at the depth k + 1.
        
    Examples:
    1.  
        Input: root = [1,2,3,4], x = 4, y = 3
        Output: false
        Explanation: different depths
          
    2.
        Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
        Output: true
        Explanation: depths are same, parents are different
    3.
        Input: root = [1,2,3,null,4], x = 2, y = 3
        Output: false
        Explanation: same parent
    
    Constraints:
        * The number of nodes in the tree is in the range [2, 100].
        * 1 <= Node.val <= 100
        * Each node has a unique value.
        * x != y
        * x and y are exist in the tree.
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
    public boolean isCousins(TreeNode root, int x, int y) {
        // depthX == depthY && parentX != parentY -> true
        // depthX != depthY -> false
        // parentX == parentY -> false
        if(root.val == x || root.val == y) return false;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        boolean xFound = false;
        boolean yFound = false;
        
        int parentX = 0;
        int parentY = 0;
        
        while (!queue.isEmpty() && !xFound && !yFound) {
            int size = queue.size();
            
            while (size-- > 0) {
                TreeNode current = queue.remove();
                
                if (current.left != null) {
                    queue.add(current.left);
                    
                    if (current.left.val == x) {
                        parentX = current.val;
                        xFound = true;
                    }
                    if (current.left.val == y) {
                        parentY = current.val;
                        yFound = true;
                    }
                }
                if (current.right != null) {
                    queue.add(current.right);
                    
                    if (current.right.val == x) {
                        parentX = current.val;
                        xFound = true;
                    }
                    if (current.right.val == y) {
                        parentY = current.val;
                        yFound = true;
                    }
                }
                
            }
        }
        
        return xFound && yFound && parentX != parentY;
    }
}
        
        /*
        // depthX == depthY && parentX != parentY -> true
        // depthX != depthY -> false
        // parentX == parentY -> false
        int depth = 0;
        boolean isCousins = false;
        return isCousinsDepth(root, x, y, depth, isCousins);
        
    }
    
    public boolean isCousinsDepth(TreeNode current, int x, int y, int depth, boolean isCousins) {
        TreeNode parentX = null;
        TreeNode parentY = null;
        while (current != null) {
            if (current.left != null || current.right != null) {
                if (current.left == x || current.right == x) {
                    parentX = current;
                }
                if (current.left == y || current.right == y) {
                    parentY = current;
                }
                if (parentX == parentY) {
                    return false;
                }
                depth++;
                isCousins = isCousins(current.left, x, y, depth, isCousins);
                isCousins = isCousins(current.right, x, y, depth, isCousins);
            }            
        }
        return isCousins;
    }*/