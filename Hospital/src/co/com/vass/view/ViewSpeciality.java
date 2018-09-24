package co.com.vass.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.com.vass.controller.Coordinator;
import co.com.vass.modelo.Logic.Messags;
import co.com.vass.vo.Patient;
import co.com.vass.vo.Speciality;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewSpeciality extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textEspeciality;
	private JTextField textCode;

	private JButton btnAdd;
	private JButton btnDelete;
	private JButton btnUpdate;
	private Coordinator coordinator;

	public Coordinator getCoordinator() {
		return coordinator;
	}

	public void setCoordinator(Coordinator coordinator) {
		this.coordinator = coordinator;
	}

	public ViewSpeciality() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 465, 259);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Especialidad Medico", null, panel, null);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.SOUTH);

		btnAdd = new JButton("Agregar");
		btnAdd.setIcon(new ImageIcon(ViewSpeciality.class.getResource("/co/com/vass/resources/add.png")));

		panel_1.add(btnAdd);
		btnAdd.addActionListener(this);
		btnDelete = new JButton("Eliminar");
		btnDelete.setIcon(new ImageIcon(ViewSpeciality.class.getResource("/co/com/vass/resources/delete.png")));
		btnDelete.addActionListener(this);
		// btnDelete.addActionListener(new ActionListener() {
		// public void actionPerformed(ActionEvent e) {
		// }
		// });
		panel_1.add(btnDelete);

		btnUpdate = new JButton("Actualizar");
		btnUpdate.setIcon(new ImageIcon(ViewSpeciality.class.getResource("/co/com/vass/resources/save.png")));
		btnUpdate.addActionListener(this);
		panel_1.add(btnUpdate);

		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(31, 42, 37, 14);
		panel_2.add(lblNewLabel);

		textEspeciality = new JTextField();
		textEspeciality.setBounds(78, 39, 86, 20);
		panel_2.add(textEspeciality);
		textEspeciality.setColumns(10);

		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(176, 42, 33, 14);
		panel_2.add(lblCodigo);

		textCode = new JTextField();
		textCode.setBounds(219, 39, 86, 20);
		panel_2.add(textCode);
		textCode.setColumns(10);

		JLabel lblEspecialidad = new JLabel("ESPECIALIDAD");
		lblEspecialidad.setBounds(137, 11, 72, 14);
		panel_2.add(lblEspecialidad);

		JPanel panelEspaciality = new JPanel();
		tabbedPane.addTab("Lista de especialidades", null, panelEspaciality, null);
		panelEspaciality.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panelEspaciality.add(scrollPane, BorderLayout.CENTER);
	}

	public Speciality save() {
		Speciality speciality = new Speciality();
		speciality.setName(textEspeciality.getText());
		speciality.setCode(textCode.getText());

		return speciality;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdd) {
			
			
			Messags ansswer = coordinator.saveSpeciality(save());

		}
		if (e.getSource() == btnDelete) {
			Speciality speciality = new Speciality();
//			patient.setIdnumber(Integer.parseInt(formatSerch.getText()));// leer documento a busacr
			// readUser(coordinator.serchPatient(patient));

		}

		if (e.getSource() == btnUpdate) {

			// Messags ansswer = coordinator.updatePatient(updatePatient());
		}

	}

}
