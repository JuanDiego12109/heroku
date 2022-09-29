package com.softic.softa.controllers;

import com.softic.softa.entities.Employee;
import com.softic.softa.services.ServicesEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ControllersRestEmployees{

    @Autowired
    ServicesEmployee servicesEmployee;  //Inyeccion de la dependencia del servicio

    //Metodos

    @GetMapping("/employee")
    private String verEmployee(Model model){
        model.addAttribute("Employees",servicesEmployee.verEmployee());
        return "employee";
    }

    @GetMapping({"/employee-new"})
    private String verFormularioDeRegistroEmployee(Employee employee){
        return "employee-new";
    }

    @PostMapping("/employee")
    private String crearEmployee(Employee employee){
        servicesEmployee.crearYActualizarEmployee(employee);
        return "redirect:/employee";
    }

    @GetMapping("/employee/borrar/{id}")
    private String eliminarEmployee(@PathVariable("id") Long id){
        servicesEmployee.eliminarEmployee(id);
        return "redirect:/employee";
    }

    @GetMapping("/employee/editar/{id}")
    private String verEmployeePorId(@PathVariable("id") Long id, Model model){
        Employee employee = servicesEmployee.verEmployeePorId(id);
        model.addAttribute("employee", employee);
        return "employee-actualizar";
    }

    @PostMapping("/employee/actualizar/{id}")
    private String editarEmployee(@PathVariable("id") Long id, Employee employee) {
        servicesEmployee.crearYActualizarEmployee(employee);
        return "redirect:/employee";
    }



//////////////////////////////////////////////////////////////////////////////////////////////
//    @PostMapping("/employee")
//    private void crearEmpleado(@RequestBody Employee employee){
//        servicesEmployee.crearYActualizarEmpleado(employee);
//    }
//
//    @DeleteMapping("/employee/{id}")
//    private void eliminarEmployee(@PathVariable("id") Long idEmployee){
//        servicesEmployee.eliminarEmployee(idEmployee);
//    }
//
//    @PatchMapping("/employee")
//    private void editarEmployee(@RequestBody Employee employee){
//        servicesEmployee.crearYActualizarEmpleado(employee);
//
////  Put se usa para modificar todo el registro
////  Patch se usa para modificar un solo campo
//
////  @PutMapping("/employee")
////  private void editarEmployee(@RequestBody Employee employee){
////      servicesEmployee.crearYActualizarEmpleado(employee);
//
//    }
//
//    //LINEA NUEVA
//    @GetMapping("/employee/{id}")
//    public Employee getEmployee(@PathVariable("id") long id){
//        return this.servicesEmployee.getEmployee(id);
//    }

}

/////////////////////////////////////////////////////////////////////////7 Nuevo Codigio aqui abajo

//package com.softic.softa.controllers;
//import com.softic.softa.entities.Employee;
//import com.softic.softa.services.ServicesEnterprise;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
// // Aqui se cambio el @RestController por @Controller
//public class ControllersRestEmployees{
//
//    @Autowired
//    ServicesEnterprise servicesEmployee;  //Inyeccion de la dependencia del servicio
//
//    //Metodos
//    @GetMapping("/employee")
//    private String verEmployee(Model model){
//        model.addAttribute("Employees",servicesEmployee.verEmployee());
//        return "employee";
//    }
//
//    @GetMapping("/employee-new")
//    private String verFormularioDeRegistroEmployee(Employee employee){
//        return "employee-new";
//    }
//
//
//    @PostMapping("/employee")
//    private String crearEmployee(Employee employee){
//        servicesEmployee.crearYActualizarEmployee(employee);
//        return "redirect:/employee";
//    }
//
//    @GetMapping("/employee/borrar/{id}")
//    private String eliminarEmployee(@PathVariable("id") Long id){
//        servicesEmployee.eliminarEmployee(id);
//        return "redirect:/employee";
//    }
//
//    @GetMapping("/employee/editar/{id}")
//    private String verEmployeePorId(@PathVariable("id") Long id, Model model){
//        Employee employee = servicesEmployee.verEmployeePorId(id);
//        model.addAttribute("employee", employee);
//        return "employee-actualizar";
//    }
//
//    @PostMapping("/employee/actualizar/{id}")
//    private String editarEmployee(@PathVariable("id") Long id, Employee employee) {
//        servicesEmployee.crearYActualizarEmployee(employee);
//        return "redirect:/employee";
//    }
//}




