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
public class GeoNamesClimateSiteLoader {

    private Logger logger = Logger.getLogger(GeoNamesClimateSiteLoader.class);
    private Map<Integer, Integer> climateSiteMap = new HashMap<>();
    private String prefix;

    public GeoNamesClimateSiteLoader() {
        prefix = this.getClass().getClassLoader().getResource("").getPath();
        load();
    }

    private void load() {
        ReadUtil reader = new ReadUtil(prefix + "geonames_china_climate_site");
        List<String> lines = reader.readByLine();
        for (String line : lines) {
            String[] params = line.split("\t");
            if (params.length == 2) {
                climateSiteMap.put(Integer.parseInt(params[0]), Integer.parseInt(params[1]));
            }
        }
        logger.info("加载GeoNames气候站点数据, 数量:" + climateSiteMap.size());
    }

    public Integer getSiteById(int id) {
        return climateSiteMap.get(id);
    }
}
