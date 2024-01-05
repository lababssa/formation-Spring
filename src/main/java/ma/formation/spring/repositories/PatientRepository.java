package ma.formation.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import lombok.ToString;
import ma.formation.spring.entities.Patient;
@ToString
public interface PatientRepository extends JpaRepository<Patient, Long>{
	
	public List<Patient> findByNomContains(String name);
	public List<Patient> findByMalade(boolean  b);
    public List<Patient> findByNomContainsAndMalade(String name, boolean b );
    
}
