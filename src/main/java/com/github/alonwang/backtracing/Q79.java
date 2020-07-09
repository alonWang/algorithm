package com.github.alonwang.backtracing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *  
 * <p>
 * 提示：
 * <p>
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q79 {
    //word转换
    private char[] wordChars;
    //维度
    private int l1, l2;
    //记录哪些位置使用过
    private boolean[][] used;
    //记录字符和坐标的对应关系
    private Map<Character, List<Integer>> coordinatesMap;

    /**
     * 首先确保chars中字符出现次数能够满足word
     * 然后进行回溯处理,由于预处理，性能不太理想。
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {

        wordChars = word.toCharArray();

        if (appearCountsNotSatisfy(board)) return false;


        l1 = board.length;
        l2 = board[0].length;
        used = new boolean[l1][l2];


        initCoordinatesMap(board);
        //从不同的起点开始尝试
        char target = wordChars[0];
        List<Integer> coordinates = coordinatesMap.get(target);
        for (Integer coordinate : coordinates) {
            int cL1 = decodeL1(coordinate);
            int cL2 = decodeL2(coordinate);
            used[cL1][cL2] = true;
            if (findMatch(1, cL1, cL2)) {
                return true;
            }
            used[cL1][cL2] = false;
        }
        return false;
    }

    private boolean appearCountsNotSatisfy(char[][] board) {
        //字符不能重复利用,确保board次数满足word
        int[] charAppears = new int[126];
        for (char[] chars : board) {
            for (char c : chars) {
                charAppears[c]++;
            }
        }
        for (char c : wordChars) {
            if (charAppears[c] <= 0) {
                return true;
            }
            charAppears[c] -= 1;
        }
        return false;
    }

    private void initCoordinatesMap(char[][] board) {
        coordinatesMap = new HashMap<>(52);
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                List<Integer> coordinates = coordinatesMap.get(board[i][j]);
                coordinates.add(encode(i, j));
                coordinatesMap.put(board[i][j], coordinates);
            }
        }
    }

    /**
     * i,j有范围限制，可以编码在整数范围内，各占2个字节
     *
     * @param i
     * @param j
     * @return
     */
    private int encode(int i, int j) {
        return (i << 16) + j;
    }

    private int decodeL1(int encoded) {
        return (encoded & 0xFFFF0000) >> 16;
    }

    private int decodeL2(int encoded) {
        return encoded & 0X0000FFFF;
    }

    private boolean findMatch(int i, int prevL1, int prevL2) {
        //全部匹配了，成功
        if (i == wordChars.length) {
            return true;
        }
        char target = wordChars[i];
        List<Integer> coordinates = coordinatesMap.get(target);
        if (coordinates == null) {
            return false;
        }
        for (Integer coordinate : coordinates) {
            int cL1 = decodeL1(coordinate);
            int cL2 = decodeL2(coordinate);
            if (!used[cL1][cL2] && canGo(prevL1, prevL2, cL1, cL2)) {
                used[cL1][cL2] = true;
                if (findMatch(i + 1, cL1, cL2)) {
                    return true;
                }
                used[cL1][cL2] = false;
            }
        }
        return false;

    }

    /**
     * 当x，或y相差1但是不都相差1时，说明是上下左右方位。 异或
     *
     * @param prevL1
     * @param prevL2
     * @param cL1
     * @param cL2
     * @return
     */
    private static boolean canGo(int prevL1, int prevL2, int cL1, int cL2) {
        int distanceL1 = Math.abs(prevL1 - cL1);
        int distanceL2 = Math.abs(prevL2 - cL2);
        if (distanceL1 > 1 || distanceL2 > 1) {

            return false;
        }
        return (distanceL1 ^ distanceL2) == 1;
    }
}
