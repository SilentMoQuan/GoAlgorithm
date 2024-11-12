package cn.moquan.leet_code;

import cn.moquan.base.Doing;
import cn.moquan.base.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * describe
 * <br />
 *
 * @author :<b> wyh </b><br />
 * @date :<b> 2024/11/4 9:18 </b><br />
 */
public class No376 implements Doing, Log {

    private static final Logger log = LoggerFactory.getLogger(No376.class);

    /**
     * let us go
     */
    @Override
    public void go() {
        log.info("result: {}", "");
    }


    public int wiggleMaxLength(int[] nums) {

        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        LinkedList<Integer> result = new LinkedList<>();

        int last = nums[0];
        result.add(last);
        for (int i = 1; i < nums.length - 1; i++) {
            int now = nums[i];
            if (last == now) {
                continue;
            }

            int next = nums[i + 1];

            if ((last < now && now > next) || (last > now && now < next)) {
                last = now;
                result.add(last);
            }

        }

        return last == nums[nums.length - 1] ? result.size() : result.size() + 1;

    }

}
