#!usr/bin/env python
# -*- coding:utf-8 _*-
"""
@author:huldar
@file: RemoveNthFromEnd.py
@time: 2019/07/24
"""


class ListNode:
    def __init__(self, x):
        self.value = x
        self.next = None


class Solution:
    def remove_nth_from_end(self, head: ListNode, n: int) -> ListNode:
        dummy = ListNode(0)
        dummy.next = head
        first, second = dummy
        i = 0
        while i < n + 1:
            first = first.next
            i += 1

        while first:
            first = first.next
            second = second.next
        second.next = second.next.next
        return dummy.next

    def remove_nth_from_end_use_array(self, head: ListNode, n: int) -> ListNode:
        dummy = ListNode(0)
        dummy.next = head
        temp_list = []
        while dummy:
            temp_list.append(dummy)
            dummy = dummy.next
        temp_list[-n - 1].next = temp_list[-n - 1].next.next
        return temp_list[0].next


if __name__ == '__main__':
    head = ListNode(1)
    second = ListNode(2)
    three = ListNode(3)
    four = ListNode(4)
    five = ListNode(5)
    head.next = second
    second.next = three
    three.next = four
    four.next = five
    s = Solution()
    # head = s.remove_nth_from_end(head=head, n=2)
    # temp = head
    #
    # while temp:
    #     print(temp.value)
    #     temp = temp.next

    head = s.remove_nth_from_end_use_array(head=head, n=2)
    temp = head
    while temp:
        print(temp.value)
        temp = temp.next
