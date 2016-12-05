package com.sunzequn.geonames.plus.loader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sloriac on 16-12-5.
 */
public class One2MoreHashSet {

    private static Map<String, List<String>> map = new HashMap<>();

    public static void add(String key, String value) {
        if (!map.containsKey(key)) {
            List<String> values = new ArrayList<>();
            values.add(value);
            map.put(key, values);
        } else {
            map.get(key).add(value);
        }
    }
}
