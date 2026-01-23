package com.apenasolinco.leetcodae;

public class LengthOfLastWord58 {
    public static void main(String[] args) {
        LengthOfLastWord58 l58 = new LengthOfLastWord58();

        // Expected result: 5
        System.out.println(l58.lengthOfLastWord("Hello World"));

        // Expected result: 4
        System.out.println(l58.lengthOfLastWord("   fly me   to   the moon  "));

        // Expected result: 6
        System.out.println(l58.lengthOfLastWord("luffy is still joyboy"));

        // Expected result: 1
        System.out.println(l58.lengthOfLastWord("a"));

        // Expected result: 3
        System.out.println(l58.lengthOfLastWord("day"));
    }

    public int lengthOfLastWord(String s) {
        int l = -1, r = s.length() - 1;

        while (r >= 0) {
            if (s.charAt(r) == ' ') {
                r--;
                continue;
            }

            l = r - 1;
            while (l >= 0 && s.charAt(l) != ' ') {
                l--;
            }

            break;
        }

        return r - l;
    }
}
