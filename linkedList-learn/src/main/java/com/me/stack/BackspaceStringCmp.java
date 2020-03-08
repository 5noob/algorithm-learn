package com.me.stack;

import java.util.Stack;

/**
 * @author: create by Rhine
 * @date:2020/3/8 17:11
 * @description: 比较含退格的字符串 leetcode 844 https://leetcode-cn.com/problems/backspace-string-compare/
 */
public class BackspaceStringCmp {

    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    private String build(String s){
        Stack<Character> s1 = new Stack<>();
        for (char c : s.toCharArray()) {
            if ('#' == c) {
                if(!s1.isEmpty()){
                    s1.pop();
                }
            } else {
                s1.push(c);
            }
        }
        return String.valueOf(s1);
    }
}
