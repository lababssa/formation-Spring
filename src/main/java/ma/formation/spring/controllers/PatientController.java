package ma.formation.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ma.formation.spring.entities.Patient;
import ma.formation.spring.repositories.PatientRepository;
@RestController
public class PatientController {
	
	@Autowired
	PatientRepository patientRepository;
	

	@GetMapping("/Patient")
	 public List<Patient> patientAll(){
		 return this.patientRepository.findAll();
	}
	@GetMapping("/Patient/{id}")
	public Patient patientFindById(@PathVariable Long id) {
		return  this.patientRepository.findById(id).get();
	}
	@PostMapping("/Patient")
	public Patient savePatient(@RequestBody Patient patient) {
		return this.patientRepository.save(patient);
	}
	
	@PutMapping("/patient/{id}")
	 Patient saveOrUpDatePatient(Patient patient ,@PathVariable Long id) {
		
		return this.patientRepository.findById(id).map(p->{
			p.setNom(patient.getNom());
			p.setPrenom(patient.getPrenom());
			return patientRepository.save(patient);
		}).orElseGet(()->{
			patient.setId(id);
			return patientRepository.save(patient);
		});
		
	}
	@DeleteMapping("Patient/{id}")
   void  deletePatient(@PathVariable Long id) {
this.patientRepository.deleteById(id);
}
}

