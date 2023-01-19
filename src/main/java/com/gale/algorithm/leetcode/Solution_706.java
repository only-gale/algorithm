package com.gale.algorithm.leetcode;

import java.util.Arrays;

/**
 * <p>不使用任何内建的哈希表库设计一个哈希映射（HashMap）。</p>
 * <p>实现 MyHashMap 类：</p>
 * <ul>
 *     <li>MyHashMap() 用空映射初始化对象</li>
 *     <li>void put(int key, int value) 向 HashMap 插入一个键值对 (key, value) 。如果 key 已经存在于映射中，则更新其对应的值 value 。</li>
 *     <li>int get(int key) 返回特定的 key 所映射的 value ；如果映射中不包含 key 的映射，返回 -1</li>
 *     <li>void remove(key) 如果映射中存在 key 的映射，则移除 key 和它所对应的 value</li>
 * </ul>
 *
 * <p>示例：</p>
 * <pre>
 *     输入：
 *     ["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
 *     [[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
 *     输出：
 *     [null, null, null, 1, -1, null, 1, null, -1]
 *
 *     解释：
 *     MyHashMap myHashMap = new MyHashMap();
 *     myHashMap.put(1, 1); // myHashMap 现在为 [[1,1]]
 *     myHashMap.put(2, 2); // myHashMap 现在为 [[1,1], [2,2]]
 *     myHashMap.get(1);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,2]]
 *     myHashMap.get(3);    // 返回 -1（未找到），myHashMap 现在为 [[1,1], [2,2]]
 *     myHashMap.put(2, 1); // myHashMap 现在为 [[1,1], [2,1]]（更新已有的值）
 *     myHashMap.get(2);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,1]]
 *     myHashMap.remove(2); // 删除键为 2 的数据，myHashMap 现在为 [[1,1]]
 *     myHashMap.get(2);    // 返回 -1（未找到），myHashMap 现在为 [[1,1]]
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>0 <= key, value <= 10^6</li>
 *     <li>最多调用 10^4 次 put、get 和 remove 方法</li>
 * </ul>
 * @see <a href="https://leetcode.cn/problems/design-hashmap/">设计哈希映射</a>
 * @since 2023/1/19 09:46
 */
public class Solution_706 {
    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1);
        myHashMap.put(2, 2);
        System.out.println(myHashMap.get(1));
        System.out.println(myHashMap.get(3));
        myHashMap.put(2, 1);
        System.out.println(myHashMap.get(2));
        myHashMap.remove(2);
        System.out.println(myHashMap.get(2));
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
class MyHashMap {
    int[] index;
    public MyHashMap() {
        index = new int[(int)Math.pow(10, 6) + 1];
        Arrays.fill(index, -1);
    }

    public void put(int key, int value) {
        index[key] = value;
    }

    public int get(int key) {
        return index[key];
    }

    public void remove(int key) {
        index[key] = -1;
    }
}