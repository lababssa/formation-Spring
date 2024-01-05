package ma.formation.spring;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import lombok.ToString;
import ma.formation.spring.entities.Patient;
import ma.formation.spring.repositories.PatientRepository;

@SpringBootApplication

public class FormationSpringApplication  implements CommandLineRunner{
	
	@Autowired
	private PatientRepository patientRepository;

	public static void main(String[] args) {
		SpringApplication.run(FormationSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		patientRepository.save(new Patient(null,"lababss","khalid",new Date(),15,false));
		patientRepository.save(new Patient(null,"fathi","rachid",new Date(),20,false));
		patientRepository.save(new Patient(null,"rochdi","nofel",new Date(),75,true));
		patientRepository.save(new Patient(null,"namir","saad",new Date(),69,true));
		patientRepository.save(new Patient(null,"lababss","khalid",new Date(),15,false));
		patientRepository.save(new Patient(null,"moiss","tadili",new Date(),18,true));
		patientRepository.save(new Patient(null,"xxxxx","kkkkkkkkkkk",new Date(),122,true));

		
		System.out.println("**************************");
		
		patientRepository.findAll().forEach(p->{
			System.out.println(p.toString());
			
		});
		
		System.out.println("***************************");
		
		Patient patient =patientRepository.findById(1L).get();
		System.out.println(patient.getPrenom());
		
		System.out.println("************************");
		
	List<Patient> patients= patientRepository.findByNomContains("ro");
	patients.forEach(p->{
		System.out.println(p.toString());
	});

		System.out.println("*************");
		List<Patient> patients1= patientRepository.findByMalade(false);
		patients1.forEach(p->{
			System.out.println(p.toString());
		});
		System.out.println("********************");
		
		List<Patient> patients2 =patientRepository.findByNomContainsAndMalade("lab", false);
		patients2.forEach(p->{
			System.out.println(p.toString());
		});
		
		patientRepository.deleteById(4L);
		System.out.println("******************************");
		
		Page<Patient> pagePatients =patientRepository.findAll(PageRequest.of(0, 2));
		
		pagePatients.getContent().forEach(p->{
			System.out.println(p.toString());
		});
	
		
	} 
	
}


