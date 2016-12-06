package com.sunzequn.geonames.plus.dao.mysql;

import com.sunzequn.geonames.plus.bean.Climate;
import com.sunzequn.geonames.plus.bean.Geoname;
import com.sunzequn.geonames.plus.utils.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


/**
 * Created by sloriac on 16-12-4.
 */
@Repository
public class ClimateDao extends BaseDao {

    @Autowired
    private DataSourcePool dataSourcePool;
    private String table = "geoname_climate";

    public Climate getById(int geonameId) {
        Connection connection;
        try {
            connection = dataSourcePool.getConnection();
            String sql = "select * from " + table + " where geonameid = " + geonameId;
            List<Climate> climates = query(connection, sql, null, Climate.class);
            connection.close();
            if (ListUtil.isEmpty(climates))
                return null;
            return climates.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


}
