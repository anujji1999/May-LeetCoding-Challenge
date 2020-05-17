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
    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = new ListNode(-1);
        ListNode evenHead = new ListNode(-1);
        ListNode oddCurr = oddHead;
        ListNode evenCurr = evenHead;

        while(head != null){
            oddCurr.next = head;
            oddCurr = oddCurr.next;

            head = head.next;

            if(head != null){
                evenCurr.next = head;
                evenCurr = evenCurr.next;
                head = head.next;
            }
        }
        evenCurr.next = null;

        oddCurr.next = evenHead.next;

        return oddHead.next;
        
    }
}