package org.learning.datastructure.linkedlist;

/**
 * @ClassName: LinkedList
 * @Description: 链表操作
 * @author carlos.chu
 * @date 2016年5月27日 下午5:39:27
 *
 */
public class LinkedList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;

        System.out.println(reverse(l1));

        System.out.println(findMiddle(l1));
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static ListNode findMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

class ListNode {
    ListNode next;
    int value;

    ListNode(int x) {
        value = x;
    }

    @Override
    public String toString() {
        return "[next=" + next + ",value=" + value + "]";
    }
}
