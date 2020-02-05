package ventanas;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;

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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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

public class Updatecampings {

	public JFrame frame1;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	static PrintStream log;
	private static final String EMAIL_PATTER = 
		    "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private JButton btnCambiarNombre;
	private JButton btnCambiarApellido;
	private JButton btnCambiarApellido_1;
	private JButton btnCambiarContrasea;
	private JTextField textField_1;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					Updatecampings window = new Updatecampings();
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
	public Updatecampings() {
		super();
		initialize();
		frame1.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame1 = new JFrame();
		frame1.setBounds(100, 100, 782, 559);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.getContentPane().setLayout(null);
		
		DefaultListModel<String> listmodel = new DefaultListModel<String>();
		JList<String> list = new JList<String>(listmodel);
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		list.setFixedCellWidth(10);
		list.setBounds(558, 94, 172, 334);
		frame1.getContentPane().add(list);
		
		JLabel lblNewLabel = new JLabel("Codigo:\r\n");
		lblNewLabel.setBounds(46, 97, 87, 20);
		frame1.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Precio:");
		lblNewLabel_1.setBounds(46, 224, 87, 20);
		frame1.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Fecha ini:");
		lblNewLabel_2.setBounds(46, 283, 135, 20);
		frame1.getContentPane().add(lblNewLabel_2);
		
		Conexion conexion4 = new Conexion();
		Connection cn4 = conexion4.conectar();
		
		JButton btnNewButton_1 = new JButton("Cambiar datos\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Conexion conexion = new Conexion();
				Connection cn = conexion.conectar();
				String fecha_ini;
				String fecha_fin;
				String nombre;
				String precio;
				String aforo;
				String codigo;
				String sql = "";
				
				codigo = textField.getText();
				aforo = textField.getText();
				fecha_fin = textField_5.getText();
				nombre = textField_4.getText();
				precio = textField_2.getText();
				fecha_ini = textField_3.getText();
				
				if(textField_4.isEditable()==true) {
					sql = "update camping set nombre = ? where codigo = ?";
					try {
						PreparedStatement pst = cn.prepareStatement(sql);
						pst.setString(1, nombre);
						pst.setString(2, codigo);
						int n = pst.executeUpdate();
						if(n>0) {
						Conexion.cerrarBD(cn, pst);
							JOptionPane.showMessageDialog(null, "Datos de un evento cambiado");
							Login.log.log(Level.FINER,"Datos de evento cambiados (nombre): "+codigo);
							frame1.dispose();
							new Gestioncamping();
						}
					} catch (SQLException e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "Los datos no son validos " +e.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
						Login.log.log(Level.FINER,"Datos no validos (nombre)");
					}
				}else if(textField_2.isEditable()==true) {
					sql = "update camping set precio = ? where codigo = ?";
					try {
						PreparedStatement pst = cn.prepareStatement(sql);
						pst.setString(1, precio);
						pst.setString(2, codigo);
						int n1 = pst.executeUpdate();
						if(n1>0) {
						Conexion.cerrarBD(cn, pst);
							JOptionPane.showMessageDialog(null, "Datos de un evento cambiado");
							Login.log.log(Level.FINER,"Datos de evento cambiados (precio): "+codigo);
							frame1.dispose();
							new Gestioncamping();
						}
					} catch (SQLException e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "Los datos no son validos " +e.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
						Login.log.log(Level.FINER,"Datos no validos (precio)");
					}
				}else if(textField_3.isEditable()==true) {
					sql = "update camping set fecha_ini = ? where codigo = ?";
					try {
						PreparedStatement pst = cn.prepareStatement(sql);
						pst.setString(1, fecha_ini);
						pst.setString(2, codigo);
						int n2 = pst.executeUpdate();
						if(n2>0) {
						Conexion.cerrarBD(cn, pst);
							JOptionPane.showMessageDialog(null, "Datos de un evento cambiado");
							Login.log.log(Level.FINER,"Datos de evento cambiados (fecha_ini): "+codigo);
							frame1.dispose();
							new Gestioncamping();
						}
					} catch (SQLException e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "Los datos no son validos " +e.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
						Login.log.log(Level.FINER,"Datos no validos (fecha_ini)");
					}
				}else if(textField_5.isEditable()==true){
					sql = "update camping set fecha_fin = ? where codigo = ?";
					try {
						PreparedStatement pst = cn.prepareStatement(sql);
						pst.setString(1, fecha_fin);
						pst.setString(2, codigo);
						int n3 = pst.executeUpdate();
						if(n3>0) {
						Conexion.cerrarBD(cn, pst);
							JOptionPane.showMessageDialog(null, "Datos de un evento cambiado");
							Login.log.log(Level.FINER,"Datos de evento cambiados (fecha_fin): "+codigo);
							frame1.dispose();
							new Gestioncamping();
						}
					} catch (SQLException e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "Los datos no son validos " +e.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
						Login.log.log(Level.FINER,"Datos no validos (fecha_fin)");
					}
				}else if(textField_1.isEditable()==true) {
					sql = "update camping set aforo = ? where codigo = ?";
					try {
						PreparedStatement pst = cn.prepareStatement(sql);
						pst.setString(1, aforo);
						pst.setString(2, codigo);
						int n3 = pst.executeUpdate();
						if(n3>0) {
						Conexion.cerrarBD(cn, pst);
							JOptionPane.showMessageDialog(null, "Datos de un evento cambiado");
							Login.log.log(Level.FINER,"Datos de evento cambiados (aforo): "+codigo);
							frame1.dispose();
							new Gestioncamping();
						}
					} catch (SQLException e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "Los datos no son validos " +e.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
						Login.log.log(Level.FINER,"Datos no validos (aforo)");
					}
				}else if(textField_4.isEditable()==true&&textField_2.isEditable()==true&&textField_3.isEditable()==true&&textField_5.isEditable()==true&&textField_1.isEditable()==true) {
					JOptionPane.showMessageDialog(null, "No has cambiado ningun valor","ERROR",JOptionPane.ERROR_MESSAGE);
				}
			
			}});
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBounds(371, 460, 140, 29);
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
				if (!Character.isDigit(c))

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
		
		JLabel lblIntroduceTusDatos = new JLabel("Introduce tu usuario para obtener tus datos");
		lblIntroduceTusDatos.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblIntroduceTusDatos.setBounds(15, 16, 398, 52);
		frame1.getContentPane().add(lblIntroduceTusDatos);
		
		JButton btnVueltaAlLogin = new JButton("Vuelta a la gestion");
		btnVueltaAlLogin.setActionCommand("Open1");
		btnVueltaAlLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd1 = e.getActionCommand();

		        if(cmd1.equals("Open1"))
		        {
		            frame1.dispose();
		            new Gestioncamping();
		        }
			}
		});
		btnVueltaAlLogin.setBounds(15, 459, 166, 31);
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
		
		JLabel lblContrasea = new JLabel("Fecha fin:\r\n");
		lblContrasea.setBounds(46, 346, 103, 20);
		frame1.getContentPane().add(lblContrasea);
		
		JButton btnCargarDatosDe = new JButton("Cargar datos del camping");
		btnCargarDatosDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "El codigo no es valdio o es nulo","ERROR",JOptionPane.ERROR_MESSAGE);
				}else {
					seleccionardatoscamping(btnCargarDatosDe);
					
				}
			}

			private void seleccionardatoscamping(JButton btnCargarDatosDe) {
				Conexion conexion = new Conexion();
				Connection cn = conexion.conectar();
				String codigo;
				codigo = textField.getText();
				btnCargarDatosDe.setVisible(false);
				String sql = "select nombre1,precio,fecha_ini,fecha_fin,aforo from camping where codigo = ?";
				try{
					PreparedStatement sentencia = cn.prepareStatement(sql);
					sentencia.setString(1, codigo);
					ResultSet rs = sentencia.executeQuery();
					textField_4.setText(rs.getString(1));
					textField_2.setText(rs.getString(2));
					textField_3.setText(rs.getString(3));
					textField_5.setText(rs.getString(4));
					textField_1.setText(rs.getString(5));
					
					textField.setEditable(false);
					textField_2.setEditable(false);
					textField_3.setEditable(false);
					textField_4.setEditable(false);
					textField_5.setEditable(false);
					textField_1.setEditable(false);
					Conexion.cerrarBD(cn, sentencia);
					
				}catch(SQLException e4) {
					JOptionPane.showMessageDialog(null, "El codigo no es valido","ERROR",JOptionPane.ERROR_MESSAGE);
					textField.setEditable(true);
					btnCargarDatosDe.setVisible(true);
				}
			}
		});
		btnCargarDatosDe.setBounds(325, 93, 218, 29);
		frame1.getContentPane().add(btnCargarDatosDe);
		
		JButton btnCambiarApellido = new JButton("Cambiar precio");
		btnCambiarApellido.setBounds(348, 220, 182, 29);
		frame1.getContentPane().add(btnCambiarApellido);
		
		JButton btnCambiarApellido_1 = new JButton("Cambiar fecha ini");
		btnCambiarApellido_1.setBounds(348, 279, 182, 29);
		frame1.getContentPane().add(btnCambiarApellido_1);
		
		JButton btnCambiarContrasea = new JButton("Cambiar fecha fin");
		btnCambiarContrasea.setBounds(348, 342, 182, 29);
		frame1.getContentPane().add(btnCambiarContrasea);
		
		JButton btnCambiarNombre = new JButton("Cambiar nombre");
		btnCambiarNombre.setBounds(348, 162, 182, 29);
		frame1.getContentPane().add(btnCambiarNombre);
		
		JButton btnNewButton = new JButton("Cambiar aforo");
		btnNewButton.setBounds(348, 399, 182, 29);
		frame1.getContentPane().add(btnNewButton);
		
		JLabel lblCantidad = new JLabel("Aforo:\r\n");
		lblCantidad.setBounds(46, 403, 69, 20);
		frame1.getContentPane().add(lblCantidad);
		
		frame1.addWindowListener(new WindowAdapter() {

			@Override
			public void windowOpened(WindowEvent e) {
				listmodel.clear();
				cargarjlist(listmodel, cn4);
			}

			private void cargarjlist(DefaultListModel<String> listmodel, Connection cn4) {
				String query = "SELECT CODIGO,NOMBRE1 FROM CAMPING";
				try {
					java.sql.Statement stmt = cn4.createStatement();
					ResultSet rs = stmt.executeQuery(query);
				while(rs.next())
				{
					listmodel.addElement("cod:"+rs.getString(1)+" ,"+"camp:"+rs.getString(2));
				}
					rs.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
					Login.log.log(Level.FINER,"Error al cargar datos camping jlist en los update");
				}
			}
			
		});
		
		textField_1 = new JTextField();
		textField_1.setBounds(164, 400, 146, 26);
		frame1.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		textField_1.addKeyListener(new KeyListener(){

			public void keyTyped(KeyEvent e){
				char c= e.getKeyChar();
				if (!Character.isDigit(c))

			     e.consume();

			}

			public void keyPressed(KeyEvent arg0) {
			}

			public void keyReleased(KeyEvent arg0) {
			}
			});
		
		textField_5 = new JTextField();
		textField_5.setBounds(164, 343, 146, 26);
		frame1.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		btnCambiarNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_4.setEditable(true);
				btnCambiarNombre.setVisible(false);
				btnCambiarApellido.setVisible(false);
				btnCambiarApellido_1.setVisible(false);
				btnCambiarContrasea.setVisible(false);
				btnNewButton.setVisible(false);
				
			}
		});
		btnCambiarApellido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_2.setEditable(true);
				btnCambiarNombre.setVisible(false);
				btnCambiarApellido.setVisible(false);
				btnCambiarApellido_1.setVisible(false);
				btnCambiarContrasea.setVisible(false);
				btnNewButton.setVisible(false);
			}
		});
		btnCambiarApellido_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_3.setEditable(true);
				btnCambiarNombre.setVisible(false);
				btnCambiarApellido.setVisible(false);
				btnCambiarApellido_1.setVisible(false);
				btnCambiarContrasea.setVisible(false);
				btnNewButton.setVisible(false);
			}
		});
		btnCambiarContrasea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_5.setEditable(true);
				btnCambiarNombre.setVisible(false);
				btnCambiarApellido.setVisible(false);
				btnCambiarApellido_1.setVisible(false);
				btnCambiarContrasea.setVisible(false);
				btnNewButton.setVisible(false);
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setEditable(true);
				btnCambiarNombre.setVisible(false);
				btnCambiarApellido.setVisible(false);
				btnCambiarApellido_1.setVisible(false);
				btnCambiarContrasea.setVisible(false);
				btnNewButton.setVisible(false);
			}
		});
	}
}
