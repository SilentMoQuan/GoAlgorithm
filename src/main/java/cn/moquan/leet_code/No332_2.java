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
 * @date :<b> 2024/11/4 9:18 </b><br />
 */
public class No332_2 implements Doing, Log {

    private static final Logger log = LoggerFactory.getLogger(No332_2.class);
    private LinkedList<String> temp;
    private List<String> result;
    private Map<String, Map<String, Long>> map;
    private int maxLen = -1;

    /**
     * let us go
     */
    @Override
    public void go() {
        log.info("result: {}", findItinerary(Arrays.asList(Arrays.asList("MUC", "LHR"), Arrays.asList("JFK", "MUC"), Arrays.asList("SFO", "SJC"), Arrays.asList("LHR", "SFO"))));
        log.info("result: {}", findItinerary(Arrays.asList(Arrays.asList("JFK", "SFO"), Arrays.asList("JFK", "ATL"), Arrays.asList("SFO", "ATL"), Arrays.asList("ATL", "JFK"), Arrays.asList("ATL", "SFO"))));
        // ["JFK","ATL","JFK","SFO","ATL","SFO"]
        log.info("result: {}", findItinerary(new ArrayList<>(Arrays.asList(Arrays.asList("JFK", "SFO"), Arrays.asList("JFK", "ATL"), Arrays.asList("SFO", "JFK"), Arrays.asList("ATL", "AAA"), Arrays.asList("AAA", "BBB"), Arrays.asList("BBB", "ATL"), Arrays.asList("ATL", "AAA"), Arrays.asList("AAA", "BBB"), Arrays.asList("BBB", "ATL"), Arrays.asList("ATL", "AAA"), Arrays.asList("AAA", "BBB"), Arrays.asList("BBB", "ATL"), Arrays.asList("ATL", "AAA"), Arrays.asList("AAA", "BBB"), Arrays.asList("BBB", "ATL"), Arrays.asList("ATL", "AAA"), Arrays.asList("AAA", "BBB"), Arrays.asList("BBB", "ATL"), Arrays.asList("ATL", "AAA"), Arrays.asList("AAA", "BBB"), Arrays.asList("BBB", "ATL"), Arrays.asList("ATL", "AAA"), Arrays.asList("AAA", "BBB"), Arrays.asList("BBB", "ATL"), Arrays.asList("ATL", "AAA"), Arrays.asList("AAA", "BBB"), Arrays.asList("BBB", "ATL"), Arrays.asList("ATL", "AAA"), Arrays.asList("AAA", "BBB"), Arrays.asList("BBB", "ATL"), Arrays.asList("ATL", "AAA"), Arrays.asList("AAA", "BBB"), Arrays.asList("BBB", "ATL"), Arrays.asList("ATL", "AAA"), Arrays.asList("AAA", "BBB"), Arrays.asList("BBB", "ATL"), Arrays.asList("ATL", "AAA"), Arrays.asList("AAA", "BBB"), Arrays.asList("BBB", "ATL"), Arrays.asList("ATL", "AAA"), Arrays.asList("AAA", "BBB"), Arrays.asList("BBB", "ATL"), Arrays.asList("ATL", "AAA"), Arrays.asList("AAA", "BBB"), Arrays.asList("BBB", "ATL"), Arrays.asList("ATL", "AAA"), Arrays.asList("AAA", "BBB"), Arrays.asList("BBB", "ATL"), Arrays.asList("ATL", "AAA"), Arrays.asList("AAA", "BBB"), Arrays.asList("BBB", "ATL"), Arrays.asList("ATL", "AAA"), Arrays.asList("AAA", "BBB"), Arrays.asList("BBB", "ATL"), Arrays.asList("ATL", "AAA"), Arrays.asList("AAA", "BBB"), Arrays.asList("BBB", "ATL"), Arrays.asList("ATL", "AAA"), Arrays.asList("AAA", "BBB"), Arrays.asList("BBB", "ATL"), Arrays.asList("ATL", "AAA"), Arrays.asList("AAA", "BBB"), Arrays.asList("BBB", "ATL"), Arrays.asList("ATL", "AAA"), Arrays.asList("AAA", "BBB"), Arrays.asList("BBB", "ATL"), Arrays.asList("ATL", "AAA"), Arrays.asList("AAA", "BBB"), Arrays.asList("BBB", "ATL")))));
        log.info("result: {}", findItinerary(Arrays.asList(Arrays.asList("AXA", "EZE"), Arrays.asList("EZE", "AUA"), Arrays.asList("ADL", "JFK"), Arrays.asList("ADL", "TIA"), Arrays.asList("AUA", "AXA"), Arrays.asList("EZE", "TIA"), Arrays.asList("EZE", "TIA"), Arrays.asList("AXA", "EZE"), Arrays.asList("EZE", "ADL"), Arrays.asList("ANU", "EZE"), Arrays.asList("TIA", "EZE"), Arrays.asList("JFK", "ADL"), Arrays.asList("AUA", "JFK"), Arrays.asList("JFK", "EZE"), Arrays.asList("EZE", "ANU"), Arrays.asList("ADL", "AUA"), Arrays.asList("ANU", "AXA"), Arrays.asList("AXA", "ADL"), Arrays.asList("AUA", "JFK"), Arrays.asList("EZE", "ADL"), Arrays.asList("ANU", "TIA"), Arrays.asList("AUA", "JFK"), Arrays.asList("TIA", "JFK"), Arrays.asList("EZE", "AUA"), Arrays.asList("AXA", "EZE"), Arrays.asList("AUA", "ANU"), Arrays.asList("ADL", "AXA"), Arrays.asList("EZE", "ADL"), Arrays.asList("AUA", "ANU"), Arrays.asList("AXA", "EZE"), Arrays.asList("TIA", "AUA"), Arrays.asList("AXA", "EZE"), Arrays.asList("AUA", "SYD"), Arrays.asList("ADL", "JFK"), Arrays.asList("EZE", "AUA"), Arrays.asList("ADL", "ANU"), Arrays.asList("AUA", "TIA"), Arrays.asList("ADL", "EZE"), Arrays.asList("TIA", "JFK"), Arrays.asList("AXA", "ANU"), Arrays.asList("JFK", "AXA"), Arrays.asList("JFK", "ADL"), Arrays.asList("ADL", "EZE"), Arrays.asList("AXA", "TIA"), Arrays.asList("JFK", "AUA"), Arrays.asList("ADL", "EZE"), Arrays.asList("JFK", "ADL"), Arrays.asList("ADL", "AXA"), Arrays.asList("TIA", "AUA"), Arrays.asList("AXA", "JFK"), Arrays.asList("ADL", "AUA"), Arrays.asList("TIA", "JFK"), Arrays.asList("JFK", "ADL"), Arrays.asList("JFK", "ADL"), Arrays.asList("ANU", "AXA"), Arrays.asList("TIA", "AXA"), Arrays.asList("EZE", "JFK"), Arrays.asList("EZE", "AXA"), Arrays.asList("ADL", "TIA"), Arrays.asList("JFK", "AUA"), Arrays.asList("TIA", "EZE"), Arrays.asList("EZE", "ADL"), Arrays.asList("JFK", "ANU"), Arrays.asList("TIA", "AUA"), Arrays.asList("EZE", "ADL"), Arrays.asList("ADL", "JFK"), Arrays.asList("ANU", "AXA"), Arrays.asList("AUA", "AXA"), Arrays.asList("ANU", "EZE"), Arrays.asList("ADL", "AXA"), Arrays.asList("ANU", "AXA"), Arrays.asList("TIA", "ADL"), Arrays.asList("JFK", "ADL"), Arrays.asList("JFK", "TIA"), Arrays.asList("AUA", "ADL"), Arrays.asList("AUA", "TIA"), Arrays.asList("TIA", "JFK"), Arrays.asList("EZE", "JFK"), Arrays.asList("AUA", "ADL"), Arrays.asList("ADL", "AUA"), Arrays.asList("EZE", "ANU"), Arrays.asList("ADL", "ANU"), Arrays.asList("AUA", "AXA"), Arrays.asList("AXA", "TIA"), Arrays.asList("AXA", "TIA"), Arrays.asList("ADL", "AXA"), Arrays.asList("EZE", "AXA"), Arrays.asList("AXA", "JFK"), Arrays.asList("JFK", "AUA"), Arrays.asList("ANU", "ADL"), Arrays.asList("AXA", "TIA"), Arrays.asList("ANU", "AUA"), Arrays.asList("JFK", "EZE"), Arrays.asList("AXA", "ADL"), Arrays.asList("TIA", "EZE"), Arrays.asList("JFK", "AXA"), Arrays.asList("AXA", "ADL"), Arrays.asList("EZE", "AUA"), Arrays.asList("AXA", "ANU"), Arrays.asList("ADL", "EZE"), Arrays.asList("AUA", "EZE")
        )));
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        temp = new LinkedList<>();
        maxLen = tickets.size() + 1;
        result = null;
        map = new HashMap<>();

        for (List<String> ticket : tickets) {
            Map<String, Long> toMap = map.getOrDefault(ticket.get(0), new HashMap<>());
            Long count = toMap.getOrDefault(ticket.get(1), 0L);
            toMap.put(ticket.get(1), count + 1);
            map.put(ticket.get(0), toMap);
        }

        back("JFK");

        return result;
    }

    private void back(String start) {
//        log.info("start: {}", start);
        temp.addLast(start);

        if (null != result) {
            return;
        }

        if (temp.size() >= maxLen) {
            result = new ArrayList<>(temp);
            return;
        }

        map.getOrDefault(start, new HashMap<>(0))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .filter(entry -> entry.getValue() > 0)
                .forEach(entry -> {
                    Long count = entry.getValue();
                    entry.setValue(count - 1);
                    back(entry.getKey());
                    entry.setValue(count);
                });

        temp.removeLast();
    }

}
