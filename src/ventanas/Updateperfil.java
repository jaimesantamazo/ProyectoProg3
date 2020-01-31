package ventanas;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import clasesbasicas.Usuario;
import gestionBD.Conexion;
import gestionBD.Gestionemailduplicado;
import gestionBD.Gestionusuarioduplicado;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Updateperfil {

	public JFrame frame1;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPasswordField passwordField;
	static PrintStream log;
	HashMap<String, String> usuarios = new HashMap<String, String>();
	private static final String EMAIL_PATTER = 
		    "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					Updateperfil window = new Updateperfil();
					window.frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Updateperfil() {
		super();
		initialize();
		frame1.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame1 = new JFrame();
		frame1.setBounds(100, 100, 450, 552);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username:\r\n");
		lblNewLabel.setBounds(46, 73, 87, 20);
		frame1.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Apellido 1:");
		lblNewLabel_1.setBounds(46, 250, 87, 20);
		frame1.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido 2:");
		lblNewLabel_2.setBounds(46, 297, 135, 20);
		frame1.getContentPane().add(lblNewLabel_2);
		
		Conexion conexion4 = new Conexion();
		Connection cn4 = conexion4.conectar();
		
		JButton btnNewButton = new JButton("Cancelar\r\n");
		btnNewButton.setActionCommand("Open70");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						String cmd = e.getActionCommand();

				        if(cmd.equals("Open70"))
				        {
				            frame1.dispose();
				            new Login();
				            
				        }
					}
				});
				
		btnNewButton.setBounds(46, 395, 115, 29);
		frame1.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cambiar datos\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Conexion conexion = new Conexion();
				Connection cn = conexion.conectar();
				String username;
				String contraseña;
				String nombre;
				String apellido_1;
				String apellido_2;
				String sql = "";
				
				username = textField.getText();
				contraseña = String.valueOf(passwordField.getPassword());
				nombre = textField_4.getText();
				apellido_1 = textField_2.getText();
				apellido_2 = textField_3.getText();
				
									
				sql = "update usuario set nombre = ?, apellido_1 = ?, apellido_2 = ?, contraseña = ? where username = ?";
				try {
					PreparedStatement pst = cn.prepareStatement(sql);
					pst.setString(1, nombre);
					pst.setString(2, apellido_1);						
					pst.setString(3, apellido_2);
					pst.setString(4, contraseña);
					pst.setString(5, username);
					pst.executeUpdate();
					Conexion.cerrarBD(cn, pst);
					
						JOptionPane.showMessageDialog(null, "Datos de usuario cambiado");
						Login.log.log(Level.FINER,"Datos de usuario cambiados: "+username);
						usuarios.put(textField.getText(),String.valueOf(passwordField.getPassword()));
						frame1.dispose();
						new Login();
				} catch (SQLException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Los datos no son validos " +e.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
				}
			
			}});
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBounds(240, 395, 140, 29);
		frame1.getContentPane().add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(197, 70, 146, 26);
		frame1.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(197, 247, 146, 26);
		frame1.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		textField_2.addKeyListener(new KeyListener(){

			public void keyTyped(KeyEvent e){
				char c= e.getKeyChar();
				if (!Character.isAlphabetic(c))

			     e.consume();

			}

			public void keyPressed(KeyEvent arg0) {
			}

			public void keyReleased(KeyEvent arg0) {
			}
			});
		
		
		textField_3 = new JTextField();
		textField_3.setBounds(196, 294, 146, 26);
		frame1.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		textField_3.addKeyListener(new KeyListener(){

			public void keyTyped(KeyEvent e){
				char c= e.getKeyChar();
				if (!Character.isAlphabetic(c))

			     e.consume();

			}

			public void keyPressed(KeyEvent arg0) {
			}

			public void keyReleased(KeyEvent arg0) {
			}
			});
		
		
		JLabel lblIntroduceTusDatos = new JLabel("Introduce tu usuario para obtener tus datos");
		lblIntroduceTusDatos.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblIntroduceTusDatos.setBounds(15, 16, 398, 52);
		frame1.getContentPane().add(lblIntroduceTusDatos);
		
		JButton btnVueltaAlLogin = new JButton("Vuelta al login");
		btnVueltaAlLogin.setActionCommand("Open1");
		btnVueltaAlLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd1 = e.getActionCommand();

		        if(cmd1.equals("Open1"))
		        {
		            frame1.dispose();
		            new Login();
		        }
			}
		});
		btnVueltaAlLogin.setBounds(125, 449, 146, 31);
		frame1.getContentPane().add(btnVueltaAlLogin);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(46, 202, 69, 20);
		frame1.getContentPane().add(lblNombre);
		
		textField_4 = new JTextField();
		textField_4.setBounds(197, 199, 146, 26);
		frame1.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		textField_4.addKeyListener(new KeyListener(){

			public void keyTyped(KeyEvent e){
				char c= e.getKeyChar();
				if (!Character.isAlphabetic(c))

			     e.consume();

			}

			public void keyPressed(KeyEvent arg0) {
			}

			public void keyReleased(KeyEvent arg0) {
			}
			});
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(45, 349, 103, 20);
		frame1.getContentPane().add(lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(197, 346, 146, 26);
		frame1.getContentPane().add(passwordField);
		
		JButton btnCargarDatosDe = new JButton("Cargar datos de perfil");
		btnCargarDatosDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "El usuario no es valdio o es nulo","ERROR",JOptionPane.ERROR_MESSAGE);
				}else {
					Conexion conexion = new Conexion();
					Connection cn = conexion.conectar();
					String username;
					username = textField.getText();
					
					String sql = "select nombre,apellido_1,apellido_2,contraseña from usuario where username = ?";
					try{
						PreparedStatement sentencia = cn.prepareStatement(sql);
						sentencia.setString(1, username);
						ResultSet rs = sentencia.executeQuery();
						textField_4.setText(rs.getString(1));
						textField_2.setText(rs.getString(2));
						textField_3.setText(rs.getString(3));
						passwordField.setText(rs.getString(4));
						textField.setEditable(false);
						Conexion.cerrarBD(cn, sentencia);
					}catch(SQLException e4) {
						JOptionPane.showConfirmDialog(null, "El usuario no es valido","ERROR",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnCargarDatosDe.setBounds(46, 127, 210, 29);
		frame1.getContentPane().add(btnCargarDatosDe);
		
		
		
	}
}
