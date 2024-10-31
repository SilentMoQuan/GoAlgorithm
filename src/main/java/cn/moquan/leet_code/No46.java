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
public class No46 implements Doing, Log {

    private static final Logger log = LoggerFactory.getLogger(No46.class);

    /**
     * let us go
     */
    @Override
    public void go() {
        log.info("result: {}", permute(new int[]{1, 2, 3}));
        log.info("result: {}", permute(new int[]{0, 1}));
        log.info("result: {}", permute(new int[]{1}));
    }

    private List<List<Integer>> result;

    private List<Integer> temp;

    private int[] elementArr;

    private Set<Integer> usedIndexSet;

    public List<List<Integer>> permute(int[] nums) {

        result = new ArrayList<>();
        temp = new LinkedList<>();
        usedIndexSet = new HashSet<>();
        elementArr = nums;

        back();
        return result;
    }

    private void back() {

        if (temp.size() >= elementArr.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < elementArr.length; i++) {
            if (usedIndexSet.contains(i)) {
                continue;
            }

            usedIndexSet.add(i);
            temp.addLast(elementArr[i]);
            back();
            temp.removeLast();
            usedIndexSet.remove(i);
        }

    }

}
