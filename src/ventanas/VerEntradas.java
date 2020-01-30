package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;

import ficherosproperties.properties;
import ficherosproperties.propertiescamping;
import ficherosproperties.propertiesentradaycamping;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.JEditorPane;
import java.awt.Font;
import javax.swing.JScrollBar;

public class VerEntradas {

	private JFrame frame;
	private JFileChooser seleccion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerEntradas window = new VerEntradas();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VerEntradas() {
		super();
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 497, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnVisualizar = new JMenu("Visualizar");
		menuBar.add(mnVisualizar);
		
		JMenuItem mntmVerEntradasUnicas = new JMenuItem("Ver entradas unicas");
		mntmVerEntradasUnicas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				properties properties = new properties();
				try {
					properties.sleep(1000);
					properties.start();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				
			}
			}
		});
		mnVisualizar.add(mntmVerEntradasUnicas);
		
		JMenuItem mntmVerCampings = new JMenuItem("Ver campings");
		mntmVerCampings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				propertiescamping propertiescamping = new propertiescamping();
				try {
					propertiescamping.sleep(1000);
					propertiescamping.start();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			}
		);
		mnVisualizar.add(mntmVerCampings);
		
		JMenuItem mntmVerEntradaConjunta = new JMenuItem("Ver entrada conjunta");
		mntmVerEntradaConjunta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				propertiesentradaycamping propertiescampingyentradas = new propertiesentradaycamping();
				try {
					propertiescampingyentradas.sleep(1000);
					propertiescampingyentradas.start();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		});
		mnVisualizar.add(mntmVerEntradaConjunta);
		frame.getContentPane().setLayout(null);
		
		JButton btnVerEntradaUnica = new JButton("Ver entrada unica");
		btnVerEntradaUnica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				properties properties = new properties();
				try {
					properties.sleep(1000);
					properties.start();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				
			}
			}});
		btnVerEntradaUnica.setBounds(281, 119, 183, 29);
		frame.getContentPane().add(btnVerEntradaUnica);
		
		JButton btnVerCamping = new JButton("Ver camping");
		btnVerCamping.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				propertiescamping propertiescamping = new propertiescamping();
				try {
					propertiescamping.sleep(1000);
					propertiescamping.start();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnVerCamping.setBounds(281, 191, 183, 29);
		frame.getContentPane().add(btnVerCamping);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(188, 38, 168, 92);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 38, 251, 271);
		frame.getContentPane().add(scrollPane);
		scrollPane.setViewportView(editorPane);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollPane.setRowHeaderView(scrollBar);
		
		JButton btnVerEntradaConjunta = new JButton("Ver entrada conjunta");
		btnVerEntradaConjunta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				propertiesentradaycamping propertiescampingyentradas = new propertiesentradaycamping();
				try {
					propertiescampingyentradas.sleep(1000);
					propertiescampingyentradas.start();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnVerEntradaConjunta.setBounds(281, 264, 183, 29);
		frame.getContentPane().add(btnVerEntradaConjunta);
		
		JButton btnVisualizarTuEntrada = new JButton("Visualizar tu entrada en la lista");
		btnVisualizarTuEntrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccion = new JFileChooser("C:\\Users\\jaime\\eclipse-workspace\\proyecto program 3\\Tickets");
				seleccion.setFileFilter(new FileNameExtensionFilter("Archivo de Texto", "txt"));
				int opcion = seleccion.showOpenDialog(null);
				if (opcion == JFileChooser.APPROVE_OPTION) {
				    String ruta = seleccion.getSelectedFile().getAbsolutePath();
				}
				File seleccion_ruta = seleccion.getSelectedFile();
				String cadena;
				try {
					BufferedReader bf = new BufferedReader(new FileReader(seleccion_ruta));
					while ((cadena = bf.readLine())!=null) {
						   editorPane.setText(cadena);
						}
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch(NullPointerException e2) {
					e2.printStackTrace();
				}
			}
		});
		btnVisualizarTuEntrada.setBounds(15, 325, 251, 29);
		frame.getContentPane().add(btnVisualizarTuEntrada);
		
		JLabel lblAquiPuederVer = new JLabel("Aqui pueder ver tus");
		lblAquiPuederVer.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAquiPuederVer.setBounds(281, 27, 198, 20);
		frame.getContentPane().add(lblAquiPuederVer);
		
		JLabel lblEntradas = new JLabel("entradas");
		lblEntradas.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEntradas.setBounds(330, 63, 90, 20);
		frame.getContentPane().add(lblEntradas);
		
		JButton btnVolverAlMenu = new JButton("Volver al menu");
		btnVolverAlMenu.setActionCommand("Open140");
		btnVolverAlMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();

			    if(cmd.equals("Open140"))
			        {
			            frame.dispose();
			            new Menu();
			        }
		} 
			
		});
		btnVolverAlMenu.setBounds(325, 338, 139, 29);
		frame.getContentPane().add(btnVolverAlMenu);
		
	}
}
