package com.demo.algorithm.run;

/*
链表反转
 */
class LinkReversal {
    public static void main(String[] args) {

    }

//迭代的方式


    public static Node iterate(Node head) {

        if (head == null)
            return head;

        Node prev = head;
        Node cur = head.next;

        Node tmp;

        while (cur != null) {
             tmp = cur.next;
             cur.next = prev;
             prev = cur;
             cur = tmp;
        }
        head.next = null;
        return prev;
    }


    class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }


}
