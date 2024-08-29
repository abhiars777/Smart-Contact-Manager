package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



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
    public String servicesPage() {
        return "services";
    }

    @RequestMapping("/contact")
    public String contactPage() {
        return "contact";
    }
    
    

}
