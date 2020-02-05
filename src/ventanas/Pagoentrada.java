package ventanas;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.text.Caret;

import com.mysql.jdbc.Statement;

import gestionBD.Conexion;

import java.awt.Font;
import java.awt.TextField;

import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JSpinner;

public class Pagoentrada {

	private JFrame frame3;
	private JTextField textTarjeta;
	private JTextField textCCV;
	private JTextField textDNI;
	private JTextField textemail;
	private int limiteTarjeta =16;
	private int limiteCCV=3;
	private int limiteDNI=8;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private static final String EMAIL_PATTERN = 
		    "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private JSpinner spinner;
	static int x = 0;
	private JTextField textField_4;
	private JTextField textField_3;
	private JFileChooser jFileChooser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					Pagoentrada window = new Pagoentrada();
					window.frame3.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Pagoentrada() {
		super();
		initialize();
		frame3.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame3 = new JFrame();
		frame3.setBounds(100, 100, 643, 536);
		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame3.getContentPane().setLayout(null);

		JLabel lblCorreo = new JLabel("E-mail:");
		lblCorreo.setBounds(25, 297, 69, 20);
		frame3.getContentPane().add(lblCorreo);

		textemail = new JTextField();
		textemail.setBounds(182, 294, 344, 26);
		frame3.getContentPane().add(textemail);
		textemail.setColumns(10);


		JLabel lblNumeroTarjeta = new JLabel("Numero tarjeta:");
		lblNumeroTarjeta.setBounds(25, 333, 126, 20);
		frame3.getContentPane().add(lblNumeroTarjeta);


		JLabel lblCcv = new JLabel("CCV:");
		lblCcv.setBounds(25, 369, 69, 20);
		frame3.getContentPane().add(lblCcv);


		JLabel lblDniCliente = new JLabel("DNI cliente:");
		lblDniCliente.setBounds(25, 405, 126, 20);
		frame3.getContentPane().add(lblDniCliente);
		

		JLabel lblIntroduceLosDatos = new JLabel("Rellena los siguientes datos para validar el pago de las entradas");
		lblIntroduceLosDatos.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblIntroduceLosDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntroduceLosDatos.setBounds(15, 16, 591, 49);
		frame3.getContentPane().add(lblIntroduceLosDatos);

		textTarjeta= new JTextField();
		textTarjeta.setBounds(182, 330, 237, 26);
		frame3.getContentPane().add(textTarjeta);
		textTarjeta.setColumns(10);
		textTarjeta.addKeyListener(new KeyListener(){

			public void keyTyped(KeyEvent e){
				char c= e.getKeyChar();
				if (textTarjeta.getText().length()== limiteTarjeta | !Character.isDigit(c))

			     e.consume();

			}

			public void keyPressed(KeyEvent arg0) {
			}

			public void keyReleased(KeyEvent arg0) {
			}
			});

		textCCV = new JTextField();
		textCCV.setBounds(182, 366, 132, 26);
		frame3.getContentPane().add(textCCV);
		textCCV.setColumns(10);
		textCCV.addKeyListener(new KeyListener(){


			public void keyTyped(KeyEvent e)

			{
				char c=e.getKeyChar();
				if (textCCV.getText().length()== limiteCCV| !Character.isDigit(c)) {

			     e.consume();}
			}

			public void keyPressed(KeyEvent arg0) {
			}

			public void keyReleased(KeyEvent arg0) {
			}
			});
		
		
		
		 
		JButton btnPagar = new JButton("Pagar");
		btnPagar.setBounds(182, 441, 115, 29);
		frame3.getContentPane().add(btnPagar);
		btnPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String[] opciones = {"Comprar entrada sola", "Comprar entrada conjunta con el camping","Cancelar el pago"};
				String confirmacion = "¿Estas seguro de que quieres comprar una entrada de "+textField_1.getText()+" en vez de comprar una entrada conjunta con el camping?";
				int respuesta = JOptionPane.showOptionDialog( null, confirmacion, "¿Estas seguro?", JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
				switch(respuesta) {
				case 0:
					String nombre;
					String cantidad1;
					String valor1;
					String cantidad;
					String cantidad2;
					String email;
					cantidad1 = textField_2.getText();
					nombre = textField_1.getText();
					valor1 =  textField_4.getText();
					int valor = Integer.parseInt(valor1);
					int numero1 = Integer.parseInt(cantidad1);
					int entradas = numero1-valor;
					cantidad2 = String.valueOf(entradas);
					textField_3.setText(cantidad2);
					cantidad = textField_3.getText();
					email = textemail.getText();
					if(numero1==0) {
						JOptionPane.showMessageDialog(null, "Las entradas estan agotadas","ERROR", JOptionPane.ERROR_MESSAGE);
						Login.log.log(Level.FINER,"Entradas agotadas: " + nombre);
					}else if (!email.matches(EMAIL_PATTERN)) {
						JOptionPane.showMessageDialog(null, "Email no valido", "ERROR", JOptionPane.ERROR_MESSAGE);
					}else if(numero1<valor) {
						JOptionPane.showMessageDialog(null, "No hay entradas suficientes","ERROR",JOptionPane.ERROR_MESSAGE);
					}else if(textField_4.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Rellena todos los huecos","ERROR",JOptionPane.ERROR_MESSAGE);
					}else if(textCCV.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Rellena todos los huecos","ERROR",JOptionPane.ERROR_MESSAGE);
					}else if(textemail.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Rellena todos los huecos","ERROR",JOptionPane.ERROR_MESSAGE);
					}else if(textTarjeta.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Rellena todos los huecos","ERROR",JOptionPane.ERROR_MESSAGE);
					}else if(textField.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Rellena todos los huecos","ERROR",JOptionPane.ERROR_MESSAGE);
					}else {
						if(numero1 >0) {
					comprarentradassql();
					comprarentradas(x);
						}else {
							JOptionPane.showMessageDialog(null, "No se ha podidio realizar la compra","ERROR",JOptionPane.ERROR_MESSAGE);
							Login.log.log(Level.FINER,"No se ha podido realizar la compra de entradas");
						}
					}
					break;
				case 1:
					frame3.dispose();
					new Pagoentradaycamping();
					break;
				case 2:
					JOptionPane.showMessageDialog(null, "Se ha cancelado la operacion");
				default:
					break;
				}
				}catch(NullPointerException e10) {
					JOptionPane.showMessageDialog(null, "Rellena todos los campos para completar el pago","ERROR",JOptionPane.ERROR_MESSAGE);
					Login.log.log(Level.FINER,"Huecos vacios en la compra de entradas");
				}catch(NumberFormatException e20) {
					JOptionPane.showMessageDialog(null, "Rellena los huecos con valores validos","ERROR",JOptionPane.ERROR_MESSAGE);
					Login.log.log(Level.FINER,"Error en el formato de numero en la compra de entradas");
				}
		}});
		


		JButton btnCancel = new JButton("Volver al menu\r\n");
		btnCancel.setActionCommand("Open20");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton btnVueltaAlLogin = new JButton("Vuelta al login");
				String cmd20 = e.getActionCommand();

		        if(cmd20.equals("Open20"))
		        {
		            frame3.dispose();
		            new Menu();
		        }
			}});
		
		btnCancel.setBounds(15, 441, 152, 29);
		frame3.getContentPane().add(btnCancel);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(95, 85, 191, 26);
		frame3.getContentPane().add(comboBox);
		

		JLabel lblFestival = new JLabel("Festival:");
		lblFestival.setBounds(25, 88, 69, 20);
		frame3.getContentPane().add(lblFestival);

		
		textField = new JTextField();
		textField.setBounds(181, 402, 183, 26);
		frame3.getContentPane().add(textField);
		textField.setColumns(10);
		textField.addKeyListener(new KeyListener(){


			public void keyTyped(KeyEvent e)

			{
				char c=e.getKeyChar();
				if (textField.getText().length()== limiteDNI| !Character.isDigit(c)) {

			     e.consume();}
			}

			public void keyPressed(KeyEvent arg0) {
			}

			public void keyReleased(KeyEvent arg0) {
			}
			});
		
		
		JLabel lblConciertoSeleccionado = new JLabel("Concierto seleccionado:");
		lblConciertoSeleccionado.setBounds(25, 146, 174, 20);
		frame3.getContentPane().add(lblConciertoSeleccionado);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(214, 143, 169, 26);
		frame3.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSeleccion = new JButton("Seleccion");
		btnSeleccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				StringTokenizer st = new StringTokenizer(comboBox.getSelectedItem().toString());
				while(st.hasMoreTokens()) {
					textField_1.setText(st.nextToken().toString());
					textField_2.setText(st.nextToken().toString());
				}
				}catch(Exception e5) {
					JOptionPane.showMessageDialog(null, "Cargar los conciertos primero","ERROR",JOptionPane.ERROR_MESSAGE);
					Login.log.log(Level.FINER,"Hay que cargar los conciertos primero");
				}
				
			}
		});
		btnSeleccion.setBounds(298, 84, 99, 29);
		frame3.getContentPane().add(btnSeleccion);
		
		JButton btnNewButton = new JButton("Cargar conciertos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarentradas(comboBox);
			}

			private void cargarentradas(JComboBox comboBox) {
				Conexion conexion3 = new Conexion();
				Connection cn3 = conexion3.conectar();
				String query = "SELECT NOMBRE,CANTIDAD FROM ENTRADAS";
				
				try {
					java.sql.Statement stmt = cn3.createStatement();
					ResultSet rs = stmt.executeQuery(query);
				while(rs.next())
				{
					comboBox.addItem(rs.getString(1)+" "+rs.getString(2));
				}
					rs.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
					Login.log.log(Level.FINER,"Error al cargar los datos de compra de entradas");
				}
			}
		});
		btnNewButton.setBounds(402, 84, 171, 29);
		frame3.getContentPane().add(btnNewButton);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(262, 191, 169, 26);
		frame3.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		
		JLabel lblNumeroDeEntradas = new JLabel("Numero de entradas restantes:");
		lblNumeroDeEntradas.setBounds(25, 194, 234, 20);
		frame3.getContentPane().add(lblNumeroDeEntradas);
		
		JLabel lblNDeEntradas = new JLabel("N\u00BA de entradas que quieres comprar:");
		lblNDeEntradas.setBounds(25, 241, 272, 20);
		frame3.getContentPane().add(lblNDeEntradas);
		
		SpinnerModel sm = new SpinnerNumberModel(1, 1, 9, 1);
		
		JSpinner spinner = new JSpinner(sm);
		spinner.setBounds(262, 238, 32, 26);
		frame3.getContentPane().add(spinner);
		
		JButton btnSeleccion_1 = new JButton("Seleccion:");
		btnSeleccion_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_4.setText(spinner.getValue().toString());
			}
		});
		btnSeleccion_1.setBounds(312, 237, 115, 29);
		frame3.getContentPane().add(btnSeleccion_1);
		
		textField_4 = new JTextField();
		textField_4.setBounds(442, 238, 99, 26);
		frame3.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(446, 191, 146, 26);
		frame3.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		textField_3.setVisible(false);
		
	}
	public void comprarentradas(int x) {
		try {
		String cantidad;
		String valor1;
		cantidad = textField_2.getText();
		valor1 =  textField_4.getText();
		int valor = Integer.parseInt(valor1);
		int numero1 = Integer.parseInt(cantidad);
		String dni;
		String concierto1;
		String email;
		
		dni = textField.getText();
		concierto1 = textField_1.getText();
		email = textemail.getText();
				if(x==valor) {
					JOptionPane.showMessageDialog(null, "Entrada/as compradas");
					
					frame3.dispose();
					new Menu();
				}else {
						try{
							FileWriter archivo = new FileWriter("C:\\Users\\jaime\\eclipse-workspace\\proyecto program 3\\TicketsAdmin\\entrada"+concierto1+".txt", true);
				
							PrintWriter escribir = new PrintWriter(archivo);
				
							String cadena = "-Dni:"+dni+", Concierto:"+concierto1+", Email:"+email;
							escribir.print(cadena);
				
							archivo.close();	
						}catch(IOException e6) {
							e6.printStackTrace();
							Login.log.log(Level.FINER,"Error en el creador de ficheros entrada");
						}
						try{
							FileWriter archivo = new FileWriter("C:\\Users\\jaime\\eclipse-workspace\\proyecto program 3\\Tickets\\Entradas\\entrada"+dni+".txt", true);
				
							PrintWriter escribir = new PrintWriter(archivo);
				
							String cadena = "-Dni:"+dni+", Concierto:"+concierto1+", Email:"+email;
							escribir.print(cadena);
				
							archivo.close();	
						}catch(IOException e6) {
							e6.printStackTrace();
							Login.log.log(Level.FINER,"Error en el creador de ficheros entrada");
						}
						try{
							FileWriter archivo = new FileWriter("C:\\Users\\jaime\\eclipse-workspace\\proyecto program 3\\TicketsProperties\\entrada.txt", true);
				
							PrintWriter escribir = new PrintWriter(archivo);
				
							String cadena = "Nºentradas:"+valor+" entrada/as"+'\n'+"Dni:"+dni+'\n'+"Concierto:"+concierto1+'\n'+"Email:"+email+'\n';
							escribir.print(cadena);
				
							archivo.close();	
						}catch(IOException e6) {
							e6.printStackTrace();
							Login.log.log(Level.FINER,"Error en el creador de ficheros entrada");
						}
					x++;
					comprarentradas(x);
				}
				}catch(NumberFormatException e20) {
					JOptionPane.showMessageDialog(null, "Rellena los huecos con valores validos","ERROR",JOptionPane.ERROR_MESSAGE);
					Login.log.log(Level.FINER,"Error en el formato del numero compra entradas");
				}
		
		}
	public void comprarentradassql() {
		try {
		Conexion conexion5 = new Conexion();
		Connection cn5 = conexion5.conectar();
		String nombre;
		String cantidad1;
		String valor1;
		String cantidad;
		String cantidad2;
		cantidad1 = textField_2.getText();
		nombre = textField_1.getText();
		valor1 =  textField_4.getText();
		int valor = Integer.parseInt(valor1);
		int numero1 = Integer.parseInt(cantidad1);
		int entradas = numero1-valor;
		cantidad2 = String.valueOf(entradas);
		textField_3.setText(cantidad2);
		cantidad = textField_3.getText();
		try {
			String sql = "UPDATE ENTRADAS SET cantidad = ? WHERE NOMBRE = ?";
			PreparedStatement pst2 = cn5.prepareStatement(sql);
			pst2.setString(1, cantidad);
			pst2.setString(2, nombre);
			int n = pst2.executeUpdate();
			if(n>0) {
				Login.log.log(Level.FINER,"Entrada comprada/as: "+valor1 + nombre);
			}
			Conexion.cerrarBD(cn5, pst2);
		}catch (SQLException e1) {
			e1.printStackTrace();
			Login.log.log(Level.FINER,"Error en la compra de entradas");
		}
		}catch(NumberFormatException e20) {
			JOptionPane.showMessageDialog(null, "Rellena los huecos con valores validos","ERROR",JOptionPane.ERROR_MESSAGE);
			Login.log.log(Level.FINER,"Error en el formato del numero update compra entradas");
		}
	}
	
} 