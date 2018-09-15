package co.com.vass.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import co.com.vass.controller.Coordinator;
import co.com.vass.modelo.Logic.Messags;
import co.com.vass.vo.Patient;
import javassist.compiler.Parser;

import com.jgoodies.forms.layout.FormSpecs;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.awt.event.KeyAdapter;

public class MenuPatients extends JFrame implements ActionListener, KeyListener, DocumentListener {

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textAddress;
	private JTextField textPhone;
	private JComboBox spnDocument;
	private JTextField textWeight;
	private JTextField textDiagnostic;
	private JTextField textHeight;
	private JTextField textJob;
	private JTextField textEmail;
	private JTextField textNatiolaty;
	private JRadioButton rdbtnMujer;
	private JRadioButton rdbtnHombre;
	Patient patient;
	ButtonGroup buttonGroup;
	private Coordinator coordinator;
	JButton btnAdd;
	JFormattedTextField formatAge;

	public MenuPatients() {

//		javax.swing.JDialog  parent, boolean modal
//		super();

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
		btnAdd.setIcon(new ImageIcon(MenuPatients.class.getResource("/co/com/vass/resources/add.png")));
		btnAdd.addActionListener(this);
		btnAdd.setEnabled(false);
		botones.add(btnAdd);

		JButton btnSerch = new JButton("BUSCAR");
		btnSerch.setIcon(new ImageIcon(MenuPatients.class.getResource("/co/com/vass/resources/search.png")));
		botones.add(btnSerch);

		JButton btnUpdate = new JButton("ACTULIZAR");
		btnUpdate.setIcon(new ImageIcon(MenuPatients.class.getResource("/co/com/vass/resources/save.png")));
		botones.add(btnUpdate);

		JButton btnDelete = new JButton(" ELIMINAR");
		btnDelete.setIcon(new ImageIcon(MenuPatients.class.getResource("/co/com/vass/resources/delete.png")));
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

		String genero[] = { "hombre", "mujer" };
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

		textWeight = new JTextField();
		textWeight.setBounds(375, 59, 86, 20);
		centro.add(textWeight);
		textWeight.setColumns(10);
		buttonGroup = new ButtonGroup();
		rdbtnHombre = new JRadioButton("Hombre");
		rdbtnHombre.setBounds(355, 27, 63, 23);
		rdbtnHombre.setActionCommand("HOMBRE");
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

		textHeight = new JTextField();

		textHeight.setBounds(375, 110, 86, 20);
		centro.add(textHeight);
		textHeight.setColumns(10);

		NumberFormat format = NumberFormat.getIntegerInstance();
		format.setGroupingUsed(false);

		// textHeight = new JFormattedTextField(format);

		textHeight.addKeyListener(this);

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
		formatAge = new JFormattedTextField(createFormatter("###"));
		formatAge.setBounds(92, 90, 80, 20);
		centro.add(formatAge);
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

	public void inputData() {
		patient.setName(textName.getText());
		patient.setAge(Integer.parseInt(formatAge.getText()));
		patient.setPhone(textPhone.getText());
		patient.setDiagnostic(textDiagnostic.getText());
		patient.setAddress(textAddress.getText());
		patient.setEmail(textEmail.getText());
		patient.setHeight(Double.parseDouble(textHeight.getText()));
		patient.setJob(textJob.getText());
		patient.setNationality(textNatiolaty.getText());
		patient.setDocument(spnDocument.getSelectedItem().toString());

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == rdbtnHombre || e.getSource() == rdbtnMujer) {
			ButtonModel buttonModel = buttonGroup.getSelection();
			String t = "Not selected";
			if (buttonModel != null)
				t = buttonModel.getActionCommand();

			patient.setGender(t);
			System.out.println(t);
		}

		if (e.getSource() == btnAdd) {
			inputData();
			Messags ansswer = coordinator.validatePatient(patient);

		}

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
		// TODO Auto-generated method stub

	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub

	}
}
