package com.sunzequn.geonames.plus.dao.mysql;

import com.sunzequn.geonames.plus.bean.Geoname;
import com.sunzequn.geonames.plus.utils.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


/**
 * Created by sloriac on 16-12-4.
 *
 */
@Repository
public class GeoNameDao extends BaseDao {

    @Autowired
    private DataSourcePool dataSourcePool;
    private String table = "geoname";

    public Geoname getById(int geonameId) {
        try {
            Connection connection = dataSourcePool.getConnection();
            String sql = "select * from " + table + " where geonameid = " + geonameId;
            List<Geoname> geonames = query(connection, sql, null, Geoname.class);
            connection.close();
            if (ListUtil.isEmpty(geonames))
                return null;
            return geonames.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Geoname> getNearby(Geoname geoname) {
        double latMin = geoname.getLatitude() - 0.5;
        double latMax = geoname.getLatitude() + 0.5;
        double lngMin = geoname.getLongitude() - 0.5;
        double lngMax = geoname.getLongitude() + 0.5;
        try {
            Connection connection = dataSourcePool.getConnection();
            String sql = "select * from " + table + " where longitude > ? and longitude < ? and latitude > ? and latitude < ? and fclass = ? and geonameid <> ?";
            Object[] params = {lngMin, lngMax, latMin, latMax, geoname.getFclass(), geoname.getGeonameid()};
            List<Geoname> geonames = query(connection, sql, params, Geoname.class);
            connection.close();
            if (ListUtil.isEmpty(geonames))
                return null;
            return geonames;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }


}
