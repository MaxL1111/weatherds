package com.weatherds;


import com.weatherds.repos.Other;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Map;


@Controller
public class GreetingController {

    @Autowired
    Other other;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Map<String, Object> model) {
        model.put("name", name);
        return "greeting";
    }

    @GetMapping
    public String main(Map<String, Object> model) throws ParseException {

        model.put("some", "fuck");
        return "main";
    }

    @PostMapping
    public String add(@RequestParam(value = "coordinates", required = false) String coordinates,
                      @RequestParam(value = "date", required = false) String date, Map<String, Object> model) {

        String res2 = other.findDat(date, coordinates);
        model.put("some", res2);
        return "main";
    }
}