package cn.moquan.leet_code;

import cn.moquan.base.Doing;
import cn.moquan.base.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * describe
 * <br />
 *
 * @author :<b> wyh </b><br />
 * @date :<b> 2024/10/29 16:17 </b><br />
 */
public class No491 implements Doing, Log {
    /**
     * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
     * <p>
     * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [4,6,7,7]
     * 输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
     * 示例 2：
     * <p>
     * 输入：nums = [4,4,3,2,1]
     * 输出：[[4,4]]
     */

    private static final Logger log = LoggerFactory.getLogger(No491.class);
    private List<List<Integer>> result;
    private LinkedList<Integer> temp;
    private int[] elementArr;

    /**
     * let us go
     */
    @Override
    public void go() {
        log.info("result: {}", findSubsequences(new int[]{4, 6, 7, 7}));
        log.info("result: {}", findSubsequences(new int[]{4, 4, 3, 2, 1}));
        log.info("result: {}", findSubsequences(new int[]{1,2,3,4,5,6,7,8,9,10,1,1,1,1,1}));
    }

    public List<List<Integer>> findSubsequences(int[] nums) {

        result = new ArrayList<>();
        temp = new LinkedList<>();
        elementArr = nums;

        back(0);

        return result;
    }

    private void back(int index) {

        if (temp.size() >= 2) {
            result.add(new ArrayList<>(temp));
        }

        if (index >= elementArr.length) {
            return;
        }

        for (int i = index; i < elementArr.length; i++) {

            if (i > index && elementArr[i] == elementArr[i - 1]) {
                continue;
            }

            int newElement = elementArr[i];
            if (temp.isEmpty() || temp.getLast() <= newElement) {
                temp.addLast(newElement);
                back(i + 1);
                temp.removeLast();
            }
        }
    }

}
