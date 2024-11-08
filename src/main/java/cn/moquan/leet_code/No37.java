package cn.moquan.leet_code;

import cn.moquan.base.Doing;
import cn.moquan.base.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * describe
 * <br />
 *
 * @author :<b> wyh </b><br />
 * @date :<b> 2024/11/4 9:18 </b><br />
 */
public class No37 implements Doing, Log {

    private static final Logger log = LoggerFactory.getLogger(No37.class);

    /**
     * let us go
     */
    @Override
    public void go() {
        solveSudoku(BOARD);
        log.info("result: {}", Arrays.deepToString(BOARD));
    }

    public static final char[][] BOARD = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
    };

    // [
    // ["5","3","4","6","7","8","9","1","2"],
    // ["6","7","2","1","9","5","3","4","8"],
    // ["1","9","8","3","4","2","5","6","7"],
    // ["8","5","9","7","6","1","4","2","3"],
    // ["4","2","6","8","5","3","7","9","1"],
    // ["7","1","3","9","2","4","8","5","6"],
    // ["9","6","1","5","3","7","2","8","4"],
    // ["2","8","7","4","1","9","6","3","5"],
    // ["3","4","5","2","8","6","1","7","9"]
    // ]

    char[][] map;

    char[] elements = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public void solveSudoku(char[][] board) {
        map = board;
        back(0, 0);
    }

    private boolean back(int row, int column) {

        if (row >= 9) {
            return true;
        }

        if (map[row][column] != '.') {
            return next(row, column);
        }

        for (char num : elements) {
            if (haveCrash(num, row, column)) {
                continue;
            }

            map[row][column] = num;
            if (next(row, column)) {
                return true;
            }

            map[row][column] = '.';
        }

        return false;
    }

    private boolean next(int row, int column) {
        if (needNextRow(column)) {
            return back(row + 1, 0);
        } else {
            return back(row, column + 1);
        }
    }

    private boolean haveCrash(char num, int row, int column) {
        return rowHaveCrash(num, row, column) ||
                columnHaveCrash(num, row, column) ||
                blockHaveCrash(num, row, column);
    }

    private boolean blockHaveCrash(char num, int row, int column) {
        int blockRow = row / 3;
        int blockColumn = column / 3;

        for (int i = blockRow * 3; i < blockRow * 3 + 3; i++) {
            for (int j = blockColumn * 3; j < blockColumn * 3 + 3; j++) {
                if (map[i][j] == num) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean columnHaveCrash(char num, int row, int column) {
        for (int i = 0; i < 9; i++) {
            if (map[i][column] == num) {
                return true;
            }
        }
        return false;
    }

    private boolean rowHaveCrash(char num, int row, int column) {

        for (int i = 0; i < 9; i++) {
            if (map[row][i] == num) {
                return true;
            }
        }

        return false;
    }

    private boolean needNextRow(int column) {
        return column + 1 >= 9;
    }

}
