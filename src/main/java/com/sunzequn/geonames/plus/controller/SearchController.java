package com.sunzequn.geonames.plus.controller;

import com.sunzequn.geonames.plus.bean.Geoname;
import com.sunzequn.geonames.plus.bean.GeonameDesc;
import com.sunzequn.geonames.plus.dao.mysql.GeoNameDao;
import com.sunzequn.geonames.plus.loader.NamesLoader;
import com.sunzequn.geonames.plus.service.SelectionHandler;
import com.sunzequn.geonames.plus.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by sloriac on 16-12-4.
 */

@Controller
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private SelectionHandler selectionHandler;

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String search(Model model, @PathVariable String name) {
        List<GeonameDesc> descs = selectionHandler.descNames(name);
        if (descs == null) {
            return "index";
        } else if (descs.size() > 1) {
            model.addAttribute("name", name);
            model.addAttribute("selections", descs);
            return "selection";
        } else {
            return "redirect:/view/" + descs.get(0).getGeonameid();
        }
    }

}
