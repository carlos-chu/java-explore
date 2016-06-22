package org.learning.algorithm.algorithm;

/**
 * @ClassName: LinkNode
 * @Description: 链表相关的
 * @author carlos.chu
 * @date 2016年6月16日 下午2:01:58
 *
 */
public class LinkNodeOpt {

    static class LinkNode {
        int value;
        LinkNode next;

        public LinkNode(int value) {
            this.value = value;
            this.next = null;
        }

        @Override
        public String toString() {
            return "[value=" + value + ", next=" + next + "]";
        }
    }

    // 求单链表节点的个数
    public static int getLength(LinkNode node) {
        int len = 1;
        while (node.next != null) {
            len++;
            node = node.next;
        }
        return len;
    }

    // 反转-循环
    public static LinkNode reverseList(LinkNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkNode prev = null;
        while (head != null) {
            LinkNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    // 查找链表中倒数第K个节点
    public static LinkNode getKthNode(LinkNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int len = getLength(head);
        if (k > len) {
            return null;
        }
        LinkNode target = head;
        LinkNode next = null;
        for (int i = 0; i < k; i++) {
            next = next.next;
        }
        while (next != null) {
            target = target.next;
            next = next.next;
        }
        return target;
    }

    public static LinkNode getMiddle(LinkNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkNode target = head;
        LinkNode fast = head;
        while (fast != null && fast.next != null) {
            target = target.next;
            fast = fast.next.next;
        }
        return target;
    }

    public static void insertNode(LinkNode head, LinkNode node, int index) {
        if (index < 0) {
            throw new IllegalArgumentException("参数错误！");
        }
        LinkNode temp = head;

        if (index > getLength(head)) {
            while (head.next != null) {
                head = head.next;
            }
        } else {
            for (int i = 1; i < index - 1; i++) {
                head = head.next;
            }
        }
        LinkNode next = head.next;
        head.next = node;
        node.next = next;
        itertor(temp);
    }

    public static void itertor(LinkNode head) {
        if (head == null) {
            return;
        }
        itertor(head.next);
        System.out.println(head);
    }

    public static void main(String[] args) {
        LinkNode node1 = new LinkNode(1);
        LinkNode node2 = new LinkNode(2);
        LinkNode node3 = new LinkNode(3);
        node1.next = node2;
        node2.next = node3;

        System.out.println("取得中间元素：" + getMiddle(node1));

        insertNode(node1, new LinkNode(4), 4);
    }

}