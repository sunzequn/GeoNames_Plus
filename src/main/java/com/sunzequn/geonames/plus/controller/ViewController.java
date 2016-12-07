package com.sunzequn.geonames.plus.controller;

import com.github.jsonldjava.utils.Obj;
import com.sunzequn.geonames.plus.bean.PropValue;
import com.sunzequn.geonames.plus.service.SelectionHandler;
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
@RequestMapping("/view")
public class ViewController {

    @Autowired
    private ViewHandler viewHandler;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String view(Model model, @PathVariable int id) {
        Object[] objects = viewHandler.geneProps(id);
        List<PropValue> propValues = (List<PropValue>) objects[0];
        String name = (String) objects[1];
        double lng = (double) objects[2];
        double lat = (double) objects[3];
        model.addAttribute("propValues", propValues);
        model.addAttribute("id", id);
        model.addAttribute("name", name);
        model.addAttribute("lng", lng);
        model.addAttribute("lat", lat);
        if (objects.length == 5)
            model.addAttribute("wiki", (String) objects[4]);
        return "view";
    }
}
