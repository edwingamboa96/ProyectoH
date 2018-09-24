package co.com.vass.vo;
import java.util.ArrayList;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;



@Entity  
@Table(name="patient")  
@AttributeOverrides({  
   
    @AttributeOverride(name="name", column=@Column(name="name")),  
    @AttributeOverride(name="lastname", column=@Column(name="lastname")),
    @AttributeOverride(name="document", column=@Column(name="document"))  ,
    @AttributeOverride(name="age", column=@Column(name="age"))  ,
    @AttributeOverride(name="nationality", column=@Column(name="nationality"))  ,
    @AttributeOverride(name="gender", column=@Column(name="gender"))  ,
    @AttributeOverride(name="phone", column=@Column(name="phone"))  ,
    @AttributeOverride(name="address", column=@Column(name="address"))  ,
    @AttributeOverride(name="email", column=@Column(name="email")),  
    @AttributeOverride(name="idnumber", column=@Column(name="idnumber")) 
    
    
})  

public class Patient extends Person  {
	@Id  
	@Column(name="idPatien")
	
	private int idPatien;
	private String diagnostic;
	private double height;
	private double weight;
	//private  ArrayList<String>allergies; 
	private String job;
	//private String affliction;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "patient", fetch = FetchType.LAZY)
	  @Fetch(FetchMode.SELECT)
	private Appointment patient;
	
	public Patient() {
		super();
	}
	public Patient(String diagnostic, double height, double weight, String job) {
		super();
		this.diagnostic = diagnostic;
		this.height = height;
		this.weight = weight;
		this.job = job;
		//this.affliction = affliction;
	}
	public String getDiagnostic() {
		return diagnostic;
	}
	public void setDiagnostic(String diagnostic) {
		this.diagnostic = diagnostic;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
//	public ArrayList<String> getAllergies() {
//		return allergies;
//	}
//	public void setAllergies(ArrayList<String> allergies) {
//		this.allergies = allergies;
//	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
//	public String getAffliction() {
//		return affliction;
//	}
//	public void setAffliction(String affliction) {
//		this.affliction = affliction;
//	}
	public int getIdPatien() {
		return idPatien;
	}
	public void setIdPatien(int idPatien) {
		this.idPatien = idPatien;
	}
	public Appointment getPatient() {
		return patient;
	}
	public void setPatient(Appointment patient) {
		this.patient = patient;
	}
	
	


	
}
