package com.gale.algorithm.leetcode;

import java.util.Stack;

/**
 * <p>请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：</p>
 * 实现 MyQueue 类：
 * <ul>
 *     <li>void push(int x) 将元素 x 推到队列的末尾</li>
 *     <li>int pop() 从队列的开头移除并返回元素</li>
 *     <li>int peek() 返回队列开头的元素</li>
 *     <li>boolean empty() 如果队列为空，返回 true ；否则，返回 false</li>
 * </ul>
 *
 * <p>说明：</p>
 * <ul>
 *     <li>你 只能 使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。</li>
 *     <li>你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。</li>
 * </ul>
 *
 * <p>示例 1：</p>
 * <pre>
 *     输入：
 *     ["MyQueue", "push", "push", "peek", "pop", "empty"]
 *     [[], [1], [2], [], [], []]
 *     输出：
 *     [null, null, null, 1, 1, false]
 *
 *     解释：
 *     MyQueue myQueue = new MyQueue();
 *     myQueue.push(1); // queue is: [1]
 *     myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
 *     myQueue.peek(); // return 1
 *     myQueue.pop(); // return 1, queue is [2]
 *     myQueue.empty(); // return false
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>1 <= x <= 9</li>
 *     <li>最多调用 100 次 push、pop、peek 和 empty</li>
 *     <li>假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）</li>
 * </ul>
 * @see <a href="https://leetcode.cn/problems/implement-queue-using-stacks/">用栈实现队列</a>
 * @since 2023/1/12 10:37
 */
public class Solution_232 {
    /**
     * Your MyQueue object will be instantiated and called as such:
     * MyQueue obj = new MyQueue();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.peek();
     * boolean param_4 = obj.empty();
     */
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());
    }
}

class MyQueue {
    // in 维护入队操作
    // out 维护出队操作，出队操作之前，如果out为空，就从in依次挪进out
    private final Stack<Integer> in, out;

    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        if (out.isEmpty()) {
            in2Out();
        }
        return out.pop();
    }

    public int peek() {
        if (out.isEmpty()) {
            in2Out();
        }
        return out.peek();
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }

    private void in2Out() {
        while (!this.in.isEmpty()) {
            out.push(in.pop());
        }
    }
}