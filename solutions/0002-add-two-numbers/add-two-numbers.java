// You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
//
// You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//
// Example:
//
//
// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8
// Explanation: 342 + 465 = 807.
//
//


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
        ListNode retList = null;
        ListNode iterList = null;
        boolean flag = false;
        int temp;
        int count;
        
        while(true){
            temp = 0;
            count = 0;
            if(l1 != null){
                temp += l1.val;
                l1 = l1.next;
            }
            else count++;
            if(l2 != null){
                temp += l2.val;
                l2 = l2.next;
            }
            else count++;
            if(flag)
                temp++;
            
            if(count == 2 && temp == 0)
                break;
            
            if(temp >= 10){
                temp -= 10;
                flag = true;
            }
            else flag = false;
            if(iterList == null){
                retList = new ListNode(temp);
                iterList = retList;
            }
            else{
                iterList.next = new ListNode(temp);
                iterList = iterList.next;
            }
        }
        
        return retList;
    }
}
