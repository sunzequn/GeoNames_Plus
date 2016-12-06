package com.sunzequn.geonames.plus.dao.virtuoso;

import org.apache.commons.lang3.StringUtils;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by sloriac on 16-12-6.
 */
@Service
public class NearbySparql {

    @Autowired
    private Sparql sparql;

    public List<Integer> getNearby(int id) {
        String uri = "http://sws.geonames.org/" + id;
        String sql = "select * from <http://www.geonames.org/nearby/> where {<" + uri + "> <http://www.geonames.org/ontology#nearby> ?o}";
        System.out.println(sql);
        ResultSet resultSet = sparql.excSparql(sql);
        Set<Integer> idset = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        while (resultSet.hasNext()) {
            QuerySolution result = resultSet.nextSolution();
            String ouri = result.get("o").toString();
            int oid = Integer.parseInt(StringUtils.removeStart(ouri.trim(), "http://sws.geonames.org/"));
            if (!idset.contains(oid)) {
                idset.add(oid);
                res.add(oid);
            }
        }
        return res.size() > 0 ? res : null;
    }

}
