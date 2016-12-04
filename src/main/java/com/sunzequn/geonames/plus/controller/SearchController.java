package com.sunzequn.geonames.plus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by sloriac on 16-12-4.
 */

@Controller
@RequestMapping("/search")
public class SearchController {

    @RequestMapping(value = "/{name}/{type}", method = RequestMethod.GET)
    public String searchBasicInfo(@PathVariable String name, @PathVariable int type) {
        System.out.println(name);
        System.out.println(type);
        return "basicinfo";
    }
}
