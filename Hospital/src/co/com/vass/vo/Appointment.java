package co.com.vass.vo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Appointment")
public class Appointment {
	@Id
	@Column(name="idappappointment")	
	private int idappappointment;

	@Column(name = "speciality")
	private String speciality;

	@Column(name = "date")
	private Date date;

	@Column(name = "namedoctor")
	private String namedoctor;

	@Column(name = "number")
	private String number;
	
	@Column(name = "idpatientapp")
	private int idpatientapp;
	
	@Column(name = "iddoctorap")
	private int iddoctorap;
	
	@OneToOne
	@JoinColumn(name = "appointment", nullable = true)
	private Doctor appointment;	
	
	@OneToOne
	@JoinColumn(name = "patient", nullable = true)
	private Patient patient;	
	

	public Doctor getAppointment() {
		return appointment;
	}

	public void setAppointment(Doctor appointment) {
		this.appointment = appointment;
	}

	public int getIdappappointment() {
		return idappappointment;
	}

	public void setIdappappointment(int idappappointment) {
		this.idappappointment = idappappointment;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getNamedoctor() {
		return namedoctor;
	}

	public void setNamedoctor(String namedoctor) {
		this.namedoctor = namedoctor;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getIdpatient() {
		return idpatientapp;
	}

	public void setIdpatient(int idpatientapp) {
		this.idpatientapp = idpatientapp;
	}

	public int getIddoctorap() {
		return iddoctorap;
	}

	public void setIddoctorap(int iddoctorap) {
		this.iddoctorap = iddoctorap;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	
}
