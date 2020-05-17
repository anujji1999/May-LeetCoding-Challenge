/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* oddEvenList(ListNode* head) {
        ListNode *oddHead = new ListNode(-1);
        ListNode *evenHead = new ListNode(-1);
         ListNode *oddCurr = oddHead;
        ListNode *evenCurr = evenHead;

        while(head != NULL){
            oddCurr->next = head;
            oddCurr = oddCurr->next;

            head = head->next;

            if(head != NULL){
                evenCurr->next = head;
                evenCurr = evenCurr->next;
                head = head->next;
            }
        }
        evenCurr->next = NULL;

        oddCurr->next = evenHead->next;
        return oddHead->next;
    }
};