/*
    Author:     Edmund Trinh, edmund.trinh@gmail.com
    Date:       Jun 28, 2020
    Update:     Jun 28, 2020
    Problem:    206. Reverse Linked List
    Difficulty: Easy
    Source:     https://leetcode.com/problems/reverse-linked-list/
    
    Notes:
        Reverse a singly linked list.
        
    Examples:
    1.
        Input: 1->2->3->4->5->NULL
        Output: 5->4->3->2->1->NULL

    Follow up:
        A linked list can be reversed either iteratively or recursively. Could you implement both?
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /*
    // Recursive Solution
    // Time Complexity: O(n) - length of list
    // Space Complexity: O(n) - recursion stack can go up to n levels deep
    public ListNode reverseList(ListNode head) {
        // null cases
        if (head == null || head.next == null) {
            return head;
        }
        
        // start at the node after head
        ListNode end = reverseList(head.next);
        // set next's next = to current (flip the arrow)
        head.next.next = head;
        head.next = null;
        return end;
    }
    */
    
    // Iterative Solution
    // TC: O(n) - length of list
    // SC: O(1) - only saving temp values
    public ListNode reverseList(ListNode head) {
        // Save temps for prev & curr        
        ListNode prev = null;
        ListNode curr = head;
        
        // Until you get to the end
        while(curr != null) {
            // save next temporarily
            ListNode tempNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tempNext;
        }
        return prev;
    }
}