package co.com.vass.controller;

import co.com.vass.modelo.Logic;
import co.com.vass.view.MenuPatients;
import co.com.vass.view.ViewLogin;
import co.com.vass.view.ViewMenu;
import co.com.vass.vo.Patient;

public class SetupApplication {
	public void startSystem() {
		ViewLogin loginview = new ViewLogin();
		MenuPatients menuPatients = new MenuPatients();
		ViewMenu windowMain = new ViewMenu();
		Patient patient = new Patient();

		Logic logic = new Logic();
		Coordinator coordinator = new Coordinator();

		loginview.setVisible(true);
		loginview.setControlador(coordinator);
         windowMain.setWindowPatients(menuPatients);
		logic.setCoordinator(coordinator);
		coordinator.setLogic(logic);
		coordinator.setMennu(windowMain);
		coordinator.setLoginview(loginview);
		coordinator.setMenuPatiens(menuPatients);
		menuPatients.setCoordinator(coordinator);
		menuPatients.setPatient(patient);

	}

}
