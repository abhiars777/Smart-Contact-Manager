package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scm.forms.UserForm;
import org.springframework.web.bind.annotation.RequestParam;



@Controller("/")
public class PageController {


    @RequestMapping("/home")
    public String home( Model model ) {
        model.addAttribute("name", "Abhishek Ranjan singh");
        model.addAttribute("Channel", "Working on the webiste on scm");
        return "home";
    }

    @RequestMapping("/about")
    public String aboutPage() {
        return "about";
    }

    @RequestMapping("/services")
    public String servicePage() {
        return "services";
    }

    @GetMapping("/contact")
    public String contactPage() {
        return new String("contact");
    }

    @GetMapping("/login")
    public String loginPage() {
        return new String("login");
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        UserForm userForm = new UserForm();
        // userForm.setName("Abhishek");
        // userForm.setEmail("abhi");
        // userForm.setPassword("pass");
        // userForm.setPhoneNumber("1234");
        // userForm.setAbout("Awesome");
        model.addAttribute("userForm", userForm);
        return "register";
    }
    

    @PostMapping("/do-register")
    public String registrationprocess(@ModelAttribute UserForm userForm) {
        System.out.println("here im....................");
        System.out.println(userForm);
        return "redirect:/register";
    }

}
