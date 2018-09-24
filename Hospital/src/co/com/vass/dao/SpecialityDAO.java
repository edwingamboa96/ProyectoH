package co.com.vass.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import co.com.vass.baseclass.ConectionDAO;
import co.com.vass.vo.Speciality;

public class SpecialityDAO extends ConectionDAO {
	public SpecialityDAO() {
		super();

	}

	
	Session session = getSession();
	public boolean createSpeciality(Speciality speciality) {
		session.beginTransaction();
		session.save(speciality);
		session.getTransaction().commit();
		boolean isUser = false;
		return isUser;

	}
	
	public List searchSpecility() {
		List specialities = null;
		session.beginTransaction();
		try {
			Query theStudents = session.createQuery(" from Speciality");
			specialities = theStudents.list();

			session.getTransaction().commit();
		} finally {
			session.close();
		}

		
		

		return specialities;

	}
	

}
