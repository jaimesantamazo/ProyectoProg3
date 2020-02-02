package ventanas;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import gestionBD.Conexion;

import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;

public class Pagoentradaycamping {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private static final String EMAIL_PATTERN = 
		    "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private JTextField textField_10;
	static int x = 0;
	private JTextField textField_12;
	private JTextField textField_13;
	private int limiteTarjeta =16;
	private int limiteCCV=3;
	private int limiteDNI=8;
	private ButtonGroup botongrupo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pagoentradaycamping window = new Pagoentradaycamping();
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
	public Pagoentradaycamping() {
		super();
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 958, 641);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JCheckBox chckbxColchones = new JCheckBox("Colchones");
		chckbxColchones.setBounds(721, 287, 139, 29);
		frame.getContentPane().add(chckbxColchones);
		
		JCheckBox chckbxAccesoADuchas = new JCheckBox("Acceso a duchas");
		chckbxAccesoADuchas.setBounds(721, 324, 166, 29);
		frame.getContentPane().add(chckbxAccesoADuchas);
		
		JCheckBox chckbxComedor = new JCheckBox("Comedor");
		chckbxComedor.setBounds(721, 361, 139, 29);
		frame.getContentPane().add(chckbxComedor);
		
		JLabel lblTipoDeTienda = new JLabel("Tipo de tienda:");
		lblTipoDeTienda.setBounds(600, 422, 122, 20);
		frame.getContentPane().add(lblTipoDeTienda);
		
		JRadioButton rdbtnTiendaPequea = new JRadioButton("Tienda peque\u00F1a");
		rdbtnTiendaPequea.setBounds(721, 418, 155, 29);
		frame.getContentPane().add(rdbtnTiendaPequea);
		rdbtnTiendaPequea.setSelected(true);
		
		JRadioButton rdbtnTiendaMediana = new JRadioButton("Tienda mediana");
		rdbtnTiendaMediana.setBounds(721, 454, 155, 29);
		frame.getContentPane().add(rdbtnTiendaMediana);
		
		JRadioButton rdbtnTiendaGrande = new JRadioButton("Tienda grande");
		rdbtnTiendaGrande.setBounds(721, 490, 155, 29);
		frame.getContentPane().add(rdbtnTiendaGrande);
		
		JRadioButton rdbtnCapsula = new JRadioButton("Capsula");
		rdbtnCapsula.setBounds(721, 527, 155, 29);
		frame.getContentPane().add(rdbtnCapsula);
		
		botongrupo = new ButtonGroup();
		botongrupo.add(rdbtnTiendaPequea);
		botongrupo.add(rdbtnTiendaMediana);
		botongrupo.add(rdbtnTiendaGrande);
		botongrupo.add(rdbtnCapsula);
		
		SpinnerModel sm = new SpinnerNumberModel(1, 1, 9, 1);
		SpinnerModel sm1 = new SpinnerNumberModel(1, 1, 9, 1);
		
		JLabel lblRellenaLosDatos = new JLabel("Rellena los datos para validar el pago de las entradas y el camping conjunto");
		lblRellenaLosDatos.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRellenaLosDatos.setBounds(116, 16, 697, 37);
		frame.getContentPane().add(lblRellenaLosDatos);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(137, 112, 177, 26);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(721, 112, 177, 26);
		frame.getContentPane().add(comboBox_1);
		
		JLabel lblConciertos = new JLabel("Conciertos:");
		lblConciertos.setBounds(31, 115, 91, 20);
		frame.getContentPane().add(lblConciertos);
		
		JLabel lblCamping = new JLabel("Camping:");
		lblCamping.setBounds(637, 115, 69, 20);
		frame.getContentPane().add(lblCamping);
		
