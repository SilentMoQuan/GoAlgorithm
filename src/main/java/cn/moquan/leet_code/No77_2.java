package cn.moquan.leet_code;

import cn.moquan.base.Doing;
import cn.moquan.base.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
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
public class No77_2 implements Doing, Log {

    private static final Logger logger = LoggerFactory.getLogger(No77_2.class);

    @Override
    public void go() {
        logger.info("result: {}", solution(4, 2));
    }

    LinkedList<Integer> result = new LinkedList<>();

    int maxIndex;

    int maxDeep;

    List<List<Integer>> list = new ArrayList<>();

    private List<List<Integer>> solution(int n, int k) {

        maxIndex = n;
        maxDeep = k;

        result = new LinkedList<>();

        execution(1);

        return list;
    }

    private void execution(int index) {

        if (result.size() >= maxDeep) {
            list.add(new ArrayList<>(result));
            return;
        }


        for (int i = index; i <= maxIndex; i++) {
            pushLast(i);
            execution(i + 1);
            removeLast();
        }


    }

    private void pushLast(int value) {
        result.add(value);
    }

    private void removeLast() {
        result.removeLast();
    }

}