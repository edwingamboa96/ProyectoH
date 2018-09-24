package co.com.vass.view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import co.com.vass.controller.Coordinator;
import co.com.vass.modelo.Logic.Messags;
import co.com.vass.vo.Doctor;
import co.com.vass.vo.Patient;
import co.com.vass.vo.Speciality;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JList;

public class ViewDoctor extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textMail;
	private JTextField textaddress;
	private Coordinator coordinator;
	private List<Speciality> specialities;
	List<Speciality> specialitiesIN;
	private JButton btnAdd;
	private JButton btnSerch;
	private JButton btnAddSpecility;
	private JButton btnDeleteSpecility;
	private JButton btnUpDateSpeciality;
	private JButton btnSerchSpeciality;
	private JFormattedTextField formatPhone;
	private JFormattedTextField formatDocument;

	private List<Doctor> doctors;
	private JTabbedPane tabbedPane;
	private JPanel panelSpecility;
	private JLabel lblApellido;
	private JTextField textLastName;
	private JTextField textAddSpeciality;
	private JTextField textField;
	private JTextField textAddCode;
	private JButton btnSelectdSpeciality;
	private JScrollPane scrollPane_2;
	private JList listsSelected;
	private JLabel lblAgregadas;
	private DefaultListModel modelSpecility;
	private JList listSpeciality;
	private String[] listVector;
	private JScrollPane scrollPane_1;
	private Set<Speciality> list_speciality;
	private Set<Speciality> list_select;
	JFormattedTextField formatSearch;
	private static final String[] coreList = {};
