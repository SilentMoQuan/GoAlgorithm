package cn.moquan.leet_code;

import cn.moquan.base.Doing;
import cn.moquan.base.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * describe
 * <br />
 *
 * @author :<b> wyh </b><br />
 * @date :<b> 2024/10/18 10:38 </b><br />
 */
public class No93 implements Doing, Log {

    private static final Logger log = LoggerFactory.getLogger(No93.class);

    /**
     * let us go
     */
    @Override
    public void go() {
        log.info("result: {}", restoreIpAddresses("25525511135"));
        log.info("result: {}", restoreIpAddresses("0000"));
        log.info("result: {}", restoreIpAddresses("101023"));
    }

    List<String> result;

    String str;

    int maxLen;

    public List<String> restoreIpAddresses(String s) {

        result = new ArrayList<>();
        maxLen = s.length();
        str = s;

        back(0, 0, new StringBuilder());

        return result;
    }

    public void back(int index, int partCount, StringBuilder builder) {

        if (index >= maxLen || partCount >= 4) {
            if (index >= maxLen && partCount >= 4) {
                result.add(builder.substring(0, builder.length() - 1));
            }
            return;
        }

        StringBuilder valueBuilder = new StringBuilder();

        int i = 0;
        while (i < 3 && index + i < maxLen) {
            valueBuilder.append(str.charAt(index + i));
            if (verify(valueBuilder)) {
                int value = Integer.parseInt(valueBuilder.toString());
                builder.append(value);
                builder.append('.');
                back(index + i + 1, partCount + 1, builder);
                builder.deleteCharAt(builder.length() - 1);
                builder.delete(builder.length() - valueBuilder.length(), builder.length());
            }

            i++;
        }

    }

    public boolean verify(StringBuilder builder) {

        if (builder.charAt(0) == '0') {
            return builder.length() == 1;
        }

        int value = Integer.parseInt(builder.toString());
        return 0 <= value && value <= 255;
    }

}
