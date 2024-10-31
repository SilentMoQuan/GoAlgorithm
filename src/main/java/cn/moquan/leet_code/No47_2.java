package cn.moquan.leet_code;

import cn.moquan.base.Doing;
import cn.moquan.base.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * describe
 * <br />
 *
 * @author :<b> wyh </b><br />
 * @date :<b> 2024/10/31 16:16 </b><br />
 */
public class No47_2 implements Doing, Log {

    private static final Logger log = LoggerFactory.getLogger(No47_2.class);

    /**
     * let us go
     */
    @Override
    public void go() {
//        log.info("result: {}", permuteUnique(new int[]{1, 2, 3}));
        log.info("result: {}", permuteUnique(new int[]{1, 1, 3}));
    }

    private List<List<Integer>> result;

    private List<Integer> temp;

    private int[] elementArray;

    private boolean[] usedArr;

    public List<List<Integer>> permuteUnique(int[] nums) {

        result = new ArrayList<>();
        temp = new LinkedList<>();
        Arrays.sort(nums);
        elementArray = nums;
        usedArr = new boolean[elementArray.length];

        back();
        return result;
    }

    private void back() {

        if (temp.size() >= elementArray.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < elementArray.length; i++) {
            int element = elementArray[i];
            if (usedArr[i] || (i > 0 && element == elementArray[i-1] && !usedArr[i-1])) {
                continue;
            }

            usedArr[i] = true;
            temp.addLast(element);
            back();
            temp.removeLast();
            usedArr[i] = false;
        }

    }

}
