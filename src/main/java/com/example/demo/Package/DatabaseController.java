package com.example.demo.Package;

import com.example.demo.JavaClasses.Home;
import com.example.demo.JavaClasses.Lawyer;
import com.example.demo.Service.LawyerService;
import com.example.demo.Service.TaxFunctionsService;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DatabaseController {
    @Autowired
    HomeController home;
    @Autowired
    UserService userService;
    @Autowired
    LawyerService lawyerService;
    @Autowired
    TaxFunctionsService taxFunctionsService;
    @RequestMapping("/seeLawyerList")

    public String getLawyerList(Model model){
        model.addAttribute("msg1TH","BDT ");
        model.addAttribute("msg2TH","/visit");
        model.addAttribute("lawyerlistTH",lawyerService.getAllLawyers());
        return "LawyerList";
    }
    @PostMapping("/DemoLawyerProfile")
    public String processExtraAction(@RequestParam("id") int id, Model model ) {
        model.addAttribute("lawyerTH",lawyerService.getLawyerById(id));
        return "DemoLawyerProfile";
    }

    @GetMapping("/seeuserlist")
    public String seeUserListCon(Model model){
        if(home.database.lawyer_mode)
        {
            model.addAttribute("messageTH",lawyerService.getLawyerById(HomeController.current_user).getLawyerName());
            model.addAttribute("userListTH",lawyerService.getLawyerById(HomeController.current_user));
            return "userList";
        }

        return "PreHome";
    }
    @RequestMapping("/demouser")
    public String demoUserCon(@RequestParam("id")int userID,Model model){
        model.addAttribute("messageTH",lawyerService.getLawyerById(HomeController.current_user).getLawyerName());
        if(home.database.lawyer_mode && (userService.getUserById(userID).getLawyer().getLawyerID()==HomeController.current_user)){
            model.addAttribute("userTH",userService.getUserById(userID));
            return "DemoUserProfile";
        }
        return "PreHome";
    }

    @PostMapping("/Ltaxform")
    public String formCon(@RequestParam("uid")int uid, Model model){
        model.addAttribute("message1",lawyerService.getLawyerById(HomeController.current_user).getLawyerName());
        model.addAttribute("message2",userService.getUserById(uid).getName());
        if(home.database.lawyer_mode && (userService.getUserById(uid).getLawyer().getLawyerID()==HomeController.current_user)){
            model.addAttribute("taxFormTH",taxFunctionsService.getTaxFunctionsByID(uid));
            return "DemoClientDetails";
        }
        return "PreHome";
    }

}
