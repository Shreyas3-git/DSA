package com.example.dsa_practice2025.stack;

import java.util.Stack;

public class ValidParenthesis
{
    public static void main(String[] args) {
        System.out.println(new ValidParenthesis().isValid("((())){}{}{"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for(char ch : chars) {
            if(ch == '{' || ch == '[' || ch == '(')
                stack.push(ch);
            else if(!isMatching(stack.pop(),ch)){
                return false;
            }
        }
        return stack.isEmpty();
    }


    public boolean isMatching(char open,char close) {
        return open == '{' && close == '}' || open == '[' && close == ']' || open == '(' && close == ')';
    }
}
