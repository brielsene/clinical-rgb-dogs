package br.com.dogs;

import br.com.dogs.orm.Clinica;
import br.com.dogs.orm.Dog;
import br.com.dogs.repository.ClinicaRepository;
import br.com.dogs.repository.DogRepository;
import br.com.dogs.service.ClinicaService;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

@SpringBootApplication
@EntityScan(basePackages = "br.com.dogs.orm")
public class DogsApplication implements CommandLineRunner {
	@Autowired
	private ClinicaService clinicaService;
	private Scanner scanner = new Scanner(System.in);
	@Autowired
	private DogRepository dogRepository;

	@Autowired
	private ClinicaRepository clinicaRepository;

	public static void main(String[] args) {
		SpringApplication.run(DogsApplication.class, args);
	}






	@Override
	public void run(String... args) throws Exception {
//			System.out.println("Digite o id da clinica");
//			Long idClinica = scanner.nextLong();
//		Optional<Clinica> byId2 = this.clinicaRepository.findById(idClinica);
//		if(byId2.isPresent()){
//			Clinica clinica = byId2.get();
//
//		}

		consultaDogsDaClinica();
//		consultaClinicosDoDogCadastrado();


	}

	private void consultaClinicosDoDogCadastrado() {
		System.out.println("Digite o id do dog");
		Long id = scanner.nextLong();
		Optional<Dog> byId = this.dogRepository.findById(id);
		if(byId.isPresent()){
			Dog dog = byId.get();
			System.out.println("Dog: "+dog.getNome()+"Clinicas : ");
			for (Clinica clinica: dog.getClinicas()
				 ) {
				System.out.println("Clinica: "+clinica.getNome());

			}
		}
	}

	private void consultaDogsDaClinica() {
		System.out.println("Digite o id da clinica");
		Long id = scanner.nextLong();
		Optional<Clinica> byId = this.clinicaRepository.findById(id);
		if(byId.isPresent()){
			Clinica clinica = byId.get();
			System.out.println("Clinica: "+clinica.getNome()+", Dogs: ");
			clinica.getDogs().size();
			for (Dog dog: clinica.getDogs()
				 ) {
				System.out.println("Dog: "+dog.getNome());

			}

		}
	}
}
