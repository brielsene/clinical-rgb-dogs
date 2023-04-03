package br.com.dogs.repository;

import br.com.dogs.orm.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface DogRepository extends CrudRepository<Dog, Long> {

}
