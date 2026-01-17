package com.apenasolinco.leetcodae;

import java.text.Collator;

/**
 * <a href="https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/">
 * Leet 28: Find the Index of the First Occurrence in a String
 * </a>
 */
public class FindFirstIndexOfStringOccurence28 {
    public static void main(String[] args) {
        FindFirstIndexOfStringOccurence28 f28 = new FindFirstIndexOfStringOccurence28();
        String needle, haystack;

        // Expected output = 0
        haystack = "sadbutsad";
        needle = "sad";
        System.out.println(f28.strStr(haystack, needle));

        // Expected output = -1
        haystack = "leetcode";
        needle = "leeto";
        System.out.println(f28.strStr(haystack, needle));
    }

    public int strStr(String haystack, String needle) {
        int answer = -1;

        // Navigate the string until the number of characters left is less than needle.length()
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            answer = i;

            for(int j = 0; j < needle.length(); j++) {
                if(haystack.charAt(i + j) != needle.charAt(j)) {
                    answer = -1;
                    break;
                }
            }

            if(answer != -1) return answer;
        }

        return answer;
    }
}
