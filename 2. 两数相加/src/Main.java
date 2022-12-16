/**
 * @author ldd
 */
public class Main {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(new int[]{2, 4, 3});
        ListNode l2 = new ListNode(new int[]{5, 6, 4});
        Solution.addTwoNumbers(l1, l2);
    }

    static class Solution {
        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode l3 = new ListNode();
            ListNode resNode = l3;
            while (true) {
                if (l1 != null && l2 != null) {
                    // 尾插法
                    l3.next = new ListNode(l1.val + l2.val);
                    l3 = l3.next;
                } else if (l1 != null && l2 == null) {
                    l3.next = l1;
                    return dealCarry(resNode.next);
                } else if (l1 == null && l2 != null) {
                    l3.next = l2;
                    return dealCarry(resNode.next);
                } else {
                    return dealCarry(resNode.next);
                }
                l1 = l1.next;
                l2 = l2.next;
            }
        }

        public static ListNode dealCarry(ListNode listNode) {
            ListNode listNode1 = listNode;
            while (listNode != null) {
                if (listNode.val >= 10) {
                    listNode.val = listNode.val - 10;
                    if (listNode.next != null) {
                        listNode.next.val += 1;
                    } else {
                        listNode.next = new ListNode(1);
                    }
                }
                listNode = listNode.next;
            }
            return listNode1;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        ListNode(int[] values) {
            ListNode l1 = new ListNode();
            ListNode l2 = l1;
            for (int i = 0; i < values.length; i++) {
                l1.next = new ListNode(values[i]);
                l1 = l1.next;
            }
            l2 = l2.next;
            this.val = l2.val;
            this.next = l2.next;
        }
    }
}