package co.com.vass.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ViewSelecSpeciality extends JFrame {

	private JList lista;
	private JList listaCopia;
	private static final String[] cores = { "Azul", "Verde", "Amarelo" };
	
	private JButton copiar;
	DefaultListModel model;

	public ViewSelecSpeciality() {
		super("Utilizando JList");
		copiar = new JButton(" SELECCIONAR >>>> ");

		lista = new JList(cores);
		setLayout(new FlowLayout());
		lista.setVisibleRowCount(3); 
		lista.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); 

		add(lista);
		add(copiar);

		listaCopia = new JList<String>();
		listaCopia.setVisibleRowCount(3);
		listaCopia.setFixedCellWidth(100);
		listaCopia.setFixedCellHeight(15);
		add(new JScrollPane(listaCopia));

		model = new DefaultListModel();
		listaCopia.setModel(model);

		copiar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			
				model.addElement(lista.getSelectedValue());
			}
		});
		

	}
}