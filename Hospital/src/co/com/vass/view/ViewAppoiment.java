package co.com.vass.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ViewAppoiment extends JFrame {

	private JPanel contentPane;
	private JTextField textpatient;
	private JTextField textespecility;
	private JTextField textdoctor;
	private JTextField texttime;
	private JTextField textDocument;
	private JTable table;


	
	public ViewAppoiment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 527, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelbutons = new JPanel();
		contentPane.add(panelbutons, BorderLayout.SOUTH);
		
		JButton btnNewButton_3 = new JButton("registrar");
		panelbutons.add(btnNewButton_3);
		
		JButton btnEliminar = new JButton(" eliminar");
		panelbutons.add(btnEliminar);
		
		JButton btnActulizar = new JButton("actulizar");
		panelbutons.add(btnActulizar);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JPanel inputs = new JPanel();
		contentPane.add(inputs, BorderLayout.CENTER);
		inputs.setLayout(null);
		
		JLabel lblNombrePaciente = new JLabel("documento paciente");
		lblNombrePaciente.setBounds(10, 32, 109, 14);
		inputs.add(lblNombrePaciente);
		
		textpatient = new JTextField();
		textpatient.setBounds(119, 29, 86, 20);
		inputs.add(textpatient);
		textpatient.setColumns(10);
		
		JLabel lblEspecialidad = new JLabel("Especialidad");
		lblEspecialidad.setBounds(253, 38, 64, 14);
		inputs.add(lblEspecialidad);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(ViewAppoiment.class.getResource("/co/com/vass/resources/searchp.png")));
		btnNewButton.setBounds(209, 29, 24, 23);
		inputs.add(btnNewButton);
		
		JButton btnSpeciality = new JButton("");
		btnSpeciality.setIcon(new ImageIcon(ViewAppoiment.class.getResource("/co/com/vass/resources/searchp.png")));
		btnSpeciality.setBounds(419, 32, 24, 20);
		inputs.add(btnSpeciality);
		
		textespecility = new JTextField();
		textespecility.setBounds(329, 35, 86, 20);
		inputs.add(textespecility);
		textespecility.setColumns(10);
		
		JLabel lblMedico = new JLabel("Medico");
		lblMedico.setBounds(253, 63, 46, 14);
		inputs.add(lblMedico);
		
		textdoctor = new JTextField();
		textdoctor.setBounds(329, 60, 86, 20);
		inputs.add(textdoctor);
		textdoctor.setColumns(10);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(119, 88, 109, 20);
		inputs.add(dateChooser);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(66, 98, 46, 14);
		inputs.add(lblFecha);
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setBounds(253, 98, 46, 14);
		inputs.add(lblHora);
		
		texttime = new JTextField();
		texttime.setBounds(329, 91, 86, 20);
		inputs.add(texttime);
		texttime.setColumns(10);
		
		JLabel lblNombrePaciente_1 = new JLabel("Nombre paciente");
		lblNombrePaciente_1.setBounds(20, 63, 92, 14);
		inputs.add(lblNombrePaciente_1);
		
		textDocument = new JTextField();
		textDocument.setBounds(119, 60, 86, 20);
		inputs.add(textDocument);
		textDocument.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 142, 481, 200);
		inputs.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"codigo ", "nombre", "nombre medico"
			}
		));
		scrollPane.setViewportView(table);
	}
}
