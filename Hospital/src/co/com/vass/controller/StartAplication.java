package co.com.vass.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.Transaction;
import co.com.vass.dao.AppoimentDAO;
import co.com.vass.dao.DoctorDAO;
import co.com.vass.dao.PatientDAO;
import co.com.vass.dao.SpecialityDAO;
import co.com.vass.view.ViewSelecSpeciality;
import co.com.vass.view.ReportsAppoiment;
import co.com.vass.view.ViewDoctor;
import co.com.vass.vo.Appointment;
import co.com.vass.vo.Doctor;
import co.com.vass.vo.Patient;
import co.com.vass.vo.Speciality;
import co.com.vass.vo.User;

public class StartAplication {

	public static void main(String[] args) {

//		ReportsAppoiment appoiment = new ReportsAppoiment();
//		Appointment appointment = new Appointment();
//		User patient = new User();
//		patient.setArea("area");
//		patient.setDocument("123");
//		patient.setId(5);
//		patient.setName("juana");
//		patient.setPassword("1234");
//		patient.setPhone("4666");
//		patient.setPosition("dd");
//		appoiment.algo();

		SetupApplication setupApplication = new SetupApplication();
		setupApplication.startSystem();

//		Speciality speciality = new Speciality();
//		speciality.setName("medico");
//		AppoimentDAO appoimentDAO = new AppoimentDAO();
//		Doctor d = appoimentDAO.consultNameDoctortabase(speciality);
//		System.out.println(d.getName());

		// ----------------------
//		Doctor doctor=new Doctor();
//		doctor.setName("HOY");
//		doctor.setIdDoctor(44);
//		Appointment appointment = new Appointment();
//		Calendar myCalendar = new GregorianCalendar(2014, 2, 11);
//		Date date = myCalendar.getTime();
//		
//		
//		Patient patient=new Patient();
//		patient.setIdPatien(42);
//		
//		appointment.setDate(date);
//		appointment.setIddoctorap(doctor.getIdDoctor());
//		appointment.setIdpatient(patient.getIdPatien());
//		appointment.setAppointment(doctor);
//		
//		appointment.setPatient(patient);
//		
//		AppoimentDAO appoimentDAO = new AppoimentDAO();
//		appoimentDAO.create_Appointment(appointment);

		// --------------------------------

	}

}
