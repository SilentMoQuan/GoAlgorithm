package cn.moquan.leet_code;

import cn.moquan.base.Doing;
import cn.moquan.base.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;

/**
 * describe
 * <br />
 *
 * @author :<b> wyh </b><br />
 * @date :<b> 2024/11/4 9:18 </b><br />
 */
public class No376_2 implements Doing, Log {

    private static final Logger log = LoggerFactory.getLogger(No376_2.class);

    /**
     * let us go
     */
    @Override
    public void go() {
        log.info("result: {}", "");
    }


    public int wiggleMaxLength(int[] nums) {

        if(nums.length <= 1) {
            return nums.length;
        }

        int count = 0;

        int lastDiff = 0;
        int currentDiff = 0;

        for (int i = 1; i < nums.length; i++) {
            currentDiff = nums[i] - nums[i - 1];
            if ((currentDiff > 0 && lastDiff <= 0) || (currentDiff < 0 && lastDiff >= 0)) {
                count++;
                lastDiff = currentDiff;
            }
        }

        return count;

    }

}
