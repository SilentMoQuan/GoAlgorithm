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
 * describe
 * <br />
 *
 * @author :<b> wyh </b><br />
 * @date :<b> 2024/10/16 14:07 </b><br />
 */
public class No40 implements Doing, Log {

    private static final Logger log = LoggerFactory.getLogger(No40.class);
    private int sumTarget;
    private int[] elementArr;
    private List<List<Integer>> result;
    private LinkedList<Integer> temp;

    @Override
    public void go() {
        log.info("result: {}", combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        // [
        //  [1, 7],
        //  [1, 2, 5],
        //  [2, 6],
        //  [1, 1, 6]
        //]
        log.info("result: {}", combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
        // [[1,2,2],[5]]
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        result = new ArrayList<>();
        temp = new LinkedList<>();

        Arrays.sort(candidates);

        sumTarget = target;
        elementArr = candidates;

        back(0, 0);

        return result;
    }

    private void back(int index, int sum) {

        if (sum >= sumTarget) {
            if (sum == sumTarget) {
                result.add(new ArrayList<>(temp));
            }
            return;
        }

        for (int i = index; i < elementArr.length; i++) {

            if (i > index && elementArr[i] == elementArr[i - 1]) {
                continue;
            }

            temp.addLast(elementArr[i]);
            back(i + 1, sum + elementArr[i]);
            temp.removeLast();
        }

    }
}
