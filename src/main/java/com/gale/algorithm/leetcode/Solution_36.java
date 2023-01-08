package com.gale.algorithm.leetcode;

/**
 * <p>请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。</p>
 * <pre>
 *     1. 数字 1-9 在每一行只能出现一次。
 *     2. 数字 1-9 在每一列只能出现一次。
 *     3. 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * </pre>
 *
 * 注意：
 * <ul>
 *     <li>一个有效的数独（部分已被填充）不一定是可解的。</li>
 *     <li>只需要根据以上规则，验证已经填入的数字是否有效即可。</li>
 *     <li>空白格用 '.' 表示。</li>
 * </ul>
 *
 *
 * @see <a href="https://leetcode.cn/problems/valid-sudoku/">有效的数独</a>
 * @since 2023/1/7 22:19
 */
public class Solution_36 {
    public static final char DOT = '.';
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != DOT && (!isRowValid(c, board, i, j) || !isColValid(c, board, i, j) || !isSquare3Valid(c, board, i, j))) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isRowValid(char c, char[][] board, int row, int col) {
        for (int i = 0; i < 9; i++) {
            if (i != col && board[row][i] == c) {
                return false;
            }
        }
        return true;
    }

    public boolean isColValid(char c, char[][] board, int row, int col) {
        for (int i = 0; i < 9; i++) {
            if (i != row && board[i][col] == c) {
                return false;
            }
        }
        return true;
    }

    public boolean isSquare3Valid(char c, char[][] board, int row, int col) {
        // 根据宫格计算坐标偏移量
        int trOff = row / 3 * 3, tcOff = col / 3 * 3;
        for (int i = 0; i < 9; i++) {
            int tr = i / 3;
            int tc = i % 3;
            if (tr + trOff == row || tc + tcOff == col) {
                continue;
            }
            if (board[tr + trOff][tc + tcOff] == c) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'8','3',DOT,DOT,'7',DOT,DOT,DOT,DOT},
                {'6',DOT,DOT,'1','9','5',DOT,DOT,DOT},
                {DOT,'9','8',DOT,DOT,DOT,DOT,'6',DOT},
                {'8',DOT,DOT,DOT,'6',DOT,DOT,DOT,'3'},
                {'4',DOT,DOT,'8',DOT,'3',DOT,DOT,'1'},
                {'7',DOT,DOT,DOT,'2',DOT,DOT,DOT,'6'},
                {DOT,'6',DOT,DOT,DOT,DOT,'2','8',DOT},
                {DOT,DOT,DOT,'4','1','9',DOT,DOT,'5'},
                {DOT,DOT,DOT,DOT,'8',DOT,DOT,'7','9'},
        };
        Solution_36 solution36 = new Solution_36();
        System.out.println(solution36.isValidSudoku(board));
    }
}
