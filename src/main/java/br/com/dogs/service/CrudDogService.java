package br.com.dogs.service;

import br.com.dogs.orm.Dog;
import br.com.dogs.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CrudDogService {

    @Autowired
    private DogRepository dogRepository;

    public void cadastrar(Dog dog){
        dogRepository.save(dog);
    }

    public Iterable<Dog>getAllDogs(){
        return dogRepository.findAll();
    }

    public void delete(Long id){
        dogRepository.deleteById(id);
    }

    //terminar o atualizar
    public void atualiza(Long id, Dog dog){
        Optional<Dog> byId = dogRepository.findById(id);
        byId.get().setNome(dog.getNome());
        byId.get().setRaca(dog.getRaca());
        byId.get().setData(dog.getData());
        dogRepository.save(byId.get());

    }

}
