package com.practice;

import java.util.Arrays;
import java.util.Stack;

// https://www.geeksforgeeks.org/next-greater-element/
public class NextGreaterElement {

    public static void main(String[] args) {
        NextGreaterElement o = new NextGreaterElement();
        int a[] = {4, 5, 2, 25};
        int b[] = {13, 7, 6, 12};
//        System.out.println(Arrays.toString(o.nextGreaterElement(a)));
//        System.out.println(Arrays.toString(o.nextGreaterElement(b)));
        int c[] = {1, 2, 1};
        System.out.println(Arrays.toString(o.nge(c)));
    }

    public int[] nge(int a[]) {
        int res[] = new int[a.length];
        Stack stack = new Stack();

        // For last element NGE = -1.
        // res[a.length-1] = -1;
        // stack.push(a[a.length-1]);

        for (int i = 2 * a.length - 1; i >= 0; i--) {

            // If current element is greater than top element on stack
            // Remove elements from stack till element on stack is less than current element.
            while (!stack.empty() && a[i % a.length] >= a[(Integer) stack.peek()]) {
                stack.pop();
            }

            // If stack is not empty, put top element from stack else -1.
            res[i % a.length] = !stack.empty() ? a[(Integer) stack.peek()] : -1;

            // Insert current element on stack.
            stack.push(i % a.length);
        }
        return res;
    }

    public int[] nextGreaterElement(int[] a) {
        int res[] = new int[a.length];
        Stack stack = new Stack();

        // For last element NGE = -1.
        res[a.length - 1] = -1;
        stack.push(a[a.length - 1]);

        for (int i = a.length - 2; i >= 0; i--) {

            // If current element is greater than top element on stack
            // Remove elements from stack till element on stack is less than current element.
            if (!stack.empty() && a[i] > (int) stack.peek()) {
                while (!stack.empty() && a[i] > (int) stack.peek()) {
                    stack.pop();
                }
            }
            // If stack is not empty, put top element from stack else -1.
            res[i] = !stack.empty() ? (int) stack.peek() : -1;

            // Insert current element on stack.
            stack.push(a[i]);
        }
        return res;
    }
}
