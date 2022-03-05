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
        if(head == null || head.next==null)return head;
        ListNode oddHead=head,oddTail = head;
        ListNode evenHead=head.next,evenTail = head.next;
        ListNode curr = head.next.next;
        oddTail.next=null;
        evenTail.next=null;
        int i=1;
        while(curr!=null){
            ListNode next=curr.next;
            if(i%2==1){
                oddTail.next=curr;
                oddTail=oddTail.next;
                oddTail.next=null;
            }else{
                evenTail.next=curr;
                evenTail=evenTail.next;
                evenTail.next=null;
            }
            curr=next;
            i++;
        }
        oddTail.next=evenHead;
        return oddHead;
    }
}
