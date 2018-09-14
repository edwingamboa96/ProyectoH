package co.com.vass.baseclass;

import java.util.List;

import co.com.vass.vo.User;

public interface IPatient extends ICRUD <User,Long>  {
	public List<User> ListarCursos();
}
