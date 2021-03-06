package com.sunzequn.geonames.plus.service;

import com.github.jsonldjava.utils.Obj;
import com.sunzequn.geonames.plus.bean.ChinaClimateFactor;
import com.sunzequn.geonames.plus.bean.Climate;
import com.sunzequn.geonames.plus.bean.Geoname;
import com.sunzequn.geonames.plus.bean.PropValue;
import com.sunzequn.geonames.plus.dao.mysql.ChinaClimateFactorDao;
import com.sunzequn.geonames.plus.dao.mysql.ClimateDao;
import com.sunzequn.geonames.plus.dao.mysql.GeoNameDao;
import com.sunzequn.geonames.plus.dao.virtuoso.WikiSparql;
import com.sunzequn.geonames.plus.loader.FClassMappingLoader;
import com.sunzequn.geonames.plus.loader.GeoNamesClimateLoader;
import com.sunzequn.geonames.plus.loader.GeoNamesClimateSiteLoader;
import com.sunzequn.geonames.plus.loader.NamesLoader;
import com.sunzequn.geonames.plus.utils.DoubleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sloriac on 16-12-6.
 * <p>
 * 给定id,获取所有信息
 */
@Service
public class ViewHandler {

    @Autowired
    private GeoNameDao geoNameDao;
    @Autowired
    private NamesLoader namesLoader;
    @Autowired
    private FClassMappingLoader fClassMappingLoader;
    //    @Autowired
//    private GeoNamesClimateLoader climateLoader;
    @Autowired
    private ClimateDao climateDao = new ClimateDao();
    @Autowired
    private ChinaClimateFactorDao chinaClimateFactorDao;
    @Autowired
    private GeoNamesClimateSiteLoader geoNamesClimateSiteLoader;
    @Autowired
    private WikiSparql wikiSparql;

    public Object[] geneProps(int id) {
        List<PropValue> propValues = new ArrayList<>();
        Object[] objs = geneBasicProp(id);
        List<PropValue> basicProps = (List<PropValue>) objs[0];
        String names = (String) objs[1];
        double lng = (double) objs[2];
        double lat = (double) objs[3];
        if (basicProps == null) return null;
        propValues.addAll(basicProps);
        List<PropValue> climatePropValues = geneClimateProp(id);
        if (climatePropValues != null)
            propValues.addAll(climatePropValues);
        String wiki = wikiSparql.getWiki(id);
        if (wiki == null)
            return new Object[]{propValues, names, lng, lat};
        return new Object[]{propValues, names, lng, lat, wiki};
    }

    private List<PropValue> geneClimateProp(int id) {
        Climate climate = climateDao.getById(id);
        if (climate == null) return null;
        List<PropValue> climateProps = new ArrayList<>();
        double nianjunqiwen = nianJunQiWen(id);
        if (nianjunqiwen > -1) climateProps.add(new PropValue("年均气温(℃)", String.valueOf(DoubleUtil.m2d(nianjunqiwen))));

        climateProps.add(new PropValue("年均降水总量(mm)", climate.getNianJunJiangShui()));
        climateProps.add(new PropValue("夏季降水总量(mm)", climate.getXiaJiJiangShui()));
        climateProps.add(new PropValue("冬季降水总量(mm)", climate.getDongJiJiangShui()));
        climateProps.add(new PropValue("Koppen气候类型", climate.getKoppen()));
        climateProps.add(new PropValue("气候类型", climate.getZhongXueQiHouLeiXing()));
        climateProps.add(new PropValue("热量带", climate.getReLiangDai()));
        return climateProps;
    }

    private Object[] geneBasicProp(int id) {
        Geoname geoname = geoNameDao.getById(id);
        if (geoname == null) return null;
        List<PropValue> basicProps = new ArrayList<>();

        basicProps.add(new PropValue("ID", String.valueOf(id)));

        String names = namesLoader.getZhNamesById(id);
        if (names == null) names = geoname.getAsciiname();
        basicProps.add(new PropValue("名称", names));

        basicProps.add(new PropValue("类型", fClassMappingLoader.get(geoname.getFclass())));
        basicProps.add(new PropValue("具体类型", geoname.getFcode()));
        basicProps.add(new PropValue("国家", geoname.getCountry()));
        basicProps.add(new PropValue("经度", String.valueOf(geoname.getLongitude())));
        basicProps.add(new PropValue("纬度", String.valueOf(geoname.getLatitude())));
        basicProps.add(new PropValue("海拔", String.valueOf(geoname.getGtopo30())));

        double population = geoname.getPopulation();
        if (population > 0)
            basicProps.add(new PropValue("人口", String.valueOf(population)));

        basicProps.add(new PropValue("时区", geoname.getTimezone()));
        return new Object[]{basicProps, names, geoname.getLongitude(), geoname.getLatitude()};
    }

    public double nianJunQiWen(int geonameid) {
        Integer id = geoNamesClimateSiteLoader.getSiteById(geonameid);
        if (id == null) return -1;
        List<ChinaClimateFactor> factors = chinaClimateFactorDao.getById(id);
        if (factors != null) {
            double temp = 0;
            for (ChinaClimateFactor factor : factors) {
                temp += factor.getV12001();
            }
            return temp / factors.size() / 10;
        }
        return -1;
    }
}
