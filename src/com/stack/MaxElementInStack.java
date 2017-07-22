package com.stack;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by nakul on 22/7/17.
 *
 * http://www.geeksforgeeks.org/tracking-current-maximum-element-in-a-stack/
 */
public class MaxElementInStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> maxStack = new Stack<>();

    void push(int data){
        stack.push(data);
        if (maxStack.empty()){
            maxStack.push(data);
        }else if (maxStack.peek() < data){
            maxStack.push(data);
        }else{
            maxStack.push(maxStack.peek());
        }
    }

    int getMax(){
        return maxStack.peek();
    }

    void printStack(){
        Iterator<Integer> iterator = stack.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
    }

    void printMaxStack(){
        Iterator<Integer> iterator = maxStack.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
    }

    public static void main(String[] args) {
        MaxElementInStack maxElementInStack = new MaxElementInStack();
        // 4, 2, 14, 1, 18
        maxElementInStack.push(4);
        System.out.println(maxElementInStack.getMax());

        maxElementInStack.push(2);
        System.out.println(maxElementInStack.getMax());

        maxElementInStack.push(14);
        System.out.println(maxElementInStack.getMax());

        maxElementInStack.push(1);
        System.out.println(maxElementInStack.getMax());

        maxElementInStack.push(18);
        System.out.println(maxElementInStack.getMax());

        System.out.print("Stack : ");
        maxElementInStack.printStack();
        System.out.println();

        System.out.print("Max stack : ");
        maxElementInStack.printMaxStack();
    }
}
