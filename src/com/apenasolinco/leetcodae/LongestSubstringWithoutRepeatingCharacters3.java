package com.apenasolinco.leetcodae;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/">Leet 3: Longest Substring Without Repeating Characters</a>
 */
public class LongestSubstringWithoutRepeatingCharacters3 {
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters3 ls3 = new LongestSubstringWithoutRepeatingCharacters3();
        String s;

        // Expected result: 3
        s = "abcabcbb";
        System.out.println(ls3.lengthOfLongestSubstring(s));

        // Expected result: 1
        s = "bbbbb";
        System.out.println(ls3.lengthOfLongestSubstring(s));

        // Expected result: 3
        s = "pwwkew";
        System.out.println(ls3.lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        final Set<Character> seen = new HashSet<>();

        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            while (seen.contains(s.charAt(r))) {
                seen.remove(s.charAt(l));
                l++;
            }

            seen.add(s.charAt(r));
            result = Math.max(result, r - l + 1);
        }

        return result;
    }
}
