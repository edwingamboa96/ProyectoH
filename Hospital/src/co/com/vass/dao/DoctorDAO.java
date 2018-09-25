package co.com.vass.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import co.com.vass.baseclass.ConectionDAO;
import co.com.vass.vo.Doctor;
import co.com.vass.vo.Patient;

public class DoctorDAO extends ConectionDAO {

	boolean isUser = false;
	Session session = getSession();

	public List doctorSearch() {
		List listDoctor = null;
		Doctor doctor = null;
		session.beginTransaction();
		try {
			Query theStudents = session.createQuery(" from Doctor");
			listDoctor = theStudents.list();
			session.getTransaction().commit();
		} finally {
			session.close();
		}

		return listDoctor;

	}

	public Doctor readDoctor(Doctor doctorIN) {
		Doctor doctor = null;

		session.beginTransaction();
		try {
		
		Query theStudents = session.createQuery(" from Doctor where idnumber="+ "'" + doctorIN.getIdnumber() + "'" );
		doctor = (Doctor) theStudents.uniqueResult();
			if (doctor == null) {
				isUser = false;
			} else {
				isUser = true;
			}
			session.getTransaction().commit();
		} finally {
			session.close();
		}
System.out.println(doctor.getName());
		return doctor;
	}

	public boolean updateDoctor(Doctor doctor) {
		session.beginTransaction();
		System.out.println("inicio");
		session.saveOrUpdate(doctor);
		session.getTransaction().commit();
		System.out.println("fin");
		boolean isUser = false;
		return isUser;
	}

	public boolean deleteDoctor(Doctor doctor) {
		session.beginTransaction();

	//	Patient object = session.get(Patient.class, doctor.getIdPerson());*
//		Query theStudents = session.createQuery(" from Patient where document=" + "'" + patientIN.getDocument() + "'");
//		object = (Patient) theStudents.uniqueResult();

	//	session.delete(object);*
		session.getTransaction().commit();
		boolean isUser = false;
		return isUser;
	}

	public boolean createDoctor(Doctor doctor) {
		session.beginTransaction();
		session.save(doctor);
		session.getTransaction().commit();
		boolean isUser = false;
		return isUser;
	}

}
