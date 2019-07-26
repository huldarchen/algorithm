package com.huldar.java.day10;


/**
 * 移除链表的倒数第n个元素
 *
 * @author huldar
 * @date 2019/7/24 10:39
 */
public class RemoveNthFromEnd {

    public LinkNode removeNthFromEndDoubleLoop(LinkNode head, int nTh) {
        //思路:给链表添加一个哑巴节点,目的是为了防止极端情况
        LinkNode dummy = new LinkNode(0);
        dummy.next = head;
        //求出链表长度
        int length = 0;
        LinkNode first = head;
        while (first != null) {
            length++;
            first = first.next;
        }
        //要删除的前一个元素的位置
        length -= nTh;

        first = dummy;
        while (length > 0) {
            length--;
            //找到要删除的前一个元素
            first = first.next;
        }
        //将删除的前一个元素的下一个赋值给下下一个
        first.next = first.next.next;

        return dummy.next;
    }

    public LinkNode removeNthFromEndOneLoop(LinkNode head, int n) {
        //安全节点 避免极端情况
        LinkNode dummy = new LinkNode(0);
        dummy.next = head;
        //两个指针
        LinkNode first = dummy;
        LinkNode second = dummy;
        //将第一个指针指向第n+1个元素,使得两个指针之间的具体为n
        for (int i = 0; i <= n + 1; i++) {
            first = first.next;
        }
        //当第一个指针指向最后一个元素时候 第二个指针正好指向第n-1的元素
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        //替换下一个元素
        second.next = second.next.next;
        return dummy.next;
    }

    class LinkNode {
        int value;
        LinkNode next;

        public LinkNode(int value) {
            this.value = value;
        }
    }
}

