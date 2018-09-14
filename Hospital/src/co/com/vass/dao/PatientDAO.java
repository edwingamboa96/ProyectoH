package co.com.vass.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import co.com.vass.baseclass.ConectionDAO;
import co.com.vass.baseclass.ICRUD;
import co.com.vass.vo.Patient;
import co.com.vass.vo.Person;

public class PatientDAO extends ConectionDAO {

	public PatientDAO() {
		super();

	}

	boolean isUser = false;
	Session session = getSession();

	public boolean readPatienr(Patient patient) {

		Patient object = null;
		try {
			Query theStudents = session.createQuery(" from Patient where document=" + "'" + patient.getDocument()
					+ "'and name=" + "'" + patient.getName() + "'");
			object = (Patient) theStudents.uniqueResult();
			if (object == null) {
				isUser = false;
			} else {
				isUser = true;
			}

			session.getTransaction().commit();
			System.out.println("" + object.getEmail());
			System.out.println("Done!");
		} finally {
			session.close();
		}
		return isUser;
	}

	public boolean updatePatien(Patient patient) {
		session.beginTransaction();
		System.out.println("inicio");
		session.saveOrUpdate(patient);
		session.getTransaction().commit();
		System.out.println("fin");
		boolean isUser = false;
		return isUser;
	}

	public boolean deletePatien(Patient patientIN) {
		Patient object = null;
		Query theStudents = session.createQuery(" from Patient where document=" + "'" + patientIN.getDocument() + "'");
		object = (Patient) theStudents.uniqueResult();
		session.beginTransaction();
		session.delete(object);
		session.getTransaction().commit();
		boolean isUser = false;
		return isUser;
	}

	public boolean createPatien(Patient patient) {
		session.beginTransaction();
		session.save(patient);
		session.getTransaction().commit();
		boolean isUser = false;
		return isUser;
	}

}
