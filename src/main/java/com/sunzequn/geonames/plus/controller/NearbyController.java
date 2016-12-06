package com.sunzequn.geonames.plus.controller;

import com.sunzequn.geonames.plus.bean.GeonameDesc;
import com.sunzequn.geonames.plus.service.NearbyHandler;
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
@RequestMapping("/nearby")
public class NearbyController {

    @Autowired
    private NearbyHandler nearbyHandler;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String nearby(Model model, @PathVariable int id) {
        List<GeonameDesc> geonameDescs = nearbyHandler.getNearby(id);
        model.addAttribute("selections", geonameDescs);
        return "selection";
    }
}
