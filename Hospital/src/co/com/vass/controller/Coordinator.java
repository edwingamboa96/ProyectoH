package co.com.vass.controller;


import co.com.vass.modelo.Logic;
import co.com.vass.modelo.Logic.Messags;
import co.com.vass.view.ViewMenu;
import co.com.vass.view.ViewLogin;
import co.com.vass.vo.User;;

public class Coordinator {

	private Logic logic;
	private ViewLogin loginview;
	private ViewMenu mennu;

	public ViewMenu getMennu() {
		return mennu;
	}

	public void setMennu(ViewMenu mennu) {
		this.mennu = mennu;
	}

	public Logic getLogic() {
		return logic;
	}

	public void setLogic(Logic logic) {
		this.logic = logic;
	}

	public ViewLogin getLoginview() {
		return loginview;
	}

	public void setLoginview(ViewLogin loginview) {
		this.loginview = loginview;
	}

	public Messags validateLogin(User usuario) {

		return logic.validateLogin(usuario);
	}

	public void showMennu() {
		mennu.setVisible(true);

	}

	public void closeLogin() {
		loginview.dispose();
	}

}
