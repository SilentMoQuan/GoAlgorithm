package cn.moquan.base;

import cn.moquan.util.StringUtil;

/**
 * describe
 * <br />
 *
 * @author :<b> wyh </b><br />
 * @date :<b> 2024/10/10 22:24 </b><br />
 */
public interface Log {

    default String formatParam(Object obj) {
        return StringUtil.toStringFormat(obj);
    }

}
