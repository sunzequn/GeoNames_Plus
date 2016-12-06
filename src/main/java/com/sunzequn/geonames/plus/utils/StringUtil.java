package com.sunzequn.geonames.plus.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sloriac on 16-12-5.
 */
public class StringUtil {

    public static boolean isContainsStr(String cardNum) {
        String regex = ".*[a-zA-Z]+.*";
        Matcher m = Pattern.compile(regex).matcher(cardNum);
        return m.matches();
    }

}
