package com.gale.algorithm.leetcode;

import java.util.*;

/**
 * <p>序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。</p>
 * <p>请设计一个算法来实现二叉树的序列化与反序列化。</p>
 * <p>这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。</p>
 * <br>
 * <p></p>
 * @see <a href="https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/">二叉树的序列化与反序列化</a>
 * @since 2023/2/6 09:52
 */
public class Solution_297 {

    public static void main(String[] args) {
//        Integer[] nums = {1,2,3,null,null,4,5,6,7};
//        Integer[] nums = {1,null, 2};
        Integer[] nums = {4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2};
        TreeNode root = Util.assembleFromLevelOrder(nums);
        Codec codec = new Codec();
        String ser = codec.serialize(root);
        System.out.println(ser);
        root = codec.deserialize(ser);
        Util.printTreeAsLevelOrder(root);
    }
}

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String assembled = rserialize(root, "");
        return assembled.substring(0, assembled.length() - 1);
    }

    private String rserialize(TreeNode root, String assembled) {
        if (root == null) {
            assembled += "null,";
        } else {
            assembled += (root.val + ",");
            assembled = rserialize(root.left, assembled);
            assembled = rserialize(root.right, assembled);
        }
        return assembled;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0 || "null".equals(data)) {
            return null;
        }
        LinkedList<String> splits = new LinkedList<>(Arrays.asList(data.split(",")));
        return rdeserialize(splits);
    }

    private TreeNode rdeserialize(LinkedList<String> splits) {
        if (splits.isEmpty()) {
            return null;
        }
        String head = splits.poll();
        if ("null".equals(head)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(head));
        root.left = rdeserialize(splits);
        root.right = rdeserialize(splits);
        return root;
    }
}