package cn.moquan.leet_code;

import cn.moquan.base.Doing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * no77
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 示例: 输入: n = 4, k = 2 输出: [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
 * <br />
 *
 * @author :<b> wyh </b><br />
 * @date :<b> 2024/10/10 16:10 </b><br />
 */
public class No77 implements Doing {

    Integer[] result;

    int maxIndex;

    int maxDeep;

    List<List<Integer>> list = new ArrayList<>();

    /**
     * let us go
     */
    @Override
    public void go() {

        int n = 4;
        int k = 2;

        maxIndex = n;
        maxDeep = k;

        result = new Integer[k];

        for (int i = 1; i <= maxIndex; i++) {
            execution(i, 0);
        }
        System.out.println(list);

    }

    private void execution(int index, int deepIndex) {

        if (deepIndex >= maxDeep) {
            list.add(Arrays.asList(Arrays.copyOf(result, result.length)));
            return;
        }
        if (index > maxIndex) {
            return;
        }



        result[deepIndex] = index;

        int nextIndex = index;
        for (int i = 1; i <= maxIndex; i++) {
            nextIndex++;
            execution(nextIndex, deepIndex + 1);
        }

        result[deepIndex] = null;
    }

}