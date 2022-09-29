package com.softic.softa.services;

import com.softic.softa.entities.Enterprise;
import com.softic.softa.repositories.EnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServicesEnterprise{
    @Autowired //Anotación para especificarle a Spring Boot que aquí estoy haciendo una inyección de dependencias
    EnterpriseRepository enterpriseRepository;

    //Metodos
    public void crearYActualizarEnterprise(Enterprise enterprise){
        enterpriseRepository.save(enterprise);
    }

    public List<Enterprise> verEnterprise(){
        List<Enterprise> enterprises = new ArrayList<Enterprise>();
        enterprises.addAll(enterpriseRepository.findAll());
        return enterprises;
    }

    public void eliminarEnterprise(Long idEnterprise){
        enterpriseRepository.deleteById(idEnterprise);
    }

    //LINEA NUEVA
    public Enterprise getEnterprise(long id) {
        Optional<Enterprise>enterprise = this.enterpriseRepository.findById(id);
        return enterprise.orElse(null);
    }

    public Enterprise verEnterprisePorId(Long id) { return enterpriseRepository.findById(id).get();
    }


}

