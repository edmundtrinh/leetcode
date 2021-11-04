/*
    Author:     Edmund Trinh, edmund.trinh@gmail.com
    Date:       Nov 3, 2021
    Update:     Nov 3, 2021
    Problem:    2. Add Two Numbers
    Difficulty: Medium <- felt like a hard... rip
    Source:     https://leetcode.com/problems/add-two-numbers/
    
    Description:
        You are given two non-empty linked lists representing two non-negative integers.
        The digits are stored in reverse order, and each of their nodes contains a single digit.
        Add the two numbers and return the sum as a linked list.

        You may assume the two numbers do not contain any leading zero, except the number 0 itself.
        
    Examples:
    1.  
        Input: l1 = [2,4,3], l2 = [5,6,4]
        Output: [7,0,8]
        Explanation: 342 + 465 = 807.
          
    2.
        Input: l1 = [0], l2 = [0]
        Output: [0]
    3.
        Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
        Output: [8,9,9,9,0,0,0,1]
    
    Constraints:
        * The number of nodes in each linked list is in the range [1, 100].
        * 0 <= Node.val <= 9
        * It is guaranteed that the list represents a number that does not have leading zeros.
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = null;
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        ListNode curr3 = null;
        boolean carry = false;
        if (l1 == null || l2 == null) {
            return null;
        }
        while (curr1 != null || curr2 != null) {
            int temp = 0;
            if (l3 == null) {
                l3 = new ListNode();
                curr3 = l3;
            } else {
                curr3 = curr3.next;
            }
            if (carry) {
                temp++;
                carry = false;
            }
            if (curr1 != null) {
                temp += curr1.val;
                curr1 = curr1.next;
            }
            if (curr2 != null) {
                temp += curr2.val;
                curr2 = curr2.next;
            }
            int mod = temp % 10;
            int carryVal = temp / 10;
            if (carryVal > 0) {
                carry = true;
            }
            curr3.val = mod;
            if (curr1 != null || curr2 != null) {
                curr3.next = new ListNode();
            }
        }
        if (carry) {
            curr3.next = new ListNode(1);
        }
        return l3;
    }
}