package ventanas;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;

import com.toedter.calendar.JDateChooser;

import clasesbasicas.Camping;
import gestionBD.Conexion;
import gestionBD.Gestioncampingduplicado;

public class Gestioncamping {
	
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_5;
	ArrayList<String> campings = new ArrayList<String>();
	private JTextField textField_3;
	private JTextField textField_4;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gestioncamping window = new Gestioncamping();
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
	public Gestioncamping() {
		super();
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 899, 652);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblGestion = new JLabel("Gestion del camping");
		lblGestion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGestion.setBounds(632, 27, 192, 41);
		frame.getContentPane().add(lblGestion);
		
		DefaultListModel<String> listmodel = new DefaultListModel<String>();
		JList<String> list = new JList<String>(listmodel);
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		list.setFixedCellWidth(10);
		list.setBounds(15, 90, 528, 490);
		frame.getContentPane().add(list);
		
		JButton btnAadirEvento = new JButton("A\u00F1adir zona camping");
		btnAadirEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				añadircamping(listmodel);
			}

			private void añadircamping(DefaultListModel<String> listmodel) {
				Conexion conexion1 = new Conexion();
				Connection cn1 = conexion1.conectar();
				String codigo;
				String nombre1;
				String precio;
				String fecha_ini;
				String fecha_fin;
				String aforo;
				
				String sql1 = "";
				codigo = textField.getText();
				nombre1 = textField_1.getText();
				precio = textField_2.getText();
				fecha_ini = textField_3.getText();
				fecha_fin = textField_4.getText();
				aforo = textField_5.getText();
				sql1 = "INSERT INTO camping (codigo, nombre1, precio, fecha_ini, fecha_fin, aforo) VALUES(?,?,?,?,?,?)";
		
				
				Gestioncampingduplicado gestioncampingduplicado = new Gestioncampingduplicado();
				Camping camping1 = new Camping();
				camping1.setCodigo(codigo);
				Camping camp = gestioncampingduplicado.obtenercampingduplicado(camping1);
					
				if(camp!=null) {
					JOptionPane.showMessageDialog(null, "Codigo no valido", "ERROR", JOptionPane.ERROR_MESSAGE);
				}else{
					try {
						PreparedStatement pst1 = cn1.prepareStatement(sql1);
						pst1.setString(1, codigo);
						pst1.setString(2, nombre1);
						pst1.setString(3, precio);
						pst1.setString(4, fecha_ini);
						pst1.setString(5, fecha_fin);
						pst1.setString(6, aforo);
						
						int n = pst1.executeUpdate();
						if(n>0) {
							
							JOptionPane.showMessageDialog(null, "Camping registrado");
							campings.add(textField_1.getText());
							if(!textField.getText().isEmpty() && !textField_1.getText().isEmpty() && !textField_2.getText().isEmpty() && !textField_3.getText().isEmpty() && !textField_4.getText().isEmpty() && !textField_5.getText().isEmpty()) {
								listmodel.addElement("cod:"+textField.getText()+","+"nom:"+textField_1.getText()+" ,"+"precio:"+textField_2.getText()+" ,"+"f.ini:"+textField_3.getText()+" ,"+"f.fin:"+textField_4.getText()+" ,"+"aforo:"+textField_5.getText());
							}
							Login.log.log(Level.FINER,"Añadiendo camping: " + nombre1);
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
		btnAadirEvento.setBounds(599, 411, 225, 29);
		frame.getContentPane().add(btnAadirEvento);
		
		JButton btnEliminarEvento = new JButton("Eliminar zona camping");
		btnEliminarEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eliminarcamping(listmodel, list);
			}

			private void eliminarcamping(DefaultListModel<String> listmodel, JList<String> list) {
				Conexion conexion2 = new Conexion();
				Connection cn2 = conexion2.conectar();
				String codigo;
				String nombre1;
				String precio;
				String fecha_ini;
				String fecha_fin;
				String aforo;
				
				String sql2 = "";
				codigo = textField.getText();
				nombre1 = textField_1.getText();
				precio = textField_2.getText();
				fecha_ini = textField_3.getText();
				fecha_fin = textField_4.getText();
				aforo = textField_5.getText();
	
				sql2 = "delete from camping where codigo = ? and nombre1 = ? and precio = ? and fecha_ini = ? and fecha_fin = ? and aforo = ?";
				try {
					PreparedStatement pst2 = cn2.prepareStatement(sql2);
					pst2.setString(1, codigo);
					pst2.setString(2, nombre1);
					pst2.setString(3, precio);
					pst2.setString(4, fecha_ini);
					pst2.setString(5, fecha_fin);
					pst2.setString(6, aforo);
					
					int n = pst2.executeUpdate();
					if(n>0) {
						JOptionPane.showMessageDialog(null, "Camping eliminado");
						campings.remove(textField_1.getText());
						int selectedindex = list.getSelectedIndex();
						if(selectedindex != -1) {
							listmodel.removeElementAt(selectedindex);
						}
						Login.log.log(Level.FINER,"Eliminar camping: " + nombre1);
					}
					Conexion.cerrarBD(cn2, pst2);
				} catch (SQLException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "No has podido eliminar el camping"+e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
					Login.log.log(Level.FINER,"Error al eliminar los datos");
				}
			}
		});
		btnEliminarEvento.setBounds(599, 456, 225, 29);
		frame.getContentPane().add(btnEliminarEvento);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(558, 93, 69, 20);
		frame.getContentPane().add(lblCodigo);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(558, 148, 69, 20);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblNewLabel = new JLabel("Precio:");
		lblNewLabel.setBounds(558, 204, 69, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblFechainicio = new JLabel("Fecha_inicio:");
		lblFechainicio.setBounds(558, 260, 105, 20);
		frame.getContentPane().add(lblFechainicio);
		
		JLabel lblFechafin = new JLabel("Fecha_fin:");
		lblFechafin.setBounds(558, 305, 89, 20);
		frame.getContentPane().add(lblFechafin);
		
		JLabel lblCantidad = new JLabel("Aforo:");
		lblCantidad.setBounds(558, 363, 69, 20);
		frame.getContentPane().add(lblCantidad);
		
		textField = new JTextField();
		textField.setBounds(632, 93, 230, 26);
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
		textField_1.setBounds(632, 145, 230, 26);
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
		textField_2.setBounds(632, 201, 230, 26);
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
		textField_5.setBounds(632, 360, 230, 26);
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
		btnVueltaAlPago.setBounds(559, 551, 133, 29);
		frame.getContentPane().add(btnVueltaAlPago);
		
		Conexion conexion4 = new Conexion();
		Connection cn4 = conexion4.conectar();
		
		JButton btnCargarDatos = new JButton("Cargar campings");
		btnCargarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listmodel.clear();
				cargarcamping(listmodel, cn4);
			}

			private void cargarcamping(DefaultListModel<String> listmodel, Connection cn4) {
				String query = "SELECT CODIGO,NOMBRE1,PRECIO,FECHA_INI,FECHA_FIN,AFORO FROM CAMPING";
				try {
					java.sql.Statement stmt = cn4.createStatement();
					ResultSet rs = stmt.executeQuery(query);
				while(rs.next())
				{
					listmodel.addElement("cod:"+rs.getString(1)+" ,"+"nom:"+rs.getString(2)+" ,"+"precio:"+rs.getInt(3)+" ,"+"f.ini:"+rs.getString(4)+" ,"+"f.fin:"+rs.getString(5)+" ,"+"aforo:"+rs.getInt(6));
				}
					rs.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
					Login.log.log(Level.FINER,"Error al cargar los datos");
				}
			}
		});
		btnCargarDatos.setBounds(707, 551, 155, 29);
		frame.getContentPane().add(btnCargarDatos);
		
		JLabel lblParaEliminarLos = new JLabel("Para eliminar los campings, ademas\r\n de marcarlo en la lista, tienes que \r\nescribir sus datos en los campos pertinentes");
		lblParaEliminarLos.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblParaEliminarLos.setBounds(15, 12, 565, 54);
		frame.getContentPane().add(lblParaEliminarLos);
		
		textField_3 = new JTextField();
		textField_3.setBounds(642, 257, 169, 26);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(642, 302, 169, 26);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("Editar zona camping");
		btnNewButton.setActionCommand("Open30000");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				 if(cmd.equals("Open30000"))
			        {
			            frame.dispose();
			            new Updatecampings();
			            
			        }
			}
		});
		btnNewButton.setBounds(599, 501, 225, 29);
		frame.getContentPane().add(btnNewButton);
	}
}
