package org.example.dsa;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {

        System.out.println(isValid("{()}"));
    }
    private static boolean isValid(String s){
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char c : arr){
            if(c == '(' || c == '{' || c == '[')
                stack.push(c);
            else if(c == ')' && !stack.isEmpty() && stack.peek() == '(')
                stack.pop();
            else if(c == '}' && !stack.isEmpty() && stack.peek() == '{')
                stack.pop();
            else if(c == ']' && !stack.isEmpty() && stack.peek() == '[')
                stack.pop();
            else
                return false;
        }
        return stack.isEmpty();
    }
}
