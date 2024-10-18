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
 * @date :<b> 2024/10/18 9:49 </b><br />
 */
public class No131 implements Doing, Log {
    private static final Logger log = LoggerFactory.getLogger(No131.class);

    /**
     * let us go
     */
    @Override
    public void go() {
        log.info("result :: {}", partition("aab"));
    }

    int maxLne;
    String target;
    List<List<String>> result;
    LinkedList<String> temp;

    public List<List<String>> partition(String s) {

        result = new ArrayList<>();
        temp = new LinkedList<>();
        maxLne = s.length();
        target = s;

        back(0);

        return result;
    }

    public void back(int index) {

        if (index >= maxLne) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int len = 1; len < maxLne - index + 1; len++) {

            String slice = target.substring(index, index + len);

            if (isPalindrome(slice)) {
                temp.addLast(slice);
                back(index + len);
                temp.removeLast();
            }

        }

    }

    private boolean isPalindrome(String s) {

        int len = s.length();

        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
