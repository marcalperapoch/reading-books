package com.perapoch.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * POST is provided by Spring Security
 * Created by marcal.perapoch on 28/02/2017.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping(method = RequestMethod.GET)
    public String renderLogin(Model model, String error, String logout) {
        return "login";
    }

}
