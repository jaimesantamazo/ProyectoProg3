package ventanas;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import clasesbasicas.Administrador;
import gestionBD.Conexion;
import gestionBD.Gestionadministrador;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Recordarcontraseña {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Recordarcontraseña window = new Recordarcontraseña();
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
	public Recordarcontraseña() {
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
		
		JLabel lblNewLabel_1 = new JLabel("Usuario:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(50, 177, 90, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblLoggeateConTu = new JLabel("Introduce el nombre de usuario utilizado en la cuenta\r\n\r\n");
		lblLoggeateConTu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLoggeateConTu.setBounds(25, 16, 477, 51);
		frame.getContentPane().add(lblLoggeateConTu);
		
		JButton btnNewButton = new JButton("Atras");
		btnNewButton.setActionCommand("Open90");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						String cmd = e.getActionCommand();
						 if(cmd.equals("Open90"))
					        {
					            frame.dispose();
					            new Login();
					            
					        }
					}
				});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(25, 264, 115, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Recordar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conexion conexion5 = new Conexion();
				Connection cn5 = conexion5.conectar();
				String contraseña;
				String username;
				username = textField.getText();
				String sql = "select contraseña from usuario where username = ?";
				try{
					PreparedStatement sentencia = cn5.prepareStatement(sql);
					sentencia.setString(1, username);
					ResultSet rs = sentencia.executeQuery();
					contraseña = rs.getString(1);
					textField_1.setText(contraseña);
				}catch(SQLException e4) {
					e4.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(null, "Tu contraseña de la cuenta es: "+textField_1.getText());
			}
		});
		btnNewButton_1.setBounds(373, 264, 115, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblSiNoDispones = new JLabel("Para recuperar la contrase\u00F1a introduce tu nombre de usuario");
		lblSiNoDispones.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSiNoDispones.setBounds(39, 94, 463, 20);
		frame.getContentPane().add(lblSiNoDispones);
		
		textField = new JTextField();
		textField.setBounds(174, 178, 256, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(171, 209, 146, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		textField_1.setVisible(false);
	}
	
}
