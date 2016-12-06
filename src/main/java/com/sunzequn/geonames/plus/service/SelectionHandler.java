package com.sunzequn.geonames.plus.service;

import com.sunzequn.geonames.plus.bean.Geoname;
import com.sunzequn.geonames.plus.bean.GeonameDesc;
import com.sunzequn.geonames.plus.dao.mysql.GeoNameDao;
import com.sunzequn.geonames.plus.loader.FClassMappingLoader;
import com.sunzequn.geonames.plus.loader.NamesLoader;
import com.sunzequn.geonames.plus.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by sloriac on 16-12-5.
 *
 */
@Service
public class SelectionHandler {


    @Autowired
    private NamesLoader namesLoader;
    @Autowired
    private FClassMappingLoader fclassMappingLoader;
    @Autowired
    private GeoNameDao geoNameDao;

    public List<GeonameDesc> descNames(String name) {
        List<GeonameDesc> descs = new ArrayList<>();
        List<String> ids;
        //判断中英文
        if (!StringUtil.isContainsStr(name)) {//中文
            ids = namesLoader.getIdByZhName(name);
        } else {//英文
            ids = namesLoader.getIdByName(name);
        }
        if (ids == null) return null;
        for (String id : ids) {
            Geoname geoname = geoNameDao.getById(Integer.parseInt(id));
            if (geoname != null) {
                descs.add(descGeoname(geoname, name));
            }
        }
        return descs.size() > 0 ? orderedDesc(descs) : null;
    }

    public GeonameDesc descGeoname(Geoname geoname, String name) {
        return new GeonameDesc("#", geoname.getGeonameid(), name, fclassMappingLoader.get(geoname.getFclass()), geoname.getFcode(), geoname.getCountry());
    }

    public List<GeonameDesc> orderedDesc(List<GeonameDesc> descs) {
        Collections.sort(descs, (o1, o2) -> o1.getFcode().compareTo(o2.getFcode()));
        int index = 0;
        for (GeonameDesc desc : descs) {
            index++;
            desc.setId(desc.getId() + index);
        }
        return descs;
    }
}
