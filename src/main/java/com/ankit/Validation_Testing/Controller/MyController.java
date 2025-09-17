package com.ankit.Validation_Testing.Controller;

import com.ankit.Validation_Testing.Entity.LoginData;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyController {

    @GetMapping("/form")
    public String form(Model model){
        System.out.println("Form called ");
        model.addAttribute("loginData",new LoginData());
        return "form";
    }

    //handler for process form
    @PostMapping("/process")
    public String submit(@Valid @ModelAttribute("loginData") LoginData loginData , BindingResult result){
        if (result.hasErrors()){
            System.out.println(result);
            return "form";
        }
        System.out.println(loginData);
        return "success";
    }
}
