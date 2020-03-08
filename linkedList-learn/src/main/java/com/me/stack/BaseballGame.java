package com.me.stack;

import java.util.Stack;

/**
 * @author: create by Rhine
 * @date:2020/3/8 17:37
 * @description: 棒球比赛 leetcode 682 https://leetcode-cn.com/problems/baseball-game/
 */
public class BaseballGame {
    public int calPoints(String[] ops) {
        Stack<Integer> pointStack = new Stack<>();
        for(String s: ops){
            if("+".equals(s)){
                int top = pointStack.pop();
                int newTop = top + pointStack.peek();
                pointStack.push(top);
                pointStack.push(newTop);
            }else if("D".equals(s)){
                int newTop = 2 * pointStack.peek();
                pointStack.push(newTop);
            }else if("C".equals(s)){
                pointStack.pop();
            }else {
                pointStack.push(Integer.valueOf(s));
            }
        }

        int result = 0;
        for(int score: pointStack){
            result += score;
        }

        return result;
    }
}
