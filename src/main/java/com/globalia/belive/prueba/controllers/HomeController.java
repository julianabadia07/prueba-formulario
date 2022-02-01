package com.globalia.belive.prueba.controllers;

import com.globalia.belive.prueba.model.User;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    private CacheManager cacheManager;

    @GetMapping(value = {"/"})
    public ModelAndView loadFormPage(HttpServletRequest request) {
        User user = new User();
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("user", user);
        modelAndView.setViewName("html/form-page");

        return modelAndView;
    }

    @PostMapping(value = {"/registrar"})
    public ModelAndView submitForm(@ModelAttribute("user") User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(user);
        modelAndView.setViewName("html/form-page-data");

        return modelAndView;
    }
}
