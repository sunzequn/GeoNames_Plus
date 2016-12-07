package com.sunzequn.geonames.plus.dao.virtuoso;

import com.sunzequn.geonames.plus.bean.Geoname;
import com.sunzequn.geonames.plus.utils.GeoNameUtil;
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
public class WikiSparql {

    @Autowired
    private Sparql sparql;

    public String getWiki(int id) {
        String uri = GeoNameUtil.getUri(id);
        String sql = "select * from <http://www.geonames.org/about/> where {<" + uri + "> <http://www.geonames.org/ontology#wikipediaArticle> ?o}";
        System.out.println(sql);
        ResultSet resultSet = sparql.excSparql(sql);
        while (resultSet.hasNext()) {
            QuerySolution result = resultSet.nextSolution();
            return result.get("o").toString();
        }
        return null;
    }

}
