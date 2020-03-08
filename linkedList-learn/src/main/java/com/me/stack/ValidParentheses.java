package com.me.stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author: create by Rhine
 * @date:2020/3/8 9:56
 * @description: 有效的括号 leetcode 20 https://leetcode-cn.com/problems/valid-parentheses/
 */
public class ValidParentheses {
    private HashMap<Character, Character> bracketMapping;

    public ValidParentheses() {
        bracketMapping = new HashMap<>();
        bracketMapping.put(')', '(');
        bracketMapping.put(']', '[');
        bracketMapping.put('}', '{');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (bracketMapping.containsKey(c)) {
                char topElement = stack.isEmpty() ? '#' : stack.pop();
                if(topElement != bracketMapping.get(c)){
                    return false;
                }

            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
