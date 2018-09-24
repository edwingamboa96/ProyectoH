package co.com.vass.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import co.com.vass.baseclass.ConectionDAO;
import co.com.vass.baseclass.ICRUD;
import co.com.vass.vo.Doctor;
import co.com.vass.vo.Patient;
import co.com.vass.vo.Person;

public class PatientDAO extends ConectionDAO {

	public PatientDAO() {
		super();

	}

	boolean isUser = false;
	Session session = getSession();

	public Patient readPatienr(Patient patient) {
		Patient patientRead = null;		
		session.beginTransaction();
		try {
			Query theStudents = session.createQuery(" from Patient where idnumber=" + "'"+patient.getIdnumber()+"'");		
			patientRead = (Patient) theStudents.uniqueResult();
			if (patientRead == null) {
				isUser = false;
			} else {
				isUser = true;
			}
			session.getTransaction().commit();
		} finally {
			session.close();
		}
	
		return patientRead;
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
		session.beginTransaction();
		
		//Patient object =session.get(Patient.class, patientIN.getIdPerson());**
//		Query theStudents = session.createQuery(" from Patient where document=" + "'" + patientIN.getDocument() + "'");
//		object = (Patient) theStudents.uniqueResult();
		
		//session.delete(object);**
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
