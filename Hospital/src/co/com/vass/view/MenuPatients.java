package co.com.vass.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;

public class MenuPatients extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	
	public MenuPatients() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		JButton btnNuevo = new JButton("REGISTRAR");
		btnNuevo.setIcon(new ImageIcon(MenuPatients.class.getResource("/co/com/vass/resources/add.png")));
		botones.add(btnNuevo);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setIcon(new ImageIcon(MenuPatients.class.getResource("/co/com/vass/resources/search.png")));
		botones.add(btnBuscar);
		
		JButton btnActulizar = new JButton("ACTULIZAR");
		btnActulizar.setIcon(new ImageIcon(MenuPatients.class.getResource("/co/com/vass/resources/save.png")));
		botones.add(btnActulizar);
		
		JButton btnEliminar = new JButton(" ELIMINAR");
		btnEliminar.setIcon(new ImageIcon(MenuPatients.class.getResource("/co/com/vass/resources/delete.png")));
		botones.add(btnEliminar);
		
		JPanel centro = new JPanel();
		panel.add(centro, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(35, 31, 46, 14);
		
		textField = new JTextField();
		textField.setBounds(126, 28, 86, 20);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("documento");
		lblNewLabel_1.setBounds(35, 62, 53, 14);
		
		textField_1 = new JTextField();
		textField_1.setBounds(126, 59, 86, 20);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Direccion");
		lblNewLabel_2.setBounds(35, 118, 46, 14);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(35, 144, 46, 14);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(35, 88, 46, 14);
		
		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setBounds(246, 31, 46, 14);
		
		textField_2 = new JTextField();
		textField_2.setBounds(126, 85, 86, 20);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(126, 115, 86, 20);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(126, 141, 86, 20);
		textField_4.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(296, 28, 28, 20);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(92, 59, 28, 20);
		
		textField_5 = new JTextField();
		textField_5.setBounds(330, 28, 86, 20);
		textField_5.setColumns(10);
		centro.setLayout(null);
		centro.add(textField_3);
		centro.add(textField_4);
		centro.add(comboBox);
		centro.add(comboBox_1);
		centro.add(textField_5);
		centro.add(lblNewLabel);
		centro.add(textField);
		centro.add(lblTelefono);
		centro.add(lblGenero);
		centro.add(lblNewLabel_1);
		centro.add(textField_1);
		centro.add(lblNewLabel_2);
		centro.add(lblEdad);
		centro.add(textField_2);
	}
}
