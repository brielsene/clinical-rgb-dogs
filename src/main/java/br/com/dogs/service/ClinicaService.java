package br.com.dogs.service;

import br.com.dogs.orm.Clinica;
import br.com.dogs.orm.Dog;
import br.com.dogs.repository.ClinicaRepository;
import br.com.dogs.repository.DogRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ClinicaService {
    @Autowired
    private ClinicaRepository clinicaRepository;

    @Autowired
    private DogRepository dogRepository;

    public void cadastrar(Clinica clinica){
        this.clinicaRepository.save(clinica);
    }

    public void deletarClinicaPorId(Long id){
        this.clinicaRepository.deleteById(id);
    }

    public List<Clinica>getAllClinicas(){
        return this.clinicaRepository.findAll();
    }

    public Clinica getClinicaById(Long id){
        Optional<Clinica> byId = this.clinicaRepository.findById(id);
        if(byId.isPresent()){
            Clinica clinica = byId.get();
            return clinica;
        }
        return null;
    }

    @Transactional
    public void matricularDogNaClinica(Long idClinica, Long idDog){
        Optional<Clinica> byId = this.clinicaRepository.findById(idClinica);
        if(byId.isPresent()){
            Clinica clinica = byId.get();
            Optional<Dog> byId1 = this.dogRepository.findById(idDog);
            if(byId1.isPresent()){
                Dog dog = byId1.get();
                clinica.getDogs().add(dog);
                this.clinicaRepository.save(clinica);

            }

        }
    }
    @Transactional
    public Set<Dog>dogsNaClinica(Long id){
        Optional<Clinica> byId = this.clinicaRepository.findById(id);
        if(byId.isPresent()){
            Clinica clinica = byId.get();
            return clinica.getDogs();
        }
        return null;
    }
}
