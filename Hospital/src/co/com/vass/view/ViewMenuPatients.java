package co.com.vass.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.InternationalFormatter;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Vector;
import co.com.vass.controller.Coordinator;
import co.com.vass.modelo.Logic.Messags;
import co.com.vass.vo.Patient;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;

public class ViewMenuPatients extends JFrame implements ActionListener, KeyListener, DocumentListener {

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textAddress;
	private JTextField textPhone;
	private JComboBox spnDocument;
	private JTextField textDiagnostic;
	private JTextField textJob;
	private JTextField textEmail;
	private JTextField textNatiolaty;
	private JRadioButton rdbtnMujer;
	private JRadioButton rdbtnHombre;
	private Patient patient;
	private boolean checkInput;
	private String gener;
	ButtonGroup buttonGroup;
	private Coordinator coordinator;
	private JButton btnAdd, btnSerch, btnUpdate, btnDelete;
	private JFormattedTextField formatAge;
	private JFormattedTextField formatDelete;
	private JFormattedTextField formatWeight;
	private JFormattedTextField formatHeigth;
	private List<JTextField> textFields = null;
	private JFormattedTextField formatSerch;
	private JFormattedTextField formatIdNumber;

	public ViewMenuPatients() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel titulo = new JPanel();
		panel.add(titulo, BorderLayout.NORTH);

		JLabel lblPacientes = new JLabel("PACIENTES");
		titulo.add(lblPacientes);

		JPanel botones = new JPanel();
		panel.add(botones, BorderLayout.SOUTH);
		botones.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnAdd = new JButton("REGISTRAR");
		btnAdd.setIcon(new ImageIcon(ViewMenuPatients.class.getResource("/co/com/vass/resources/add.png")));
		btnAdd.addActionListener(this);
		btnAdd.setEnabled(false);
		botones.add(btnAdd);

		btnSerch = new JButton("BUSCAR");
		btnSerch.setIcon(new ImageIcon(ViewMenuPatients.class.getResource("/co/com/vass/resources/search.png")));
		btnSerch.addActionListener(this);
		botones.add(btnSerch);

		btnUpdate = new JButton("ACTULIZAR");
		btnUpdate.addActionListener(this);
		btnUpdate.setIcon(new ImageIcon(ViewMenuPatients.class.getResource("/co/com/vass/resources/save.png")));
		botones.add(btnUpdate);

		btnDelete = new JButton(" ELIMINAR");
		btnDelete.addActionListener(this);
		btnDelete.setIcon(new ImageIcon(ViewMenuPatients.class.getResource("/co/com/vass/resources/delete.png")));
		botones.add(btnDelete);

		JPanel centro = new JPanel();
		panel.add(centro, BorderLayout.CENTER);

		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(35, 31, 46, 14);

		textName = new JTextField();
		textName.setBounds(92, 28, 86, 20);
		textName.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("documento");
		lblNewLabel_1.setBounds(35, 62, 53, 14);

		JLabel lblNewLabel_2 = new JLabel("Direccion");
		lblNewLabel_2.setBounds(35, 118, 46, 14);

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(35, 144, 46, 14);

		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(35, 88, 46, 14);

		JLabel lblGenero = new JLabel("Sexo");
		lblGenero.setBounds(330, 31, 46, 14);

		textAddress = new JTextField();
		textAddress.setBounds(92, 115, 86, 20);
		textAddress.setColumns(10);

		textPhone = new JTextField();
		textPhone.setBounds(92, 141, 86, 20);
		textPhone.setColumns(10);

		//String genero[] = { "hombre", "mujer" };
		String documentType[] = { "cedula", "pasaporte", "targeta identidad" };

		spnDocument = new JComboBox(documentType);

		spnDocument.setBounds(92, 59, 80, 20);
		centro.setLayout(null);
		centro.add(textAddress);
		centro.add(textPhone);
		centro.add(spnDocument);
		centro.add(lblNewLabel);
		centro.add(textName);
		centro.add(lblTelefono);
		centro.add(lblGenero);
		centro.add(lblNewLabel_1);
		centro.add(lblNewLabel_2);
		centro.add(lblEdad);

		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setBounds(330, 62, 46, 14);
		centro.add(lblPeso);
		buttonGroup = new ButtonGroup();
		rdbtnHombre = new JRadioButton("Hombre");
		rdbtnHombre.setBounds(355, 27, 63, 23);
		rdbtnHombre.setActionCommand("HOMBRE");
		rdbtnHombre.setSelected(true);
		setGener("HOMBRE");
		centro.add(rdbtnHombre);

		rdbtnMujer = new JRadioButton("mujer");
		rdbtnMujer.setBounds(420, 27, 63, 23);
		rdbtnMujer.setActionCommand("MUJER");
		rdbtnHombre.addActionListener(this);
		rdbtnMujer.addActionListener(this);

		centro.add(rdbtnMujer);

		buttonGroup.add(rdbtnHombre);
		buttonGroup.add(rdbtnMujer);

