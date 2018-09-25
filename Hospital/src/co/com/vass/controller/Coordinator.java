package co.com.vass.controller;

import java.util.ArrayList;
import java.util.List;

import co.com.vass.modelo.ControllerDAO;
import co.com.vass.modelo.ControllerDAO.Messags;
import co.com.vass.view.ViewMainMenu;
import co.com.vass.view.ViewMenuPatients;
import co.com.vass.view.ViewLogin;
import co.com.vass.vo.Appointment;
import co.com.vass.vo.Doctor;
import co.com.vass.vo.Patient;
import co.com.vass.vo.Speciality;
import co.com.vass.vo.User;;

public class Coordinator {

	private ControllerDAO controllerDAO;
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

	public void setLogic(ControllerDAO logic) {
		this.controllerDAO = logic;
	}

//	public ViewLogin getLoginview() {
//		return loginview;
//	}

	public void setLoginview(ViewLogin loginview) {
		this.loginview = loginview;
	}

	public Messags validateLogin(User usuario) {

		return controllerDAO.validateLogin(usuario);
	}

//////////////PATIENT
	public Messags savePatient(Patient patient) {
		return controllerDAO.savePatient(patient);

	}

	public Patient serchPatient(Patient patient) {
		return controllerDAO.serchPatient(patient);

	}

	public Messags updatePatient(Patient patient) {
		return controllerDAO.updatePatient(patient);

	}

	public Messags deletePatient(Patient doctor) {
		return controllerDAO.deletePatient(doctor);

	}

	////////////////////////////// DOCTOR
	public Messags saveDoctor(Doctor doctor) {
		return controllerDAO.saveDoctor(doctor);

	}

	public Doctor serchDoctor(Doctor doctor) {
		return controllerDAO.searchDoctor(doctor);

	}
	public List serchDoctor() {
		return controllerDAO.searchDoctor();

	}
	public Messags updateDoctor(Doctor doctor) {
		return controllerDAO.updateDoctor(doctor);

	}

	public Messags deleteDoctor(Doctor doctor) {
		return controllerDAO.deleteDoctor(doctor);

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
		return controllerDAO.saveSpeciality(speciality);

	}

	public List searchSpecility() {
		return controllerDAO.searchSpecility();

	}
	
	/////////////////////////
	//Apoiment
	
	public Appointment saveAppoiment(Appointment appointment) {
		return controllerDAO.saveAppoiment(appointment);
	}
	public Doctor searchDoctorfromSpeciality(Speciality speciality) {
		return controllerDAO.searchDoctorfromSpeciality(speciality);
	}
}
