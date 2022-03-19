package com.yitu.algorithms._01时间复杂度;

public class Main {
    public static void main(String[] args) {
        System.out.println(fib1(9));
        System.out.println(fib2(9));
    }

    public static int fib1(int n) {
        if (n <= 2) return 1;
        return fib1(n - 1) + fib1(n - 2);
    }

    public static int fib2(int n) {
        if (n <= 2) return 1;
        int first = 1;
        int second = 1;

        for (int i = 2; i < n; i++) {
            int num = first + second;
            first = second;
            second = num;
        }
        return second;
    }
}
