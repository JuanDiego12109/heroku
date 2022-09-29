package com.softic.softa.controllers;

import com.softic.softa.entities.User;
import com.softic.softa.services.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class FrontController{

    UserService userService;

    public FrontController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String logi (Model model, @AuthenticationPrincipal OidcUser principal){

        if (principal != null){
            User user = this.userService.getOrCreateUser(principal.getClaims());
        }
        return "logi";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }


    @GetMapping("/sistemaIngresos")
    public String sistemaIngresos(){ return "sistemaIngresos";

   }

}
