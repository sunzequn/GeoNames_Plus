package com.sunzequn.geonames.plus.loader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sloriac on 16-12-5.
 */
public class One2MoreHashSet {

    private Map<String, List<Integer>> map = new HashMap<>();

    public void add(String key, int value) {
        if (!map.containsKey(key)) {
            List<Integer> values = new ArrayList<>();
            values.add(value);
            map.put(key, values);
        } else {
            map.get(key).add(value);
        }
    }

    public int getNum() {
        return map.size();
    }

    public List<Integer> get(String key) {
        return map.get(key);
    }
}
