/*
    Author:     Edmund Trinh, edmund.trinh@gmail.com
    Date:       Apr 23, 2020
    Update:     Apr 23, 2020
    Problem:    83. Remove Duplicates from Sorted List
    Difficulty: Easy
    Source:     https://leetcode.com/problems/remove-duplicates-from-sorted-list/
    
    Notes:
        Given a sorted linked list, delete all duplicates such that each element appear only once.
        
    Examples:
    1.
        Input: 1->1->2
        Output: 1->2
    
    2.
        Input: 1->1->2->3->3
        Output: 1->2->3
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode curr = head;
        // Always check 2 at a time for comparison
        // Base case current not null and next also not null
        while (curr != null && curr.next != null) {
            if (curr.next.val == curr.val) {
                curr.next = curr.next.next;
            // Go to next node
            } else {
                curr = curr.next;
            }
        }
        return head;
    }
}