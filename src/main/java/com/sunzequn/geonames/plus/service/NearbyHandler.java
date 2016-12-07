package com.sunzequn.geonames.plus.service;

import com.sunzequn.geonames.plus.bean.Geoname;
import com.sunzequn.geonames.plus.bean.GeonameDesc;
import com.sunzequn.geonames.plus.dao.mysql.GeoNameDao;
import com.sunzequn.geonames.plus.dao.virtuoso.NearbySparql;
import com.sunzequn.geonames.plus.loader.NamesLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sloriac on 16-12-6.
 */
@Service
public class NearbyHandler {

    @Autowired
    private NamesLoader namesLoader;
    @Autowired
    private GeoNameDao geoNameDao;
    @Autowired
    private SelectionHandler selectionHandler;
    @Autowired
    private NearbySparql nearbySparql;

    public List<GeonameDesc> getNearby(int id) {
        Geoname geoname = geoNameDao.getById(id);
        if (geoname == null) return null;
        List<Geoname> geonames = geoNameDao.getNearby(geoname);
        return desc(geonames);
//        List<GeonameDesc> geonameDescs = getNearbyFromVirtuoso(id);
//        return geonameDescs.size() > 0 ? selectionHandler.orderedDesc(geonameDescs) : null;
    }

    public List<GeonameDesc> getNearbyFromVirtuoso(int id) {
        List<Integer> ids = nearbySparql.getNearby(id);
        if (ids == null) return null;
        return descByIds(ids);
    }

    public List<GeonameDesc> desc(List<Geoname> geonames) {
        List<GeonameDesc> geonameDescs = new ArrayList<>();
        for (Geoname geoname : geonames) {
            GeonameDesc geonameDesc = descByGeoname(geoname);
            geonameDescs.add(geonameDesc);
        }
        return geonameDescs.size() > 0 ? selectionHandler.orderedDesc(geonameDescs) : null;
    }

    public List<GeonameDesc> descByIds(List<Integer> ids) {
        List<GeonameDesc> geonameDescs = new ArrayList<>();
        for (Integer id : ids) {
            GeonameDesc geonameDesc = descById(id);
            if (geonameDesc != null)
                geonameDescs.add(geonameDesc);
        }
        return geonameDescs.size() > 0 ? selectionHandler.orderedDesc(geonameDescs) : null;
    }

    public GeonameDesc descByGeoname(Geoname geoname) {
        if (geoname == null) return null;
        String name = namesLoader.getZhNamesById(geoname.getGeonameid());
        if (name == null)
            name = namesLoader.getNameById(geoname.getGeonameid());
        return selectionHandler.descGeoname(geoname, name);
    }

    public GeonameDesc descById(int id) {
        Geoname geoname = geoNameDao.getById(id);
        if (geoname == null) return null;
        String name = namesLoader.getZhNamesById(id);
        if (name == null)
            name = namesLoader.getNameById(id);
        return selectionHandler.descGeoname(geoname, name);
    }
}
