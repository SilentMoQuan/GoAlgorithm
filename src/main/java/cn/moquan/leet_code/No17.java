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
 * @date :<b> 2024/10/14 21:42 </b><br />
 */
public class No17 implements Doing, Log {

    private static final Logger log = LoggerFactory.getLogger(No17.class);

    private Map<Character, List<Character>> mapping = new HashMap<>();

    {
        mapping.put('2', Arrays.asList('a', 'b', 'c'));
        mapping.put('3', Arrays.asList('d', 'e', 'f'));
        mapping.put('4', Arrays.asList('g', 'h', 'i'));
        mapping.put('5', Arrays.asList('j', 'k', 'l'));
        mapping.put('6', Arrays.asList('m', 'n', 'o'));
        mapping.put('7', Arrays.asList('p', 'q', 'r', 's'));
        mapping.put('8', Arrays.asList('t', 'u', 'v'));
        mapping.put('9', Arrays.asList('w', 'x', 'y', 'z'));
    }

    private int maxLen;

    private char[] buttons;

    private final List<String> result = new ArrayList<>();

    private final StringBuilder temp = new StringBuilder();

    private void back(int index) {

        if (temp.length() == maxLen) {
            result.add(temp.toString());
            return;
        }

        List<Character> letters = mapping.getOrDefault(buttons[index], Collections.emptyList());
        for (Character letter : letters) {
            temp.append(letter);
            back(index + 1);
            temp.deleteCharAt(index);
        }

    }

    public List<String> letterCombinations(String digits) {

        if (digits.isEmpty()) {
            return Collections.emptyList();
        }

        buttons = digits.toCharArray();
        maxLen = digits.length();
        back(0);
        return result;
    }

    @Override
    public void go() {
        List<String> answer = letterCombinations("23");
        String resultStr = formatParam(answer);
        log.info("result is : {}", resultStr);
    }
}
