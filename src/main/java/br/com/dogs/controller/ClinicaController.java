package br.com.dogs.controller;

import br.com.dogs.orm.Clinica;
import br.com.dogs.orm.Dog;
import br.com.dogs.service.ClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/clinica")
public class ClinicaController {

    @Autowired
    private ClinicaService clinicaService;

    @PostMapping
    public void cadastrarClinica(@RequestBody Clinica clinica){
        clinicaService.cadastrar(clinica);

    }

    @GetMapping
    public List<Clinica> getAllClinicas(){
        return clinicaService.getAllClinicas();
    }

    @PostMapping("/matriculaDog/{idClinica}/{idDog}")
    public void matricularDogNaClinica(@PathVariable("idClinica") Long idClinica, @PathVariable("idDog") Long idDog){
        clinicaService.matricularDogNaClinica(idClinica, idDog);
    }

    @GetMapping ("/dogs/{id}")
    public Set<Dog>dogsNaClinica(@PathVariable("id")Long id){
        return this.clinicaService.dogsNaClinica(id);
    }
}
