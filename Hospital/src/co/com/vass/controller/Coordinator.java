package co.com.vass.controller;

import java.util.ArrayList;
import java.util.List;

import co.com.vass.modelo.Logic;
import co.com.vass.modelo.Logic.Messags;
import co.com.vass.view.ViewMainMenu;
import co.com.vass.view.ViewMenuPatients;
import co.com.vass.view.ViewLogin;
import co.com.vass.vo.Doctor;
import co.com.vass.vo.Patient;
import co.com.vass.vo.Speciality;
import co.com.vass.vo.User;;

public class Coordinator {

	private Logic logic;
	private ViewLogin loginview;
	private ViewMenuPatients menuPatiens;
	private ViewMainMenu mennu;

	public ViewMainMenu getMennu() {
		return mennu;
	}

	public void setMennu(ViewMainMenu mennu) {
		this.mennu = mennu;
	}

//	public ViewMenuPatients getMenuPatiens() {
//		return menuPatiens;
//	}

//	public void setMenuPatiens(ViewMenuPatients menuPatiens) {
//		this.menuPatiens = menuPatiens;
//	}

//	public Logic getLogic() {
//		return logic;
//	}

	public void setLogic(Logic logic) {
		this.logic = logic;
	}

//	public ViewLogin getLoginview() {
//		return loginview;
//	}

	public void setLoginview(ViewLogin loginview) {
		this.loginview = loginview;
	}

	public Messags validateLogin(User usuario) {

		return logic.validateLogin(usuario);
	}

//////////////PATIENT
	public Messags savePatient(Patient patient) {
		return logic.savePatient(patient);

	}

	public Patient serchPatient(Patient patient) {
		return logic.serchPatient(patient);

	}

	public Messags updatePatient(Patient patient) {
		return logic.updatePatient(patient);

	}

	public Messags deletePatient(Patient doctor) {
		return logic.deletePatient(doctor);

	}

	////////////////////////////// DOCTOR
	public Messags saveDoctor(Doctor doctor) {
		return logic.saveDoctor(doctor);

	}

	public Doctor serchDoctor(Doctor doctor) {
		return logic.searchDoctor(doctor);

	}
	public List serchDoctor() {
		return logic.searchDoctor();

	}
	public Messags updateDoctor(Doctor doctor) {
		return logic.updateDoctor(doctor);

	}

	public Messags deleteDoctor(Doctor doctor) {
		return logic.deleteDoctor(doctor);

	}

	////////////////

	public void showMenuMain() {
		mennu.setVisible(true);
	}

	public void shouMenuPatients() {
		menuPatiens.setVisible(true);
	}

	public void closeLogin() {
		loginview.dispose();
	}
	// Speciality

	public Messags saveSpeciality(Speciality speciality) {
		return logic.saveSpeciality(speciality);

	}

	public List searchSpecility() {
		return logic.searchSpecility();

	}
	

}
