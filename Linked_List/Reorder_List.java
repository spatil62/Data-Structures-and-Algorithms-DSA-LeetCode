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
    public void reorderList(ListNode head) {
        
        // Step 1: Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        //tortoise and hare algorithm will give us exact mid because 
        //slow pointer move one and fast by two so it will be twice as 
        //dist as slow 
        while (fast != null && fast.next != null) {
            slow = slow.next;       // Move slow by 1
            fast = fast.next.next;  // Move fast by 2
        }



        // Step 2: Reverse the second half of the list
        ListNode prev = null;
        ListNode current = slow; // Start from the middle
        while (current != null) {
            ListNode temp = current.next; // Store the next node
            current.next = prev;           // Reverse the link
            prev = current;                // Move prev forward
            current = temp;                // Move to next node
        }

        ListNode secondHalf = prev; // This is the head of the reversed second half

        // Step 3: Merge the two halves
        ListNode firstHalf = head;

        // We can also use a temporary pointer for easier manipulation
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (firstHalf != null && secondHalf != null) {

             // Link curr to firstHalf and move curr forward
            curr.next = firstHalf;
            curr = curr.next;
            firstHalf = firstHalf.next;

            // Link curr to secondHalf and move curr forward
            curr.next = secondHalf;
            curr = curr.next;
            secondHalf = secondHalf.next;
                

            /*temp1 = firstHalf.next; // Store next node of first half
            temp2 = secondHalf.next; // Store next node of reversed second half

            firstHalf.next = secondHalf; // Link from the first half to the second half
            secondHalf.next = temp1;      // Link back to the next node in the first half

            firstHalf = temp1; // Move to the next node in the first half
            secondHalf = temp2; // Move to the next node in the reversed half*/
        }

        // Set the last node's next to null to avoid cycles
        curr.next = null;
    }
}

