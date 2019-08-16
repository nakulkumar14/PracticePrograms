package com.endurance;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class CrazyStack {
    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack stack = new Stack();
        while (n-- != 0) {
            String s = br.readLine();
            String[] split = s.split(" ");
            if (split[0].equals("pop")) {
                stack.pop();
            } else if (split[0].equals("push")) {
                stack.push(Integer.parseInt(split[1]));
            } else {
                Stack newStack = new Stack();
                while (!stack.empty()) {
                    newStack.push(stack.pop());
                }
                int x = Integer.parseInt(split[1]);
                int d = Integer.parseInt(split[2]);

                while (!newStack.empty()) {
                    if (x > 0) {
                        stack.push((int) newStack.pop() + d);
                    } else {
                        stack.push(newStack.pop());
                    }
                    x--;
                }
            }

            if (stack.empty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(stack.peek());
            }
        }
    }
}
