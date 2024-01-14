package com.example.demo.Package;

import com.example.demo.JavaClasses.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired //bean-home
    Home home;
    @Autowired
    User user;
    @Autowired
    DataBase database;
    @Autowired
    Lawyer lawyer;

    ModelAndView mv = new ModelAndView();
     static int current_user=0;

    public static int getCurrent_user() {
        return current_user;
    }


    /*@RequestMapping("/PreHome")
    public String HomeCon(){
        database.user_mode=false;
        database.lawyer_mode=false;
        return "PreHome";
    }*/
    @RequestMapping("/")
    public ModelAndView HomeCon1(){
        database.user_mode=false;
        database.lawyer_mode=false;
        ModelAndView mv = new ModelAndView("homepage");
        return mv;
    }
    @RequestMapping("/Home")
    public String Home(){
        if(database.lawyer_mode)
            return "LawyerHome";
        else if(database.user_mode)
            return "UserHome";
        else return "homepage";
    }
    @GetMapping("/PreHome")
    public String showJoinPage() {
        return "PreHome"; // Assuming your HTML file is named "join.html" and it's located in the templates directory
    }

    @PostMapping("/join")
    public String handleJoinSelection(@RequestParam("userType") String userType) {

        database.user_mode=false;
        database.lawyer_mode=false;
        // Handle the selected user type (client or lawyer) here
        if ("client".equals(userType)) {
            // User selected to join as a client
            // Handle accordingly
            return "Registration";

        } else if ("lawyer".equals(userType)) {
            // User selected to join as a lawyer
            // Handle accordingly
            return "LawyerRegistration";
        }

        // Redirect to another page or perform other actions as needed
        return "redirect:/PreHome"; // Redirect to the home page, for example
    }
}

