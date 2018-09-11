package co.com.vass.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JToolBar;
import java.awt.FlowLayout;
import javax.swing.JMenu;
import javax.swing.JSeparator;

public class ViewMenu extends JFrame implements ActionListener,MenuListener {
	private Dimension tamPantalla;
	private Rectangle pantalla;
	JMenu menuPatients;
	public ViewMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setTitle("GESTION DE HOSPITAL");
		tamPantalla = Toolkit.getDefaultToolkit().getScreenSize();
		pantalla = new Rectangle(tamPantalla);
		setBounds(pantalla);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel Inferior = new JPanel();
		getContentPane().add(Inferior, BorderLayout.SOUTH);
		Inferior.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel superior = new JPanel();
		getContentPane().add(superior, BorderLayout.NORTH);
		superior.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JMenuBar menuBar = new JMenuBar();
		superior.add(menuBar);
		
	    menuPatients = new JMenu("Pacientes");
	    menuPatients.setIcon(new ImageIcon(ViewMenu.class.getResource("/co/com/vass/resources/patients.png")));
		menuBar.add(menuPatients);
		menuPatients.addMenuListener(this);
		
		JSeparator separator = new JSeparator();
		menuBar.add(separator);
		JMenu mnNewMenu_1 = new JMenu("Medicos");
		mnNewMenu_1.setIcon(new ImageIcon(ViewMenu.class.getResource("/co/com/vass/resources/doctor.png")));
		menuBar.add(mnNewMenu_1);
		
		JMenu mnCuartos = new JMenu("Cuartos");
		mnCuartos.setIcon(new ImageIcon(ViewMenu.class.getResource("/co/com/vass/resources/bedroom.png")));
		menuBar.add(mnCuartos);
		
		JMenu mnHistoriaClinica = new JMenu("Historia clinica");
		mnHistoriaClinica.setIcon(new ImageIcon(ViewMenu.class.getResource("/co/com/vass/resources/historia.png")));
		menuBar.add(mnHistoriaClinica);
		
		JPanel central = new JPanel();
		getContentPane().add(central, BorderLayout.CENTER);
		central.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\edwin.gamboa\\Desktop\\fondo.png"));
		central.add(lblNewLabel_1);
		start_components();
	}
	
	public void start_components() {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

	@Override
	public void menuCanceled(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuDeselected(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuSelected(MenuEvent e) {
		if (e.getSource() == menuPatients) {
			MenuPatients men=new MenuPatients();
			men.setVisible(true);
		
		}
	}

}
