package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListModel;

import com.mysql.jdbc.Statement;
import com.toedter.calendar.JDateChooser;

import clasesbasicas.Entradas;
import gestionBD.Conexion;
import gestionBD.Gestionentradas;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.border.BevelBorder;

public class Gestion {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_5;
	ArrayList<String> conciertos = new ArrayList<String>();
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gestion window = new Gestion();
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
	public Gestion() {
		super();
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 899, 637);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblGestion = new JLabel("Gestion de eventos");
		lblGestion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGestion.setBounds(99, 25, 179, 20);
		frame.getContentPane().add(lblGestion);
		
		DefaultListModel<String> listmodel = new DefaultListModel<String>();
		JList<String> list = new JList<String>(listmodel);
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		list.setFixedCellWidth(10);
		list.setBounds(322, 79, 540, 486);
		frame.getContentPane().add(list);
		
		JButton btnAadirEvento = new JButton("A\u00F1adir evento");
		btnAadirEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				añadirentradas(listmodel);
			}

			private void añadirentradas(DefaultListModel<String> listmodel) {
				Conexion conexion1 = new Conexion();
				Connection cn1 = conexion1.conectar();
				String codigo;
				String nombre;
				String precio;
				String fecha_ini;
				String fecha_fin;
				String cantidad;
				
				String sql1 = "";
				codigo = textField.getText();
				nombre = textField_1.getText();
				precio = textField_2.getText();
				fecha_ini = textField_3.getText();
				fecha_fin = textField_4.getText();
				cantidad = textField_5.getText();
				sql1 = "INSERT INTO entradas (codigo, nombre, precio, fecha_ini, fecha_fin, cantidad) VALUES(?,?,?,?,?,?)";
		
				
				Gestionentradas gestionentradas = new Gestionentradas();
				Entradas entradas2 = new Entradas();
				entradas2.setCodigo(codigo);
				Entradas entra = gestionentradas.obtenerentradas(entradas2);
					
				if(entra!=null) {
					JOptionPane.showMessageDialog(null, "Codigo no valido", "ERROR", JOptionPane.ERROR_MESSAGE);
				}else{
					try {
						PreparedStatement pst1 = cn1.prepareStatement(sql1);
						pst1.setString(1, codigo);
						pst1.setString(2, nombre);
						pst1.setString(3, precio);
						pst1.setString(4, fecha_ini);
						pst1.setString(5, fecha_fin);
						pst1.setString(6, cantidad);
						
						int n = pst1.executeUpdate();
						if(n>0) {
							
							JOptionPane.showMessageDialog(null, "Evento registrado");
							conciertos.add(textField_1.getText());
							if(!textField.getText().isEmpty() && !textField_1.getText().isEmpty() && !textField_2.getText().isEmpty() && !textField_3.getText().isEmpty() && !textField_4.getText().isEmpty() && !textField_5.getText().isEmpty()) {
								listmodel.addElement("cod:"+textField.getText()+","+"nom:"+textField_1.getText()+" ,"+"precio:"+textField_2.getText()+" ,"+"f.ini:"+textField_3.getText()+" ,"+"f.fin:"+textField_4.getText()+" ,"+"cant:"+textField_5.getText());
							}
							Login.log.log(Level.FINER,"Añadiendo eventos: " + nombre);
						}
						Conexion.cerrarBD(cn1, pst1);
					} catch (SQLException e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "Los datos no son validos"+e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
						Login.log.log(Level.FINER,"Error al meter los datos");
					}
				}
			}
		});
		btnAadirEvento.setBounds(13, 437, 120, 29);
		frame.getContentPane().add(btnAadirEvento);
		
		JButton btnEliminarEvento = new JButton("Eliminar evento");
		btnEliminarEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eliminarentradas(listmodel, list);
			}

			private void eliminarentradas(DefaultListModel<String> listmodel, JList<String> list) {
				Conexion conexion2 = new Conexion();
				Connection cn2 = conexion2.conectar();
				String codigo;
				String nombre;
				String precio;
				String fecha_ini;
				String fecha_fin;
				String cantidad;
				
				String sql2 = "";
				codigo = textField.getText();
				nombre = textField_1.getText();
				precio = textField_2.getText();
				fecha_ini = textField_3.getText();
				fecha_fin = textField_4.getText();
				cantidad = textField_5.getText();
	
				sql2 = "delete from entradas where codigo = ? and nombre = ? and precio = ? and fecha_ini = ? and fecha_fin = ? and cantidad = ?";
				try {
					PreparedStatement pst2 = cn2.prepareStatement(sql2);
					pst2.setString(1, codigo);
					pst2.setString(2, nombre);
					pst2.setString(3, precio);
					pst2.setString(4, fecha_ini);
					pst2.setString(5, fecha_fin);
					pst2.setString(6, cantidad);
					
					int n = pst2.executeUpdate();
					if(n>0) {
						JOptionPane.showMessageDialog(null, "Evento eliminado");
						conciertos.remove(textField_1.getText());
						int selectedindex = list.getSelectedIndex();
						if(selectedindex != -1) {
							listmodel.removeElementAt(selectedindex);
						}
						Login.log.log(Level.FINER,"Eliminar eventos: " + nombre);
					}
					Conexion.cerrarBD(cn2, pst2);
				} catch (SQLException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "No has podido eliminar el evento"+e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
					Login.log.log(Level.FINER,"Error al eliminar los datos");
				}
			}
		});
		btnEliminarEvento.setBounds(163, 437, 144, 29);
		frame.getContentPane().add(btnEliminarEvento);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(15, 99, 69, 20);
		frame.getContentPane().add(lblCodigo);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(15, 160, 69, 20);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblNewLabel = new JLabel("Precio:");
		lblNewLabel.setBounds(15, 218, 69, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblFechainicio = new JLabel("Fecha_inicio:");
		lblFechainicio.setBounds(15, 273, 105, 20);
		frame.getContentPane().add(lblFechainicio);
		
		JLabel lblFechafin = new JLabel("Fecha_fin:");
		lblFechafin.setBounds(15, 330, 89, 20);
		frame.getContentPane().add(lblFechafin);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(15, 385, 69, 20);
		frame.getContentPane().add(lblCantidad);
		
		textField = new JTextField();
		textField.setBounds(99, 96, 198, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.addKeyListener(new KeyListener(){

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
		
		textField_1 = new JTextField();
		textField_1.setBounds(99, 157, 198, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		textField_1.addKeyListener(new KeyListener(){

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
		
		textField_2 = new JTextField();
		textField_2.setBounds(99, 215, 198, 26);
		frame.getContentPane().add(textField_2);
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
		
		textField_5 = new JTextField();
		textField_5.setBounds(99, 382, 198, 26);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		textField_5.addKeyListener(new KeyListener(){

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
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 561, 402, -259);
		frame.getContentPane().add(scrollPane);
		
		JButton btnVueltaAlPago = new JButton("Vuelta al menu");
		btnVueltaAlPago.setActionCommand("Open30");
		btnVueltaAlPago.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				 if(cmd.equals("Open30"))
			        {
			            frame.dispose();
			            new MenuAdmin();
			            
			        }
			}
		});
		btnVueltaAlPago.setBounds(13, 536, 120, 29);
		frame.getContentPane().add(btnVueltaAlPago);
		
		Conexion conexion4 = new Conexion();
		Connection cn4 = conexion4.conectar();
		
		JButton btnCargarDatos = new JButton("Cargar conciertos");
		btnCargarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listmodel.clear();
				cargarentradas(listmodel, cn4);
			}
			
			private void cargarentradas(DefaultListModel<String> listmodel, Connection cn4) {
				String query = "SELECT CODIGO,NOMBRE,PRECIO,FECHA_INI,FECHA_FIN,CANTIDAD FROM ENTRADAS";
				try {
					java.sql.Statement stmt = cn4.createStatement();
					ResultSet rs = stmt.executeQuery(query);
				while(rs.next())
				{
					listmodel.addElement("cod:"+rs.getString(1)+" ,"+"nom:"+rs.getString(2)+" ,"+"precio:"+rs.getInt(3)+" ,"+"f.ini:"+rs.getString(4)+" ,"+"f.fin:"+rs.getString(5)+" ,"+"cant:"+rs.getInt(6));
				}
					rs.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
					Login.log.log(Level.FINER,"Error al cargar los datos");
				}
			}
		});
		btnCargarDatos.setBounds(163, 536, 144, 29);
		frame.getContentPane().add(btnCargarDatos);
		
		JLabel lblParaEliminarLos = new JLabel("Para eliminar los conciertos, ademas\r\n de marcarlo en la lista, tienes que \r\nescribir sus datos en los campos pertinentes");
		lblParaEliminarLos.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblParaEliminarLos.setBounds(312, 12, 565, 54);
		frame.getContentPane().add(lblParaEliminarLos);
		
		textField_3 = new JTextField();
		textField_3.setBounds(109, 270, 169, 26);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(109, 327, 169, 26);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnEditarLosEventos = new JButton("Editar los eventos");
		btnEditarLosEventos.setActionCommand("Open3000");
		btnEditarLosEventos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				 if(cmd.equals("Open3000"))
			        {
			            frame.dispose();
			            new Updateeventos();
			            
			        }
			}
		});
		btnEditarLosEventos.setBounds(73, 492, 157, 29);
		frame.getContentPane().add(btnEditarLosEventos);
	}
}
