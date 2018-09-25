package co.com.vass.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import co.com.vass.controller.Coordinator;
import co.com.vass.vo.Speciality;

import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import javax.swing.JMenu;
import javax.swing.JSeparator;
import javax.swing.JButton;

public class ViewMainMenu extends JFrame implements ActionListener {

	private JMenuItem patienItem;
	private JMenuItem doctorItem;
	private JMenuItem roomsItem;
	private JMenuItem historyItem;
	private JMenuItem citasItem;

	private ViewMenuPatients viewPatiens;
	private ViewDoctor viewDoctor;
	private ViewSpeciality viewEspeciality;
	private ViewClinicalHistory viewClinicalHistory;
	private ViewRooms viewRooms;
	private ViewAppoiment  viewAppoiment;
	private Coordinator coordinator;

	public ViewMainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("GESTION DE HOSPITAL");
		Dimension tamPantalla = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle pantalla = new Rectangle(tamPantalla);
		setBounds(pantalla);
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel superior = new JPanel();
		getContentPane().add(superior, BorderLayout.NORTH);
		superior.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JMenuBar menuBar = new JMenuBar();// Barra menu
		superior.add(menuBar);

		JMenu menuPatients = new JMenu("Pacientes");// menu
		patienItem = new JMenuItem("Registrar pacientes");// Sub menu
		patienItem.addActionListener(this);
		menuPatients.setIcon(new ImageIcon(ViewMainMenu.class.getResource("/co/com/vass/resources/patients.png")));
		menuPatients.add(patienItem);

		JMenu menuDoctors = new JMenu("Medicos");// menu
		doctorItem = new JMenuItem("Registrar medico");// Sub menu
		doctorItem.addActionListener(this);
		menuDoctors.setIcon(new ImageIcon(ViewMainMenu.class.getResource("/co/com/vass/resources/doctor.png")));
		menuDoctors.add(doctorItem);

		JMenu mnCuartos = new JMenu("Cuartos");
		roomsItem = new JMenuItem("Registrar curto");// Sub menu
		mnCuartos.setIcon(new ImageIcon(ViewMainMenu.class.getResource("/co/com/vass/resources/bedroom.png")));
		roomsItem.addActionListener(this);
		mnCuartos.add(roomsItem);

		JMenu mnHistoriaClinica = new JMenu("Historia clinica");
		historyItem = new JMenuItem("Historia clinica");// Sub menu
		mnHistoriaClinica
				.setIcon(new ImageIcon(ViewMainMenu.class.getResource("/co/com/vass/resources/medicalhistory.jpg")));
		historyItem.addActionListener(this);
		mnHistoriaClinica.add(historyItem);
		menuBar.add(menuPatients);
		menuBar.add(menuDoctors);
		menuBar.add(mnCuartos);
		menuBar.add(mnHistoriaClinica);
		
				JMenu mnCitas = new JMenu("Citas");
				citasItem = new JMenuItem("Citas Medicos");
				mnCitas.setIcon(new ImageIcon(ViewMainMenu.class.getResource("/co/com/vass/resources/calendar.png")));
				citasItem.addActionListener(this);
				mnCitas.add(citasItem);
				
						menuBar.add(mnCitas);

		JPanel central = new JPanel();
		getContentPane().add(central, BorderLayout.CENTER);
		central.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(218, 0, 1340, 674);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\edwin.gamboa\\Desktop\\fondo.png"));
		central.add(lblNewLabel_1);

	}

	public ViewDoctor getViewDoctor() {
		return viewDoctor;
	}

	public void setViewDoctor(ViewDoctor viewDoctor) {
		this.viewDoctor = viewDoctor;
	}

	public ViewSpeciality getViewEspeciality() {
		return viewEspeciality;
	}

	public void setViewEspeciality(ViewSpeciality viewEspeciality) {
		this.viewEspeciality = viewEspeciality;
	}

	public ViewClinicalHistory getViewClinicalHistory() {
		return viewClinicalHistory;
	}

	public void setViewClinicalHistory(ViewClinicalHistory viewClinicalHistory) {
		this.viewClinicalHistory = viewClinicalHistory;
	}

	public ViewRooms getViewRooms() {
		return viewRooms;
	}

	public void setViewRooms(ViewRooms viewRooms) {
		this.viewRooms = viewRooms;
	}

	public ViewMenuPatients getViewPatiens() {
		return viewPatiens;
	}

	public void setViewPatiens(ViewMenuPatients viewPatiens) {
		this.viewPatiens = viewPatiens;
	}

	public Coordinator getCoordinator() {
		return coordinator;
	}

	public void setCoordinator(Coordinator coordinator) {
		this.coordinator = coordinator;
	}
	

	public ViewAppoiment getvIewApoiment() {
		return viewAppoiment;
	}

	public void setviewApoiment(ViewAppoiment viewAppoiment) {
		this.viewAppoiment = viewAppoiment;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == patienItem) {
			getViewPatiens().setVisible(true);

		}
		if (e.getSource() == doctorItem) {

			getViewDoctor().setVisible(true);

		}
		if (e.getSource() == roomsItem) {
			getViewRooms().setVisible(true);

		}
		if (e.getSource() == historyItem) {
			getViewClinicalHistory().setVisible(true);

		}
		if (e.getSource() == citasItem) {
			getvIewApoiment().setVisible(true);

		}

	}

}
