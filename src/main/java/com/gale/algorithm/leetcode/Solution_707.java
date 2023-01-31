package com.gale.algorithm.leetcode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;

/**
 * <p>设计链表的实现。您可以选择使用单链表或双链表。</p>
 * <p>单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。</p>
 * <p>如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。</p>
 * <p>假设链表中的所有节点都是 0-index 的。</p>
 *
 * <p>在链表类中实现这些功能：</p>
 * <ul>
 *     <li>get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。</li>
 *     <li>addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。</li>
 *     <li>addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。</li>
 *     <li>addAtIndex(index,val)：在链表中的第index个节点之前添加值为val 的节点。如果index等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。</li>
 *     <li>deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。</li>
 * </ul>
 *
 * <br>
 * <p>示例：</p>
 * <pre>
 *     MyLinkedList linkedList = new MyLinkedList();
 *     linkedList.addAtHead(1);
 *     linkedList.addAtTail(3);
 *     linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
 *     linkedList.get(1);            //返回2
 *     linkedList.deleteAtIndex(1);  //现在链表是1-> 3
 *     linkedList.get(1);            //返回3
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>0 <= index, val <= 1000</li>
 *     <li>请不要使用内置的 LinkedList 库。</li>
 *     <li>get, addAtHead, addAtTail, addAtIndex 和 deleteAtIndex 的操作次数不超过 2000。</li>
 * </ul>
 *
 * @see <a href="https://leetcode.cn/problems/design-linked-list/">设计链表</a>
 * @since 2023/1/31 11:19
 */
public class Solution_707 {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        MyLinkedList linkedList = new MyLinkedList();
//        linkedList.addAtHead(1);
//        linkedList.addAtTail(3);
//        linkedList.addAtIndex(1,2);
//        linkedList.get(1);
//        linkedList.deleteAtIndex(1);
//        linkedList.get(1);
//        System.out.println(Arrays.toString(Util.assemble(linkedList.head)));

        String[] ops = {"MyLinkedList","addAtHead","addAtTail","addAtTail","get","get","addAtTail","addAtIndex","addAtHead","addAtHead","addAtTail","addAtTail","addAtTail","addAtTail","get","addAtHead","addAtHead","addAtIndex","addAtIndex","addAtHead","addAtTail","deleteAtIndex","addAtHead","addAtHead","addAtIndex","addAtTail","get","addAtIndex","addAtTail","addAtHead","addAtHead","addAtIndex","addAtTail","addAtHead","addAtHead","get","deleteAtIndex","addAtTail","addAtTail","addAtHead","addAtTail","get","deleteAtIndex","addAtTail","addAtHead","addAtTail","deleteAtIndex","addAtTail","deleteAtIndex","addAtIndex","deleteAtIndex","addAtTail","addAtHead","addAtIndex","addAtHead","addAtHead","get","addAtHead","get","addAtHead","deleteAtIndex","get","addAtHead","addAtTail","get","addAtHead","get","addAtTail","get","addAtTail","addAtHead","addAtIndex","addAtIndex","addAtHead","addAtHead","deleteAtIndex","get","addAtHead","addAtIndex","addAtTail","get","addAtIndex","get","addAtIndex","get","addAtIndex","addAtIndex","addAtHead","addAtHead","addAtTail","addAtIndex","get","addAtHead","addAtTail","addAtTail","addAtHead","get","addAtTail","addAtHead","addAtTail","get","addAtIndex"};
        int[][] arg = {{},{84},{2},{39},{3},{1},{42},{1,80},{14},{1},{53},{98},{19},{12},{2},{16},{33},{4,17},{6,8},{37},{43},{11},{80},{31},{13,23},{17},{4},{10,0},{21},{73},{22},{24,37},{14},{97},{8},{6},{17},{50},{28},{76},{79},{18},{30},{5},{9},{83},{3},{40},{26},{20,90},{30},{40},{56},{15,23},{51},{21},{26},{83},{30},{12},{8},{4},{20},{45},{10},{56},{18},{33},{2},{70},{57},{31,24},{16,92},{40},{23},{26},{1},{92},{3,78},{42},{18},{39,9},{13},{33,17},{51},{18,95},{18,33},{80},{21},{7},{17,46},{33},{60},{26},{4},{9},{45},{38},{95},{78},{54},{42,86}};
        Integer[] results = new Integer[arg.length];
        Method[] methods = MyLinkedList.class.getDeclaredMethods();
        int i = 1;
        for (; i < ops.length; i++) {
            String op = ops[i];
            int[] arguments = arg[i];
            Optional<Method> first = Arrays.stream(methods).filter(method -> method.getName().equals(op)).findFirst();
            if (first.isPresent()) {
                Method method = first.get();
                // 根据方法声明中的参数个数来获取可用的参数
                int argCount = method.getParameterCount();
                Integer[] params = Arrays.stream(arguments).limit(argCount).boxed().toArray(Integer[]::new);
                method.setAccessible(true);
                try {
                    Object invoke = method.invoke(linkedList, (Object[]) params);
                    results[i] = invoke == null ? null : (Integer) invoke;
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println(Arrays.toString(results));
    }
}

class MyLinkedList {
    public ListNode head, tail;
    private int size = 0;

    public MyLinkedList() {
        head = null;
        tail = null;
    }

    public int get(int index) {
        if (size == 0 || index < 0 || index >= size) {
            return -1;
        }
        if (index == 0) {
            return head.val;
        }
        if (index == size - 1) {
            return tail.val;
        }

        ListNode ans = head;
        while (ans != null && index > 0) {
            ans = ans.next;
            index--;
        }
        return ans != null ? ans.val : -1;
    }

    public void addAtHead(int val) {
        ListNode added = new ListNode(val);
        added.next = head;
        head = added;
        if (tail == null) {
            tail = added;
            head.next = tail;
        }
        size++;
    }

    public void addAtTail(int val) {
        ListNode added = new ListNode(val);
        if (tail != null) {
            tail.next = added;
        }
        tail = added;
        if (head == null) {
            head = added;
            head.next = tail;
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index <= 0) {
            addAtHead(val);
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }
        ListNode added = new ListNode(val), cur = head;
        while (cur != null && index > 1) {
            cur = cur.next;
            index--;
        }
        if (cur != null) {
            added.next = cur.next;
            cur.next = added;
            size++;
        }
    }

    public void deleteAtIndex(int index) {
        // 非法条件
        if (size == 0 || index < 0 || index >= size) {
            return;
        }
        // 边界条件
        if (size == 1) {
            head = null;
            tail = null;
            size--;
            return;
        }
        if (index == 0) {
            head = head.next;
            size--;
            return;
        }

        ListNode cur = head;
        while (cur != null && index > 1) {
            cur = cur.next;
            index--;
        }
        if (cur != null) {
            ListNode del = cur.next;
            if (del != null) {
                cur.next = del.next;
                // 如果删的是tail，则修正tail
                if (del == tail) {
                    tail = cur;
                } else {
                    // 断开被删除的节点，方便gc
                    del.next = null;
                }
                size--;
            }
        }
    }
}