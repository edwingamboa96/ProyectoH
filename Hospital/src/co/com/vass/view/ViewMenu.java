package co.com.vass.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JToolBar;
import java.awt.FlowLayout;
import javax.swing.JMenu;

public class ViewMenu extends JFrame {
	private Dimension tamPantalla;
	private Rectangle pantalla;
	
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
		
		JMenu mnNewMenu = new JMenu("Pacientes");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Medicos");
		menuBar.add(mnNewMenu_1);
		
		JMenu mnCuartos = new JMenu("Cuartos");
		menuBar.add(mnCuartos);
		
		JMenu mnHistoriaClinica = new JMenu("Historia clinica");
		menuBar.add(mnHistoriaClinica);
		
		JPanel panel = new JPanel();
		menuBar.add(panel);
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ViewMenu.class.getResource("/co/com/vass/resources/mano.png")));
		panel.add(lblNewLabel);
		
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

}
