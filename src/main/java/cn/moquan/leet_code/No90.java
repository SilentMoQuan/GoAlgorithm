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
 * @date :<b> 2024/10/24 14:55 </b><br />
 */
public class No90 implements Doing, Log {

    private static final Logger log = LoggerFactory.getLogger(No90.class);

    /**
     * let us go
     */
    @Override
    public void go() {
        log.info("result : {} ", subsetsWithDup(new int[]{1, 2, 2}));
    }

    private List<List<Integer>> result;

    private LinkedList<Integer> temp;

    private int[] elementArr;

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        result = new ArrayList<>();
        temp = new LinkedList<>();

        Arrays.sort(nums);
        elementArr = nums;

        back(0);

        return result;
    }

    private void back(int index) {
        result.add(new ArrayList<>(temp));

        if (index >= elementArr.length) {
            return;
        }

        for (int i = index; i < elementArr.length; i++) {

            if (i > index && elementArr[i] == elementArr[i - 1]) {
                continue;
            }

            temp.addLast(elementArr[i]);
            back(i + 1);
            temp.removeLast();
        }

    }

}
