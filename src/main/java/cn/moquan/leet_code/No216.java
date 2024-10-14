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
 * @date :<b> 2024/10/14 21:17 </b><br />
 */
public class No216 implements Doing, Log {

    private static final Logger log = LoggerFactory.getLogger(No216.class);

    @Override
    public void go() {
        String resultStr = formatParam(solution(3, 9));
        log.info("result is : {}", resultStr);
    }

    private int maxDeep;

    private int should;

    private LinkedList<Integer> temp = new LinkedList<>();

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> solution(int k, int n) {

        maxDeep = k;
        should = n;

        back(1, 0);

        return result;
    }

    public void back(int index, int sum) {

        if (temp.size() == maxDeep) {

            if (should == sum) {
                result.add(new ArrayList<>(temp));
            }

            return;
        }

        for (int i = index; i < 10; i++) {
            temp.addLast(i);
            back(i + 1, sum + i);
            temp.removeLast();
        }

    }

}
