package com.apenasolinco.leetcodae;

/**
 * <a href="https://leetcode.com/problems/add-two-numbers/description/">Leet 2: Add Two Numbers</a>
 */
public class AddTwoNumbers2 {
    public static void main(String[] args) {
        AddTwoNumbers2 atn2 = new AddTwoNumbers2();
        ListNode l1, l2;
        ListNode result;

        // Expected result: [7, 0, 8]
        l1 = newListFrom(2, 4, 3);
        l2 = newListFrom(5, 6, 4);
        result = atn2.addTwoNumbers(l1, l2);
        printResult(result);

        // Expected result: [8, 9, 9, 9, 0, 0, 0, 1]
        l1 = newListFrom(9, 9, 9, 9, 9, 9, 9);
        l2 = newListFrom(9, 9, 9, 9);
        result = atn2.addTwoNumbers(l1, l2);
        printResult(result);
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

    private static void printResult(ListNode result) {
        System.out.print("result = [ ");

        while (result != null) {
            System.out.print(result.val + (result.next == null ? "" : ", "));
            result = result.next;
        }

        System.out.println(" ]");
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode resultHead = result;

        // Using a human-like way to sum: when summing two values of equal
        // decimal value, an exceeding value can be carried to the next node
        int carry = 0;
        while (l1 != null || l2 != null) {
            result.next = new ListNode();
            result = result.next;

            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            result.val = sum % 10;
            carry = sum / 10;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // The loop can exit with a remaining carry, so we have to add it manually:
        if (carry > 0) result.next = new ListNode(carry);

        return resultHead.next;
    }

    /* Definition for singly-linked list. */
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
