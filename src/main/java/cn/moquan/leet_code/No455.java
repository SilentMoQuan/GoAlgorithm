package cn.moquan.leet_code;

import cn.moquan.base.Doing;
import cn.moquan.base.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
public class No455 implements Doing, Log {

    private static final Logger log = LoggerFactory.getLogger(No455.class);

    /**
     * let us go
     */
    @Override
    public void go() {
        log.info("result: {}", "");
    }


    public int findContentChildren(int[] g, int[] s) {

        Map<Integer, Integer> childrenMap = new HashMap<>();
        Map<Integer, Integer> cookieMap = new HashMap<>();
        for (int i : g) {
            childrenMap.put(i, childrenMap.getOrDefault(i, 0) + 1);
        }
        for (int i : s) {
            cookieMap.put(i, cookieMap.getOrDefault(i, 0) + 1);
        }

        int count = 0;

        List<Integer> children = childrenMap.keySet().stream().sorted().collect(Collectors.toList());
        List<Integer> cookies = cookieMap.keySet().stream().sorted().collect(Collectors.toList());

        for (Integer cookieSize : cookies) {

            for (Integer child : children) {
                if (cookieSize < child) {
                    break;
                }

                Integer restCount = cookieMap.get(cookieSize);
                if (restCount <= 0) {
                    break;
                }

                Integer needCount = childrenMap.get(child);
                if (needCount <= 0) {
                    continue;
                }

                if (needCount <= restCount) {
                    count += needCount;
                    restCount -= needCount;
                    needCount = 0;
                } else {
                    count += restCount;
                    needCount -= restCount;
                    restCount = 0;
                }

                childrenMap.put(child, needCount);
                cookieMap.put(cookieSize, restCount);
            }

        }

        return count;
    }
}
