package proyecto;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ListSelectionModel;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Panel;
import javax.swing.JTextPane;


public class Ventana {
	
	/**
	 * Creamos dos ArrayList donde guardaremos las cajas de texto 
	 */
	private static ArrayList <JTextField> cajasCantidades = new ArrayList<>();
	private ArrayList <ArrayList <JTextField>> cajasResultados = new ArrayList<ArrayList<JTextField>>(10);
	
	/**
	 * Creamos un ArrayList de las checkboxes
	 */
	private static ArrayList <JCheckBox> checkboxes = new ArrayList<>();
	
	private JFrame frmInutritionist;
	
	/**
	 *  Creamos un ArrayList donde iremos anadiremos los alimentos
	 */
	
	private static ArrayList <Alimento> alimentosAL = new ArrayList <> ();
	
	
	private JTextField txtCantAlim1;
	private JTextField txtCantAlim2;
	private JTextField txtCantAlim3;
	private JTextField txtCantAlim4;
	private JTextField txtCantAlim5;
	private JTextField txtGrasas0;
	private JTextField txtGSat0;
	private JTextField txtHCarb0;
	private JTextField txtAzucar0;
	private JTextField txtProt0;
	private JTextField txtSal0;
	private JTextField txtCal0;
	private JTextField txtGrasas1;
	private JTextField txtGrasas2;
	private JTextField txtGrasas3;
	private JTextField txtGrasas4;
	private JTextField txtGSat1;
	private JTextField txtGSat2;
	private JTextField txtGSat3;
	private JTextField txtGSat4;
	private JTextField txtHCarb1;
	private JTextField txtHCarb2;
	private JTextField txtHCarb3;
	private JTextField txtHCarb4;
	private JTextField txtAzucar1;
	private JTextField txtAzucar2;
	private JTextField txtAzucar3;
	private JTextField txtAzucar4;
	private JTextField txtProt1;
	private JTextField txtProt2;
	private JTextField txtProt3;
	private JTextField txtProt4;
	private JTextField txtSal1;
	private JTextField txtSal2;
	private JTextField txtSal3;
	private JTextField txtSal4;
	private JTextField txtCal1;
	private JTextField txtCal2;
	private JTextField txtCal3;
	private JTextField txtCal4;
	private JLabel lblgr1;
	private JLabel lblgr2;
	private JLabel lblgr3;
	private JLabel lblgr4;
	private JLabel lblgr5;
	private JLabel lblErrorAzucar;
	private JTextField txtVerde;
	private JTextField txtRojo;

		
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
					window.frmInutritionist.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ventana() {
		initialize();
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */	
	private void initialize() {
	

		/**
		 * Inizializamos cada fila del ArrayList
		 */

		cajasResultados.add(new ArrayList<>());
		cajasResultados.add(new ArrayList<>());
		cajasResultados.add(new ArrayList<>());
		cajasResultados.add(new ArrayList<>());
		cajasResultados.add(new ArrayList<>());


		// Creamos los alimentos que introduciremos en el ArrayList
		// Orden: Nombre, Grasas, Grasas Saturadas, Hidratos de carbono, Azucar, Proteinas, Sal, kiloCalorias
		Alimento tomateFrito = new Alimento ("Tomate frito", 3.5, 0.3, 9.5, 6.9, 1.5, 1, 77);
		Alimento chocolate = new Alimento ("Chocolate Negro 85%", 49, 30, 20, 14, 12, 0.03, 597);
		Alimento macarrones = new Alimento ("Macarrones", 1.5, 0.4, 71, 3.5, 12.5,0.01, 354);
		Alimento pan = new Alimento ("Barra Pan", 1.3, 0.2, 54, 2.7, 8.9, 1.6, 268);
		Alimento patatasBolsa = new Alimento("Patatas fritas bolsa", 36, 3, 50, 4, 7, 1, 555);
		
		
		// Llenamos el ArrayList con los Alimentos
		alimentosAL.add(tomateFrito);
		alimentosAL.add(chocolate);
		alimentosAL.add(macarrones);
		alimentosAL.add(pan);
		alimentosAL.add(patatasBolsa);
		
		frmInutritionist = new JFrame();
		frmInutritionist.setTitle("iNutritionist");
		frmInutritionist.getContentPane().setEnabled(false);
		frmInutritionist.getContentPane().setBackground(new Color(216, 191, 216));
		frmInutritionist.setBounds(100, 100, 1331, 660);
		frmInutritionist.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInutritionist.getContentPane().setLayout(null);
		
		
		JLabel lblErrorSaturadas = new JLabel("");
		lblErrorSaturadas.setBounds(491, 369, 360, 17);
		frmInutritionist.getContentPane().add(lblErrorSaturadas);
		
		JLabel lblErrorAzucar = new JLabel("");
		lblErrorAzucar.setBounds(466, 406, 360, 17);
		frmInutritionist.getContentPane().add(lblErrorAzucar);
		
		
		/**
		 * En este bucle se comprueba que las grasas saturadas no sean mayores que las totales y que los azucares no sean mayores que los hidratos de carbono
		 */
		for (int i = 0; i < alimentosAL.size(); i++) {
			if (alimentosAL.get(i).getGrasasSat() > alimentosAL.get(i).getGrasas()) {
				JOptionPane.showMessageDialog(frmInutritionist, "Las grasas saturadas no pueden ser mayores que las grasas en el alimento " + alimentosAL.get(i).getNombre(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			if (alimentosAL.get(i).getAzucar() > alimentosAL.get(i).getHidratosCarbono()) {
				JOptionPane.showMessageDialog(frmInutritionist, "El azucar no puede ser mayor que los hidratos de carbono en el alimento " + alimentosAL.get(i).getNombre(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			
		}

		JLabel lblAlimentos = new JLabel("Alimentos");
		lblAlimentos.setBounds(55, 62, 73, 17);
		frmInutritionist.getContentPane().add(lblAlimentos);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(208, 62, 51, 17);
		frmInutritionist.getContentPane().add(lblCantidad);
		
		JLabel lblAlimento1 = new JLabel("");
		lblAlimento1.setBounds(55, 103, 131, 17);
		frmInutritionist.getContentPane().add(lblAlimento1);
		// Anadimos el 1er alimento a la etiqueta de alimento
		lblAlimento1.setText(alimentosAL.get(0).getNombre());
		
		
		/**
		 * Se crean las cajas de texto de las cantidades y rellenamos el ArrayList
		 */
		
		txtCantAlim1 = new JTextField();
		txtCantAlim1.setHorizontalAlignment(SwingConstants.CENTER);
		txtCantAlim1.setEnabled(false);
		txtCantAlim1.setBounds(196, 101, 67, 21);
		frmInutritionist.getContentPane().add(txtCantAlim1);
		txtCantAlim1.setColumns(10);
		cajasCantidades.add(txtCantAlim1);
		
		txtCantAlim2 = new JTextField();
		txtCantAlim2.setHorizontalAlignment(SwingConstants.CENTER);
		txtCantAlim2.setEnabled(false);
		txtCantAlim2.setBounds(196, 143, 67, 21);
		frmInutritionist.getContentPane().add(txtCantAlim2);
		txtCantAlim2.setColumns(10);
		cajasCantidades.add(txtCantAlim2);
		
		txtCantAlim3 = new JTextField();
		txtCantAlim3.setHorizontalAlignment(SwingConstants.CENTER);
		txtCantAlim3.setEnabled(false);
		txtCantAlim3.setBounds(196, 186, 67, 21);
		frmInutritionist.getContentPane().add(txtCantAlim3);
		txtCantAlim3.setColumns(10);
		cajasCantidades.add(txtCantAlim3);
		
		txtCantAlim4 = new JTextField();
		txtCantAlim4.setHorizontalAlignment(SwingConstants.CENTER);
		txtCantAlim4.setEnabled(false);
		txtCantAlim4.setColumns(10);
		txtCantAlim4.setBounds(196, 230, 67, 21);
		frmInutritionist.getContentPane().add(txtCantAlim4);
		cajasCantidades.add(txtCantAlim4);
		
		txtCantAlim5 = new JTextField();
		txtCantAlim5.setHorizontalAlignment(SwingConstants.CENTER);
		txtCantAlim5.setEnabled(false);
		txtCantAlim5.setColumns(10);
		txtCantAlim5.setBounds(196, 276, 67, 21);
		frmInutritionist.getContentPane().add(txtCantAlim5);
		cajasCantidades.add(txtCantAlim5);
		
		JCheckBox chckAlim1 = new JCheckBox("");
		chckAlim1.setBackground(new Color(216, 191, 216));
		chckAlim1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(chckAlim1.isSelected()) {
					txtCantAlim1.setEnabled(true);
				}else {
					txtCantAlim1.setEnabled(false);
					int longitudFila = cajasResultados.get(0).size();
					for (int i=0; i < longitudFila;i++) {
						txtCantAlim1.setText("");
						cajasResultados.get(0).get(i).setText("");
						cajasResultados.get(0).get(i).setBackground(new Color(255,255,255));
						cajasResultados.get(0).get(i).setEnabled(false);
					}
				}
			}
		});
		chckAlim1.setBounds(23, 97, 18, 25);
		frmInutritionist.getContentPane().add(chckAlim1);
		
		JCheckBox chckAlim2 = new JCheckBox("");
		chckAlim2.setBackground(new Color(216, 191, 216));
		chckAlim2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(chckAlim2.isSelected()) {
					txtCantAlim2.setEnabled(true);
				}else {
					txtCantAlim2.setEnabled(false);
					int longitudFila = cajasResultados.get(0).size();
					for (int i=0; i < longitudFila;i++) {
						txtCantAlim2.setText("");
						cajasResultados.get(1).get(i).setText("");
						cajasResultados.get(1).get(i).setBackground(new Color(255,255,255));
						cajasResultados.get(1).get(i).setEnabled(false);
					}
				}
			}
		});
		chckAlim2.setBounds(23, 139, 21, 25);
		frmInutritionist.getContentPane().add(chckAlim2);
		
		JCheckBox chckAlim3 = new JCheckBox("New check box");
		chckAlim3.setBackground(new Color(216, 191, 216));
		chckAlim3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(chckAlim3.isSelected()) {
					txtCantAlim3.setEnabled(true);
				}else {
					txtCantAlim3.setEnabled(false);
					int longitudFila = cajasResultados.get(0).size();
					for (int i=0; i < longitudFila;i++) {
						txtCantAlim3.setText("");
						cajasResultados.get(2).get(i).setText("");
						cajasResultados.get(2).get(i).setBackground(new Color(255,255,255));
						cajasResultados.get(2).get(i).setEnabled(false);
					}
				}
			}
		});
		chckAlim3.setBounds(23, 186, 18, 21);
		frmInutritionist.getContentPane().add(chckAlim3);
		
		JCheckBox chckAlim4 = new JCheckBox("New check box");
		chckAlim4.setBackground(new Color(216, 191, 216));
		chckAlim4.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(chckAlim4.isSelected()) {
					txtCantAlim4.setEnabled(true);
				}else {
					txtCantAlim4.setEnabled(false);
					int longitudFila = cajasResultados.get(0).size();
					for (int i=0; i < longitudFila;i++) {
						txtCantAlim4.setText("");
						cajasResultados.get(3).get(i).setText("");
						cajasResultados.get(3).get(i).setBackground(new Color(255,255,255));
						cajasResultados.get(3).get(i).setEnabled(false);
					}
				}
			}
		});
		chckAlim4.setBounds(23, 228, 18, 21);
		frmInutritionist.getContentPane().add(chckAlim4);
		
		JCheckBox chckAlim5 = new JCheckBox("New check box");
		chckAlim5.setBackground(new Color(216, 191, 216));
		chckAlim5.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(chckAlim5.isSelected()) {
					txtCantAlim5.setEnabled(true);
				}else {
					txtCantAlim5.setEnabled(false);
					int longitudFila = cajasResultados.get(0).size();
					for (int i=0; i < longitudFila;i++) {
						txtCantAlim5.setText("");
						cajasResultados.get(4).get(i).setText("");
						cajasResultados.get(4).get(i).setBackground(new Color(255,255,255));
						cajasResultados.get(4).get(i).setEnabled(false);
					}
				}
			}
		});
		chckAlim5.setBounds(23, 274, 18, 21);
		frmInutritionist.getContentPane().add(chckAlim5);
		
		checkboxes.add(chckAlim1);
		checkboxes.add(chckAlim2);
		checkboxes.add(chckAlim3);
		checkboxes.add(chckAlim4);
		checkboxes.add(chckAlim5);

		JLabel lblAlimento2 = new JLabel("");
		lblAlimento2.setBounds(55, 145, 131, 17);
		frmInutritionist.getContentPane().add(lblAlimento2);
		// Anadimos el segundo alimento a la etiqueta
		lblAlimento2.setText(alimentosAL.get(1).getNombre());
		
		JLabel lblAlimento3 = new JLabel((String) null);
		lblAlimento3.setBounds(55, 188, 131, 17);
		frmInutritionist.getContentPane().add(lblAlimento3);
		// Anadimos el tercer alimento a su respectiva etiqueta
		lblAlimento3.setText(alimentosAL.get(2).getNombre());
		
		JLabel lblGrasas = new JLabel("Grasas");
		lblGrasas.setBounds(329, 62, 67, 17);
		frmInutritionist.getContentPane().add(lblGrasas);
		
		JLabel lblGsaturadas = new JLabel("G.Saturadas");
		lblGsaturadas.setBounds(466, 62, 94, 17);
		frmInutritionist.getContentPane().add(lblGsaturadas);
		
		JLabel lblHidratosCarbono = new JLabel("H. Carbono");
		lblHidratosCarbono.setBounds(600, 62, 94, 17);
		frmInutritionist.getContentPane().add(lblHidratosCarbono);
		
		JLabel lblAzucar = new JLabel("Azucar");
		lblAzucar.setBounds(752, 62, 74, 17);
		frmInutritionist.getContentPane().add(lblAzucar);
		
		JLabel lblProteinas = new JLabel("Proteinas");
		lblProteinas.setBounds(880, 62, 94, 17);
		frmInutritionist.getContentPane().add(lblProteinas);
		
		JLabel lblSal = new JLabel("Sal");
		lblSal.setBounds(1042, 62, 18, 17);
		frmInutritionist.getContentPane().add(lblSal);
		
		JLabel lblKiloCalorias = new JLabel("KiloCalorias");
		lblKiloCalorias.setBounds(1161, 62, 82, 17);
		frmInutritionist.getContentPane().add(lblKiloCalorias);
		
		JLabel lblCantidadesIngeridas = new JLabel("Valores nutricionales");
		lblCantidadesIngeridas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCantidadesIngeridas.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidadesIngeridas.setForeground(new Color(0, 0, 0));
		lblCantidadesIngeridas.setBounds(561, 22, 193, 17);
		frmInutritionist.getContentPane().add(lblCantidadesIngeridas);
		
		JLabel lblAlimento4 = new JLabel((String) null);
		lblAlimento4.setBounds(55, 232, 131, 17);
		frmInutritionist.getContentPane().add(lblAlimento4);
		lblAlimento4.setText(alimentosAL.get(3).getNombre());
		
		JLabel lblAlimento5 = new JLabel((String) null);
		lblAlimento5.setBounds(55, 278, 131, 17);
		frmInutritionist.getContentPane().add(lblAlimento5);
		lblAlimento5.setText(alimentosAL.get(4).getNombre());

		

		/**
		 * Creamos las cajas de texto de los resultados y las añadimos al ArrayList
		 */
		
		// FILA 1
		txtGrasas0 = new JTextField();
		txtGrasas0.setEditable(false);
		txtGrasas0.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtGrasas0.setHorizontalAlignment(SwingConstants.CENTER);
		txtGrasas0.setBounds(320, 101, 60, 21);
		frmInutritionist.getContentPane().add(txtGrasas0);
		txtGrasas0.setColumns(10);
		cajasResultados.get(0).add(txtGrasas0);
		
		txtGSat0 = new JTextField();
		txtGSat0.setEditable(false);
		txtGSat0.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtGSat0.setHorizontalAlignment(SwingConstants.CENTER);
		txtGSat0.setColumns(10);
		txtGSat0.setBounds(460, 101, 60, 21);
		frmInutritionist.getContentPane().add(txtGSat0);
		cajasResultados.get(0).add(txtGSat0);
		
		txtHCarb0 = new JTextField();
		txtHCarb0.setEditable(false);
		txtHCarb0.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtHCarb0.setHorizontalAlignment(SwingConstants.CENTER);
		txtHCarb0.setColumns(10);
		txtHCarb0.setBounds(600, 101, 60, 21);
		frmInutritionist.getContentPane().add(txtHCarb0);
		cajasResultados.get(0).add(txtHCarb0);
		
		txtAzucar0 = new JTextField();
		txtAzucar0.setEditable(false);
		txtAzucar0.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtAzucar0.setHorizontalAlignment(SwingConstants.CENTER);
		txtAzucar0.setColumns(10);
		txtAzucar0.setBounds(740, 101, 60, 21);
		frmInutritionist.getContentPane().add(txtAzucar0);
		cajasResultados.get(0).add(txtAzucar0);
		
		txtProt0 = new JTextField();
		txtProt0.setEditable(false);
		txtProt0.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtProt0.setHorizontalAlignment(SwingConstants.CENTER);
		txtProt0.setColumns(10);
		txtProt0.setBounds(880, 101, 60, 21);
		frmInutritionist.getContentPane().add(txtProt0);
		cajasResultados.get(0).add(txtProt0);
		
		txtSal0 = new JTextField();
		txtSal0.setEditable(false);
		txtSal0.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtSal0.setHorizontalAlignment(SwingConstants.CENTER);
		txtSal0.setColumns(10);
		txtSal0.setBounds(1020, 101, 60, 21);
		frmInutritionist.getContentPane().add(txtSal0);
		cajasResultados.get(0).add(txtSal0);
		
		txtCal0 = new JTextField();
		txtCal0.setEditable(false);
		txtCal0.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtCal0.setHorizontalAlignment(SwingConstants.CENTER);
		txtCal0.setColumns(10);
		txtCal0.setBounds(1160, 101, 60, 21);
		frmInutritionist.getContentPane().add(txtCal0);
		cajasResultados.get(0).add(txtCal0);
		
		// FIN FILA 1 ///////////////////////////////////////////////////////////////////////////////
		
		// FILA 2
		txtGrasas1 = new JTextField();
		txtGrasas1.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtGrasas1.setHorizontalAlignment(SwingConstants.CENTER);
		txtGrasas1.setEditable(false);
		txtGrasas1.setColumns(10);
		txtGrasas1.setBounds(320, 143, 60, 21);
		frmInutritionist.getContentPane().add(txtGrasas1);
		cajasResultados.get(1).add(txtGrasas1);
		
		txtGSat1 = new JTextField();
		txtGSat1.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtGSat1.setHorizontalAlignment(SwingConstants.CENTER);
		txtGSat1.setEditable(false);
		txtGSat1.setColumns(10);
		txtGSat1.setBounds(460, 143, 60, 21);
		frmInutritionist.getContentPane().add(txtGSat1);
		cajasResultados.get(1).add(txtGSat1);
		
		txtHCarb1 = new JTextField();
		txtHCarb1.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtHCarb1.setHorizontalAlignment(SwingConstants.CENTER);
		txtHCarb1.setEditable(false);
		txtHCarb1.setColumns(10);
		txtHCarb1.setBounds(600, 143, 60, 21);
		frmInutritionist.getContentPane().add(txtHCarb1);
		cajasResultados.get(1).add(txtHCarb1);
		
		txtAzucar1 = new JTextField();
		txtAzucar1.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtAzucar1.setHorizontalAlignment(SwingConstants.CENTER);
		txtAzucar1.setEditable(false);
		txtAzucar1.setColumns(10);
		txtAzucar1.setBounds(740, 143, 60, 21);
		frmInutritionist.getContentPane().add(txtAzucar1);
		cajasResultados.get(1).add(txtAzucar1);
		
		txtProt1 = new JTextField();
		txtProt1.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtProt1.setHorizontalAlignment(SwingConstants.CENTER);
		txtProt1.setEditable(false);
		txtProt1.setColumns(10);
		txtProt1.setBounds(880, 143, 60, 21);
		frmInutritionist.getContentPane().add(txtProt1);
		cajasResultados.get(1).add(txtProt1);
		
		txtSal1 = new JTextField();
		txtSal1.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtSal1.setHorizontalAlignment(SwingConstants.CENTER);
		txtSal1.setEditable(false);
		txtSal1.setColumns(10);
		txtSal1.setBounds(1020, 143, 60, 21);
		frmInutritionist.getContentPane().add(txtSal1);
		cajasResultados.get(1).add(txtSal1);
		
		txtCal1 = new JTextField();
		txtCal1.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtCal1.setHorizontalAlignment(SwingConstants.CENTER);
		txtCal1.setEditable(false);
		txtCal1.setColumns(10);
		txtCal1.setBounds(1160, 143, 60, 21);
		frmInutritionist.getContentPane().add(txtCal1);
		cajasResultados.get(1).add(txtCal1);
		
		// FIN FILA 2 ///////////////////////////////////////////////////////////////////////////////
		
		// FILA 3
		
		txtGrasas2 = new JTextField();
		txtGrasas2.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtGrasas2.setHorizontalAlignment(SwingConstants.CENTER);
		txtGrasas2.setEditable(false);
		txtGrasas2.setColumns(10);
		txtGrasas2.setBounds(320, 186, 60, 21);
		frmInutritionist.getContentPane().add(txtGrasas2);
		cajasResultados.get(2).add(txtGrasas2);
		
		txtGSat2 = new JTextField();
		txtGSat2.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtGSat2.setHorizontalAlignment(SwingConstants.CENTER);
		txtGSat2.setEditable(false);
		txtGSat2.setColumns(10);
		txtGSat2.setBounds(460, 186, 60, 21);
		frmInutritionist.getContentPane().add(txtGSat2);
		cajasResultados.get(2).add(txtGSat2);
		
		txtHCarb2 = new JTextField();
		txtHCarb2.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtHCarb2.setHorizontalAlignment(SwingConstants.CENTER);
		txtHCarb2.setEditable(false);
		txtHCarb2.setColumns(10);
		txtHCarb2.setBounds(600, 186, 60, 21);
		frmInutritionist.getContentPane().add(txtHCarb2);
		cajasResultados.get(2).add(txtHCarb2);
		
		txtAzucar2 = new JTextField();
		txtAzucar2.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtAzucar2.setHorizontalAlignment(SwingConstants.CENTER);
		txtAzucar2.setEditable(false);
		txtAzucar2.setColumns(10);
		txtAzucar2.setBounds(740, 186, 60, 21);
		frmInutritionist.getContentPane().add(txtAzucar2);
		cajasResultados.get(2).add(txtAzucar2);
		
		txtProt2 = new JTextField();
		txtProt2.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtProt2.setHorizontalAlignment(SwingConstants.CENTER);
		txtProt2.setEditable(false);
		txtProt2.setColumns(10);
		txtProt2.setBounds(880, 186, 60, 21);
		frmInutritionist.getContentPane().add(txtProt2);
		cajasResultados.get(2).add(txtProt2);
		
		txtSal2 = new JTextField();
		txtSal2.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtSal2.setHorizontalAlignment(SwingConstants.CENTER);
		txtSal2.setEditable(false);
		txtSal2.setColumns(10);
		txtSal2.setBounds(1020, 186, 60, 21);
		frmInutritionist.getContentPane().add(txtSal2);
		cajasResultados.get(2).add(txtSal2);
		
		txtCal2 = new JTextField();
		txtCal2.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtCal2.setHorizontalAlignment(SwingConstants.CENTER);
		txtCal2.setEditable(false);
		txtCal2.setColumns(10);
		txtCal2.setBounds(1160, 186, 60, 21);
		frmInutritionist.getContentPane().add(txtCal2);
		cajasResultados.get(2).add(txtCal2);
		
		// FIN FILA 3 ///////////////////////////////////////////////////////////////////////////////
		
		// FILA 4
		
		txtGrasas3 = new JTextField();
		txtGrasas3.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtGrasas3.setHorizontalAlignment(SwingConstants.CENTER);
		txtGrasas3.setEditable(false);
		txtGrasas3.setColumns(10);
		txtGrasas3.setBounds(320, 230, 60, 21);
		frmInutritionist.getContentPane().add(txtGrasas3);
		cajasResultados.get(3).add(txtGrasas3);
		
		txtGSat3 = new JTextField();
		txtGSat3.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtGSat3.setHorizontalAlignment(SwingConstants.CENTER);
		txtGSat3.setEditable(false);
		txtGSat3.setColumns(10);
		txtGSat3.setBounds(460, 230, 60, 21);
		frmInutritionist.getContentPane().add(txtGSat3);
		cajasResultados.get(3).add(txtGSat3);
		
		txtHCarb3 = new JTextField();
		txtHCarb3.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtHCarb3.setHorizontalAlignment(SwingConstants.CENTER);
		txtHCarb3.setEditable(false);
		txtHCarb3.setColumns(10);
		txtHCarb3.setBounds(600, 228, 60, 21);
		frmInutritionist.getContentPane().add(txtHCarb3);
		cajasResultados.get(3).add(txtHCarb3);
		
		txtAzucar3 = new JTextField();
		txtAzucar3.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtAzucar3.setHorizontalAlignment(SwingConstants.CENTER);
		txtAzucar3.setEditable(false);
		txtAzucar3.setColumns(10);
		txtAzucar3.setBounds(740, 230, 60, 21);
		frmInutritionist.getContentPane().add(txtAzucar3);
		cajasResultados.get(3).add(txtAzucar3);
		
		txtProt3 = new JTextField();
		txtProt3.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtProt3.setHorizontalAlignment(SwingConstants.CENTER);
		txtProt3.setEditable(false);
		txtProt3.setColumns(10);
		txtProt3.setBounds(880, 230, 60, 21);
		frmInutritionist.getContentPane().add(txtProt3);
		cajasResultados.get(3).add(txtProt3);
		
		txtSal3 = new JTextField();
		txtSal3.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtSal3.setHorizontalAlignment(SwingConstants.CENTER);
		txtSal3.setEditable(false);
		txtSal3.setColumns(10);
		txtSal3.setBounds(1020, 230, 60, 21);
		frmInutritionist.getContentPane().add(txtSal3);
		cajasResultados.get(3).add(txtSal3);
		
		txtCal3 = new JTextField();
		txtCal3.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtCal3.setHorizontalAlignment(SwingConstants.CENTER);
		txtCal3.setEditable(false);
		txtCal3.setColumns(10);
		txtCal3.setBounds(1160, 230, 60, 21);
		frmInutritionist.getContentPane().add(txtCal3);
		cajasResultados.get(3).add(txtCal3);
		
		// FIN FILA 4 ///////////////////////////////////////////////////////////////////////////////
		
		// FILA 5
	
		txtGrasas4 = new JTextField();
		txtGrasas4.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtGrasas4.setHorizontalAlignment(SwingConstants.CENTER);
		txtGrasas4.setEditable(false);
		txtGrasas4.setColumns(10);
		txtGrasas4.setBounds(320, 276, 60, 21);
		frmInutritionist.getContentPane().add(txtGrasas4);
		cajasResultados.get(4).add(txtGrasas4);
		
		txtGSat4 = new JTextField();
		txtGSat4.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtGSat4.setHorizontalAlignment(SwingConstants.CENTER);
		txtGSat4.setEditable(false);
		txtGSat4.setColumns(10);
		txtGSat4.setBounds(460, 274, 60, 21);
		frmInutritionist.getContentPane().add(txtGSat4);
		cajasResultados.get(4).add(txtGSat4);
		
		txtHCarb4 = new JTextField();
		txtHCarb4.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtHCarb4.setHorizontalAlignment(SwingConstants.CENTER);
		txtHCarb4.setEditable(false);
		txtHCarb4.setColumns(10);
		txtHCarb4.setBounds(600, 276, 60, 21);
		frmInutritionist.getContentPane().add(txtHCarb4);
		cajasResultados.get(4).add(txtHCarb4);
		
		txtAzucar4 = new JTextField();
		txtAzucar4.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtAzucar4.setHorizontalAlignment(SwingConstants.CENTER);
		txtAzucar4.setEditable(false);
		txtAzucar4.setColumns(10);
		txtAzucar4.setBounds(740, 276, 60, 21);
		frmInutritionist.getContentPane().add(txtAzucar4);
		cajasResultados.get(4).add(txtAzucar4);
		
		txtProt4 = new JTextField();
		txtProt4.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtProt4.setHorizontalAlignment(SwingConstants.CENTER);
		txtProt4.setEditable(false);
		txtProt4.setColumns(10);
		txtProt4.setBounds(880, 276, 60, 21);
		frmInutritionist.getContentPane().add(txtProt4);
		cajasResultados.get(4).add(txtProt4);
		
		txtSal4 = new JTextField();
		txtSal4.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtSal4.setHorizontalAlignment(SwingConstants.CENTER);
		txtSal4.setEditable(false);
		txtSal4.setColumns(10);
		txtSal4.setBounds(1020, 276, 60, 21);
		frmInutritionist.getContentPane().add(txtSal4);
		cajasResultados.get(4).add(txtSal4);
		
		txtCal4 = new JTextField();
		txtCal4.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtCal4.setHorizontalAlignment(SwingConstants.CENTER);
		txtCal4.setEditable(false);
		txtCal4.setColumns(10);
		txtCal4.setBounds(1161, 276, 60, 21);
		frmInutritionist.getContentPane().add(txtCal4);
		cajasResultados.get(4).add(txtCal4);

		JButton btnValidarDieta = new JButton("Validar dieta");
		btnValidarDieta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					if (calcularGrasasTotales(alimentosAL)<(calcularIngestaCalorica(alimentosAL)*30/100) && calcularAzucarTotal(alimentosAL)<(calcularIngestaCalorica(alimentosAL)*10/100) && (calcularSalTotal(alimentosAL) < 5)) {
						for (int i = 0; i < cajasResultados.size(); i++) {
							if (checkboxes.get(i).isSelected()) {
								for (int j = 0; j < cajasResultados.get(i).size(); j++) {
									cajasResultados.get(i).get(j).setBackground(new Color(0,255,0));
								}
							}
						}
					}
					else {
						for (int i = 0; i < cajasResultados.size(); i++) {
							if (checkboxes.get(i).isSelected()) {
								for (int j = 0; j < cajasResultados.get(i).size(); j++) {
									cajasResultados.get(i).get(j).setBackground(new Color(255,0,0));
								}
							}
							
						}
					}
					calcularValoresNutricionales(alimentosAL);
					System.out.println(calcularSalTotal(alimentosAL));
					
				}

				catch (NumberFormatException e1){
					JOptionPane.showMessageDialog(frmInutritionist, "¡Solo números admitidos!", "Error", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnValidarDieta.setBackground(new Color(255, 255, 255));
		btnValidarDieta.setBounds(600, 459, 114, 27);
		frmInutritionist.getContentPane().add(btnValidarDieta);
		
		lblgr1 = new JLabel("g");
		lblgr1.setBounds(274, 103, 18, 17);
		frmInutritionist.getContentPane().add(lblgr1);
		
		lblgr2 = new JLabel("g");
		lblgr2.setBounds(274, 147, 8, 17);
		frmInutritionist.getContentPane().add(lblgr2);
		
		lblgr3 = new JLabel("g");
		lblgr3.setBounds(274, 188, 18, 17);
		frmInutritionist.getContentPane().add(lblgr3);
		
		lblgr4 = new JLabel("g");
		lblgr4.setBounds(274, 232, 18, 17);
		frmInutritionist.getContentPane().add(lblgr4);
		
		lblgr5 = new JLabel("g");
		lblgr5.setBounds(274, 278, 18, 17);
		frmInutritionist.getContentPane().add(lblgr5);
		
		txtVerde = new JTextField();
		txtVerde.setBackground(Color.GREEN);
		txtVerde.setEditable(false);
		txtVerde.setEnabled(false);
		txtVerde.setBounds(23, 551, 37, 20);
		frmInutritionist.getContentPane().add(txtVerde);
		txtVerde.setColumns(10);
		
		txtRojo = new JTextField();
		txtRojo.setBackground(Color.RED);
		txtRojo.setEditable(false);
		txtRojo.setEnabled(false);
		txtRojo.setColumns(10);
		txtRojo.setBounds(23, 577, 37, 20);
		frmInutritionist.getContentPane().add(txtRojo);
		
		JLabel lblCorrectoValores = new JLabel("Est\u00E1 dentro de los valores nutricionales saludables");
		lblCorrectoValores.setBounds(70, 554, 325, 14);
		frmInutritionist.getContentPane().add(lblCorrectoValores);
		
		JLabel lblIncorrectoValores = new JLabel("No est\u00E1 dentro de los valores nutricionales saludables");
		lblIncorrectoValores.setBounds(70, 580, 325, 14);
		frmInutritionist.getContentPane().add(lblIncorrectoValores);
		
		JButton btnAyuda = new JButton("?");	
		btnAyuda.setBackground(new Color(255, 255, 255));
		btnAyuda.setForeground(new Color(0, 0, 0));
		/**
		 * Evento para sacar el mensaje al pulsar el boton de ayuda
		 */
		btnAyuda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(frmInutritionist, "Seleccione que alimentos consume, indique cuanta cantidad y pulse el botón", "Help", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnAyuda.setBounds(1259, 576, 46, 22);
		frmInutritionist.getContentPane().add(btnAyuda);
		
	}
	
	/**
	 * Metodo para calcular los valores nutricionales
	 */
	private void calcularValoresNutricionales (ArrayList<Alimento> alimentos)
	{				
		for (int i=0; i< cajasCantidades.size(); i++)
		{		
			if (checkboxes.get(i).isSelected()) {
				String textoCantidad = cajasCantidades.get(i).getText();
				double cantidadActual = Double.valueOf(textoCantidad);
				double resultadoActual = 0;
				String resultadoEnTexto = "";
				for (int j = 0; j < cajasResultados.get(i).size(); j++) {
					/**
					 *  Aqui averiguamos en que tipo de valor nutricional nos encontramos (Grasas, Grasas Saturadas, Hidratos, etc...)
					 */
					switch (j) {
					case 0:
	                    resultadoActual = (cantidadActual * alimentos.get(i).getGrasas())/100 ;
	                    resultadoEnTexto = Double.toString(resultadoActual);
	                    cajasResultados.get(i).get(j).setText(resultadoEnTexto);
	                    break;
	                case 1:
	                    resultadoActual = (cantidadActual * alimentos.get(i).getGrasasSat())/100;
	                    resultadoEnTexto = Double.toString(resultadoActual);
	                    cajasResultados.get(i).get(j).setText(resultadoEnTexto);
	                    break;
	                case 2:
	                    resultadoActual = (cantidadActual * alimentos.get(i).getHidratosCarbono())/100;
	                    resultadoEnTexto = Double.toString(resultadoActual);
	                    cajasResultados.get(i).get(j).setText(resultadoEnTexto);
	                    break;
	                case 3:
	                    resultadoActual = (cantidadActual * alimentos.get(i).getAzucar())/100;
	                    resultadoEnTexto = Double.toString(resultadoActual);
	                    cajasResultados.get(i).get(j).setText(resultadoEnTexto);
	                    break;
	                case 4:
	                    resultadoActual = (cantidadActual * alimentos.get(i).getProteinas())/100;
	                    resultadoEnTexto = Double.toString(resultadoActual);
	                    cajasResultados.get(i).get(j).setText(resultadoEnTexto);
	                    break;
	                case 5:
	                    resultadoActual = (cantidadActual * alimentos.get(i).getSal())/100;
	                    resultadoEnTexto = Double.toString(resultadoActual);
	                    cajasResultados.get(i).get(j).setText(resultadoEnTexto);
	                    break;
	                case 6:
	                    resultadoActual = (cantidadActual * alimentos.get(i).getKiloCalorias())/100;
	                    resultadoEnTexto = Double.toString(resultadoActual);
	                    cajasResultados.get(i).get(j).setText(resultadoEnTexto);
	                    break;
					}
				}
			}

		}	
	}

	// Metodo para calcular la ingesta calorica total
	private static double calcularIngestaCalorica(ArrayList <Alimento> alimentos) {
		double totalKCal=0;
		for (int i=0;i<alimentos.size();i++) {
			if (checkboxes.get(i).isSelected()) {
				totalKCal+=alimentos.get(i).getKiloCalorias();
			}
		}
		return totalKCal;
	}

	// Metodo para calcular las grasas totales
	private static double calcularGrasasTotales(ArrayList <Alimento> alimentos) {
		double totalGrasas=0;
		for (int i=0;i<alimentos.size();i++) {
			if (checkboxes.get(i).isSelected()) {
				totalGrasas+=alimentos.get(i).getGrasas();
			}
		}
		return totalGrasas;
	}

	// Metodo para calcular el azucar total
	private static double calcularAzucarTotal(ArrayList <Alimento> alimentos) {
		double totalAzucar=0;
		for (int i=0;i<alimentos.size();i++) {
			if (checkboxes.get(i).isSelected()) {
				totalAzucar+=alimentos.get(i).getAzucar();
			}
		}
		return totalAzucar;
	}

	private static double calcularSalTotal(ArrayList <Alimento> alimentos) {
		double totalSal=0;
		for (int i=0;i<alimentos.size();i++) {
			if (checkboxes.get(i).isSelected()) {
				totalSal+=alimentos.get(i).getSal()*Double.valueOf(cajasCantidades.get(i).getText());
			}
		}
		return totalSal;
	}
	
}
