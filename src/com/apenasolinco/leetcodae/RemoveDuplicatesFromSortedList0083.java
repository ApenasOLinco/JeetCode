package com.apenasolinco.leetcodae;

/**
 * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list/">Leet 83: Remove Duplicates From Sorted List</a>
 */
public class RemoveDuplicatesFromSortedList0083 {
    public static void main(String[] args) {
        final RemoveDuplicatesFromSortedList0083 rm83 = new RemoveDuplicatesFromSortedList0083();
        ListNode result;

        // Expected result: [ 1, 2 ]
        result = rm83.deleteDuplicates(newListFrom(1, 1, 2));
        printResult(result);

        // Expected result: [ 1, 2, 3 ]
        result = rm83.deleteDuplicates(newListFrom(1, 1, 2, 3, 3));
        printResult(result);

        // Expected result: [ 1 ]
        result = rm83.deleteDuplicates(newListFrom(1));
        printResult(result);
    }

    private static void printResult(ListNode head) {
        System.out.print("[ ");
        while (head != null) {
            System.out.print(head.val + (head.next == null ? " " : ", "));
            head = head.next;
        }
        System.out.println("]");
    }

    private static ListNode newListFrom(int... nums) {
        ListNode result = new ListNode();
        ListNode resultHead = result;

        for (int num : nums) {
            result.next = new ListNode();
            result = result.next;
            result.val = num;
        }

        return resultHead.next;
    }

    public ListNode deleteDuplicates(ListNode head) {
        final ListNode result = head;

        int currentValue;
        while (head != null) {
            currentValue = head.val;

            ListNode nextNode = head.next;

            while (nextNode != null && nextNode.val == currentValue)
                nextNode = nextNode.next;

            head.next = nextNode;
            head = head.next;
        }

        return result;
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
    }

}
