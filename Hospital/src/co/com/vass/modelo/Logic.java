package co.com.vass.modelo;

import co.com.vass.controller.Coordinator;
import co.com.vass.dao.PatientDAO;
import co.com.vass.dao.UserDAO;
import co.com.vass.vo.Patient;
import co.com.vass.vo.User;

public class Logic {
	private Coordinator coordinator;
	final int USUARIO = 1;
	final int ADMINISTRADOR = 2;

	public Coordinator getCoordinator() {
		return coordinator;
	}

	public enum Messags {
		CAMPOS {
			public String toString() {
				return "Los campos no pueden estar vacios";
			}
		},
		CONEXION {
			public String toString() {
				return "No hay conexion a la Base de datos";
			}
		},
		BD_USSER {
			public String toString() {
				return "Usuario o contraseña invalidos";
			}
		},
		OK_USER {
			public String toString() {
				return "Bienvenido";
			}
		},
		ADD_PATIENT_OK {
			public String toString() {
				return "Usuario agregado con exito";
			}
		}
	}

	public void setCoordinator(Coordinator coordinator) {
		this.coordinator = coordinator;
	}

	public Messags validateLogin(User usuario) {// validar campos de entrada
		boolean validation = true;
		Messags result;
		String name = usuario.getName();
		String password = usuario.getPassword();
		if (usuario.getName().equals("") || usuario.getPassword().equals("")) {
			validation = false;
		}
		if (name == null || password == null) {
			validation = false;
		}

		if (validation) {
			return result = checkUserBD(usuario);

		} else {

			return Messags.CAMPOS;
		}

	}

	public Messags checkUserBD(User usuarioIn) {
		UserDAO userDAO = new UserDAO();
		Messags answer;
		boolean isUserBd = userDAO.consultUserDatabase(usuarioIn);
		if (isUserBd) {
			answer = Messags.OK_USER;
			coordinator.showMenuMain();
			coordinator.closeLogin();

		} else {

			answer = Messags.BD_USSER;

		}
//		else {
//			answer =Messags.BD_USSER;
//		}

		return answer;
	}

	public Messags savePatient(Patient patient) {
		Messags result = Messags.ADD_PATIENT_OK;
		PatientDAO patientDAO = new PatientDAO();
		patientDAO.createPatien(patient);
		return result;
	}

	public Patient serchPatient(Patient patientSerch) {
		Messags result = Messags.ADD_PATIENT_OK;
		PatientDAO patientDAO = new PatientDAO();
		return patientDAO.readPatienr(patientSerch);

	}

	public Messags updatePatient(Patient patient) {
		Messags result = Messags.ADD_PATIENT_OK;
		PatientDAO patientDAO = new PatientDAO();
		patientDAO.updatePatien(patient);

		return result;
	}

	public Messags deletePatient(Patient patient) {
		Messags result = Messags.ADD_PATIENT_OK;
		PatientDAO patientDAO = new PatientDAO();
		patientDAO.deletePatien(patient);

		return result;
	}

//	public Messags validatePatient(Patient patient) {
//		
//
//		
//		boolean validation = true;
//		Messags result;
//		String name = usuario.getName();
//		String password = usuario.getPassword();
//		if (usuario.getName().equals("") || usuario.getPassword().equals("")) {
//			validation = false;
//		}
//		if (name == null || password == null) {
//			validation = false;
//		}
//
//		if (validation) {
//			return result = checkUserBD(usuario);
//
//		} else {
//
//			return Messags.CAMPOS;
//		}
//
//	}

}
