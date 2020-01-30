package ventanas;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import ficherosproperties.properties;
import ficherosproperties.propertiescamping;
import ficherosproperties.propertiesentradaycamping;

import javax.swing.JMenuBar;

public class MenuAdmin {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuAdmin window = new MenuAdmin();
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
	public MenuAdmin() {
		super();
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 356, 526);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton_2 = new JButton("Salir ");
		btnNewButton_2.setActionCommand("Open50");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						String cmd = e.getActionCommand();

				        if(cmd.equals("Open50"))
				        {
				            frame.dispose();
				            Login.log.log(Level.FINER,"Usuario desconectado");
				            new Menu();
				        }
			}
		});
		
		btnNewButton_2.setBounds(84, 348, 173, 29);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblMenuPrincipal = new JLabel("MENU ADMINISTRADOR\r\n");
		lblMenuPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMenuPrincipal.setBounds(65, 30, 227, 29);
		frame.getContentPane().add(lblMenuPrincipal);
		
		JButton btnGestion = new JButton("Gestion de eventos");
		btnGestion.setBounds(84, 124, 173, 29);
		frame.getContentPane().add(btnGestion);
		btnGestion.setActionCommand("Open40");
		btnGestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String cmd = e.getActionCommand();

				    if(cmd.equals("Open40"))
				        {
				            frame.dispose();
				            new Gestion();
				            
				        }
					}
			
				});
		
		JButton btnGestionCamping = new JButton("Gestion camping");
		btnGestionCamping.setBounds(84, 197, 173, 29);
		frame.getContentPane().add(btnGestionCamping);
		btnGestionCamping.setActionCommand("Open50");
		
		JLabel lblAdministrador = new JLabel("Administrador:");
		lblAdministrador.setBounds(84, 88, 112, 20);
		frame.getContentPane().add(lblAdministrador);
		
		JButton btnTotalEntradas = new JButton("Total entradas");
		btnTotalEntradas.setActionCommand("Open250");
		btnTotalEntradas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();

		        if(cmd.equals("Open250"))
		        {
		            frame.dispose();
		            new VerEntradasAdmin();
		        
			}
			}
		});
		btnTotalEntradas.setBounds(84, 275, 173, 29);
		frame.getContentPane().add(btnTotalEntradas);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnAdministrador = new JMenu("Administrador");
		menuBar.add(mnAdministrador);
		
		JMenuItem mntmGestionConcietos = new JMenuItem("Gestion concietos");
		mntmGestionConcietos.setActionCommand("Open220");
		mntmGestionConcietos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();

			    if(cmd.equals("Open220"))
			        {
			            frame.dispose();
			            new Gestion();
			        }
		} 
			}
		);
		mnAdministrador.add(mntmGestionConcietos);
		
		JMenuItem mntmGestionCampings = new JMenuItem("Gestion campings");
		mntmGestionCampings.setActionCommand("Open230");
		mntmGestionCampings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();

			    if(cmd.equals("Open230"))
			        {
			            frame.dispose();
			            new Gestioncamping();
			        }
		}
			}
		);
		mnAdministrador.add(mntmGestionCampings);
		
		JMenuItem mntmTotalEntradas = new JMenuItem("Total entradas");
		mntmTotalEntradas.setActionCommand("Open280");
		mntmTotalEntradas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();

		        if(cmd.equals("Open280"))
		        {
		            frame.dispose();
		            new VerEntradasAdmin();
		        
			}
			}
		});
		mnAdministrador.add(mntmTotalEntradas);
		btnGestionCamping.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String cmd = e.getActionCommand();

				    if(cmd.equals("Open50"))
				        {
				            frame.dispose();
				            new Gestioncamping();
				        }
					}
				});
	}
}
