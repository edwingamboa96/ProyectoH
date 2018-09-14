package co.com.vass.controller;

import co.com.vass.dao.PatientDAO;
import co.com.vass.view.MenuPatients;
import co.com.vass.vo.Patient;

public class StartAplication {
	                    
	public static void main(String[] args) {
		//MenuPatients m=new MenuPatients();
		
		//m.setVisible(true);
		SetupApplication setupApplication=new SetupApplication();
		setupApplication.startSystem();	
//		Patient pa=new Patient();
//		pa.setAddress("cr 5");
//		pa.setName("jham");
//		pa.setDiagnostic("migraña");
//		PatientDAO pat=new PatientDAO();
//		pat.createPatien(pa);

	}

}
