package com.perapoch.controllers;

import com.perapoch.model.Reader;
import com.perapoch.services.ReaderService;
import com.perapoch.validators.ReaderValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by marcal.perapoch on 28/02/2017.
 */
@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private final ReaderValidator readerValidator;
    @Autowired
    private final ReaderService readerService;

    public RegisterController(ReaderValidator readerValidator, ReaderService readerService) {
        this.readerValidator = readerValidator;
        this.readerService = readerService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new Reader());

        return "register";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String registration(@ModelAttribute("readerForm") Reader readerForm, BindingResult bindingResult, Model model) {
        readerValidator.validate(readerForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "register";
        }

        readerService.save(readerForm);

        return "redirect:/login";
    }

}