		JLabel lblNewLabel_3 = new JLabel("Diagnostico");
		lblNewLabel_3.setBounds(302, 88, 63, 14);
		centro.add(lblNewLabel_3);

		textDiagnostic = new JTextField();
		textDiagnostic.setBounds(375, 85, 86, 20);
		centro.add(textDiagnostic);
		textDiagnostic.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Estatura");
		lblNewLabel_4.setBounds(312, 116, 46, 14);
		centro.add(lblNewLabel_4);

		JLabel lblTrabajo = new JLabel("Trabajo");
		lblTrabajo.setBounds(35, 169, 46, 14);
		centro.add(lblTrabajo);

		textJob = new JTextField();
		textJob.setBounds(92, 172, 86, 20);
		centro.add(textJob);
		textJob.setColumns(10);

		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setBounds(319, 160, 46, 14);
		centro.add(lblCorreo);

		textEmail = new JTextField();
		textEmail.setBounds(375, 160, 86, 20);
		centro.add(textEmail);
		textEmail.setColumns(10);

		JLabel lblNacionalidad = new JLabel("Nacionalidad");
		lblNacionalidad.setBounds(302, 194, 74, 14);
		centro.add(lblNacionalidad);

		textNatiolaty = new JTextField();
		textNatiolaty.setBounds(375, 191, 86, 20);
		centro.add(textNatiolaty);
		textNatiolaty.setColumns(10);
		formatDelete = new JFormattedTextField();
		formatAge = new JFormattedTextField(createFormatter());
		formatWeight = new JFormattedTextField(doubleFormatter());
		formatHeigth = new JFormattedTextField(doubleFormatter());
		formatSerch = new JFormattedTextField(formatteInt());
		formatIdNumber = new JFormattedTextField(formatteInt());
		formatAge.setBounds(92, 90, 80, 20);
		textFields = new Vector<>();

		textFields.add(textName);
		textFields.add(textAddress);
		textFields.add(textDiagnostic);
		textFields.add(formatWeight);
		textFields.add(textEmail);
		textFields.add(textNatiolaty);
		textFields.add(textPhone);
		textFields.add(formatHeigth);
		textFields.add(textJob);
		textFields.add(formatAge);
		textFields.add(formatIdNumber);

		textName.getDocument().addDocumentListener(this);
		formatAge.getDocument().addDocumentListener(this);
		textNatiolaty.getDocument().addDocumentListener(this);
		textEmail.getDocument().addDocumentListener(this);
		textPhone.getDocument().addDocumentListener(this);
		textDiagnostic.getDocument().addDocumentListener(this);
		textAddress.getDocument().addDocumentListener(this);
		textJob.getDocument().addDocumentListener(this);
		formatHeigth.getDocument().addDocumentListener(this);
		formatWeight.getDocument().addDocumentListener(this);
		formatIdNumber.getDocument().addDocumentListener(this);
		centro.add(formatAge);

		formatWeight.setBounds(375, 59, 86, 20);
		centro.add(formatWeight);

		formatHeigth.setBounds(375, 115, 86, 20);
		centro.add(formatHeigth);

		formatSerch.setBounds(92, 214, 86, 20);
		centro.add(formatSerch);

		formatIdNumber.setBounds(183, 59, 70, 20);
		centro.add(formatIdNumber);

		JLabel lblNewLabel_5 = new JLabel("BUSCAR");
		lblNewLabel_5.setBounds(35, 217, 46, 14);
		centro.add(lblNewLabel_5);

		JLabel lblEliminar = new JLabel("ELIMINAR");
		lblEliminar.setBounds(234, 220, 53, 14);
		centro.add(lblEliminar);

