package co.com.vass.vo;
import java.util.ArrayList;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;



@Entity  
@Table(name="patient")  
@AttributeOverrides({  
   
    @AttributeOverride(name="name", column=@Column(name="name")),  
   // @AttributeOverride(name="position", column=@Column(name="position")),
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
	//co.com.vass.vo.Patient
	private String diagnostic;
	private double height;
	private double weight;
	//private  ArrayList<String>allergies; 
	private String job;
	//private String affliction;
	
	
	
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
	


	
}
