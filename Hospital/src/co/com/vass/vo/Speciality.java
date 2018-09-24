package co.com.vass.vo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "speciality", catalog = "databasehospital")
public class Speciality implements java.io.Serializable  {
	@Id
	@GeneratedValue
	@Column(name = "idspeciality")
	private int idspeciality;

	
	
	@ManyToMany(mappedBy = "listSpeciality")
	private Set<Doctor> doctors = new HashSet<>();

	@Column(name = "code")
	private String code;

	@Column(name = "name")
	private String name;

	public int getIdspeciality() {
		return idspeciality;
	}

	public void setIdspeciality(int idspeciality) {
		this.idspeciality = idspeciality;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public Set<Doctor> getDoctors() {
//		return doctors;
//	}
//
//	public void setDoctors(Set<Doctor> doctors) {
//		this.doctors = doctors;
//	}

	
	
	

}
