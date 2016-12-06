package com.sunzequn.geonames.plus.controller;

import com.sunzequn.geonames.plus.bean.Feedback;
import com.sunzequn.geonames.plus.dao.mysql.FeedbackDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by sloriac on 16-12-5.
 */
@Controller
@RequestMapping("/feed")
public class FeedbackController {

    @Autowired
    private FeedbackDao feedbackDao;

    @RequestMapping(value = "/{id}/{content}", method = RequestMethod.GET)
    public
    @ResponseBody
    String view(@PathVariable int id, @PathVariable String content) {
        Feedback feedback = new Feedback(id, new Date(), content, 0);
        feedbackDao.add(feedback);
        return content;
    }
}
