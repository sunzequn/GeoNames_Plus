package com.sunzequn.geonames.plus.bean;

/**
 * Created by sloriac on 16-12-5.
 */
public class GeonameDesc {

    private String id;
    private int geonameid;
    private String name;
    private String fclass;
    private String country;

    public GeonameDesc(String id, int geonameid, String name, String fclass, String country) {
        this.id = id;
        this.geonameid = geonameid;
        this.name = name;
        this.fclass = fclass;
        this.country = country;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getGeonameid() {
        return geonameid;
    }

    public void setGeonameid(int geonameid) {
        this.geonameid = geonameid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFclass() {
        return fclass;
    }

    public void setFclass(String fclass) {
        this.fclass = fclass;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "GeonameDesc{" +
                "id='" + id + '\'' +
                ", geonameid=" + geonameid +
                ", name='" + name + '\'' +
                ", fclass='" + fclass + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
