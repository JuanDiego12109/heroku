package com.softic.softa.controllers;

import com.softic.softa.entities.Enterprise;
import com.softic.softa.services.ServicesEnterprise;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller // Aqui se cambio el @RestController por @Controller
public class ControllersRestEnterprises{

    @Autowired
    ServicesEnterprise servicesEnterprise;  //Inyeccion de la dependencia del servicio

    //Metodos
    @GetMapping("/enterprise")
    private String verEnterprise(Model model){
        model.addAttribute("enterprises",servicesEnterprise.verEnterprise());
        return "enterprise";
    }

    @GetMapping("/enterprise-new")
    private String verFormularioDeRegistroEnterprise(Enterprise enterprise){
        return "enterprise-new";
    }


    @PostMapping("/enterprise")
    private String crearEnterprise(Enterprise enterprise){
        servicesEnterprise.crearYActualizarEnterprise(enterprise);
        return "redirect:/enterprise";
    }

    @GetMapping("/enterprise/borrar/{id}")
    private String eliminarEnterprise(@PathVariable("id") Long id){
        servicesEnterprise.eliminarEnterprise(id);
        return "redirect:/enterprise";
    }

    @GetMapping("/enterprise/editar/{id}")
    private String verEnterprisePorId(@PathVariable("id") Long id, Model model){
        Enterprise enterprise = servicesEnterprise.verEnterprisePorId(id);
        model.addAttribute("enterprise", enterprise);
        return "enterprise-actualizar";
    }

    @PostMapping("/enterprise/actualizar/{id}")
    private String editarEnterprise(@PathVariable("id") Long id, Enterprise enterprise) {
        servicesEnterprise.crearYActualizarEnterprise(enterprise);
        return "redirect:/enterprise";
    }


}


