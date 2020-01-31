package ventanas;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import gestionBD.Conexion;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JCheckBox;
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
import javax.swing.JSpinner;

public class Pagocamping {

	private JFrame frame;
	private int limiteTarjeta =16;
	private int limiteCCV=3;
	private int limiteDNI=8;
	private static final String EMAIL_PATTERN = 
		    "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private ButtonGroup btngroup;
	private JRadioButton rdbtnTiendaPequea;
	private JRadioButton rdbtnTiendaMediana;
	private JRadioButton rdbtnTiendaGrande;
	private JRadioButton rdbtnCapsula;
	private JTextField textField;
	static int x = 0;
	private JCheckBox chckbxColchones;
	private JCheckBox chckbxAccesoADuchas;
	private JCheckBox chckbxComedor;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_9;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pagocamping window = new Pagocamping();
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
	public Pagocamping() {
		super();
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 656, 646);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Rellena los siguientes datos para validar el pago del camping");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(58, 16, 555, 35);
		frame.getContentPane().add(lblNewLabel);
		
		SpinnerModel sm = new SpinnerNumberModel(1, 1, 9, 1);
		
		JSpinner spinner = new JSpinner(sm);
		spinner.setBounds(255, 344, 32, 26);
		frame.getContentPane().add(spinner);
		
		JLabel lblCamping = new JLabel("Camping:");
		lblCamping.setBounds(35, 67, 69, 20);
		frame.getContentPane().add(lblCamping);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(119, 67, 168, 26);
		frame.getContentPane().add(comboBox);
		
		textField_2 = new JTextField();
		textField_2.setBounds(9, 227, 146, 26);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		textField_2.setVisible(false);
		
		textField_9 = new JTextField();
		textField_9.setBounds(327, 227, 146, 26);
		frame.getContentPane().add(textField_9);
		textField_9.setColumns(10);
		textField_9.setVisible(false);
		