//Coordinator coordinator

	public ViewDoctor(List<Speciality> specialitiesIN) {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 577, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(new BorderLayout(0, 0));

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		JPanel panelDoctor = new JPanel();
		tabbedPane.addTab("Agregar medico", null, panelDoctor, null);
		panelDoctor.setLayout(null);

		btnSerch = new JButton("Buscar");
		btnSerch.setBounds(24, 305, 136, 46);
		btnSerch.setIcon(new ImageIcon(ViewDoctor.class.getResource("/co/com/vass/resources/search.png")));
		btnSerch.addActionListener(this);
		panelDoctor.add(btnSerch);

		JButton btnDelete = new JButton("Eliminar");

		btnDelete.setBounds(180, 245, 136, 51);
		btnDelete.setIcon(new ImageIcon(ViewDoctor.class.getResource("/co/com/vass/resources/delete.png")));
		panelDoctor.add(btnDelete);

		JButton btnUpdate = new JButton("Actualizar");
		btnUpdate.setBounds(326, 249, 149, 51);
		btnUpdate.setIcon(new ImageIcon(ViewDoctor.class.getResource("/co/com/vass/resources/save.png")));
		panelDoctor.add(btnUpdate);

		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(24, 63, 106, 14);
		panelDoctor.add(lblNewLabel);

		textName = new JTextField();
		textName.setBounds(152, 60, 86, 20);
		panelDoctor.add(textName);
		textName.setColumns(10);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(531, 33, 0, 2);
		panelDoctor.add(separator_1);

		JLabel lblCargo = new JLabel(" numero Documento");
		lblCargo.setBounds(24, 88, 118, 14);
		panelDoctor.add(lblCargo);

		formatDocument = new JFormattedTextField();
		formatDocument.setBounds(152, 86, 86, 20);
		panelDoctor.add(formatDocument);

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(24, 113, 94, 14);
		panelDoctor.add(lblTelefono);

		formatPhone = new JFormattedTextField();
		formatPhone.setBounds(152, 114, 81, 20);
		panelDoctor.add(formatPhone);

		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setBounds(272, 113, 44, 14);
		panelDoctor.add(lblCorreo);

		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(272, 89, 54, 14);
		panelDoctor.add(lblDireccion);

		textMail = new JTextField();
		textMail.setBounds(349, 117, 86, 20);
		panelDoctor.add(textMail);
		textMail.setColumns(10);

		textaddress = new JTextField();
		textaddress.setBounds(349, 86, 86, 20);
		panelDoctor.add(textaddress);
		textaddress.setColumns(10);

		JLabel lblMedicos = new JLabel("MEDICOS");
		lblMedicos.setBounds(237, 11, 46, 14);
		panelDoctor.add(lblMedicos);

		btnAdd = new JButton("Agregar");
		btnAdd.setBounds(24, 243, 136, 51);
		btnAdd.setVerticalAlignment(SwingConstants.TOP);
		btnAdd.setIcon(new ImageIcon(ViewDoctor.class.getResource("/co/com/vass/resources/add.png")));
		btnAdd.addActionListener(this);
		panelDoctor.add(btnAdd);

		lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(272, 63, 46, 14);
		panelDoctor.add(lblApellido);

		textLastName = new JTextField();
		textLastName.setBounds(349, 60, 86, 20);
		panelDoctor.add(textLastName);
		textLastName.setColumns(10);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(44, 144, 88, 88);
		panelDoctor.add(scrollPane_1);

		JLabel lblNewLabel_2 = new JLabel("Especialides");
		scrollPane_1.setColumnHeaderView(lblNewLabel_2);

		listSpeciality = new JList(coreList);
		listSpeciality.setVisibleRowCount(3);
		listSpeciality.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		scrollPane_1.setViewportView(listSpeciality);

		btnSelectdSpeciality = new JButton("");
		btnSelectdSpeciality.setIcon(new ImageIcon(ViewDoctor.class.getResource("/co/com/vass/resources/right.png")));
		btnSelectdSpeciality.setBounds(142, 155, 67, 30);
		btnSelectdSpeciality.addActionListener(this);
		panelDoctor.add(btnSelectdSpeciality);

		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(219, 145, 86, 89);
		panelDoctor.add(scrollPane_2);

		listsSelected = new JList();
		listsSelected = new JList<String>();
		listsSelected.setVisibleRowCount(3);
		listsSelected.setFixedCellWidth(100);
		listsSelected.setFixedCellHeight(15);

		scrollPane_2.setViewportView(listsSelected);

		lblAgregadas = new JLabel("agregadas:");
		scrollPane_2.setColumnHeaderView(lblAgregadas);

		panelSpecility = new JPanel();
		tabbedPane.addTab("Agregar especialidad", null, panelSpecility, null);
		panelSpecility.setLayout(null);

		JLabel lblEspecialidad = new JLabel("Nombre Especialidad");
		lblEspecialidad.setBounds(35, 47, 106, 14);
		panelSpecility.add(lblEspecialidad);

		textAddSpeciality = new JTextField();
		textAddSpeciality.setBounds(151, 44, 86, 20);
		panelSpecility.add(textAddSpeciality);
		textAddSpeciality.setColumns(10);

		btnAddSpecility = new JButton("AGREGAR");
		btnAddSpecility.setBounds(89, 122, 89, 23);
		btnAddSpecility.addActionListener(this);
		panelSpecility.add(btnAddSpecility);

		btnDeleteSpecility = new JButton("ELIMINAR");
		btnDeleteSpecility.setBounds(188, 122, 89, 23);
		panelSpecility.add(btnDeleteSpecility);

		btnUpDateSpeciality = new JButton("ACTUALIZAR");
		btnUpDateSpeciality.setBounds(302, 122, 99, 23);
		panelSpecility.add(btnUpDateSpeciality);

		btnSerchSpeciality = new JButton("BUSCAR");
		btnSerchSpeciality.setBounds(202, 173, 89, 23);
		panelSpecility.add(btnSerchSpeciality);

		textField = new JTextField();
		textField.setBounds(106, 174, 86, 20);
		panelSpecility.add(textField);
		textField.setColumns(10);

		JLabel lblEspecialidad_1 = new JLabel("ESPECIALIDAD");
		lblEspecialidad_1.setBounds(192, 11, 83, 14);
		panelSpecility.add(lblEspecialidad_1);

		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(282, 47, 46, 14);
		panelSpecility.add(lblCodigo);

		textAddCode = new JTextField();
		textAddCode.setBounds(326, 44, 86, 20);
		panelSpecility.add(textAddCode);
		textAddCode.setColumns(10);
		modelSpecility = new DefaultListModel<>();
		listsSelected.setModel(modelSpecility);
		
		 formatSearch = new JFormattedTextField();
		formatSearch.setBounds(170, 318, 113, 20);
		panelDoctor.add(formatSearch);
		loadSpecialityExternal(specialitiesIN);
		list_select = new HashSet<Speciality>();

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

	private void loadSpeciality() {
		List<Speciality> specialities;
		specialities = new ArrayList<>();
		Speciality speciality = new Speciality();
		speciality.setName(textAddSpeciality.getText());
		speciality.setCode(textAddCode.getText());
		Messags ansswer = coordinator.saveSpeciality(speciality);
		List<Speciality> specialitiesOUT = coordinator.searchSpecility();
		specialities.add(speciality);
		if (specialitiesOUT.size() > 0) {
			String v[] = new String[specialitiesOUT.size()];
			for (int i = 0; i < specialitiesOUT.size(); i++) {
				v[i] = specialitiesOUT.get(i).getName();
			}

			listSpeciality.setListData(v);
		}

	}

	private void loadDoctor() {
		list_speciality = new HashSet<Speciality>();
//		list_speciality.add(speciality);
		doctors = coordinator.serchDoctor();
		String v[] = new String[doctors.size()];
		for (int i = 0; i < doctors.size(); i++) {
			v[i] = doctors.get(i).getName();
		}
		DefaultComboBoxModel model = new DefaultComboBoxModel(v);

	}

	private Doctor saveDoctor() {
		Doctor doctor = new Doctor();
		doctor.setName(textName.getText());
		doctor.setAddress(textaddress.getText());
		doctor.setEmail(textMail.getText());
		doctor.setPhone(formatPhone.getText());
		doctor.setIdnumber(Integer.parseInt(formatDocument.getText()));
		doctor.setSpecility(list_speciality());
		return doctor;
	}

	public void readDoctor(Doctor doctor) {
		textName.setText(doctor.getName());
		textaddress.setText(doctor.getAddress());
		textMail.setText(doctor.getEmail());
		formatPhone.setText(doctor.getPhone());
	
	
		formatDocument.setText(String.valueOf(doctor.getIdnumber()));
	//	doctor.setSpecility(list_speciality());
	}

	private Set<Speciality> list_speciality() {
		for (int i = 0; i < modelSpecility.getSize(); i++) {

			for (Speciality s : list_speciality) {
				if (s.getName().equals(modelSpecility.getElementAt(i)))
					list_select.add(s);
			}
		}

		return list_select;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdd) {
			coordinator.saveDoctor(saveDoctor());

		}

		if (e.getSource() == btnAddSpecility) {

			loadSpeciality();

		}
		if (e.getSource() == btnSelectdSpeciality) {
			modelSpecility.addElement(listSpeciality.getSelectedValue());

		}
		if (e.getSource() == btnSerch) {
			Doctor doctor = new Doctor();
			
          doctor.setIdnumber(Integer.parseInt(formatSearch.getText()));

			readDoctor(coordinator.serchDoctor(doctor));

		}

	}

	public String[] getListVector() {
		return listVector;
	}

	public void setListVector(String[] listVector) {
		this.listVector = listVector;
	}

	public Coordinator getCoordinator() {
		return coordinator;
	}

	public void setCoordinator(Coordinator coordinator) {
		this.coordinator = coordinator;
	}
}