		formatDelete.setBounds(312, 219, 86, 20);
		centro.add(formatDelete);

	}

	public Coordinator getCoordinator() {
		return coordinator;
	}

	public void setCoordinator(Coordinator coordinator) {
		this.coordinator = coordinator;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getGener() {
		return gener;
	}

	public void setGener(String gener) {
		this.gener = gener;
	}

	public boolean isCheckInput() {
		return checkInput;
	}

	public void setCheckInput(boolean checkInput) {
		this.checkInput = checkInput;
	}

	public Patient savePatient() {
		Patient patient = new Patient();
		patient.setAge(Integer.parseInt(formatAge.getText()));
		patient.setHeight(Double.parseDouble(formatHeigth.getText().replace(" ", "").replace(",", ".")));
		patient.setPhone(textPhone.getText());
		patient.setDiagnostic(textDiagnostic.getText());
		patient.setAddress(textAddress.getText());
		patient.setEmail(textEmail.getText());
		patient.setJob(textJob.getText());
		patient.setNationality(textNatiolaty.getText());
		patient.setDocument(spnDocument.getSelectedItem().toString());
		patient.setGender(getGener());
		patient.setName(textName.getText());
		patient.setWeight(Double.parseDouble(formatWeight.getText().replace(" ", "").replace(",", ".")));
		patient.setIdnumber(Integer.parseInt(formatIdNumber.getText()));

		return patient;
	}

	public void readUser(Patient patientIN) {// optiene objeto de la BD

		textName.setText(patientIN.getName());
		textAddress.setText(patientIN.getAddress());
		textPhone.setText(patientIN.getPhone());
		spnDocument.setSelectedItem(patientIN.getDocument());
		textDiagnostic.setText(patientIN.getDiagnostic());
		textJob.setText(patientIN.getJob());
		textEmail.setText(patientIN.getEmail());
		textNatiolaty.setText(patientIN.getNationality());
		formatAge.setText(String.valueOf(patientIN.getAge()));
		formatWeight.setText(String.valueOf(patientIN.getWeight()));
		formatHeigth.setText(String.valueOf(patientIN.getHeight()));
		System.out.println("" + patientIN.getIdPerson());
		setPatient(patientIN);// para guardar el ID
	}

	public Patient updatePatient() {
		Patient patient = new Patient();
		patient.setAge(Integer.parseInt(formatAge.getText()));
		patient.setHeight(Double.parseDouble(formatHeigth.getText().replace(" ", "").replace(",", ".")));
		patient.setPhone(textPhone.getText());
		patient.setDiagnostic(textDiagnostic.getText());
		patient.setAddress(textAddress.getText());
		patient.setEmail(textEmail.getText());
		patient.setJob(textJob.getText());
		patient.setNationality(textNatiolaty.getText());
		patient.setDocument(spnDocument.getSelectedItem().toString());
		patient.setGender(getGener());
		patient.setName(textName.getText());
		patient.setWeight(Double.parseDouble(formatWeight.getText().replace(" ", "").replace(",", ".")));
		patient.setIdnumber(Integer.parseInt(formatIdNumber.getText()));
		patient.setIdPerson(getPatient().getIdPerson());// leer el actual ID
		return patient;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdd && isCheckInput()) {
			Messags ansswer = coordinator.savePatient(savePatient());

		}
		if (e.getSource() == btnSerch) {
			Patient patient = new Patient();
			patient.setIdnumber(Integer.parseInt(formatSerch.getText()));// leer documento a busacr
			readUser(coordinator.serchPatient(patient));

		}

		if (e.getSource() == btnUpdate && isCheckInput()) {

			Messags ansswer = coordinator.updatePatient(updatePatient());
		}
		if (e.getSource() == btnDelete) {
			Messags ansswer = coordinator.deletePatient(getPatient());
		}

		if (e.getSource() == rdbtnHombre || e.getSource() == rdbtnMujer) {
			ButtonModel buttonModel = buttonGroup.getSelection();
			String t = "Not selected";
			if (buttonModel != null)
				t = buttonModel.getActionCommand();
			setGener(t);
		}

	}

	private void updateButtonEnabledStatus(List<JTextField> fields) {
		boolean enabled = true;
		for (JTextField field : fields) {
			if (field.getText().length() == 0) {
				enabled = false;
				break;
			}
		}
		btnAdd.setEnabled(enabled);
		setCheckInput(enabled);

	}

	protected NumberFormatter createFormatter() {
		NumberFormat intFormat = NumberFormat.getIntegerInstance();
		intFormat.setGroupingUsed(false);
		NumberFormatter numberFormatter = new NumberFormatter(intFormat);
		numberFormatter.setValueClass(Integer.class);
		numberFormatter.setAllowsInvalid(false);
		numberFormatter.setMinimum(1);
		numberFormatter.setMaximum(1000);
		return numberFormatter;
	}

	protected NumberFormatter formatteInt() {
		NumberFormat intFormat = DecimalFormat.getInstance();
		intFormat.setGroupingUsed(false);
		NumberFormatter numberFormatter = new NumberFormatter(intFormat);
		numberFormatter.setValueClass(Integer.class);
		numberFormatter.setAllowsInvalid(false);
		numberFormatter.setMinimum(1);
		numberFormatter.setMaximum(1000000000);
		return numberFormatter;
	}

	protected MaskFormatter createFormatter(String s) {
		MaskFormatter formatter = null;
		try {
			formatter = new MaskFormatter(s);
		} catch (java.text.ParseException exc) {
			System.err.println("formatter is bad: " + exc.getMessage());
			System.exit(-1);
		}
		return formatter;
	}

	protected InternationalFormatter doubleFormatter() {
		NumberFormat format = DecimalFormat.getInstance();
		format.setMinimumFractionDigits(1);
		format.setMaximumFractionDigits(2);
		// format.setRoundingMode(RoundingMode.HALF_UP);
		InternationalFormatter formatter = new InternationalFormatter(format);
		formatter.setAllowsInvalid(false);
		formatter.setMinimum(0.0);
		formatter.setMaximum(100.00);
		return formatter;

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		updateButtonEnabledStatus(textFields);

	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		updateButtonEnabledStatus(textFields);

	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		updateButtonEnabledStatus(textFields);

	}
}
