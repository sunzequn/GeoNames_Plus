package com.sunzequn.geonames.plus.controller;

import com.sunzequn.geonames.plus.bean.PropValue;
import com.sunzequn.geonames.plus.service.ViewHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by sloriac on 16-12-5.
 */
@Controller
@RequestMapping("/as")
public class ASController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String view() {
        return "redirect:http://210.28.132.62:8080/GEONamesAS/";
    }
}
