package com.example.demo.Package;

import com.example.demo.JavaClasses.TaxFunctions;
import com.example.demo.Service.TaxFunctionsService;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class taxFunctionController {
    @Autowired
    HomeController home;
    @Autowired
    UserService userService;
    @Autowired
    TaxFunctionsService taxFunctionsService;
    @GetMapping("/taxForm")
    public String inputTaxForm( Model model){
        if(home.database.user_mode){
            if(taxFunctionsService.getTaxFunctionsByID(HomeController.current_user)==null)
            {
                TaxFunctions tax=new TaxFunctions();
                tax.setTaxFunctionID(HomeController.current_user);
                tax.setUserID(HomeController.current_user);
                taxFunctionsService.createTaxFunctions(tax);
            }
            model.addAttribute("messageTH",userService.getUserById(HomeController.current_user).getName());
            model.addAttribute("taxTH",taxFunctionsService.getTaxFunctionsByID(HomeController.current_user));
            return "TaxForm";
        }
        else return "PreHome";
    }
    @PostMapping("/submitTaxform")
    public String taxFormInputs(@ModelAttribute TaxFunctions taxFunctions, Model model){

        System.out.println(taxFunctions.getTotal_taxable());

        if(taxFunctionsService.getTaxFunctionsByID(HomeController.current_user)==null)
            taxFunctionsService.createTaxFunctions(taxFunctions);
        else taxFunctionsService.updateTaxFunction(taxFunctions);

        System.out.println(taxFunctions.getTaxFunctionID());
        System.out.println(userService.getUserById(HomeController.current_user).getTaxId());
        model.addAttribute("userTH",userService.getUserById(HomeController.current_user));
        return "ViewUserProfile";
    }

    @GetMapping("/reform")
    public String seeTaxFormCon(Model model){
        if(home.database.user_mode){

            model.addAttribute("message",userService.getUserById(HomeController.current_user).getName());
            model.addAttribute("taxFormTH",taxFunctionsService.getTaxFunctionsByID(HomeController.current_user));
            return "ViewTaxForm";
        }

        return "/";
    }
}
