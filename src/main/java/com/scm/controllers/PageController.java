package com.scm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.helpers.Message;
import com.scm.helpers.MessageType;
import com.scm.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;




@Controller("/")
public class PageController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index() {
        return "redirect:/home";
    }
    

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
        return "login";
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
    public String registrationprocess(@Valid @ModelAttribute UserForm userForm, BindingResult rBindingResult, HttpSession session) {
        //Fetching Data
        System.out.println(userForm);

        //Validation
        if (rBindingResult.hasErrors()) {
            return "register";
        }

        // User user = User.builder()
        // .name(userForm.getName())
        // .email(userForm.getEmail())
        // .password(userForm.getPassword())
        // .about(userForm.getAbout())
        // .phoneNumber(userForm.getPhoneNumber())
        // .build();

        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setProfilePic("");

        User savedUser = userService.saveUser(user);

        System.out.println("User saved........");

        Message message = Message.builder().content("Registration Successful!").type(MessageType.green).build();
        session.setAttribute("message", message);

        return "redirect:/register";
    }

}
