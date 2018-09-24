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
import co.com.vass.view.ViewDoctor;
import co.com.vass.vo.Appointment;
import co.com.vass.vo.Doctor;
import co.com.vass.vo.Patient;
import co.com.vass.vo.Speciality;

public class StartAplication {

	public static void main(String[] args) {
		SetupApplication setupApplication = new SetupApplication();
		setupApplication.startSystem();
		// ----------------------
//		Doctor doctor=new Doctor();
//		doctor.setName("HOY");
//		doctor.setIdDoctor(43);
//		Appointment appointment = new Appointment();
//		Calendar myCalendar = new GregorianCalendar(2014, 2, 11);
//		Date date = myCalendar.getTime();
//		
//		
//		Patient patient=new Patient();
//		patient.setIdPatien(36);
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
