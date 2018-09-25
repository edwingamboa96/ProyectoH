package co.com.vass.dao;

import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

import co.com.vass.baseclass.ConectionDAO;
import co.com.vass.vo.Appointment;
import co.com.vass.vo.Doctor;
import co.com.vass.vo.Speciality;
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
			Query theStudents = session
					.createQuery(" from appointment where idpatient=" + "'" + appointmentIN.getIdpatient() + "'");

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

	public Doctor searchDoctorfromSpeciality(Speciality speciality) {
		Doctor doctor;
		session.beginTransaction();		
		String name = null;
		try {
			List resultWithAliasedBean = session.createSQLQuery(" SELECT doctor.name,doctor.idDoctor "
					+ "       FROM doctor_has_speciality "
					+ "          JOIN doctor  ON doctor_has_speciality.doctor_idDoctor = doctor.idDoctor"
					+ "          JOIN speciality ON doctor_has_speciality.speciality_idspeciality = speciality.idspeciality"
					+ "       WHERE speciality.name =" + "'" + speciality.getName() + "'").addScalar("name").addScalar("idDoctor")
					.setResultTransformer(Transformers.aliasToBean(Doctor.class)).list();
			 doctor = (Doctor) resultWithAliasedBean.get(0);		
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			session.close();
		}
		return doctor;
	}

	public boolean create_Appointment(Appointment appointment) {
		session.beginTransaction();
		session.save(appointment);
		session.getTransaction().commit();
		boolean isUser = false;
		return isUser;
	}
}
