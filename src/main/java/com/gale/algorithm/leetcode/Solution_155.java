package com.gale.algorithm.leetcode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * <p>设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。</p>
 * <p>实现 MinStack 类:</p>
 * <ul>
 *     <li>MinStack() 初始化堆栈对象。</li>
 *     <li>void push(int val) 将元素val推入堆栈。</li>
 *     <li>void pop() 删除堆栈顶部的元素。</li>
 *     <li>int top() 获取堆栈顶部的元素。</li>
 *     <li>int getMin() 获取堆栈中的最小元素。</li>
 * </ul>
 * <br>
 *
 * <p>示例 1:</p>
 * <pre>
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>-2^31 <= val <= 2^31 - 1</li>
 *     <li>pop、top 和 getMin 操作总是在 非空栈 上调用</li>
 *     <li>push, pop, top, and getMin最多被调用 3 * 10^4 次</li>
 * </ul>
 * @see <a href="https://leetcode.cn/problems/min-stack/">最小栈</a>
 * @since 2023/2/1 09:39
 */
public class Solution_155 {

    public static void main(String[] args) {
        int[] nums = {4,2,8,5,3,2};
        Heapify.HeapType heapType = Heapify.HeapType.LITTLE;
        System.out.printf("before %s heap sort:\n", heapType);
        System.out.println(Arrays.toString(nums));
        Heapify heapify = new Heapify(nums, heapType);
        System.out.printf("after %s heap sort:\n", heapType);
        System.out.println(Arrays.toString(heapify.getHeap()));

        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}

class MinStack {
    private final Heapify minsHeap;
    private final LinkedList<Integer> link;

    public MinStack() {
        minsHeap = new Heapify(new int[0], Heapify.HeapType.LITTLE);
        link = new LinkedList<>();
    }

    public void push(int val) {
        link.push(val);
        int[] heap = minsHeap.getHeap();
        if (heap.length == 0) {
            minsHeap.heapSort(new int[]{val});
        } else {
            int[] newHeap = new int[heap.length + 1];
            System.arraycopy(heap, 0, newHeap, 0, heap.length);
            newHeap[heap.length] = val;
            minsHeap.heapSort(newHeap);
        }
    }

    public void pop() {
        if (link.isEmpty()) {
            return;
        }
        int val = link.pop();
        if (link.isEmpty()) {
            minsHeap.heapSort(new int[0]);
        } else {
            int[] heap = minsHeap.getHeap();
            int len = heap.length;
            int[] newHeap = new int[len - 1];
            for (int i = 0; i < len; i++) {
                if (heap[i] == val && i != len - 1) {
                    minsHeap.swap(heap, i, len - 1);
                    break;
                }
            }
            System.arraycopy(heap, 0, newHeap, 0, len - 1);
            minsHeap.heapSort(newHeap);
        }
    }

    public int top() {
        return link.isEmpty() ? -1 : link.getFirst();
    }

    public int getMin() {
        int[] heap = minsHeap.getHeap();
        return heap.length > 0 ? heap[0] : -1;
    }
}

/**
 * 大顶堆/小顶堆
 */
class Heapify {
    enum HeapType {
        BIGGER,
        LITTLE
    }
    private int[] heap;
    private final HeapType heapType;

    Heapify(int[] heap, HeapType heapType) {
        this.heap = heap;
        this.heapType = heapType;
        this.heapSort(this.heap);
    }

    public void swap(int[] heap, int i, int j) {
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    /**
     * 堆排序
     * @param count 堆（heap）中待排序的元素数量
     * @param index 待排序元素中最后一个非叶子节点在heap中的索引值
     */
    private void heapify(int[] heap, int count, int index) {
        int need2swap = index;
        while (true) {
            // 根据堆类型选择和index交换的索引
            // index的左右子节点
            int left = (index << 1) + 1, right = (index << 1) + 2;
            // 有左子节点且左子节点值大于父节点，交换
            if (left < count && heap[left] > heap[index]) {
                need2swap = left;
            }
            // 有右子节点且右子节点值大于父节点，交换
            if (right < count && heap[right] > heap[need2swap]) {
                need2swap = right;
            }
            // 不需要交换则退出
            if (need2swap == index) {
                break;
            }
            // 交换
            swap(heap, index, need2swap);
            // 从交换后的节点开始往下继续堆化
            index = need2swap;
        }
    }

    private void build(int[] nums, int len) {
        for (int i = (len >> 1) - 1; i >= 0; i--) {
            heapify(nums, len, i);
        }
    }

    private void buildBiggerHeap(int[] nums) {
        for (int i = nums.length; i >= 1; i--) {
            build(nums, i);
        }
    }

    private void buildLittleHeap(int[] nums) {
        int len = nums.length;
        build(nums, len);
        // 构造完后，堆顶（数组第一个元素）是最大值，需要将其沉到堆底（数组最后一个元素）
        for (int i = len - 1; i > 0; i--) {
            swap(nums, 0, i);
            heapify(nums, i, 0);
        }
    }

    public void heapSort(int[] nums) {
        this.heap = nums;
        if (nums == null || nums.length <= 1) {
            return;
        }
        if (this.heapType == HeapType.BIGGER) {
            buildBiggerHeap(nums);
        } else {
            buildLittleHeap(nums);
        }
    }

    public int[] getHeap() {
        return this.heap;
    }
}