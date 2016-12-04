package com.sunzequn.geonames.plus.dao.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * Created by sloriac on 16-12-4.
 *
 */
@Repository
public class GeoNameDao extends BaseDao {

    @Autowired
    private DataSourcePool dataSourcePool;

}
