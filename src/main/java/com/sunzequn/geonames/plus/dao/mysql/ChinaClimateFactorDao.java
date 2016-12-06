package com.sunzequn.geonames.plus.dao.mysql;

import com.sunzequn.geonames.plus.bean.ChinaClimateFactor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


/**
 * Created by sunzequn on 2016/7/22.
 */
@Repository
public class ChinaClimateFactorDao extends BaseDao {

    @Autowired
    private DataSourcePool dataSourcePool;
    private static final String TABLE = "ext_china_climate_factor";

    public List<ChinaClimateFactor> getById(int id) {
        Connection connection;
        try {
            connection = dataSourcePool.getConnection();
            String sql = "select * from " + TABLE + " where V01000 = ?";
            Object[] params = {id};
            List<ChinaClimateFactor> chinaClimateFactors = query(connection, sql, params, ChinaClimateFactor.class);
            return chinaClimateFactors != null ? chinaClimateFactors : null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
