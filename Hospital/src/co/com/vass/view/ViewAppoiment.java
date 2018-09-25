package co.com.vass.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.awt.event.ActionEvent;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import co.com.vass.controller.Coordinator;
import co.com.vass.vo.Appointment;
import co.com.vass.vo.Doctor;
import co.com.vass.vo.Patient;
import co.com.vass.vo.Speciality;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFormattedTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewAppoiment extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textSpeciality;
	private JTextField texttime;
	private JTextField textName;
	private JTable table;
	private JScrollPane scrollPane_1;
	private JList listSpeciality;
	private Set<Speciality> list_speciality;
	private Set<Doctor> list_ddoctor;
	private JTextField textDoctor;
	Doctor doctor;
	JFormattedTextField formatDocument;
	private DefaultListModel modelSpecility;
	private Coordinator coordinator;
	JButton btnSerchPatient;
	private JTextField textLasname;
	JDateChooser dateChooser;
	SimpleDateFormat formatoFecha;
	Date fecha;
	private Patient patient;
	JButton btnregistrar;

	public ViewAppoiment(List<Speciality> specialitiesIN) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panelbutons = new JPanel();
		contentPane.add(panelbutons, BorderLayout.SOUTH);

		btnregistrar = new JButton("registrar");
		panelbutons.add(btnregistrar);
		btnregistrar.addActionListener(this);
		JButton btnEliminar = new JButton(" eliminar");
		panelbutons.add(btnEliminar);

		JButton btnActulizar = new JButton("actulizar");
		panelbutons.add(btnActulizar);

		JPanel inputs = new JPanel();
		contentPane.add(inputs, BorderLayout.CENTER);
		inputs.setLayout(null);

		JLabel lblNombrePaciente = new JLabel("documento paciente");
		lblNombrePaciente.setBounds(10, 32, 109, 14);
		inputs.add(lblNombrePaciente);

		JLabel lblEspecialidad = new JLabel("Especialidad");
		lblEspecialidad.setBounds(253, 38, 64, 14);
		inputs.add(lblEspecialidad);

		btnSerchPatient = new JButton("");
		btnSerchPatient.setIcon(new ImageIcon(ViewAppoiment.class.getResource("/co/com/vass/resources/searchp.png")));
		btnSerchPatient.setBounds(209, 29, 24, 23);
		btnSerchPatient.addActionListener(this);
		inputs.add(btnSerchPatient);

		JLabel lblMedico = new JLabel("Medico");
		lblMedico.setBounds(271, 133, 46, 14);
		inputs.add(lblMedico);

		textSpeciality = new JTextField();
		textSpeciality.setBounds(327, 32, 86, 20);
		inputs.add(textSpeciality);
		textSpeciality.setColumns(10);

		dateChooser = new JDateChooser();

		dateChooser.addPropertyChangeListener("date", new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				JDateChooser chooser = (JDateChooser) evt.getSource();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
				String f = formatter.format(chooser.getDate());

				// textSpeciality.setText(formatter.format(chooser.getDate()));

				try {
					fecha = formatter.parse(f);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// fecha = dateChooser.getDate();

			}

		});

		dateChooser.setBounds(112, 133, 98, 20);
		inputs.add(dateChooser);

		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(10, 133, 46, 14);
		inputs.add(lblFecha);

		JLabel lblHora = new JLabel("Hora");
		lblHora.setBounds(59, 178, 46, 14);
		inputs.add(lblHora);

		texttime = new JTextField();
		texttime.setBounds(112, 194, 86, 20);
		inputs.add(texttime);
		texttime.setColumns(10);

		JLabel lblNombrePaciente_1 = new JLabel("Nombre paciente");
		lblNombrePaciente_1.setBounds(20, 63, 92, 14);
		inputs.add(lblNombrePaciente_1);

		textName = new JTextField();
		textName.setBounds(112, 57, 86, 20);
		inputs.add(textName);
		textName.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 225, 471, 117);
		inputs.add(scrollPane);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(434, 30, 88, 88);
		inputs.add(scrollPane_1);

		listSpeciality = new JList();
		scrollPane_1.setViewportView(listSpeciality);
		listSpeciality.setVisibleRowCount(3);
		listSpeciality.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		listSpeciality.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					textSpeciality.setText(listSpeciality.getSelectedValue().toString());
					Speciality speciality = new Speciality();
					speciality.setName(textSpeciality.getText());

					doctor = coordinator.searchDoctorfromSpeciality(speciality);
					textDoctor.setText(doctor.getName());
				}

			}
		});
		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] { { null, null, null }, { null, null, null }, },
				new String[] { "codigo ", "nombre", "nombre medico" }));
		scrollPane.setViewportView(table);

		textDoctor = new JTextField();
		textDoctor.setBounds(327, 130, 86, 20);
		inputs.add(textDoctor);
		textDoctor.setColumns(10);

		formatDocument = new JFormattedTextField();
		formatDocument.setBounds(112, 29, 86, 20);
		inputs.add(formatDocument);

		JLabel lblApellido = new JLabel(" Apellido");
		lblApellido.setBounds(30, 91, 46, 14);
		inputs.add(lblApellido);

		textLasname = new JTextField();
		textLasname.setBounds(112, 91, 86, 20);
		inputs.add(textLasname);
		textLasname.setColumns(10);
		loadSpecialityExternal(specialitiesIN);
		// loadDoctorExternal(doctorIN);
	}

	public Coordinator getCoordinator() {
		return coordinator;
	}

	public void setCoordinator(Coordinator coordinator) {
		this.coordinator = coordinator;
	}

	void loadSpecialityExternal(List<Speciality> specialitiesIN) {
		list_speciality = new HashSet<Speciality>();
		if (specialitiesIN.size() > 0) {
			String v[] = new String[specialitiesIN.size()];
			for (int i = 0; i < specialitiesIN.size(); i++) {
				v[i] = specialitiesIN.get(i).getName();
				list_speciality.add(specialitiesIN.get(i));
			}

			listSpeciality.setListData(v);
		}

	}

//	void loadDoctorExternal(List<Doctor> doctorIN) {
//		list_ddoctor = new HashSet<Doctor>();
//		if (doctorIN.size() > 0) {
//			String v[] = new String[doctorIN.size()];
//			for (int i = 0; i < doctorIN.size(); i++) {
//				v[i] = doctorIN.get(i).getName();
//				list_ddoctor.add(doctorIN.get(i));
//			}
//
//			jlistDoctor.setListData(v);
//		}
//
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSerchPatient) {
			patient = new Patient();
			patient.setIdnumber(Integer.parseInt(formatDocument.getText()));
			patient = coordinator.serchPatient(patient);
			readPatient();
		}

		if (e.getSource() == btnregistrar) {

			coordinator.saveAppoiment(saveAppoiment());

		}
		// TODO Auto-generated method stub

	}

//	appointment.setAppointment(doctor);

	private Appointment saveAppoiment() {
		Appointment appointment = new Appointment();
		appointment.setDate(fecha);
		appointment.setIdpatient(patient.getIdPatien());
		appointment.setIddoctorap(doctor.getIdDoctor());
		appointment.setAppointment(doctor);
		return appointment;

	}

	private void readPatient() {
		textName.setText(patient.getName());
		textLasname.setText(patient.getLastname());

	}
}
