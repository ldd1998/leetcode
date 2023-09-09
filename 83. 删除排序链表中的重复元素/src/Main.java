import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1,new ListNode(1,new ListNode(1,new ListNode(1,new ListNode(1)))));
        Solution.deleteDuplicates(listNode);
    }
    /**
     * Definition for singly-linked list.
     */
      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    static class Solution {
        public static ListNode deleteDuplicates(ListNode head) {
            if (head == null){
                return null;
            }
            ListNode headRes = head;
            Set<Integer> set = new HashSet<>();
            set.add(head.val);
            while (head.next != null){
                if(set.contains(head.next.val)){
                    head.next = head.next.next;
                    if(head == null){
                        return headRes;
                    }
                }else {
                    set.add(head.next.val);
                    head = head.next;
                }
            }
            return headRes;
        }
    }
}