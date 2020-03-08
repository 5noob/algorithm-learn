package com.me.stack;

import java.util.Stack;

/**
 * @author: create by Rhine
 * @date:2020/3/8 10:50
 * @description: 最小栈 leetcode 155 https://leetcode-cn.com/problems/min-stack/
 */
public class MinStack {
    private Stack<Integer> dataStack;
    private Stack<Integer> helperStack;

    public MinStack() {
        dataStack = new Stack<>();
        helperStack = new Stack<>();
    }

    public void push(int x) {
        dataStack.push(x);
        if(helperStack.isEmpty() || helperStack.peek() >= x){
            helperStack.add(x);
        }
    }

    public void pop() {
        if(!dataStack.isEmpty()){
            int top = dataStack.pop();
            if(top == helperStack.peek()){
                helperStack.pop();
            }
        }
    }

    public int top() {
        if(!dataStack.isEmpty()){
            return dataStack.peek();
        }

        throw new RuntimeException("栈中元素为空");
    }

    public int getMin() {
        if(!helperStack.isEmpty()){
            return helperStack.peek();
        }

        throw new RuntimeException("栈中元素为空");
    }
}
