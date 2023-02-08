package com.gale.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>你是一位系统管理员，手里有一份文件夹列表 folder，你的任务是要删除该列表中的所有 子文件夹，并以 任意顺序 返回剩下的文件夹。</p>
 * <p>如果文件夹 folder[i] 位于另一个文件夹 folder[j] 下，那么 folder[i] 就是 folder[j] 的 子文件夹 。</p>
 * <p>文件夹的「路径」是由一个或多个按以下格式串联形成的字符串：'/' 后跟一个或者多个小写英文字母。</p>
 * <ul>
 *     <li>例如，"/leetcode" 和 "/leetcode/problems" 都是有效的路径，而空字符串和 "/" 不是。</li>
 * </ul>
 * <br>
 *
 * <p>示例 1：</p>
 * <pre>
 * 输入：folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
 * 输出：["/a","/c/d","/c/f"]
 * 解释："/a/b" 是 "/a" 的子文件夹，而 "/c/d/e" 是 "/c/d" 的子文件夹。
 * </pre>
 *
 * <p>示例 2：</p>
 * <pre>
 * 输入：folder = ["/a","/a/b/c","/a/b/d"]
 * 输出：["/a"]
 * 解释：文件夹 "/a/b/c" 和 "/a/b/d" 都会被删除，因为它们都是 "/a" 的子文件夹。
 * </pre>
 *
 * <p>示例 3：</p>
 * <pre>
 * 输入: folder = ["/a/b/c","/a/b/ca","/a/b/d"]
 * 输出: ["/a/b/c","/a/b/ca","/a/b/d"]
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>1 <= folder.length <= 4 * 10^4</li>
 *     <li>2 <= folder[i].length <= 100</li>
 *     <li>folder[i] 只包含小写字母和 '/'</li>
 *     <li>folder[i] 总是以字符 '/' 起始</li>
 *     <li>每个文件夹名都是 唯一 的</li>
 * </ul>
 *
 * @see <a href="https://leetcode.cn/problems/remove-sub-folders-from-the-filesystem/">删除子文件夹</a>
 * @since 2023/2/8 16:10
 */
public class Solution_1233 {
    public List<String> removeSubfolders(String[] folder) {
        if (folder.length == 1) {
            return new ArrayList<String>(){{add(folder[0]);}};
        }
        DirNode root = assembleTree(folder);
        List<String> ans = new ArrayList<>();
        dfs(root, ans, folder);
        return ans;
    }

    private DirNode assembleTree(String[] folder) {
        DirNode root = new DirNode(), cur;
        String path, subDirName;
        for (int i = 0; i < folder.length; i++) {
            path = folder[i];
            cur = root;
            String[] split = path.split("/");
            // j 从1开始，因为所有路径都是以/开头
            for (int j = 1; j < split.length; j++) {
                subDirName = split[j];
                cur.children.putIfAbsent(subDirName, new DirNode());
                cur = cur.children.get(subDirName);
            }
            cur.setRef(i);
        }
        return root;
    }

    private void dfs(DirNode root, List<String> ans, String[] folder) {
        if (root != null) {
            if (root.getRef() != -1) {
                ans.add(folder[root.getRef()]);
            } else {
                for (DirNode child : root.getChildren().values()) {
                    dfs(child, ans, folder);
                }
            }
        }
    }

    private static class DirNode {
        private int ref;
        private final Map<String, DirNode> children;

        private DirNode() {
            this.ref = -1;
            this.children = new HashMap<>();
        }

        private int getRef() {
            return this.ref;
        }

        private void setRef(int idx) {
            this.ref = idx;
        }

        private Map<String, DirNode> getChildren() {
            return this.children;
        }
    }

    public static void main(String[] args) {
        String[] folder = {"/a","/a/b","/c/d","/c/d/e","/c/f"};
        Solution_1233 solution1233 = new Solution_1233();
        List<String> removeSubfolders = solution1233.removeSubfolders(folder);
        System.out.println(removeSubfolders);
    }
}
