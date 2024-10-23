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
 * @date :<b> 2024/10/23 11:49 </b><br />
 */
public class No78_2 implements Doing, Log {

    private static final Logger log = LoggerFactory.getLogger(No78_2.class);
    private List<List<Integer>> result;
    private LinkedList<Integer> temp;
    private int[] elementArr;
    private int maxLen;

    /**
     * let us go
     */
    @Override
    public void go() {

        log.info("result : {}", subsets(new int[]{1, 2, 3}));
        log.info("result : {}", subsets(new int[]{0}));

    }

    public List<List<Integer>> subsets(int[] nums) {

        result = new ArrayList<>();
        temp = new LinkedList<>();
        elementArr = nums;
        maxLen = nums.length;

        back(0, maxLen);

        return result;
    }

    private void back(int index, int size) {

        result.add(new ArrayList<>(temp));

        if (temp.size() == size) {
            return;
        }

        for (int i = index; i < maxLen; i++) {
            temp.addLast(elementArr[i]);
            back(i + 1, size);
            temp.removeLast();
        }

    }

}
