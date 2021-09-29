package com.yitu.leetcode.字符串;


/**
 * https://leetcode-cn.com/problems/add-binary/
 */
public class _67_二进制求和 {
    public String addBinary(String a, String b) {
        char[] shortChars;
        char[] longChars;
        if (a.length() < b.length()) {
            shortChars = a.toCharArray();
            longChars = b.toCharArray();
        } else {
            shortChars = b.toCharArray();
            longChars = a.toCharArray();
        }
        for (int i = shortChars.length - 1; i >= 0; i--) {
            int distance = longChars.length - shortChars.length;
            if (shortChars[i] == '1' && longChars[i + distance] == '1') {
                longChars[i + distance] = '0';
                int index = i + distance - 1;
                while (index >= 0 && longChars[index] == '1') {
                    longChars[index] = '0';
                    index--;
                }
                if (index < 0) {
                    char[] newLongChars = new char[longChars.length + 1];
                    for (int j = 0; j < longChars.length; j++) {
                        newLongChars[j + 1] = longChars[j];
                    }
                    newLongChars[0] = '1';
                    longChars = newLongChars;
                } else {
                    longChars[index] = '1';
                }
            } else if (shortChars[i] == '0' && longChars[i + distance] == '0') {

            } else {
                longChars[i + distance] = '1';
            }
        }
        return new String(longChars);
    }

    public static void main(String[] args) {
        String s = new _67_二进制求和().addBinary("1111", "1111");
        System.out.println(s);
    }
}
