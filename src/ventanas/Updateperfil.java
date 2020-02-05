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
	private static final String EMAIL_PATTER = 
		    "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private JButton btnCambiarNombre;
	private JButton btnCambiarApellido;
	private JButton btnCambiarApellido_1;
	private JButton btnCambiarContrasea;

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
		frame1.setBounds(100, 100, 580, 552);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username:\r\n");
		lblNewLabel.setBounds(46, 97, 87, 20);
		frame1.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Apellido 1:");
		lblNewLabel_1.setBounds(46, 224, 87, 20);
		frame1.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido 2:");
		lblNewLabel_2.setBounds(46, 283, 135, 20);
		frame1.getContentPane().add(lblNewLabel_2);
		
		Conexion conexion4 = new Conexion();
		Connection cn4 = conexion4.conectar();
		
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
				
				if(textField_4.isEditable()==true) {
					sql = "update usuario set nombre = ? where username = ?";
					try {
						PreparedStatement pst = cn.prepareStatement(sql);
						pst.setString(1, nombre);
						pst.setString(2, username);
						int n = pst.executeUpdate();
						if(n>0) {
						Conexion.cerrarBD(cn, pst);
							JOptionPane.showMessageDialog(null, "Datos de usuario cambiado");
							Login.log.log(Level.FINER,"Datos de usuario cambiados (nombre): "+username);
							frame1.dispose();
							new Login();
						}
					} catch (SQLException e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "Los datos no son validos " +e.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
						Login.log.log(Level.FINER,"Datos no validos (nombre)");
					}
				}else if(textField_2.isEditable()==true) {
					sql = "update usuario set apellido_1 = ? where username = ?";
					try {
						PreparedStatement pst1 = cn.prepareStatement(sql);
						pst1.setString(1, apellido_1);
						pst1.setString(2, username);
						int n1 = pst1.executeUpdate();
						if(n1>0) {
						Conexion.cerrarBD(cn, pst1);
							JOptionPane.showMessageDialog(null, "Datos de usuario cambiado");
							Login.log.log(Level.FINER,"Datos de usuario cambiados (apellido 1): "+username);
							frame1.dispose();
							new Login();
						}
					} catch (SQLException e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "Los datos no son validos " +e.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
						Login.log.log(Level.FINER,"Datos no validos (apellido_1)");
					}
				}else if(textField_3.isEditable()==true) {
					sql = "update usuario set apellido_2 = ? where username = ?";
					try {
						PreparedStatement pst2 = cn.prepareStatement(sql);
						pst2.setString(1, apellido_2);
						pst2.setString(2, username);
						int n2 = pst2.executeUpdate();
						if(n2>0) {
						Conexion.cerrarBD(cn, pst2);
							JOptionPane.showMessageDialog(null, "Datos de usuario cambiado");
							Login.log.log(Level.FINER,"Datos de usuario cambiados (apellido 2): "+username);
							frame1.dispose();
							new Login();
						}
					} catch (SQLException e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "Los datos no son validos " +e.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
						Login.log.log(Level.FINER,"Datos no validos (apellido_2)");
					}
				}else if(passwordField.isEditable()==true){
					sql = "update usuario set contraseña = ? where username = ?";
					try {
						PreparedStatement pst3 = cn.prepareStatement(sql);
						pst3.setString(1, contraseña);
						pst3.setString(2, username);
						int n3 = pst3.executeUpdate();
						if(n3>0) {
						Conexion.cerrarBD(cn, pst3);
							JOptionPane.showMessageDialog(null, "Datos de usuario cambiado");
							Login.log.log(Level.FINER,"Datos de usuario cambiados (contraseña): "+username);
							frame1.dispose();
							new Login();
						}
					} catch (SQLException e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "Los datos no son validos " +e.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
						Login.log.log(Level.FINER,"Datos no validos (contraseña)");
					}
				}else if(textField_4.isEditable()==true&&textField_2.isEditable()==true&&textField_3.isEditable()==true&&passwordField.isEditable()==true) {
					JOptionPane.showMessageDialog(null, "No has cambiado ningun valor","ERROR",JOptionPane.ERROR_MESSAGE);
				}
			
			}});
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBounds(390, 449, 140, 29);
		frame1.getContentPane().add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(164, 94, 146, 26);
		frame1.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(164, 221, 146, 26);
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
		textField_3.setBounds(164, 280, 146, 26);
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
		btnVueltaAlLogin.setBounds(15, 449, 146, 31);
		frame1.getContentPane().add(btnVueltaAlLogin);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(46, 166, 69, 20);
		frame1.getContentPane().add(lblNombre);
		
		textField_4 = new JTextField();
		textField_4.setBounds(164, 163, 146, 26);
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
		lblContrasea.setBounds(46, 346, 103, 20);
		frame1.getContentPane().add(lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(164, 343, 146, 26);
		frame1.getContentPane().add(passwordField);
		
		JButton btnCargarDatosDe = new JButton("Cargar datos de perfil");
		btnCargarDatosDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "El usuario no es valdio o es nulo","ERROR",JOptionPane.ERROR_MESSAGE);
				}else {
					cargardatosusuario(btnCargarDatosDe);
					
				}
			}

			private void cargardatosusuario(JButton btnCargarDatosDe) {
				Conexion conexion = new Conexion();
				Connection cn = conexion.conectar();
				String username;
				username = textField.getText();
				btnCargarDatosDe.setVisible(false);
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
					textField_2.setEditable(false);
					textField_3.setEditable(false);
					textField_4.setEditable(false);
					passwordField.setEditable(false);
					Conexion.cerrarBD(cn, sentencia);
					
				}catch(SQLException e4) {
					JOptionPane.showMessageDialog(null, "El usuario no es valido","ERROR",JOptionPane.ERROR_MESSAGE);
					textField.setEditable(true);
					btnCargarDatosDe.setVisible(true);
				}
			}
		});
		btnCargarDatosDe.setBounds(325, 93, 210, 29);
		frame1.getContentPane().add(btnCargarDatosDe);
		
		JButton btnCambiarApellido = new JButton("Cambiar apellido 1");
		btnCambiarApellido.setBounds(348, 220, 182, 29);
		frame1.getContentPane().add(btnCambiarApellido);
		
		JButton btnCambiarApellido_1 = new JButton("Cambiar apellido 2");
		btnCambiarApellido_1.setBounds(348, 279, 182, 29);
		frame1.getContentPane().add(btnCambiarApellido_1);
		
		JButton btnCambiarContrasea = new JButton("Cambiar contrase\u00F1a");
		btnCambiarContrasea.setBounds(348, 342, 182, 29);
		frame1.getContentPane().add(btnCambiarContrasea);
		
		JButton btnCambiarNombre = new JButton("Cambiar nombre");
		btnCambiarNombre.setBounds(348, 162, 182, 29);
		frame1.getContentPane().add(btnCambiarNombre);
		btnCambiarNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_4.setEditable(true);
				btnCambiarNombre.setVisible(false);
				btnCambiarApellido.setVisible(false);
				btnCambiarApellido_1.setVisible(false);
				btnCambiarContrasea.setVisible(false);
			}
		});
		btnCambiarApellido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_2.setEditable(true);
				btnCambiarNombre.setVisible(false);
				btnCambiarApellido.setVisible(false);
				btnCambiarApellido_1.setVisible(false);
				btnCambiarContrasea.setVisible(false);
			}
		});
		btnCambiarApellido_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_3.setEditable(true);
				btnCambiarNombre.setVisible(false);
				btnCambiarApellido.setVisible(false);
				btnCambiarApellido_1.setVisible(false);
				btnCambiarContrasea.setVisible(false);
			}
		});
		btnCambiarContrasea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordField.setEditable(true);
				btnCambiarNombre.setVisible(false);
				btnCambiarApellido.setVisible(false);
				btnCambiarApellido_1.setVisible(false);
				btnCambiarContrasea.setVisible(false);
			}
		});
	}
}
