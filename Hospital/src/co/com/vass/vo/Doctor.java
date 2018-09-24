package co.com.vass.vo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.JoinColumn;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;



@Entity  
@Table(name="doctor") 
//@DynamicUpdate
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
// extends Person

public class Doctor extends Person   {
	@Id
	@Column(name="idDoctor")
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int idDoctor;
	

	
	 
	 
	 

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "doctor_has_speciality", catalog = "databasehospital", joinColumns = { 
			@JoinColumn(name = "doctor_idDoctor", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "speciality_idspeciality", 
					nullable = false, updatable = false) })
	private Set<Speciality>listSpeciality=new HashSet<Speciality>(0);
	

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "appointment", fetch = FetchType.LAZY)
	  @Fetch(FetchMode.SELECT)
	private Appointment appointment;
	
	
	

	public Set<Speciality> getSpecility() {
		return listSpeciality;
	}
	
	 
	public void setSpecility(Set<Speciality> specility) {
		this.listSpeciality = specility;
	}


	public int getIdDoctor() {
		return idDoctor;
	}


	public void setIdDoctor(int idDoctor) {
		this.idDoctor = idDoctor;
	}


	public Appointment getCustomer() {
		return appointment;
	}


	public void setCustomer(Appointment customer) {
		this.appointment = customer;
	}



	

	


	

}
