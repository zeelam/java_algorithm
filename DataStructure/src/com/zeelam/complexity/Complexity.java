package com.zeelam.complexity;

public class Complexity {

    public static void main(String[] args) {

        System.out.println(fibRecursion(10));
        System.out.println(fibLoop(10));

        //when the n get bigger, recursion method will meet performance problem
//        System.out.println(fibRecursion(64));
        System.out.println(fibLoop(64));
    }

    /**
     * fibonacci sequence recursion method
     * @param n
     * @return
     */
    public static int fibRecursion(int n) {
        if (n == 1 || n == 2){
            return 1;
        }
        // O(2^n)
        return fibRecursion(n-1) + fibRecursion(n - 2);
    }

    /**
     * fibonacci sequence loop method
     * @param n
     * @return
     */
    public static int fibLoop(int n) {
        if (n <= 0) {
            return -1;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int first = 1;
        int second = 1;
        int current = second;
        // O(n)
        for (int i = 3; i <= n; i++) {
            current = first + second;
            first = second;
            second = current;
        }
        return current;
    }

    public static void test1(int n){
        // 1
        if (n > 10){
            System.out.println("n > 10");
        } else if(n > 5) {
            System.out.println("n > 5");
        } else {
            System.out.println("n <= 5");
        }

        // 1 + 4 + 4 + 4
        for (int i = 0; i < 4; i++) {
            System.out.println("test");
        }

        // total = 14 -> O(1)

    }

    public static void test2(int n) {
        // 1 + n + n + n -> O(n)
        for (int i = 0; i < n; i++) {
            System.out.println("Test");
        }
    }

    public static void test3(int n) {
        // 1 + 2n + n * (1 + 3n) -> O(n^2)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("Test");
            }
        }
    }

    public static void test4(int n) {
        // 1 + 2n + n * (46) -> O(n)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 15; j++) {
                System.out.println("Test");
            }
        }
    }

    public static void test5(int n) {
        // log2(n) -> O(log(n))
        while ((n = n / 2) > 0) {
            System.out.println("Test");
        }
    }

    public static void test6(int n) {
        // log5(n) -> O(log(n))
        while((n = n / 5) > 0) {
            System.out.println("Test");
        }
    }

    public static void test7(int n) {
        // 1 + 2 * log2(n) + log2(n) * (1 + 3n) -> O(nlog(n))
        for (int i = 1; i < n; i += i) {
            // 1 + 3n
            for (int j = 0; j < n; j++) {
                System.out.println("Test");
            }
        }
    }

    /**
     * O(1) < O(logn) < O(n) < O(nlogn) < O(n^2) < O(n^3) < O(2^n) < O(n!) < O(n^n)
     */

}
