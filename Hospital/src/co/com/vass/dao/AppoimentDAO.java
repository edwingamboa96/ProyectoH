package co.com.vass.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import co.com.vass.baseclass.ConectionDAO;
import co.com.vass.vo.Appointment;
import co.com.vass.vo.User;

public class AppoimentDAO extends ConectionDAO {
	public AppoimentDAO() {
		super();
	}
	Session session = getSession();
	public boolean consultUserDatabase(Appointment appointmentIN) {
		session.beginTransaction();
		boolean isUser = false;
		Appointment appointment = null;
		try {
			Query theStudents = session.createQuery(" from appointment where idpatient=" + "'" + appointmentIN.getIdpatient()+"'");
					
			appointment = (Appointment) theStudents.uniqueResult();
			if (appointment == null) {
				isUser = false;
			} else {
				isUser = true;
			}

			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			session.close();
		}
		return isUser;
	}

	

	
	
	public boolean create_Appointment(Appointment appointment) {
		session.beginTransaction();
		session.save(appointment);
		session.getTransaction().commit();
		boolean isUser = false;
		return isUser;
	}
}
