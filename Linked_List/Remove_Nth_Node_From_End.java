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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // Dummy node helps handle cases where we delete the head node
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Initialize two pointers, both start at the dummy node
        ListNode slow = dummy;
        ListNode fast = dummy;

        // Move the fast pointer n steps ahead
        /*for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }*/
        
        int count = 0;
        while(count!=n+1)
        {
        fast=fast.next;
        count++;
        }

        // Move both pointers until fast reaches the end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Slow pointer is now right before the node to remove
        slow.next = slow.next.next;

        // Return the modified list
        return dummy.next;
    }
}
