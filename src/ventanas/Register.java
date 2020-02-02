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

public class Register {

	public JFrame frame1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPasswordField passwordField;
	static PrintStream log;
	HashMap<String, Integer> usuarios = new HashMap<String, Integer>();
	private static final String EMAIL_PATTER = 
		    "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private JDateChooser calendar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register();
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
	public Register() {
		super();
		initialize();
		frame1.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame1 = new JFrame();
		frame1.setBounds(100, 100, 450, 600);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username:\r\n");
		lblNewLabel.setBounds(46, 87, 87, 20);
		frame1.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Apellido 1:");
		lblNewLabel_1.setBounds(46, 191, 87, 20);
		frame1.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido 2:");
		lblNewLabel_2.setBounds(46, 227, 135, 20);
		frame1.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email:");
		lblNewLabel_3.setBounds(46, 123, 69, 20);
		frame1.getContentPane().add(lblNewLabel_3);
		
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
		calendar = new JDateChooser("yyyy/MM/dd","####/##/##",'_');
		calendar.setBounds(197,288,164,29);
		frame1.getContentPane().add(calendar);
				
		btnNewButton.setBounds(46, 407, 115, 29);
		frame1.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Registrarse\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Conexion conexion = new Conexion();
				Connection cn = conexion.conectar();
				String username;
				String contraseña;
				String nombre;
				String apellido_1;
				String apellido_2;
				String fecha_nac;
				String email;
				String admin;
				String sql = "";
				
				username = textField.getText();
				contraseña = String.valueOf(passwordField.getPassword());
				nombre = textField_4.getText();
				apellido_1 = textField_2.getText();
				apellido_2 = textField_3.getText();
				fecha_nac = calendar.getDate().toString();
				email = textField_1.getText();
				admin = "0";
				
				Gestionusuarioduplicado gestionusuarioduplicado = new Gestionusuarioduplicado();
				Usuario usuario2 = new Usuario();
				usuario2.setUsername(username);
				Usuario usu = gestionusuarioduplicado.obtenerusuarioduplicado(usuario2);
				Gestionemailduplicado gestionemailduplicado = new Gestionemailduplicado();
				usuario2.setEmail(email);
				Usuario usu1 = gestionemailduplicado.obteneremailduplicado(usuario2);
					
				if(usu!=null) {
					JOptionPane.showMessageDialog(null, "Usuario ya utilizado","ERROR", JOptionPane.ERROR_MESSAGE);
				}else if(usu1!=null) {
					JOptionPane.showMessageDialog(null, "Email ya utilizado","ERROR", JOptionPane.ERROR_MESSAGE);
				}else{
					if (!email.matches(EMAIL_PATTER)) {
						JOptionPane.showMessageDialog(null, "Email no valido", "ERROR", JOptionPane.ERROR_MESSAGE);
					}else {
					sql = "INSERT INTO usuario (username, contraseña, nombre, apellido_1, apellido_2, fecha_nac, email, admin) VALUES(?,?,?,?,?,?,?,?)";
					try {
						PreparedStatement pst = cn.prepareStatement(sql);
						pst.setString(1, username);
						pst.setString(2, contraseña);
						pst.setString(3, nombre);
						pst.setString(4, apellido_1);
						pst.setString(5, apellido_2);
						pst.setString(6, fecha_nac);
						pst.setString(7, email);
						pst.setString(8, admin);
						int n = pst.executeUpdate();
						if(n>0) {
							JOptionPane.showMessageDialog(null, "Usuario registrado");
							Login.log.log(Level.FINER,"Usuario registrado: "+username);
							if(!usuarios.containsKey(username)) {
								usuarios.put(username, 1);
							}else {
								Login.log.log(Level.FINER,"No se ha registrado el usuario en el hashmap");
							}
							frame1.dispose();
							new Login();
						}
						
					} catch (SQLException e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "Los datos no son validos" +e.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
				
				
				
			}
			}});
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBounds(242, 407, 115, 29);
		frame1.getContentPane().add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(197, 84, 146, 26);
		frame1.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(197, 120, 182, 26);
		frame1.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(197, 188, 146, 26);
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
		textField_3.setBounds(197, 224, 146, 26);
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
		
		
		JLabel lblIntroduceTusDatos = new JLabel("Introduce tus datos para crear una cuenta nueva");
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
		btnVueltaAlLogin.setBounds(126, 497, 146, 31);
		frame1.getContentPane().add(btnVueltaAlLogin);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(46, 155, 69, 20);
		frame1.getContentPane().add(lblNombre);
		
		textField_4 = new JTextField();
		textField_4.setBounds(197, 152, 146, 26);
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
		
		JLabel lblFechaNacimiento = new JLabel("Fecha nacimiento:");
		lblFechaNacimiento.setBounds(46, 292, 135, 20);
		frame1.getContentPane().add(lblFechaNacimiento);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(46, 345, 103, 20);
		frame1.getContentPane().add(lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(197, 342, 146, 26);
		frame1.getContentPane().add(passwordField);
		
		
		
	}
}
