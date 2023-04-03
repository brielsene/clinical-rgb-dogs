package br.com.dogs.controller;

import br.com.dogs.orm.Dog;
import br.com.dogs.service.CrudDogService;
import com.electronwill.nightconfig.core.conversion.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("dog")
public class DogController {

    @Autowired
    private CrudDogService crudDogService;

    @PostMapping
    public void cadastrarDog(@RequestBody Dog dog){
        crudDogService.cadastrar(dog);

    }

    @GetMapping
    public Iterable<Dog> getAllDogs(){
        return crudDogService.getAllDogs();
    }

    @DeleteMapping("/{id}")
    public void deletar (@PathVariable("id") Long id){
        crudDogService.delete(id);
    }

    @PutMapping("/{id}")
    public void atualiza (@PathVariable("id") Long id, @RequestBody Dog dog){
       crudDogService.atualiza(id, dog);
    }
}
