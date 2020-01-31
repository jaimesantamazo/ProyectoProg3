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

public class Recordarusuario {

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
					Recordarusuario window = new Recordarusuario();
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
	public Recordarusuario() {
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
		
		JLabel lblNewLabel_1 = new JLabel("Email:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(73, 177, 67, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblLoggeateConTu = new JLabel("Introduce el email utilizado en la cuenta\r\n\r\n");
		lblLoggeateConTu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLoggeateConTu.setBounds(81, 16, 367, 51);
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
				String email;
				String username;
				email = textField.getText();
				String sql = "select username from usuario where email = ?";
				try{
					PreparedStatement sentencia = cn5.prepareStatement(sql);
					sentencia.setString(1, email);
					ResultSet rs = sentencia.executeQuery();
					username = rs.getString(1);
					textField_1.setText(username);
				}catch(SQLException e4) {
					JOptionPane.showConfirmDialog(null, "El email no es valido","ERROR",JOptionPane.ERROR_MESSAGE);
				}
				
				JOptionPane.showMessageDialog(null, "Tu nombre de usuario es: "+textField_1.getText());
			}
		});
		btnNewButton_1.setBounds(373, 264, 115, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblSiNoDispones = new JLabel("Para recuperar el usuario introduce tu email utilizado en la cuenta");
		lblSiNoDispones.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSiNoDispones.setBounds(14, 94, 474, 20);
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
