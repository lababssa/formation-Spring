package ma.formation.spring.entities;

import java.util.Date;

import com.jayway.jsonpath.internal.function.text.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity @AllArgsConstructor @NoArgsConstructor 
@Data
@Table(name="PATIENTS")
@ToString
public class Patient {
	public Patient() {
		super();
	}
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="NOM",length = 25)
	private String nom;
	private String prenom;
	
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	private int score;
	private boolean malade;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public Patient(Long id, String nom, String prenom, Date dateNaissance, int score, boolean malade) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.score = score;
		this.malade = malade;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public boolean isMalade() {
		return malade;
	}
	public void setMalade(boolean malade) {
		this.malade = malade;
	}
	
	
	

}
