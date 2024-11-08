package cn.moquan.leet_code;

import cn.moquan.base.Doing;
import cn.moquan.base.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * describe
 * <br />
 *
 * @author :<b> wyh </b><br />
 * @date :<b> 2024/11/4 9:18 </b><br />
 */
public class No51 implements Doing, Log {

    private static final Logger log = LoggerFactory.getLogger(No51.class);
    private List<List<String>> result;
    private boolean[][] map;
    private boolean[] columnUsed;
    private int usedQueen;
    private int maxRow;

    /**
     * let us go
     */
    @Override
    public void go() {
        // n = 4
        // 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
        log.info("result: {}", solveNQueens(4));
    }

    public List<List<String>> solveNQueens(int n) {

        map = new boolean[n][n];
        columnUsed = new boolean[n];
        maxRow = n;

        result = new ArrayList<>();

        back(0);

        return result;
    }

    private void back(int row) {
        if (row >= maxRow || usedQueen == maxRow) {
            if (usedQueen == maxRow) {
                List<String> rowList = new ArrayList<>();
                for (boolean[] rows : map) {
                    StringBuilder columnStr = new StringBuilder();
                    for (boolean cell : rows) {
                        columnStr.append(cell ? "Q" : ".");
                    }
                    rowList.add(columnStr.toString());
                }
                result.add(rowList);
            }
            return;
        }

        for (int i = 0; i < maxRow; i++) {


            if (checkCrash(row, i)) {
                continue;
            }

            map[row][i] = true;
            columnUsed[i] = true;
            usedQueen++;
            back(row + 1);
            usedQueen--;
            columnUsed[i] = false;
            map[row][i] = false;
        }
    }

    private boolean checkCrash(int row, int column) {

        if (columnUsed[column]) {
            return true;
        }

        int localRow = row;
        int localColumn = column;

        while (localRow >= 0 && localColumn >= 0) {
            if (map[localRow][localColumn]) {
                return true;
            }
            localRow--;
            localColumn--;
        }

        localRow = row;
        localColumn = column;
        while (localRow >= 0 && localColumn < maxRow) {
            if (map[localRow][localColumn]) {
                return true;
            }
            localRow--;
            localColumn++;
        }

        return false;
    }

}
