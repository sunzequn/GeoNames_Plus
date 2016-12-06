package com.sunzequn.geonames.plus.dao.mysql;

import com.sunzequn.geonames.plus.bean.Climate;
import com.sunzequn.geonames.plus.bean.Feedback;
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
public class FeedbackDao extends BaseDao {

    @Autowired
    private DataSourcePool dataSourcePool;
    private String table = "feedback";

    public void add(Feedback feedback) {
        try {
            Connection connection = dataSourcePool.getConnection();
            String sql = "insert into " + table + " (id, time, content, status) values (?, ?, ?, ?)";
            Object[] prams = {feedback.getId(), feedback.getTime(), feedback.getContent(), feedback.getStatus()};
            execute(connection, sql, prams);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
