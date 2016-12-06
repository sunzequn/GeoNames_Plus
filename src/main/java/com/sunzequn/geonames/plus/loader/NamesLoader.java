package com.sunzequn.geonames.plus.loader;

import com.sunzequn.geonames.plus.utils.ReadUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sloriac on 16-12-5.
 */
@Repository
public class NamesLoader {

    private Logger logger = Logger.getLogger(NamesLoader.class);
    private One2MoreHashSet zhNames2IdsMap = new One2MoreHashSet();
    private One2MoreHashSet ids2ZhNamesMap = new One2MoreHashSet();
    private One2MoreHashSet names2IdsMap = new One2MoreHashSet();

    private String prefix;

    public NamesLoader() {
        prefix = this.getClass().getClassLoader().getResource("").getPath();
        loadZhNames();
        loadNames();
    }

    public List<String> getIdByZhName(String name) {
        return zhNames2IdsMap.get(name);
    }

    public List<String> getIdByName(String name) {
        return names2IdsMap.get(name);
    }

    public String getZhNamesById(int id) {
        List<String> names = ids2ZhNamesMap.get(String.valueOf(id));
        if (names == null) return null;
        String res = "";
        for (String name : names) {
            res += (name + ", ");
        }
        res = StringUtils.strip(res, ", ");
        return res;
    }

    private void loadNames() {
        String file = prefix + "geonames_names";
        load(names2IdsMap, file, null);
        logger.info("加载GeoNames名称数据, 数量:" + names2IdsMap.getNum());
    }

    private void loadZhNames() {
        String file = prefix + "geonames_zhs_all";
        load(zhNames2IdsMap, file, ids2ZhNamesMap);
        logger.info("加载GeoNames中文名称数据, 数量:" + zhNames2IdsMap.getNum());
    }

    private void load(One2MoreHashSet map, String file, One2MoreHashSet ids2ZhNamesMap) {
        ReadUtil reader = new ReadUtil(file);
        List<String> lines = reader.readByLine();
        for (String line : lines) {
            String[] params = line.split("\t");
            if (params.length == 2) {
                // 名称作为key
                map.add(params[1], params[0]);
                if (ids2ZhNamesMap != null) {
                    ids2ZhNamesMap.add(params[0], params[1]);
                }
            }
        }
    }
}
