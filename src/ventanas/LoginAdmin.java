package ventanas;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import clasesbasicas.Administrador;
import gestionBD.Gestionadministrador;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginAdmin {

	private JFrame frame;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginAdmin window = new LoginAdmin();
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
	public LoginAdmin() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 539, 376);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Codigo:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(67, 177, 75, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblLoggeateConTu = new JLabel("Introduce el codigo de administrador\r\n");
		lblLoggeateConTu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLoggeateConTu.setBounds(89, 16, 351, 51);
		frame.getContentPane().add(lblLoggeateConTu);
		
		JButton btnNewButton = new JButton("Atras");
		btnNewButton.setActionCommand("Open90");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						String cmd = e.getActionCommand();
						 if(cmd.equals("Open90"))
					        {
					            frame.dispose();
					            new Menu();
					            
					        }
					}
				});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(43, 264, 115, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Entrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresaradmin();
			}
		});
		btnNewButton_1.setBounds(373, 264, 115, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordField.setBounds(197, 175, 226, 29);
		frame.getContentPane().add(passwordField);
		
		JLabel lblSiNoDispones = new JLabel("Si no dispones de uno no puedes acceder a la gestion de eventos y campings");
		lblSiNoDispones.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSiNoDispones.setBounds(15, 93, 473, 20);
		frame.getContentPane().add(lblSiNoDispones);
	}
	protected void ingresaradmin() {
		String contraseña = String.valueOf(passwordField.getPassword());
		
		Gestionadministrador gestionadministrador = new Gestionadministrador();
		Administrador administrador2 = new Administrador();
		administrador2.setContraseña(contraseña);
		
		Administrador admin = gestionadministrador.obteneradministrador(administrador2);
			
		if(admin!=null) {
			frame.dispose();
			JOptionPane.showMessageDialog(frame, "Bienvenido administrador");
			new MenuAdmin();
			
		}else{
			JOptionPane.showMessageDialog(frame, "Datos no validos", "error", JOptionPane.ERROR_MESSAGE);
			Login.log.log(Level.FINER,"Datos no validos");
		}
		
	}
}
