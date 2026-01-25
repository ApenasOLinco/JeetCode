package com.apenasolinco.leetcodae;

public class AddBinary67 {
    public static void main(String[] args) {
        final AddBinary67 ab67 = new AddBinary67();

        // Expected result: 100
        System.out.println(ab67.addBinary("11", "1"));

        // Expected result: 10101
        System.out.println(ab67.addBinary("1010", "1011"));

        // Expected result: 0
        System.out.println(ab67.addBinary("0", "0"));
    }

    public String addBinary(String a, String b) {
        int longest = Math.max(a.length(), b.length());

        // Since the sum can have an additional decimal space, we take it into account when sizing the resulting String
        char[] result = new char[longest + 1];
        int carry = 0;

        for (int i = 0; i < result.length; i++) {
            int numA = 0, numB = 0;
            if (a.length() - 1 - i >= 0) numA = a.charAt(a.length() - 1 - i) - '0';
            if (b.length() - 1 - i >= 0) numB = b.charAt(b.length() - 1 - i) - '0';
            result[longest - i] = Character.forDigit((numA + numB + carry) % 2, 10);
            carry = (numA + numB + carry) / 2;
        }

        String resultStr = String.valueOf(result);
        return resultStr.replaceFirst("^0", "");
    }
}
