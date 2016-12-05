package com.sunzequn.geonames.plus.loader;

import com.sunzequn.geonames.plus.utils.ReadUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sloriac on 16-12-5.
 */
@Repository
public class FClassMappingLoader {

    private Logger logger = Logger.getLogger(FClassMappingLoader.class);
    private Map<String, String> fclassMap = new HashMap<>();
    private String prefix;

    public FClassMappingLoader() {
        prefix = this.getClass().getClassLoader().getResource("").getPath();
        load();
    }

    private void load() {
        ReadUtil reader = new ReadUtil(prefix + "fclass_mappings");
        List<String> lines = reader.readByLine();
        for (String line : lines) {
            String[] params = line.split(" ");
            fclassMap.put(params[0], params[1]);
        }
        logger.info("加载fclass映射数据");
    }

    public String get(String key) {
        return fclassMap.get(key);
    }

}
