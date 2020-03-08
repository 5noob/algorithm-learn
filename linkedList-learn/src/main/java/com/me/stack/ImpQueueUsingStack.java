package com.me.stack;

import java.util.Stack;

/**
 * @author: create by Rhine
 * @date:2020/3/8 16:58
 * @description: 使用栈实现一个队列 leetcode 232 https://leetcode-cn.com/problems/implement-queue-using-stacks/
 */
public class ImpQueueUsingStack {
    private int front;
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    /** Initialize your data structure here. */
    public ImpQueueUsingStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if(s1.isEmpty()){
            front = x;
        }

        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }

        return s2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(!s2.isEmpty()){
            return s2.peek();
        }

        return front;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