		JButton btnNewButton = new JButton("Cargar eventos y campings\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Conexion conexion3 = new Conexion();
				Connection cn3 = conexion3.conectar();
				String query = "SELECT NOMBRE,CANTIDAD FROM ENTRADAS";
				String query1 = "SELECT NOMBRE1,AFORO FROM CAMPING";
				
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
				}
				try {
					java.sql.Statement stmt1 = cn3.createStatement();
					ResultSet rs1 = stmt1.executeQuery(query1);
				while(rs1.next())
				{
					comboBox_1.addItem(rs1.getString(1)+" "+rs1.getString(2));
				}
					rs1.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(365, 84, 239, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnSeleccion = new JButton("Seleccion");
		btnSeleccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					StringTokenizer st = new StringTokenizer(comboBox.getSelectedItem().toString());
					while(st.hasMoreTokens()) {
						textField.setText(st.nextToken().toString());
						textField_1.setText(st.nextToken().toString());
					}
					}catch(Exception e5) {
						JOptionPane.showMessageDialog(null, "Cargar los conciertos y campings primero","ERROR",JOptionPane.ERROR_MESSAGE);
					}
				try {
					StringTokenizer st1 = new StringTokenizer(comboBox_1.getSelectedItem().toString());
					while(st1.hasMoreTokens()) {
						textField_6.setText(st1.nextToken().toString());
						textField_7.setText(st1.nextToken().toString());
					}
					}catch(Exception e5) {
						JOptionPane.showMessageDialog(null, "Cargar los campings primero","ERROR",JOptionPane.ERROR_MESSAGE);
					}
			
			}
		});
		btnSeleccion.setBounds(426, 129, 115, 29);
		frame.getContentPane().add(btnSeleccion);
		
		JLabel lblNewLabel = new JLabel("Concierto:");
		lblNewLabel.setBounds(31, 173, 91, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("N\u00BA entradas:");
		lblNewLabel_1.setBounds(31, 224, 91, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(137, 170, 177, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setEditable(false);
		
		textField_1 = new JTextField();
		textField_1.setBounds(137, 221, 177, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		textField_1.setEditable(false);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(31, 386, 69, 20);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblNTarjeta = new JLabel("N\u00BA tarjeta:");
		lblNTarjeta.setBounds(31, 422, 91, 20);
		frame.getContentPane().add(lblNTarjeta);
		
		JLabel lblCcv = new JLabel("CCV:");
		lblCcv.setBounds(31, 458, 69, 20);
		frame.getContentPane().add(lblCcv);
		
		JLabel lblDni = new JLabel("Dni:");
		lblDni.setBounds(31, 494, 69, 20);
		frame.getContentPane().add(lblDni);
		
		textField_2 = new JTextField();
		textField_2.setBounds(137, 383, 262, 26);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(137, 419, 205, 26);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		textField_3.addKeyListener(new KeyListener(){

			public void keyTyped(KeyEvent e){
				char c= e.getKeyChar();
				if (textField_3.getText().length()== limiteTarjeta | !Character.isDigit(c))

			     e.consume();

			}

			public void keyPressed(KeyEvent arg0) {
			}

			public void keyReleased(KeyEvent arg0) {
			}
			});
		
		textField_4 = new JTextField();
		textField_4.setBounds(137, 455, 128, 26);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		textField_4.addKeyListener(new KeyListener(){


			public void keyTyped(KeyEvent e)

			{
				char c=e.getKeyChar();
				if (textField_4.getText().length()== limiteCCV| !Character.isDigit(c)) {

			     e.consume();}
			}

			public void keyPressed(KeyEvent arg0) {
			}

			public void keyReleased(KeyEvent arg0) {
			}
			});
		
		textField_5 = new JTextField();
		textField_5.setBounds(137, 491, 146, 26);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		textField_5.addKeyListener(new KeyListener(){


			public void keyTyped(KeyEvent e)

			{
				char c=e.getKeyChar();
				if (textField_5.getText().length()== limiteDNI| !Character.isDigit(c)) {

			     e.consume();}
			}

			public void keyPressed(KeyEvent arg0) {
			}

			public void keyReleased(KeyEvent arg0) {
			}
			});
		
		JLabel lblCamping_1 = new JLabel("Camping:");
		lblCamping_1.setBounds(637, 173, 69, 20);
		frame.getContentPane().add(lblCamping_1);
		
		JLabel lblAforoRestante = new JLabel("Aforo restante:");
		lblAforoRestante.setBounds(599, 224, 107, 20);
		frame.getContentPane().add(lblAforoRestante);
		
		textField_6 = new JTextField();
		textField_6.setBounds(721, 170, 177, 26);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		textField_6.setEditable(false);
		
		textField_7 = new JTextField();
		textField_7.setBounds(721, 221, 177, 26);
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		textField_7.setEditable(false);
		
		JLabel lblExtras = new JLabel("Extras:");
		lblExtras.setBounds(657, 291, 49, 20);
		frame.getContentPane().add(lblExtras);
		
		
		JLabel lblNDeEntradas = new JLabel("N\u00BA de entradas conjuntas que quieres comprar:");
		lblNDeEntradas.setBounds(15, 310, 272, 20);
		frame.getContentPane().add(lblNDeEntradas);
		
		JSpinner spinner = new JSpinner(sm);
		spinner.setBounds(292, 307, 32, 26);
		frame.getContentPane().add(spinner);
		
		JButton btnNewButton_1 = new JButton("Volver al menu");
		btnNewButton_1.setActionCommand("Open20");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd20 = e.getActionCommand();

		        if(cmd20.equals("Open20"))
		        {
		            frame.dispose();
		            new Menu();
		        }
			}
		});
		btnNewButton_1.setBounds(15, 540, 158, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnPagar = new JButton("Pagar");
		btnPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String nombre;
				String cantidadentradas;
				String numentradas;
				String cantidadfinal;
				String email;
				
				cantidadentradas = textField_1.getText();
				nombre = textField.getText();
				numentradas =  textField_8.getText();
				int valor = Integer.parseInt(numentradas);
				int numero1 = Integer.parseInt(cantidadentradas);
				int entradas = numero1-valor;
				cantidadfinal = String.valueOf(entradas);
				textField_10.setText(cantidadfinal);
				email = textField_2.getText();
				String aforo;
				String numcampings;
				String aforofinal;
				aforo = textField_7.getText();
				numcampings = textField_8.getText();
				int valor1 = Integer.parseInt(numcampings);
				int numero2 = Integer.parseInt(aforo);
				int campings = numero2-valor1;
				aforofinal = String.valueOf(campings);
				textField_10.setText(aforofinal);
				
				String tipotienda = "";
				String extras = "";
				
				if(rdbtnTiendaPequea.isSelected()) {
					textField_13.setText("Tienda pequeña");
				}else if(rdbtnTiendaMediana.isSelected()) {
					textField_13.setText("Tienda mediana");
				}else if(rdbtnTiendaGrande.isSelected()) {
					textField_13.setText("Tienda grande");
				}else if(rdbtnCapsula.isSelected()) {
					textField_13.setText("Capsula");
				}
				
				if(chckbxColchones.isSelected()) {
					extras = extras+"Colchones, ";
				}
				if(chckbxAccesoADuchas.isSelected()) {
					extras = extras+"Acesso a las duchas, ";
				}
				if(chckbxComedor.isSelected()) {
					extras = extras+"Acesso al comedor. ";
				}
				if(!chckbxColchones.isSelected()&&!chckbxAccesoADuchas.isSelected()&&!chckbxComedor.isSelected()) {
					extras = "No hay extras";
				}
					
				
				textField_12.setText(extras);
			
				String[] opciones = {"SI", "NO"};
				String confirmacion = "¿Estas seguro de que quieres comprar un abono del concierto: "+textField.getText()+" y con el camping: "+textField_6.getText()+" con la tienda: "+textField_13.getText()+" y los extras: "+textField_12.getText();
				int respuesta = JOptionPane.showOptionDialog( null, confirmacion, "¿Estas seguro?", JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
				switch (respuesta) {
				case 0:
					if(numero1==0) {
						JOptionPane.showMessageDialog(null, "Las entradas estan agotadas","ERROR", JOptionPane.ERROR_MESSAGE);
						Login.log.log(Level.FINER,"Entradas agotadas: " + nombre);
					}else if(numero2 == 0) {
						JOptionPane.showMessageDialog(null, "Las plazas del camping estan agotadas","ERROR", JOptionPane.ERROR_MESSAGE);
						Login.log.log(Level.FINER,"Plazas de camping agotadas: " + nombre);
					}else if (!email.matches(EMAIL_PATTERN)) {
						JOptionPane.showMessageDialog(null, "Email no valido", "ERROR", JOptionPane.ERROR_MESSAGE);
					}else if(numero1<valor) {
						JOptionPane.showMessageDialog(null, "No hay entradas suficientes","ERROR",JOptionPane.ERROR_MESSAGE);
					}else if(numero2<valor) {
						JOptionPane.showMessageDialog(null, "No hay plazas de camping suficientes","ERROR",JOptionPane.ERROR_MESSAGE);
					}else if(textField_8.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Rellena todos los huecos","ERROR",JOptionPane.ERROR_MESSAGE);
					}else if(textField_2.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Rellena todos los huecos","ERROR",JOptionPane.ERROR_MESSAGE);
					}else if(textField_3.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Rellena todos los huecos","ERROR",JOptionPane.ERROR_MESSAGE);
					}else if(textField_4.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Rellena todos los huecos","ERROR",JOptionPane.ERROR_MESSAGE);
					}else if(textField_5.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Rellena todos los huecos","ERROR",JOptionPane.ERROR_MESSAGE);
					}else {
						if(numero1>0 && numero2>0) {
						comprarentradassql2();
						comprarcampingsql2();
						comprarentradasycamping(x);
						}else {
							JOptionPane.showMessageDialog(null, "No se ha podidio realizar la compra","ERROR",JOptionPane.ERROR_MESSAGE);
						}
					}
					break;
				case 1:
					JOptionPane.showMessageDialog(null, "Has cancelado la operacion");
					break;
				default:
					break;
				}
			}catch(NullPointerException e10) {
				JOptionPane.showMessageDialog(null, "Rellena todos los campos para completar el pago","ERROR",JOptionPane.ERROR_MESSAGE);
			}catch(NumberFormatException e20) {
				JOptionPane.showMessageDialog(null, "Rellena los huecos con valores validos","ERROR",JOptionPane.ERROR_MESSAGE);
			}
			}
			});
		btnPagar.setBounds(188, 540, 115, 29);
		frame.getContentPane().add(btnPagar);
		
		JButton btnNewButton_2 = new JButton("Seleccion:");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_8.setText(spinner.getValue().toString());
				
			}});
		btnNewButton_2.setBounds(328, 306, 115, 29);
		frame.getContentPane().add(btnNewButton_2);
		
		textField_8 = new JTextField();
		textField_8.setBounds(458, 307, 146, 26);
		frame.getContentPane().add(textField_8);
		textField_8.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(615, 307, 39, 26);
		frame.getContentPane().add(textField_10);
		textField_10.setColumns(10);
		textField_10.setVisible(false);
		
		textField_12 = new JTextField();
		textField_12.setBounds(842, 362, 56, 26);
		frame.getContentPane().add(textField_12);
		textField_12.setColumns(10);
		textField_12.setVisible(false);
		
		textField_13 = new JTextField();
		textField_13.setBounds(860, 455, 49, 26);
		frame.getContentPane().add(textField_13);
		textField_13.setColumns(10);
		textField_13.setVisible(false);
	}
	public void comprarentradassql2() {
		Conexion conexion5 = new Conexion();
		Connection cn5 = conexion5.conectar();
		String nombre;
		String cantidadentradas;
		String numentradas;
		String cantidadrestantes;
		String cantidadfinal;
		cantidadentradas = textField_1.getText();
		nombre = textField.getText();
		numentradas =  textField_8.getText();
		int valor = Integer.parseInt(numentradas);
		int numero1 = Integer.parseInt(cantidadentradas);
		int entradas = numero1-valor;
		cantidadfinal = String.valueOf(entradas);
		textField_10.setText(cantidadfinal);
		cantidadrestantes = textField_10.getText();
		try {
			String sql = "UPDATE ENTRADAS SET cantidad = ? WHERE NOMBRE = ?";
			PreparedStatement pst2 = cn5.prepareStatement(sql);
			pst2.setString(1, cantidadrestantes);
			pst2.setString(2, nombre);
			int n = pst2.executeUpdate();
			if(n>0) {
				Login.log.log(Level.FINER,"Entrada comprada/as: "+numentradas + nombre);
			}
		}catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	public void comprarcampingsql2() {
		try {
		Conexion conexion5 = new Conexion();
		Connection cn5 = conexion5.conectar();
		String nombre1;
		String aforo;
		String numcampings;
		String afororestante;
		String aforofinal;
		aforo = textField_7.getText();
		nombre1 = textField_6.getText();
		numcampings = textField_8.getText();
		int valor1 = Integer.parseInt(numcampings);
		int numero2 = Integer.parseInt(aforo);
		int campings = numero2-valor1;
		aforofinal = String.valueOf(campings);
		textField_10.setText(aforofinal);
		afororestante = textField_10.getText();
		
		try {
			String sql = "UPDATE camping SET aforo = ? WHERE NOMBRE1 = ?";
			PreparedStatement pst2 = cn5.prepareStatement(sql);
			pst2.setString(1, afororestante);
			pst2.setString(2, nombre1);
			int n = pst2.executeUpdate();
			if(n>0) {
				Login.log.log(Level.FINER,"Campings comprado/os: "+valor1 + nombre1);
			}
		}catch (SQLException e1) {
			e1.printStackTrace();
		}
		}catch(NumberFormatException e20) {
			JOptionPane.showMessageDialog(null, "Rellena los huecos con valores validos","ERROR",JOptionPane.ERROR_MESSAGE);
		}
	}
public void comprarentradasycamping(int x) {
		try {
		String valor1;
		valor1 =  textField_8.getText();
		int valor = Integer.parseInt(valor1);
		String tipotienda;
		String extras;
		String dni;
		String concierto;
		String email;
		String camping;
		tipotienda = textField_13.getText();
		extras = textField_12.getText();
		camping = textField_6.getText();
		dni = textField_5.getText();
		concierto = textField.getText();
		email = textField_2.getText();
				if(x==valor) {
					JOptionPane.showMessageDialog(null, "Entrada/as y camping/s comprados");
					
					frame.dispose();
					new Menu();
				}else {
						try{
							FileWriter archivo = new FileWriter("C:\\Users\\jaime\\eclipse-workspace\\proyecto program 3\\TicketsAdmin\\entrada+camping"+concierto+".txt", true);
				
							PrintWriter escribir = new PrintWriter(archivo);
				
							String cadena = "-Dni:"+dni+", Camping:"+camping+", Concierto:"+concierto+", Email:"+email+", Tienda:"+tipotienda+", Extras:"+extras;
							escribir.print(cadena);
				
							archivo.close();	
						}catch(IOException e6) {
							e6.printStackTrace();
						}
						try{
							FileWriter archivo = new FileWriter("C:\\Users\\jaime\\eclipse-workspace\\proyecto program 3\\Tickets\\Entrada+camping\\entrada+camping"+dni+".txt", true);
				
							PrintWriter escribir = new PrintWriter(archivo);
				
							String cadena = "-Dni:"+dni+", Camping:"+camping+", Concierto:"+concierto+", Email:"+email+", Tienda:"+tipotienda+", Extras:"+extras;
							escribir.print(cadena);
				
							archivo.close();	
						}catch(IOException e6) {
							e6.printStackTrace();
						}
						try{
							FileWriter archivo = new FileWriter("C:\\Users\\jaime\\eclipse-workspace\\proyecto program 3\\TicketsProperties\\entrada+camping.txt", true);
				
							PrintWriter escribir = new PrintWriter(archivo);
				
							String cadena = "Nºcampingsconentradas:"+valor+" entrada/as con camping"+'\n'+"Dni:"+dni+'\n'+"Camping:"+camping+'\n'+"Concierto:"+concierto+'\n'+"Email:"+email+'\n'+"Tienda:"+tipotienda+'\n'+"Extras:"+extras+'\n';
							escribir.print(cadena);
				
							archivo.close();	
						}catch(IOException e6) {
							e6.printStackTrace();
						}
					x++;
					comprarentradasycamping(x);
				}
		}catch(NumberFormatException e20) {
			JOptionPane.showMessageDialog(null, "Rellena los huecos con valores validos","ERROR",JOptionPane.ERROR_MESSAGE);
		}
		}
}
