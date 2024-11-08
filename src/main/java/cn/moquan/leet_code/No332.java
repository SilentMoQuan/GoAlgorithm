package cn.moquan.leet_code;

import cn.moquan.base.Doing;
import cn.moquan.base.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;

/**
 * describe
 * <br />
 *
 * @author :<b> wyh </b><br />
 * @date :<b> 2024/11/4 9:18 </b><br />
 */
public class No332 implements Doing, Log {

    private static final Logger log = LoggerFactory.getLogger(No332.class);
    private LinkedList<String> temp;
    private List<String> result;
    private Map<String, LinkedList<String>> map;
    private int maxLen = -1;

    /**
     * let us go
     */
    @Override
    public void go() {
        log.info("result: {}", findItinerary(Arrays.asList(Arrays.asList("MUC", "LHR"), Arrays.asList("JFK", "MUC"), Arrays.asList("SFO", "SJC"), Arrays.asList("LHR", "SFO"))));
        log.info("result: {}", findItinerary(Arrays.asList(Arrays.asList("JFK", "SFO"), Arrays.asList("JFK", "ATL"), Arrays.asList("SFO", "ATL"), Arrays.asList("ATL", "JFK"), Arrays.asList("ATL", "SFO"))));
        log.info("result: {}", findItinerary(new ArrayList<>(Arrays.asList(Arrays.asList("JFK", "SFO"), Arrays.asList("JFK", "ATL"), Arrays.asList("SFO", "JFK"), Arrays.asList("ATL", "AAA"), Arrays.asList("AAA", "BBB"), Arrays.asList("BBB", "ATL"), Arrays.asList("ATL", "AAA"), Arrays.asList("AAA", "BBB"), Arrays.asList("BBB", "ATL"), Arrays.asList("ATL", "AAA"), Arrays.asList("AAA", "BBB"), Arrays.asList("BBB", "ATL"), Arrays.asList("ATL", "AAA"), Arrays.asList("AAA", "BBB"), Arrays.asList("BBB", "ATL"), Arrays.asList("ATL", "AAA"), Arrays.asList("AAA", "BBB"), Arrays.asList("BBB", "ATL"), Arrays.asList("ATL", "AAA"), Arrays.asList("AAA", "BBB"), Arrays.asList("BBB", "ATL"), Arrays.asList("ATL", "AAA"), Arrays.asList("AAA", "BBB"), Arrays.asList("BBB", "ATL"), Arrays.asList("ATL", "AAA"), Arrays.asList("AAA", "BBB"), Arrays.asList("BBB", "ATL"), Arrays.asList("ATL", "AAA"), Arrays.asList("AAA", "BBB"), Arrays.asList("BBB", "ATL"), Arrays.asList("ATL", "AAA"), Arrays.asList("AAA", "BBB"), Arrays.asList("BBB", "ATL"), Arrays.asList("ATL", "AAA"), Arrays.asList("AAA", "BBB"), Arrays.asList("BBB", "ATL"), Arrays.asList("ATL", "AAA"), Arrays.asList("AAA", "BBB"), Arrays.asList("BBB", "ATL"), Arrays.asList("ATL", "AAA"), Arrays.asList("AAA", "BBB"), Arrays.asList("BBB", "ATL"), Arrays.asList("ATL", "AAA"), Arrays.asList("AAA", "BBB"), Arrays.asList("BBB", "ATL"), Arrays.asList("ATL", "AAA"), Arrays.asList("AAA", "BBB"), Arrays.asList("BBB", "ATL"), Arrays.asList("ATL", "AAA"), Arrays.asList("AAA", "BBB"), Arrays.asList("BBB", "ATL"), Arrays.asList("ATL", "AAA"), Arrays.asList("AAA", "BBB"), Arrays.asList("BBB", "ATL"), Arrays.asList("ATL", "AAA"), Arrays.asList("AAA", "BBB"), Arrays.asList("BBB", "ATL"), Arrays.asList("ATL", "AAA"), Arrays.asList("AAA", "BBB"), Arrays.asList("BBB", "ATL"), Arrays.asList("ATL", "AAA"), Arrays.asList("AAA", "BBB"), Arrays.asList("BBB", "ATL"), Arrays.asList("ATL", "AAA"), Arrays.asList("AAA", "BBB"), Arrays.asList("BBB", "ATL"), Arrays.asList("ATL", "AAA"), Arrays.asList("AAA", "BBB"), Arrays.asList("BBB", "ATL")))));
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        temp = new LinkedList<>();
        maxLen = tickets.size() + 1;
        result = null;

        tickets.sort(Comparator.comparing(t -> t.get(1)));

        map = tickets.stream()
                .collect(
                        Collectors.groupingBy(
                                list -> list.get(0),
                                HashMap::new,
                                Collectors.mapping(list -> list.get(1), Collectors.toCollection(LinkedList::new))
                        )
                );

        back("JFK");

        return result;
    }

    private void back(String start) {
        log.info("start: {}", start);
        temp.addLast(start);

        if (result != null) {
            return;
        }

        if (temp.size() >= maxLen) {
            result = new ArrayList<>(temp);
            return;
        }

        LinkedList<String> tickets = map.getOrDefault(start, new LinkedList<>());

        ArrayList<String> lists = new ArrayList<>(tickets);
        for (int i = 0; i < lists.size(); i++) {
            String ticket = lists.get(i);

            if (i > 0 && ticket.equals(lists.get(i - 1))) {
                continue;
            }

            tickets.remove(ticket);
            back(ticket);
            tickets.add(ticket);
        }

        temp.removeLast();
    }

}
