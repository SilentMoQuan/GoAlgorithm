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
 * @date :<b> 2024/10/16 11:42 </b><br />
 */
public class No39 implements Doing, Log {

    /**
     * let us go
     */
    @Override
    public void go() {
        log.info("result: {}", combinationSum(new int[]{2, 3, 6, 7}, 7));
        log.info("result: {}", combinationSum(new int[]{2, 3, 5}, 8));
        log.info("result: {}", combinationSum(new int[]{2}, 1));
    }

    private static final Logger log = LoggerFactory.getLogger(No39.class);

    private LinkedList<Integer> temp;
    private List<List<Integer>> result;
    private int sumTarget;
    private int[] elementArr;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        temp = new LinkedList<>();
        result = new ArrayList<>();
        elementArr = candidates;
        sumTarget = target;
        back(0, 0);
        return result;
    }

    public void back(int index, int sum) {
        if (sum >= sumTarget) {
            if (sum == sumTarget) {
                result.add(new ArrayList<>(temp));
            }
            return;
        }

        for (int i = index; i < elementArr.length; i++) {
            temp.addLast(elementArr[i]);
            back(i, sum + elementArr[i]);
            temp.removeLast();
        }
    }

}
