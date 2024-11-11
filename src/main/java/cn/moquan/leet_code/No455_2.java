package cn.moquan.leet_code;

import cn.moquan.base.Doing;
import cn.moquan.base.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * describe
 * <br />
 *
 * @author :<b> wyh </b><br />
 * @date :<b> 2024/11/4 9:18 </b><br />
 */
public class No455_2 implements Doing, Log {

    private static final Logger log = LoggerFactory.getLogger(No455_2.class);

    /**
     * let us go
     */
    @Override
    public void go() {
        log.info("result: {}", findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}));
        log.info("result: {}", findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3}));
    }

    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;
        int start = 0;

        for(int index = 0 ; index < s.length && start < g.length; index++) {

            if (s[index] >= g[start]) {
                count++;
                start++;
            }

        }

        return count;
    }
}
