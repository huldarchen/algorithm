package com.huldar.java.util;

/**
 * 链表
 *
 * @author huldar
 * @date 2019/7/24 10:41
 */
public class IntegerLinkedNode {
    private int val;
    private IntegerLinkedNode next;

    public IntegerLinkedNode(int x) {
        val = x;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public IntegerLinkedNode getNext() {
        return next;
    }

    public void setNext(IntegerLinkedNode next) {
        this.next = next;
    }
}
