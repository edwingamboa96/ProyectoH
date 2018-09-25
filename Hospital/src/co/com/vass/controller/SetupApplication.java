package co.com.vass.controller;

import co.com.vass.modelo.ControllerDAO;
import co.com.vass.view.ViewMenuPatients;
import co.com.vass.view.ViewRooms;
import co.com.vass.view.ViewSpeciality;
import co.com.vass.view.ViewAppoiment;
import co.com.vass.view.ViewClinicalHistory;
import co.com.vass.view.ViewDoctor;

import co.com.vass.view.ViewLogin;
import co.com.vass.view.ViewMainMenu;
import co.com.vass.vo.Patient;

public class SetupApplication {
	public void startSystem() {
		ViewLogin loginview = new ViewLogin();
		ViewMainMenu viewMainMenu = new ViewMainMenu();
		ViewMenuPatients menuPatients = new ViewMenuPatients();
		ViewClinicalHistory viewClinicalHistory = new ViewClinicalHistory();
	
		ViewSpeciality viewSpeciality = new ViewSpeciality();
		ViewRooms viewRooms = new ViewRooms();
	
		
		Patient patient = new Patient();
		ControllerDAO logic = new ControllerDAO();
		
		Coordinator coordinator = new Coordinator();
		coordinator.setLogic(logic);
		coordinator.setMennu(viewMainMenu);
		coordinator.setLoginview(loginview);// relaciona login con coordinador

		loginview.setVisible(true);

		// para enviar iniciar las varibles en menuMAIN
		viewMainMenu.setViewPatiens(menuPatients);
		viewMainMenu.setViewClinicalHistory(viewClinicalHistory);
		viewMainMenu.setViewRooms(viewRooms);
		ViewAppoiment viewAppoiment=new ViewAppoiment(coordinator.searchSpecility());
		viewMainMenu.setviewApoiment(viewAppoiment);
		ViewDoctor viewDoctor = new ViewDoctor(coordinator.searchSpecility());
		viewDoctor.setCoordinator(coordinator);
		viewMainMenu.setViewDoctor(viewDoctor);
		viewMainMenu.setViewEspeciality(viewSpeciality);
		viewMainMenu.setCoordinator(coordinator);
		viewAppoiment.setCoordinator(coordinator);

		// coordinator.setMenuPatiens(menuPatients);

		/// iniciar coordinador en las vistas
		logic.setCoordinator(coordinator);
		menuPatients.setCoordinator(coordinator);
		loginview.setControlador(coordinator);
		viewSpeciality.setCoordinator(coordinator);
		

	}

}
