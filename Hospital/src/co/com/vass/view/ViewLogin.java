package co.com.vass.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import co.com.vass.controller.Coordinator;
import co.com.vass.dao.UserDAO;
import co.com.vass.modelo.Logic.Messags;
import co.com.vass.vo.User;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;

public class ViewLogin extends JDialog implements ActionListener,KeyListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JPasswordField passwordField;
	private Coordinator coordinator;
	JButton btnIngresar;

	public ViewLogin() {
	
		setTitle("Ventana Login");
		setBounds(100, 100, 504, 337);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JPanel panelLogin = new JPanel();
		panelLogin.setBounds(171, 118, 10, 10);
		getContentPane().add(panelLogin);

		JLabel lblNewLabel = new JLabel("INGRESO");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel.setBounds(174, 38, 105, 22);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(ViewLogin.class.getResource("/co/com/vass/resources/candado.jpg")));
		lblNewLabel_1.setBounds(202, 71, 62, 68);
		getContentPane().add(lblNewLabel_1);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(77, 175, 73, 14);
		getContentPane().add(lblUsuario);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(77, 216, 62, 14);
		getContentPane().add(lblContrasea);

		textField = new JTextField();
		textField.setBounds(148, 172, 191, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		textField.addKeyListener(this);
		passwordField = new JPasswordField();
		passwordField.setBounds(149, 213, 190, 20);
		passwordField.addKeyListener(this);
		getContentPane().add(passwordField);

		btnIngresar = new JButton("Ingresar");
		
		btnIngresar.addKeyListener(this);
			
		btnIngresar.setBounds(190, 244, 89, 23);
		btnIngresar.addActionListener(this);
		getContentPane().add(btnIngresar);

	}

	public void setControlador(Coordinator coordinator) {
		this.coordinator = coordinator;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		
		if (e.getSource() == btnIngresar) {
			loginUser();
		}

	}

	public void loginUser() {
		User usuario = new User();
		Messags answer;		
		usuario.setName(textField.getText());
		usuario.setPassword(new String(passwordField.getPassword()));
		answer = coordinator.validateLogin(usuario);
		ShowDialog(answer);
	}

	public void ShowDialog(Messags message) {

		switch (message) {
		case CAMPOS  :
			JOptionPane.showMessageDialog(null, Messags.CAMPOS, "ERROR" ,JOptionPane.ERROR_MESSAGE);
			break;

		case CONEXION:
			JOptionPane.showMessageDialog(null, Messags.CONEXION, "LOST CONEXION" ,JOptionPane.ERROR_MESSAGE);
			break;
			
		case BD_USSER:
			JOptionPane.showMessageDialog(null, Messags.BD_USSER, "USER" ,JOptionPane.WARNING_MESSAGE);
			break;
			
		case OK_USER:
//			JFrame f = new JFrame();
//			JOptionPane.showMessageDialog(f, Messags.OK_USER);
			break;
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		 if (e.getKeyCode()==KeyEvent.VK_ENTER){
			 loginUser();
			 
		 }
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
