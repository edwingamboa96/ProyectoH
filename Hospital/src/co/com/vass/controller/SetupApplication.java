package co.com.vass.controller;

import co.com.vass.modelo.Logic;
import co.com.vass.view.ViewLogin;
import co.com.vass.view.ViewMenu;

public class SetupApplication {
	public void startSystem() {
		ViewLogin loginview = new ViewLogin();
		ViewMenu mennu = new ViewMenu();
		Logic logic = new Logic();
		Coordinator coordinator = new Coordinator();
		
		loginview.setVisible(true);		
		loginview.setControlador(coordinator);
		logic.setCoordinator(coordinator);
		coordinator.setLogic(logic);
		coordinator.setMennu(mennu);
		coordinator.setLoginview(loginview);

	}

}
