package com.softic.softa.services;

import com.softic.softa.entities.Employee;
import com.softic.softa.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServicesEmployee{
    @Autowired //Anotación para especificarle a Spring Boot que aquí estoy haciendo una inyección de dependencias
    EmployeeRepository employeeRepository;

    //Metodos
    public void crearYActualizarEmpleado(Employee employee){
        employeeRepository.save(employee);
    }

    public List<Employee> verEmployee(){
        List<Employee> employees = new ArrayList<Employee>();
        employees.addAll(employeeRepository.findAll());
        return employees;
    }

    public void eliminarEmployee(Long idEmployee){
        employeeRepository.deleteById(idEmployee);
    }

    //LINEA NUEVA
    public Employee getEmployee(long id) {
        Optional<Employee>employee = this.employeeRepository.findById(id);
        return employee.orElse(null);
    }

    public void crearYActualizarEmployee(Employee employee) { employeeRepository.save(employee);
    }

    public Employee verEmployeePorId(Long id) { return employeeRepository.findById(id).get();
    }
}

