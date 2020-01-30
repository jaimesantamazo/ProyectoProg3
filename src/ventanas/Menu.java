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

public class Menu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
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
	public Menu() {
		super();
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 512, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Comprar entradas");
		btnNewButton.setActionCommand("Open60");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
								String cmd = e.getActionCommand();

						        if(cmd.equals("Open60"))
						        {
						            frame.dispose();
						            new Pagoentrada();
						        }
					}
				});
		btnNewButton.setBounds(41, 108, 159, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Salir del usuario");
		btnNewButton_2.setActionCommand("Open50");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						String cmd = e.getActionCommand();

				        if(cmd.equals("Open50"))
				        {
				            frame.dispose();
				            Login.log.log(Level.FINER,"Usuario desconectado");
				            new Login();
				        }
			}
		});
		
		btnNewButton_2.setBounds(41, 360, 159, 29);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblMenuPrincipal = new JLabel("MENU PRINCIPAL");
		lblMenuPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMenuPrincipal.setBounds(177, 30, 215, 29);
		frame.getContentPane().add(lblMenuPrincipal);
		
		JButton btnadministrador = new JButton("Administrador");
		btnadministrador.setBounds(280, 108, 173, 29);
		frame.getContentPane().add(btnadministrador);
		btnadministrador.setActionCommand("Open50");
		
		JButton btnComprarCamping = new JButton("Comprar camping");
		btnComprarCamping.setBounds(41, 174, 159, 29);
		frame.getContentPane().add(btnComprarCamping);
		btnComprarCamping.setActionCommand("Open120");
		btnComprarCamping.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String cmd = e.getActionCommand();

				    if(cmd.equals("Open120"))
				        {
				            frame.dispose();
				            new Pagocamping();
				        }
			}   
				        });
		
		JLabel lblClientes = new JLabel("Clientes:");
		lblClientes.setBounds(41, 75, 69, 20);
		frame.getContentPane().add(lblClientes);
		
		JLabel lblAdministrador = new JLabel("Administrador:");
		lblAdministrador.setBounds(307, 72, 112, 20);
		frame.getContentPane().add(lblAdministrador);
		
		JButton btnTusEntradas = new JButton("Tus entradas");
		btnTusEntradas.setActionCommand("Open250");
		btnTusEntradas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();

		        if(cmd.equals("Open250"))
		        {
		            frame.dispose();
		            new VerEntradas();
		        }
			}
		});
		btnTusEntradas.setBounds(41, 298, 159, 29);
		frame.getContentPane().add(btnTusEntradas);
		
		JButton btnComprarEntradacamping = new JButton("Comprar entrada+camping");
		btnComprarEntradacamping.setActionCommand("Open270");
		btnComprarEntradacamping.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();

		        if(cmd.equals("Open270"))
		        {
		            frame.dispose();
		            new Pagoentradaycamping();
		        
			}
			}});
		btnComprarEntradacamping.setBounds(41, 236, 192, 29);
		frame.getContentPane().add(btnComprarEntradacamping);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnEntrada = new JMenu("Entrada");
		menuBar.add(mnEntrada);
		
		JMenuItem mntmComprar = new JMenuItem("Comprar");
		mntmComprar.setActionCommand("Open140");
		mntmComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();

			    if(cmd.equals("Open140"))
			        {
			            frame.dispose();
			            new Pagoentrada();
			        }
		} 
			}
		);
		mnEntrada.add(mntmComprar);
		
		JMenu mnCamping = new JMenu("Camping");
		menuBar.add(mnCamping);
		
		JMenuItem mntmComprar_1 = new JMenuItem("Comprar");
		mntmComprar_1.setActionCommand("Open150");
		mntmComprar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();

			    if(cmd.equals("Open150"))
			        {
			            frame.dispose();
			            new Pagocamping();
			        }
		} 
			}
		);
		mnCamping.add(mntmComprar_1);
		
		JMenu mnEntradacamping = new JMenu("Entrada+camping");
		menuBar.add(mnEntradacamping);
		
		JMenuItem mntmComprar_2 = new JMenuItem("Comprar");
		mntmComprar_2.setActionCommand("Open160");
		mntmComprar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();

			    if(cmd.equals("Open160"))
			        {
			            frame.dispose();
			            new Pagoentradaycamping();
			        }
		} 
			}
		);
		mnEntradacamping.add(mntmComprar_2);
		
		JMenu mnTusEntradas = new JMenu("Tus entradas");
		menuBar.add(mnTusEntradas);
		
		JMenuItem mntmVerEntradas = new JMenuItem("Ver entradas");
		mntmVerEntradas.setActionCommand("Open250");
		mntmVerEntradas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();

		        if(cmd.equals("Open250"))
		        {
		            frame.dispose();
		            new VerEntradas();
		        }
			}
		});
		mnTusEntradas.add(mntmVerEntradas);
		
		JMenu mnAdministrador = new JMenu("Administrador");
		menuBar.add(mnAdministrador);
		
		JMenuItem mntmGestionGeneral = new JMenuItem("Gestion general");
		mntmGestionGeneral.setActionCommand("Open301");
		mntmGestionGeneral.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cmd = arg0.getActionCommand();

			    if(cmd.equals("Open301"))
			        {
			            frame.dispose();
			            new LoginAdmin();
			        }
			}
		});
		mnAdministrador.add(mntmGestionGeneral);
		btnadministrador.setActionCommand("Open300");
		btnadministrador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String cmd = e.getActionCommand();

				    if(cmd.equals("Open300"))
				        {
				            frame.dispose();
				            new LoginAdmin();
				        }
					}
				});
	}
}