		JButton btnSeleccion = new JButton("Seleccion");
		btnSeleccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					StringTokenizer st = new StringTokenizer(comboBox.getSelectedItem().toString());
					while(st.hasMoreTokens()) {
						textField_3.setText(st.nextToken().toString());
						textField_4.setText(st.nextToken().toString());
					}
					}catch(Exception e5) {
						JOptionPane.showMessageDialog(null, "Cargar los conciertos primero","ERROR",JOptionPane.ERROR_MESSAGE);
					}
			}
		});
		btnSeleccion.setBounds(302, 67, 115, 29);
		frame.getContentPane().add(btnSeleccion);
		
		JButton btnCargarCampings = new JButton("Cargar campings");
		btnCargarCampings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conexion conexion3 = new Conexion();
				Connection cn3 = conexion3.conectar();
				String query = "SELECT NOMBRE1,AFORO FROM CAMPING";
				
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
			}
		});
		btnCargarCampings.setBounds(432, 67, 168, 29);
		frame.getContentPane().add(btnCargarCampings);
		
		JLabel lblCampingSeleccionado = new JLabel("Camping seleccionado:");
		lblCampingSeleccionado.setBounds(35, 109, 165, 20);
		frame.getContentPane().add(lblCampingSeleccionado);
		
		JLabel lblAforoRestante = new JLabel("Aforo restante:");
		lblAforoRestante.setBounds(35, 145, 120, 20);
		frame.getContentPane().add(lblAforoRestante);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(35, 389, 69, 20);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblN = new JLabel("Numero tarjeta:");
		lblN.setBounds(35, 425, 120, 20);
		frame.getContentPane().add(lblN);
		
		JLabel lblCcv = new JLabel("CCV:");
		lblCcv.setBounds(35, 461, 69, 20);
		frame.getContentPane().add(lblCcv);
		
		textField = new JTextField();
		textField.setBounds(423, 344, 115, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(405, 145, 146, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		textField_1.setVisible(false);
		
		JLabel lblDniCliente = new JLabel("DNI Cliente:");
		lblDniCliente.setBounds(35, 497, 99, 20);
		frame.getContentPane().add(lblDniCliente);
		
		textField_3 = new JTextField();
		textField_3.setBounds(244, 109, 264, 26);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		textField_3.setEditable(false);
		
		textField_4 = new JTextField();
		textField_4.setBounds(244, 145, 146, 26);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		textField_4.setEditable(false);
		
		textField_5 = new JTextField();
		textField_5.setBounds(243, 383, 316, 26);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(243, 422, 191, 26);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		textField_6.addKeyListener(new KeyListener(){

			public void keyTyped(KeyEvent e){
				char c= e.getKeyChar();
				if (textField_6.getText().length()== limiteTarjeta | !Character.isDigit(c))

			     e.consume();

			}

			public void keyPressed(KeyEvent arg0) {
			}

			public void keyReleased(KeyEvent arg0) {
			}
			});
		
		textField_7 = new JTextField();
		textField_7.setBounds(243, 458, 115, 26);
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		textField_7.addKeyListener(new KeyListener(){


			public void keyTyped(KeyEvent e)

			{
				char c=e.getKeyChar();
				if (textField_7.getText().length()== limiteCCV| !Character.isDigit(c)) {

			     e.consume();}
			}

			public void keyPressed(KeyEvent arg0) {
			}

			public void keyReleased(KeyEvent arg0) {
			}
			});
		
		textField_8 = new JTextField();
		textField_8.setBounds(243, 494, 158, 26);
		frame.getContentPane().add(textField_8);
		textField_8.setColumns(10);
		textField_8.addKeyListener(new KeyListener(){


			public void keyTyped(KeyEvent e)

			{
				char c=e.getKeyChar();
				if (textField_8.getText().length()== limiteDNI| !Character.isDigit(c)) {

			     e.consume();}
			}

			public void keyPressed(KeyEvent arg0) {
			}

			public void keyReleased(KeyEvent arg0) {
			}
			});
		
		JRadioButton rdbtnTiendaPequea = new JRadioButton("Tienda peque\u00F1a");
		rdbtnTiendaPequea.setBounds(478, 183, 155, 29);
		frame.getContentPane().add(rdbtnTiendaPequea);
		rdbtnTiendaPequea.setSelected(true);
		
		JRadioButton rdbtnTiendaMediana = new JRadioButton("Tienda mediana");
		rdbtnTiendaMediana.setBounds(478, 226, 155, 29);
		frame.getContentPane().add(rdbtnTiendaMediana);
		
		JRadioButton rdbtnTiendaGrande = new JRadioButton("Tienda grande");
		rdbtnTiendaGrande.setBounds(478, 263, 155, 29);
		frame.getContentPane().add(rdbtnTiendaGrande);
		
		JRadioButton rdbtnCapsula = new JRadioButton("Capsula");
		rdbtnCapsula.setBounds(478, 300, 155, 29);
		frame.getContentPane().add(rdbtnCapsula);
		
		btngroup = new ButtonGroup();
		btngroup.add(rdbtnTiendaPequea);
		btngroup.add(rdbtnTiendaMediana);
		btngroup.add(rdbtnTiendaGrande);
		btngroup.add(rdbtnCapsula);
		
		JLabel lblTipoDeTienda = new JLabel("Tipo de tienda:");
		lblTipoDeTienda.setBounds(348, 187, 119, 20);
		frame.getContentPane().add(lblTipoDeTienda);
		
		JLabel lblExtras = new JLabel("Extras:");
		lblExtras.setBounds(35, 181, 69, 20);
		frame.getContentPane().add(lblExtras);
		
		JCheckBox chckbxColchones = new JCheckBox("Colchones");
		chckbxColchones.setBounds(148, 177, 139, 29);
		frame.getContentPane().add(chckbxColchones);
		
		JCheckBox chckbxAccesoADuchas = new JCheckBox("Acceso a duchas");
		chckbxAccesoADuchas.setBounds(148, 226, 168, 29);
		frame.getContentPane().add(chckbxAccesoADuchas);
		
		JCheckBox chckbxComedor = new JCheckBox("Comedor");
		chckbxComedor.setBounds(148, 273, 139, 29);
		frame.getContentPane().add(chckbxComedor);
		
		JButton btnVolverAlMenu = new JButton("Volver al menu");
		btnVolverAlMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd20 = e.getActionCommand();

		        if(cmd20.equals("Open20"))
		        {
		            frame.dispose();
		            new Menu();
		        }
			}
		});
		btnVolverAlMenu.setBounds(15, 545, 140, 29);
		frame.getContentPane().add(btnVolverAlMenu);
		btnVolverAlMenu.setActionCommand("Open20");
		
		JButton btnPagar = new JButton("Pagar");
		btnPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre;
				String aforo;
				aforo = textField_4.getText();
				nombre = textField_3.getText();
				int numero1 = Integer.parseInt(aforo);
				String email;
				String tipotienda = "";
				String extras = "";
				String valor1;
				email = textField_5.getText();
				valor1 = textField.getText();
				int valor = Integer.parseInt(valor1);
				
				
				if(rdbtnTiendaPequea.isSelected()) {
					textField_9.setText("Tienda pequeña");
				}else if(rdbtnTiendaMediana.isSelected()) {
					textField_9.setText("Tienda mediana");
				}else if(rdbtnTiendaGrande.isSelected()) {
					textField_9.setText("Tienda grande");
				}else if(rdbtnCapsula.isSelected()) {
					textField_9.setText("Capsula");
				}
				
				if(chckbxColchones.isSelected()) {
					extras = extras+"Colchones, ";
				}
				if(chckbxAccesoADuchas.isSelected()) {
					extras = extras+"Acesso a las duchas, ";
				}
				if(chckbxComedor.isSelected()) {
					extras = extras+"Acesso al comedor. ";
				}else{
					extras = "No hay extras";
					
				}
				textField_2.setText(extras);
				String[] opciones = {"Comprar camping solo", "Comprar ticket en conjunto con la entrada","Cancelar la operacion"};
				String confirmacion = "¿Estas seguro de que quieres comprar una plaza de camping de "+textField_3.getText()+" con los siguientes extras: "+textField_2.getText()+" y con la tienda: "+textField_9.getText()+" en vez de comprar una ticket conjunto con la entrada?";
				int respuesta = JOptionPane.showOptionDialog( null, confirmacion, "¿Estas seguro?", JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
				switch(respuesta) {
				case 0:
					
					if(numero1==0) {
						JOptionPane.showMessageDialog(null, "Las plazas de camping estan agotadas","ERROR", JOptionPane.ERROR_MESSAGE);
						Login.log.log(Level.FINER,"Entradas agotadas: " + nombre);
					}else if (!email.matches(EMAIL_PATTERN)) {
						JOptionPane.showMessageDialog(null, "Email no valido", "ERROR", JOptionPane.ERROR_MESSAGE);
					}else if(numero1<valor) {
						JOptionPane.showMessageDialog(null, "No hay plazas de camping suficientes","ERROR",JOptionPane.ERROR_MESSAGE);
					}else {
						if(numero1 >0) {
					comprarcampingsql();
					comprarcamping(x);
						}else {
							JOptionPane.showMessageDialog(null, "No se ha podidio realizar la compra","ERROR",JOptionPane.ERROR_MESSAGE);
							Login.log.log(Level.FINER,"No se ha podido realizar la compra");
						}
					}
					break;
				case 1:
					frame.dispose();
					new Pagoentradaycamping();
					break;
				case 2:
					JOptionPane.showMessageDialog(null, "Se ha cancelado la operacion");
					break;
				default:
					break;
				}
				
			}
		});
		btnPagar.setBounds(170, 545, 115, 29);
		frame.getContentPane().add(btnPagar);
		
		JLabel lblNDeCampings = new JLabel("N\u00BA de campings que quieres comprar:");
		lblNDeCampings.setBounds(35, 347, 279, 20);
		frame.getContentPane().add(lblNDeCampings);
		
		JButton btnSeleccion_1 = new JButton("Seleccion:");
		btnSeleccion_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(spinner.getValue().toString());
				
			}});
		btnSeleccion_1.setBounds(302, 343, 115, 29);
		frame.getContentPane().add(btnSeleccion_1);
	}
	public void comprarcampingsql() {
		Conexion conexion5 = new Conexion();
		Connection cn5 = conexion5.conectar();
		String nombre1;
		String aforo;
		String valor1;
		String aforo2;
		String aforo1;
		aforo1 = textField_4.getText();
		nombre1 = textField_3.getText();
		valor1 = textField.getText();
		int valor = Integer.parseInt(valor1);
		int numero1 = Integer.parseInt(aforo1);
		int campings = numero1-valor;
		aforo2 = String.valueOf(campings);
		textField_1.setText(aforo2);
		aforo = textField_1.getText();
		
		try {
			String sql = "UPDATE camping SET aforo = ? WHERE NOMBRE1 = ?";
			PreparedStatement pst2 = cn5.prepareStatement(sql);
			pst2.setString(1, aforo);
			pst2.setString(2, nombre1);
			int n = pst2.executeUpdate();
			if(n>0) {
				Login.log.log(Level.FINER,"Campings comprado/os: "+valor1 + nombre1);
			}
		}catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}
	public void comprarcamping(int x) {
		String aforo;
		String valor1;
		aforo = textField_4.getText();
		int numero1 = Integer.parseInt(aforo);
		valor1 =  textField.getText();
		int valor = Integer.parseInt(valor1);
		
		String dni;
		String camping;
		String email;
		String tipotienda;
		String extras;
		
		dni = textField_8.getText();
		camping = textField_3.getText();
		email = textField_5.getText();
		tipotienda = textField_9.getText();
		extras = textField_2.getText();
		
		if(x==valor) {
			JOptionPane.showMessageDialog(null, "Camping/s comprado/os");
			
			frame.dispose();
			new Menu();
		}else {
				try{
					FileWriter archivo = new FileWriter("C:\\Users\\jaime\\eclipse-workspace\\proyecto program 3\\TicketsAdmin\\camping"+camping+".txt", true);
		
					PrintWriter escribir = new PrintWriter(archivo);
		
					String cadena = "-Dni:"+dni+", Camping:"+camping+", Email:"+email+", Tienda:"+tipotienda+", Extras:"+extras;
					escribir.print(cadena);
		
					archivo.close();
					Login.log.log(Level.FINER,"Fichero creado de camping: "+camping );
				}catch(IOException e6) {
					e6.printStackTrace();
				}
				try{
					FileWriter archivo = new FileWriter("C:\\Users\\jaime\\eclipse-workspace\\proyecto program 3\\Tickets\\Camping\\camping"+dni+".txt", true);
		
					PrintWriter escribir = new PrintWriter(archivo);
		
					String cadena = "-Dni:"+dni+", Camping:"+camping+", Email:"+email+", Tienda:"+tipotienda+", Extras:"+extras;
					escribir.print(cadena);
		
					archivo.close();
					Login.log.log(Level.FINER,"Fichero creado de camping: "+camping );
				}catch(IOException e6) {
					e6.printStackTrace();
				}
				try{
					FileWriter archivo = new FileWriter("C:\\Users\\jaime\\eclipse-workspace\\proyecto program 3\\TicketsProperties\\camping.txt", true);
		
					PrintWriter escribir = new PrintWriter(archivo);
		
					String cadena = "Nºcampings:"+valor+" camping/s"+'\n'+"Dni:"+dni+'\n'+"Camping:"+camping+'\n'+"Email:"+email+'\n'+"Tienda:"+tipotienda+'\n'+"Extras:"+extras+'\n';
					escribir.print(cadena);
		
					archivo.close();
					Login.log.log(Level.FINER,"Fichero creado de camping: "+camping );
				}catch(IOException e6) {
					e6.printStackTrace();
				}
			x++;
			comprarcamping(x);
		}
		
	}
}
