package com.sunzequn.geonames.plus.bean;

/**
 * Created by sloriac on 16-12-6.
 */
public class PropValue {

    private String prop;
    private String value;

    public PropValue() {
    }

    public PropValue(String prop, String value) {
        this.prop = prop;
        this.value = value;
    }

    public String getProp() {
        return prop;
    }

    public void setProp(String prop) {
        this.prop = prop;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "PropValue{" +
                "prop='" + prop + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
