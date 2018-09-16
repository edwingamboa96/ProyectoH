package co.com.vass.controller;

import javax.swing.text.MaskFormatter;

import co.com.vass.dao.PatientDAO;
import co.com.vass.view.MenuPatients;
import co.com.vass.vo.Patient;

public class StartAplication {

	public static void main(String[] args) {


		SetupApplication setupApplication = new SetupApplication();
		setupApplication.startSystem();

//	Patient pa=new Patient();
//	pa.setIdPerson(21);
//	pa.setAge(43);
//		pa.setName("jham");
//		pa.setDiagnostic("migraña");
//	PatientDAO pat=new PatientDAO();
//	pat.deletePatien(pa);
	//pat.updatePatien(pa);
//		pat.readPatienr(pa);

	}

}
