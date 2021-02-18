package com.stack;

import java.util.Stack;

class CQueue {

    Stack<Integer> get;
    Stack<Integer> push;

    public CQueue() {
        get = new Stack<>();
        push = new Stack<>();
    }

    public void appendTail(int value) {
        push.push(value);

    }

    public int deleteHead() {
        if (get.empty()) {
            while (!push.empty()) {
                get.push(push.pop());
            }
        }
        if (get.empty()) return -1;
        return get.pop();
    }
}

