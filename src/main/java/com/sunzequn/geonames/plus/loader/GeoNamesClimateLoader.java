package com.sunzequn.geonames.plus.loader;

import com.sunzequn.geonames.plus.bean.Climate;
import com.sunzequn.geonames.plus.utils.ReadUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sloriac on 16-12-6.
 */
@Service
public class GeoNamesClimateLoader {

    private Logger logger = Logger.getLogger(GeoNamesClimateLoader.class);
    private Map<Integer, Climate> climateMap = new HashMap<>();
    private String prefix;

    public GeoNamesClimateLoader() {
        prefix = this.getClass().getClassLoader().getResource("").getPath();
        load();
    }

    private void load() {
        ReadUtil reader = new ReadUtil(prefix + "geonames_climate");
        List<String> lines = reader.readByLine();
        for (String line : lines) {
            String[] params = line.split("\t");
            if (params.length == 7) {
                climateMap.put(Integer.parseInt(params[0]),
                        new Climate(params[1], params[2], params[3], params[4], params[5], params[6]));
            }
        }
        logger.info("加载GeoNames气候数据, 数量:" + climateMap.size());
    }

    public Climate getById(int id) {
        return climateMap.get(id);
    }
}
