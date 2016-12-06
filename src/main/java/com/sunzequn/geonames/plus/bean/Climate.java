package com.sunzequn.geonames.plus.bean;

/**
 * Created by sloriac on 16-12-6.
 */
public class Climate {

    private String nianJunJiangShui;
    private String xiaJiJiangShui;
    private String dongJiJiangShui;
    private String koppen;
    private String zhongXueQiHouLeiXing;
    private String reLiangDai;

    public Climate() {
    }

    public Climate(String nianJunJiangShui, String xiaJiJiangShui, String dongJiJiangShui, String koppen, String zhongXueQiHouLeiXing, String reLiangDai) {
        this.nianJunJiangShui = nianJunJiangShui;
        this.xiaJiJiangShui = xiaJiJiangShui;
        this.dongJiJiangShui = dongJiJiangShui;
        this.koppen = koppen;
        this.zhongXueQiHouLeiXing = zhongXueQiHouLeiXing;
        this.reLiangDai = reLiangDai;
    }

    public String getNianJunJiangShui() {
        return nianJunJiangShui;
    }

    public void setNianJunJiangShui(String nianJunJiangShui) {
        this.nianJunJiangShui = nianJunJiangShui;
    }

    public String getXiaJiJiangShui() {
        return xiaJiJiangShui;
    }

    public void setXiaJiJiangShui(String xiaJiJiangShui) {
        this.xiaJiJiangShui = xiaJiJiangShui;
    }

    public String getDongJiJiangShui() {
        return dongJiJiangShui;
    }

    public void setDongJiJiangShui(String dongJiJiangShui) {
        this.dongJiJiangShui = dongJiJiangShui;
    }

    public String getKoppen() {
        return koppen;
    }

    public void setKoppen(String koppen) {
        this.koppen = koppen;
    }

    public String getZhongXueQiHouLeiXing() {
        return zhongXueQiHouLeiXing;
    }

    public void setZhongXueQiHouLeiXing(String zhongXueQiHouLeiXing) {
        this.zhongXueQiHouLeiXing = zhongXueQiHouLeiXing;
    }

    public String getReLiangDai() {
        return reLiangDai;
    }

    public void setReLiangDai(String reLiangDai) {
        this.reLiangDai = reLiangDai;
    }
}
