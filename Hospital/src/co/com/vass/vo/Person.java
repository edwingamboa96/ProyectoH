package co.com.vass.vo;

import java.io.Serializable;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@MappedSuperclass
//@Table (name =  "person"  )
@Inheritance (strategy=InheritanceType.TABLE_PER_CLASS )
public class Person  {
	
	
	//@Id  
	//@GeneratedValue(strategy=GenerationType.AUTO)  	      
//	@Column(name = "idperson")  
//	private int idPerson;
	
	@Column(name="name")
	private String name;
	
	@Column(name="lastname")
	private String lastname;

	
	@Column(name="document")
	private String document;
	
	@Column(name="age")
	private int age;
	
	@Column(name="nationality")
	private String nationality;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="address")
	private String address;
	
	
	@Column(name="email")
	private String email;
	
	@Column(name="idnumber")
	private int idnumber;
	 
//	public int getIdPerson() {
//		return idPerson;
//	}
//	public void setIdPerson(int idPerson) {
//		this.idPerson = idPerson;
//	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
//	public String getPosition() {
//		return position;
//	}
//	public void setPosition(String position) {
//		this.position = position;
//	}
	
	public String getDocument() {
		return document;
	}
	public void setDocument(String document) {
		this.document = document;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getIdnumber() {
		return idnumber;
	}
	public void setIdnumber(int idnumber) {
		this.idnumber = idnumber;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	} 
	
	
	
	
}
