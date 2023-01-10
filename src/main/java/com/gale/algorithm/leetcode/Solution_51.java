package com.gale.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。</p>
 * <p>n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。</p>
 * <p>给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。</p>
 * <p>每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。</p>
 * @see <a href="https://leetcode.cn/problems/n-queens/">N皇后</a>
 */
public class Solution_51 {
    public static final String EMPTY = ".";
    public static final String QUEEN = "Q";
    public static List<List<List<String>>> res = new ArrayList<>();

    public static void solveNQueens(int n) {
        List<List<String>> board = initBoard(n);
        backtrace(board, 0);
    }

    public static List<List<String>> initBoard(int n) {
        List<List<String>> board = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            board.add(initLine(n));
        }
        return board;
    }

    public static List<String> initLine(int n) {
        List<String> line = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            line.add(EMPTY);
        }
        return line;
    }

    public static void backtrace(List<List<String>> board, int row) {
        if (row == board.size()) {
            res.add(takeSnapshot(board));
            return;
        }
        int cols = board.get(row).size();
        for (int col = 0; col < cols; col++) {
            if (!isValid(board, row, col)) {
                continue;
            }
            board.get(row).set(col, QUEEN);
            backtrace(board, row + 1);
            board.get(row).set(col, EMPTY);
        }
    }

    public static List<List<String>> takeSnapshot(List<List<String>> board) {
        List<List<String>> boardSnapshot = new ArrayList<>();
        for (List<String> strings : board) {
            List<String> line = new ArrayList<>(strings.size());
            line.addAll(strings);
            boardSnapshot.add(line);
        }
        return boardSnapshot;
    }

    public static boolean isValid(List<List<String>> board, int row, int col) {
        int n = board.get(row).size();

        // 检查列
        for (int i = 0; i < row; i++) {
            if (isQueen(board.get(i).get(col))) {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (isQueen(board.get(i).get(j))) {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (isQueen(board.get(i).get(j))) {
                return false;
            }
        }

        return true;
    }

    public static boolean isQueen(String node) {
        return QUEEN.equals(node);
    }

    public static void printSolved(List<List<List<String>>> solved) {
        for (int i = 0; i < solved.size(); i++) {
            System.out.printf("第%d种方案\n", i+1);
            Util.printBoard(solved.get(i));
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solveNQueens(6);
        printSolved(res);
    }
}
