/*
    Author:     Edmund Trinh, edmund.trinh@gmail.com
    Date:       Apr 13, 2020
    Update:     Apr 13, 2020
    Problem:    141. Linked List Cycle
    Difficulty: Easy
    Source:     https://leetcode.com/problems/linked-list-cycle/
    
    Description:
        Given a linked list, determine if it has a cycle in it.

        To represent a cycle in the given linked list, we use an integer pos which represents the position
        (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
        
    Examples:
    1.
        Input: head = [3,2,0,-4], pos = 1
        Output: true
        Explanation: There is a cycle in the linked list, where tail connects to the second node.
        
    2.
        Input: head = [1,2], pos = 0
        Output: true
        Explanation: There is a cycle in the linked list, where tail connects to the first node.
        
    3.
        Input: head = [1], pos = -1
        Output: false
        Explanation: There is no cycle in the linked list.
        
        Follow up:
            Can you solve it using O(1) (i.e. constant) memory?
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // Short Solution
        /*
        // Current node is null
        // Next null is null
        // both -> false
        if (head == null || head.next == null) {
            return false;
        }
        
        // Self-cycle (loops to itself) -> true
        if (head.next == head) {
            return true;
        }
        
        // Iterate through rest of the nodes
        ListNode nextNode = head.next;
        // Mark current as checked (turn into self-loop)
        head.next = head;
        return hasCycle(nextNode);
        */
        
        // Hash Table Solution (use hash to check if node has been visited before)
        /*
        // Go through each node and save each pointer in hash table
        // If current node is null -> false because reached end => not cyclic
        // If current node ref exists in hash, then there is a cycle
        Set<ListNode> nodes = new HashSet<ListNode>();
        while (head != null) {
            if (nodes.contains(head)) {
                return true;
            } else {
                nodes.add(head);
            }
            // Go to next node
            head = head.next;
        }
        return false;
        */
        
        // Two Pointers Solution
        if (head == null || head.next == null) {
            return false;
        }
        
        ListNode slow = head;
        ListNode fast = head.next;
        // 2 pointers at different speed
        // Slow moves one at a time, fast moves 2 at a time
        // If no cycle in the list, the fast pointer will reach the end and we can return false
        // If there is a cycle
            // Fast will eventually meet the slow
            // When fast is one behind, in the next, they will be on the same one, which means there is a cycle
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}