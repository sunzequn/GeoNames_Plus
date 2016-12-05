package com.sunzequn.geonames.plus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by sloriac on 16-12-5.
 */
@Controller
@RequestMapping("/view")
public class ViewController {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String view(Model model, @PathVariable int id) {
        return "index";
    }
}
