package me.zhaoyudong;

import java.util.Stack;

public class ValidateStackSequences {

    public static void main(String[] args) {
        System.out.println(new ValidateStackSequences().validateStackSequences(new int[]{2, 1, 0}, new int[]{1, 2, 0}));
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null && popped == null) {
            return true;
        }
        if (pushed == null || popped == null || pushed.length != popped.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int startPop = 0;
        for (int i = 0; i < pushed.length; ) {
            if (i != 0 && !stack.isEmpty() && stack.peek() == popped[startPop]) {
                stack.pop();
                startPop++;
            } else {
                stack.push(pushed[i]);
                if (pushed[i] == popped[startPop]) {
                    stack.pop();
                    startPop++;
                }
                i++;
            }
        }

        for (; startPop < popped.length; startPop++) {
            int pop = stack.pop();
            if (pop != popped[startPop]) {
                return false;
            }
        }

        return true;
    }
}
