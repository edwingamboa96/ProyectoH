package co.com.vass.controller;

import co.com.vass.modelo.Logic;
import co.com.vass.view.ViewMenuPatients;
import co.com.vass.view.ViewRooms;
import co.com.vass.view.ViewClinicalHistory;
import co.com.vass.view.ViewDoctor;
import co.com.vass.view.ViewEspeciality;
import co.com.vass.view.ViewLogin;
import co.com.vass.view.ViewMainMenu;
import co.com.vass.vo.Patient;

public class SetupApplication {
	public void startSystem() {
		ViewLogin loginview = new ViewLogin();

		ViewMainMenu viewMainMenu = new ViewMainMenu();

		ViewMenuPatients menuPatients = new ViewMenuPatients();
		ViewClinicalHistory viewClinicalHistory = new ViewClinicalHistory();
		ViewDoctor viewDoctor = new ViewDoctor();
		ViewEspeciality viewEspeciality = new ViewEspeciality();
		ViewRooms viewRooms = new ViewRooms();
		Patient patient = new Patient();
		Logic logic = new Logic();
		Coordinator coordinator = new Coordinator();

		loginview.setVisible(true);
		loginview.setControlador(coordinator);

		viewMainMenu.setViewPatiens(menuPatients);
		viewMainMenu.setViewClinicalHistory(viewClinicalHistory);
		viewMainMenu.setViewRooms(viewRooms);
		viewMainMenu.setViewDoctor(viewDoctor);
		viewMainMenu.setViewEspeciality(viewEspeciality);

		logic.setCoordinator(coordinator);
		coordinator.setLogic(logic);
		coordinator.setMennu(viewMainMenu);
		coordinator.setLoginview(loginview);
		coordinator.setMenuPatiens(menuPatients);
		menuPatients.setCoordinator(coordinator);

	}

}
