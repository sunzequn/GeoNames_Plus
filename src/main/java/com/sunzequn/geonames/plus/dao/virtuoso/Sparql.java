package com.sunzequn.geonames.plus.dao.virtuoso;

import org.apache.jena.query.ParameterizedSparqlString;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFactory;

import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Created by sloriac on 16-12-6.
 */
public class Sparql {

    private String ip;

    public Sparql(String ip) {
        this.ip = ip;
    }

    public ResultSet excSparql(String sql) {
        try {
            ParameterizedSparqlString sparqlstr = new ParameterizedSparqlString(sql);
            URL queryURL = new URL(ip + "sparql?default-graph-uri=&query=" + URLEncoder.encode(sparqlstr.toString(), "UTF-8") + "&format=xml%2Fhtml&timeout=0&debug=on");
            System.out.println(queryURL.toString());
            URLConnection connAPI = queryURL.openConnection();
            connAPI.setConnectTimeout(10000);
            connAPI.connect();
            ResultSet rs = ResultSetFactory.fromXML(connAPI.getInputStream());
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
