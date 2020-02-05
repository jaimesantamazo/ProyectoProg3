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
import java.util.logging.Level;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.JEditorPane;
import java.awt.Font;
import javax.swing.JScrollBar;

public class VerEntradasAdmin {

	private JFrame frame;
	private JFileChooser seleccion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerEntradasAdmin window = new VerEntradasAdmin();
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
	public VerEntradasAdmin() {
		super();
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 560, 466);
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
					Login.log.log(Level.FINER,"Error interrupt en hilo properties");
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
					Login.log.log(Level.FINER,"Error interrupt en hilo properties");
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
					Login.log.log(Level.FINER,"Error interrupt en hilo properties");
				}
			}
		});
		mnVisualizar.add(mntmVerEntradaConjunta);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 110, 504, 199);
		frame.getContentPane().add(scrollPane);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollPane.setRowHeaderView(scrollBar);
		
		JEditorPane editorPane = new JEditorPane();
		scrollPane.setViewportView(editorPane);
		
		JButton btnVisualizarTuEntrada = new JButton("Visualizar el total de entradas vendidas");
		btnVisualizarTuEntrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccion = new JFileChooser("C:\\Users\\jaime\\eclipse-workspace\\proyecto program 3\\TicketsAdmin");
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
					Login.log.log(Level.FINER,"Error al abrir jfilechooser");
				} catch (IOException e1) {
					Login.log.log(Level.FINER,"Error al abrir jfilechooser");
				} catch(NullPointerException e2) {
					Login.log.log(Level.FINER,"Error al abrir jfilechooser");
				}
			}
		});
		btnVisualizarTuEntrada.setBounds(15, 334, 307, 29);
		frame.getContentPane().add(btnVisualizarTuEntrada);
		
		JButton btnVolverAlMenu = new JButton("Volver al menu");
		btnVolverAlMenu.setActionCommand("Open140");
		btnVolverAlMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();

			    if(cmd.equals("Open140"))
			        {
			            frame.dispose();
			            new MenuAdmin();
			        }
		} 
			
		});
		btnVolverAlMenu.setBounds(380, 334, 139, 29);
		frame.getContentPane().add(btnVolverAlMenu);
		
		JLabel lblAquiElAdministrador = new JLabel("Aqui el administrador puede ver los tickets vendidos de todos los festivales");
		lblAquiElAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAquiElAdministrador.setBounds(15, 74, 504, 20);
		frame.getContentPane().add(lblAquiElAdministrador);
		
		JLabel lblTotalDe = new JLabel("Total de entradas vendidas\r\n");
		lblTotalDe.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTotalDe.setBounds(144, 31, 266, 20);
		frame.getContentPane().add(lblTotalDe);
		
	}
}
