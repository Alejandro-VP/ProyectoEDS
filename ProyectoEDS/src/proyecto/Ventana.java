package proyecto;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
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


public class Ventana {
	
	/**
	 * Creamos dos ArrayList donde guardaremos las cajas de texto 
	 */
	private ArrayList <JTextField> cajasCantidades = new ArrayList<>();
	private ArrayList <ArrayList <JTextField>> cajasResultados = new ArrayList<ArrayList<JTextField>>(10);
	
	
	private JFrame frame;
	
	/**
	 *  Creamos un ArrayList donde iremos anadiremos los alimentos
	 */
	
	private ArrayList <Alimento> alimentosAL = new ArrayList <> ();
	
	
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

		
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
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
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1331, 660);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JLabel lblErrorSaturadas = new JLabel("");
		lblErrorSaturadas.setBounds(466, 377, 360, 17);
		frame.getContentPane().add(lblErrorSaturadas);
		
		JLabel lblErrorAzucar = new JLabel("");
		lblErrorAzucar.setBounds(466, 406, 360, 17);
		frame.getContentPane().add(lblErrorAzucar);
		
		
		/**
		 * En este bucle se comprueba que las grasas saturadas no sean mayores que las totales y que los azucares no sean mayores que los hidratos de carbono
		 */
		for (int i = 0; i < alimentosAL.size(); i++) {
			if (alimentosAL.get(i).getGrasasSat() > alimentosAL.get(i).getGrasas()) {
				lblErrorSaturadas.setText("Las grasas saturadas no pueden ser mayores que las totales en el alimento " + alimentosAL.get(i).getNombre());
				}
			if (alimentosAL.get(i).getAzucar() > alimentosAL.get(i).getHidratosCarbono()) {
				lblErrorAzucar.setText("Los azucares no pueden superar los hidratos en el alimento "+ alimentosAL.get(i).getNombre());
			}
			
		}

		JLabel lblAlimentos = new JLabel("Alimentos");
		lblAlimentos.setBounds(55, 62, 73, 17);
		frame.getContentPane().add(lblAlimentos);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(208, 62, 51, 17);
		frame.getContentPane().add(lblCantidad);
		
		JLabel lblAlimento1 = new JLabel("");
		lblAlimento1.setBounds(55, 103, 131, 17);
		frame.getContentPane().add(lblAlimento1);
		// Anadimos el 1er alimento a la etiqueta de alimento
		lblAlimento1.setText(alimentosAL.get(0).getNombre());
		
		JCheckBox chckAlim1 = new JCheckBox("");
		chckAlim1.setBounds(23, 97, 18, 25);
		frame.getContentPane().add(chckAlim1);
		
		/**
		 * Se crean las cajas de texto de las cantidades y rellenamos el ArrayList
		 */
		
		txtCantAlim1 = new JTextField();
		txtCantAlim1.setText("0");
		txtCantAlim1.setBounds(196, 101, 67, 21);
		frame.getContentPane().add(txtCantAlim1);
		txtCantAlim1.setColumns(10);
		cajasCantidades.add(txtCantAlim1);
		
		txtCantAlim2 = new JTextField();
		txtCantAlim2.setText("0");
		txtCantAlim2.setBounds(196, 143, 67, 21);
		frame.getContentPane().add(txtCantAlim2);
		txtCantAlim2.setColumns(10);
		cajasCantidades.add(txtCantAlim2);
		
		txtCantAlim3 = new JTextField();
		txtCantAlim3.setText("0");
		txtCantAlim3.setBounds(196, 186, 67, 21);
		frame.getContentPane().add(txtCantAlim3);
		txtCantAlim3.setColumns(10);
		cajasCantidades.add(txtCantAlim3);
		
		txtCantAlim4 = new JTextField();
		txtCantAlim4.setText("0");
		txtCantAlim4.setColumns(10);
		txtCantAlim4.setBounds(196, 230, 67, 21);
		frame.getContentPane().add(txtCantAlim4);
		cajasCantidades.add(txtCantAlim4);
		
		txtCantAlim5 = new JTextField();
		txtCantAlim5.setText("0");
		txtCantAlim5.setColumns(10);
		txtCantAlim5.setBounds(196, 276, 67, 21);
		frame.getContentPane().add(txtCantAlim5);
		cajasCantidades.add(txtCantAlim5);
		
		JCheckBox chckAlim2 = new JCheckBox("");
		chckAlim2.setBounds(23, 139, 21, 25);
		frame.getContentPane().add(chckAlim2);
		
		JLabel lblAlimento2 = new JLabel("");
		lblAlimento2.setBounds(55, 145, 131, 17);
		frame.getContentPane().add(lblAlimento2);
		// Anadimos el segundo alimento a la etiqueta
		lblAlimento2.setText(alimentosAL.get(1).getNombre());
		
		JCheckBox chckAlim3 = new JCheckBox("New check box");
		chckAlim3.setBounds(23, 186, 18, 21);
		frame.getContentPane().add(chckAlim3);
		
		JLabel lblAlimento3 = new JLabel((String) null);
		lblAlimento3.setBounds(55, 188, 131, 17);
		frame.getContentPane().add(lblAlimento3);
		// Anadimos el tercer alimento a su respectiva etiqueta
		lblAlimento3.setText(alimentosAL.get(2).getNombre());
		
		JLabel lblGrasas = new JLabel("Grasas");
		lblGrasas.setBounds(329, 62, 67, 17);
		frame.getContentPane().add(lblGrasas);
		
		JLabel lblGsaturadas = new JLabel("G.Saturadas");
		lblGsaturadas.setBounds(466, 62, 94, 17);
		frame.getContentPane().add(lblGsaturadas);
		
		JLabel lblHidratosCarbono = new JLabel("H. Carbono");
		lblHidratosCarbono.setBounds(600, 62, 94, 17);
		frame.getContentPane().add(lblHidratosCarbono);
		
		JLabel lblAzucar = new JLabel("Azucar");
		lblAzucar.setBounds(752, 62, 74, 17);
		frame.getContentPane().add(lblAzucar);
		
		JLabel lblProteinas = new JLabel("Proteinas");
		lblProteinas.setBounds(880, 62, 94, 17);
		frame.getContentPane().add(lblProteinas);
		
		JLabel lblSal = new JLabel("Sal");
		lblSal.setBounds(1042, 62, 18, 17);
		frame.getContentPane().add(lblSal);
		
		JLabel lblKiloCalorias = new JLabel("KiloCalorias");
		lblKiloCalorias.setBounds(1161, 62, 82, 17);
		frame.getContentPane().add(lblKiloCalorias);
		
		JLabel lblCantidadesIngeridas = new JLabel("Valores nutricionales");
		lblCantidadesIngeridas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCantidadesIngeridas.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidadesIngeridas.setForeground(new Color(30, 144, 255));
		lblCantidadesIngeridas.setBounds(563, 22, 193, 17);
		frame.getContentPane().add(lblCantidadesIngeridas);
		
		
		
		JLabel lblAlimento4 = new JLabel((String) null);
		lblAlimento4.setBounds(55, 232, 131, 17);
		frame.getContentPane().add(lblAlimento4);
		lblAlimento4.setText(alimentosAL.get(3).getNombre());
		

		JCheckBox chckAlim4 = new JCheckBox("New check box");
		chckAlim4.setBounds(23, 228, 18, 21);
		frame.getContentPane().add(chckAlim4);
		
		JLabel lblAlimento5 = new JLabel((String) null);
		lblAlimento5.setBounds(55, 278, 131, 17);
		frame.getContentPane().add(lblAlimento5);
		lblAlimento5.setText(alimentosAL.get(4).getNombre());

		JCheckBox chckAlim5 = new JCheckBox("New check box");
		chckAlim5.setBounds(23, 274, 18, 21);
		frame.getContentPane().add(chckAlim5);

		/**
		 * Creamos las cajas de texto de los resultados y las añadimos al ArrayList
		 */
		
		// FILA 1
		txtGrasas0 = new JTextField();
		txtGrasas0.setText("0");
		txtGrasas0.setHorizontalAlignment(SwingConstants.CENTER);
		txtGrasas0.setEditable(false);
		txtGrasas0.setBounds(320, 101, 60, 21);
		frame.getContentPane().add(txtGrasas0);
		txtGrasas0.setColumns(10);
		cajasResultados.get(0).add(txtGrasas0);
		
		txtGSat0 = new JTextField();
		txtGSat0.setText("0");
		txtGSat0.setHorizontalAlignment(SwingConstants.CENTER);
		txtGSat0.setEditable(false);
		txtGSat0.setColumns(10);
		txtGSat0.setBounds(460, 101, 60, 21);
		frame.getContentPane().add(txtGSat0);
		cajasResultados.get(0).add(txtGSat0);
		
		txtHCarb0 = new JTextField();
		txtHCarb0.setText("0");
		txtHCarb0.setHorizontalAlignment(SwingConstants.CENTER);
		txtHCarb0.setEditable(false);
		txtHCarb0.setColumns(10);
		txtHCarb0.setBounds(600, 101, 60, 21);
		frame.getContentPane().add(txtHCarb0);
		cajasResultados.get(0).add(txtHCarb0);
		
		txtAzucar0 = new JTextField();
		txtAzucar0.setText("0");
		txtAzucar0.setHorizontalAlignment(SwingConstants.CENTER);
		txtAzucar0.setEditable(false);
		txtAzucar0.setColumns(10);
		txtAzucar0.setBounds(740, 101, 60, 21);
		frame.getContentPane().add(txtAzucar0);
		cajasResultados.get(0).add(txtAzucar0);
		
		txtProt0 = new JTextField();
		txtProt0.setText("0");
		txtProt0.setHorizontalAlignment(SwingConstants.CENTER);
		txtProt0.setEditable(false);
		txtProt0.setColumns(10);
		txtProt0.setBounds(880, 101, 60, 21);
		frame.getContentPane().add(txtProt0);
		cajasResultados.get(0).add(txtProt0);
		
		txtSal0 = new JTextField();
		txtSal0.setText("0");
		txtSal0.setHorizontalAlignment(SwingConstants.CENTER);
		txtSal0.setEditable(false);
		txtSal0.setColumns(10);
		txtSal0.setBounds(1020, 101, 60, 21);
		frame.getContentPane().add(txtSal0);
		cajasResultados.get(0).add(txtSal0);
		
		txtCal0 = new JTextField();
		txtCal0.setText("0");
		txtCal0.setHorizontalAlignment(SwingConstants.CENTER);
		txtCal0.setEditable(false);
		txtCal0.setColumns(10);
		txtCal0.setBounds(1160, 101, 60, 21);
		frame.getContentPane().add(txtCal0);
		cajasResultados.get(0).add(txtCal0);
		
		// FIN FILA 1 ///////////////////////////////////////////////////////////////////////////////
		
		// FILA 2
		txtGrasas1 = new JTextField();
		txtGrasas1.setText("0");
		txtGrasas1.setHorizontalAlignment(SwingConstants.CENTER);
		txtGrasas1.setEditable(false);
		txtGrasas1.setColumns(10);
		txtGrasas1.setBounds(320, 143, 60, 21);
		frame.getContentPane().add(txtGrasas1);
		cajasResultados.get(1).add(txtGrasas1);
		
		txtGSat1 = new JTextField();
		txtGSat1.setText("0");
		txtGSat1.setHorizontalAlignment(SwingConstants.CENTER);
		txtGSat1.setEditable(false);
		txtGSat1.setColumns(10);
		txtGSat1.setBounds(460, 143, 60, 21);
		frame.getContentPane().add(txtGSat1);
		cajasResultados.get(1).add(txtGSat1);
		
		txtHCarb1 = new JTextField();
		txtHCarb1.setText("0");
		txtHCarb1.setHorizontalAlignment(SwingConstants.CENTER);
		txtHCarb1.setEditable(false);
		txtHCarb1.setColumns(10);
		txtHCarb1.setBounds(600, 143, 60, 21);
		frame.getContentPane().add(txtHCarb1);
		cajasResultados.get(1).add(txtHCarb1);
		
		txtAzucar1 = new JTextField();
		txtAzucar1.setText("0");
		txtAzucar1.setHorizontalAlignment(SwingConstants.CENTER);
		txtAzucar1.setEditable(false);
		txtAzucar1.setColumns(10);
		txtAzucar1.setBounds(740, 143, 60, 21);
		frame.getContentPane().add(txtAzucar1);
		cajasResultados.get(1).add(txtAzucar1);
		
		txtProt1 = new JTextField();
		txtProt1.setText("0");
		txtProt1.setHorizontalAlignment(SwingConstants.CENTER);
		txtProt1.setEditable(false);
		txtProt1.setColumns(10);
		txtProt1.setBounds(880, 139, 60, 21);
		frame.getContentPane().add(txtProt1);
		cajasResultados.get(1).add(txtProt1);
		
		txtSal1 = new JTextField();
		txtSal1.setText("0");
		txtSal1.setHorizontalAlignment(SwingConstants.CENTER);
		txtSal1.setEditable(false);
		txtSal1.setColumns(10);
		txtSal1.setBounds(1020, 139, 60, 21);
		frame.getContentPane().add(txtSal1);
		cajasResultados.get(1).add(txtSal1);
		
		txtCal1 = new JTextField();
		txtCal1.setText("0");
		txtCal1.setHorizontalAlignment(SwingConstants.CENTER);
		txtCal1.setEditable(false);
		txtCal1.setColumns(10);
		txtCal1.setBounds(1160, 143, 60, 21);
		frame.getContentPane().add(txtCal1);
		cajasResultados.get(1).add(txtCal1);
		
		// FIN FILA 2 ///////////////////////////////////////////////////////////////////////////////
		
		// FILA 3
		
		txtGrasas2 = new JTextField();
		txtGrasas2.setText("0");
		txtGrasas2.setHorizontalAlignment(SwingConstants.CENTER);
		txtGrasas2.setEditable(false);
		txtGrasas2.setColumns(10);
		txtGrasas2.setBounds(320, 186, 60, 21);
		frame.getContentPane().add(txtGrasas2);
		cajasResultados.get(2).add(txtGrasas2);
		
		txtGSat2 = new JTextField();
		txtGSat2.setText("0");
		txtGSat2.setHorizontalAlignment(SwingConstants.CENTER);
		txtGSat2.setEditable(false);
		txtGSat2.setColumns(10);
		txtGSat2.setBounds(460, 186, 60, 21);
		frame.getContentPane().add(txtGSat2);
		cajasResultados.get(2).add(txtGSat2);
		
		txtHCarb2 = new JTextField();
		txtHCarb2.setText("0");
		txtHCarb2.setHorizontalAlignment(SwingConstants.CENTER);
		txtHCarb2.setEditable(false);
		txtHCarb2.setColumns(10);
		txtHCarb2.setBounds(600, 186, 60, 21);
		frame.getContentPane().add(txtHCarb2);
		cajasResultados.get(2).add(txtHCarb2);
		
		txtAzucar2 = new JTextField();
		txtAzucar2.setText("0");
		txtAzucar2.setHorizontalAlignment(SwingConstants.CENTER);
		txtAzucar2.setEditable(false);
		txtAzucar2.setColumns(10);
		txtAzucar2.setBounds(740, 186, 60, 21);
		frame.getContentPane().add(txtAzucar2);
		cajasResultados.get(2).add(txtAzucar2);
		
		txtProt2 = new JTextField();
		txtProt2.setText("0");
		txtProt2.setHorizontalAlignment(SwingConstants.CENTER);
		txtProt2.setEditable(false);
		txtProt2.setColumns(10);
		txtProt2.setBounds(880, 186, 60, 21);
		frame.getContentPane().add(txtProt2);
		cajasResultados.get(2).add(txtProt2);
		
		txtSal2 = new JTextField();
		txtSal2.setText("0");
		txtSal2.setHorizontalAlignment(SwingConstants.CENTER);
		txtSal2.setEditable(false);
		txtSal2.setColumns(10);
		txtSal2.setBounds(1020, 186, 60, 21);
		frame.getContentPane().add(txtSal2);
		cajasResultados.get(2).add(txtSal2);
		
		txtCal2 = new JTextField();
		txtCal2.setText("0");
		txtCal2.setHorizontalAlignment(SwingConstants.CENTER);
		txtCal2.setEditable(false);
		txtCal2.setColumns(10);
		txtCal2.setBounds(1160, 186, 60, 21);
		frame.getContentPane().add(txtCal2);
		cajasResultados.get(2).add(txtCal2);
		
		// FIN FILA 3 ///////////////////////////////////////////////////////////////////////////////
		
		// FILA 4
		
		txtGrasas3 = new JTextField();
		txtGrasas3.setText("0");
		txtGrasas3.setHorizontalAlignment(SwingConstants.CENTER);
		txtGrasas3.setEditable(false);
		txtGrasas3.setColumns(10);
		txtGrasas3.setBounds(320, 230, 60, 21);
		frame.getContentPane().add(txtGrasas3);
		cajasResultados.get(3).add(txtGrasas3);
		
		txtGSat3 = new JTextField();
		txtGSat3.setText("0");
		txtGSat3.setHorizontalAlignment(SwingConstants.CENTER);
		txtGSat3.setEditable(false);
		txtGSat3.setColumns(10);
		txtGSat3.setBounds(460, 230, 60, 21);
		frame.getContentPane().add(txtGSat3);
		cajasResultados.get(3).add(txtGSat3);
		
		txtHCarb3 = new JTextField();
		txtHCarb3.setText("0");
		txtHCarb3.setHorizontalAlignment(SwingConstants.CENTER);
		txtHCarb3.setEditable(false);
		txtHCarb3.setColumns(10);
		txtHCarb3.setBounds(600, 228, 60, 21);
		frame.getContentPane().add(txtHCarb3);
		cajasResultados.get(3).add(txtHCarb3);
		
		txtAzucar3 = new JTextField();
		txtAzucar3.setText("0");
		txtAzucar3.setHorizontalAlignment(SwingConstants.CENTER);
		txtAzucar3.setEditable(false);
		txtAzucar3.setColumns(10);
		txtAzucar3.setBounds(740, 230, 60, 21);
		frame.getContentPane().add(txtAzucar3);
		cajasResultados.get(3).add(txtAzucar3);
		
		txtProt3 = new JTextField();
		txtProt3.setText("0");
		txtProt3.setHorizontalAlignment(SwingConstants.CENTER);
		txtProt3.setEditable(false);
		txtProt3.setColumns(10);
		txtProt3.setBounds(880, 230, 60, 21);
		frame.getContentPane().add(txtProt3);
		cajasResultados.get(3).add(txtProt3);
		
		txtSal3 = new JTextField();
		txtSal3.setText("0");
		txtSal3.setHorizontalAlignment(SwingConstants.CENTER);
		txtSal3.setEditable(false);
		txtSal3.setColumns(10);
		txtSal3.setBounds(1020, 230, 60, 21);
		frame.getContentPane().add(txtSal3);
		cajasResultados.get(3).add(txtSal3);
		
		txtCal3 = new JTextField();
		txtCal3.setText("0");
		txtCal3.setHorizontalAlignment(SwingConstants.CENTER);
		txtCal3.setEditable(false);
		txtCal3.setColumns(10);
		txtCal3.setBounds(1160, 230, 60, 21);
		frame.getContentPane().add(txtCal3);
		cajasResultados.get(3).add(txtCal3);
		
		// FIN FILA 4 ///////////////////////////////////////////////////////////////////////////////
		
		// FILA 5
	
		txtGrasas4 = new JTextField();
		txtGrasas4.setText("0");
		txtGrasas4.setHorizontalAlignment(SwingConstants.CENTER);
		txtGrasas4.setEditable(false);
		txtGrasas4.setColumns(10);
		txtGrasas4.setBounds(320, 276, 60, 21);
		frame.getContentPane().add(txtGrasas4);
		cajasResultados.get(4).add(txtGrasas4);
		
		txtGSat4 = new JTextField();
		txtGSat4.setText("0");
		txtGSat4.setHorizontalAlignment(SwingConstants.CENTER);
		txtGSat4.setEditable(false);
		txtGSat4.setColumns(10);
		txtGSat4.setBounds(460, 274, 60, 21);
		frame.getContentPane().add(txtGSat4);
		cajasResultados.get(4).add(txtGSat4);
		
		txtHCarb4 = new JTextField();
		txtHCarb4.setText("0");
		txtHCarb4.setHorizontalAlignment(SwingConstants.CENTER);
		txtHCarb4.setEditable(false);
		txtHCarb4.setColumns(10);
		txtHCarb4.setBounds(600, 276, 60, 21);
		frame.getContentPane().add(txtHCarb4);
		cajasResultados.get(4).add(txtHCarb4);
		
		txtAzucar4 = new JTextField();
		txtAzucar4.setText("0");
		txtAzucar4.setHorizontalAlignment(SwingConstants.CENTER);
		txtAzucar4.setEditable(false);
		txtAzucar4.setColumns(10);
		txtAzucar4.setBounds(740, 276, 60, 21);
		frame.getContentPane().add(txtAzucar4);
		cajasResultados.get(4).add(txtAzucar4);
		
		txtProt4 = new JTextField();
		txtProt4.setText("0");
		txtProt4.setHorizontalAlignment(SwingConstants.CENTER);
		txtProt4.setEditable(false);
		txtProt4.setColumns(10);
		txtProt4.setBounds(880, 276, 60, 21);
		frame.getContentPane().add(txtProt4);
		cajasResultados.get(4).add(txtProt4);
		
		txtSal4 = new JTextField();
		txtSal4.setText("0");
		txtSal4.setHorizontalAlignment(SwingConstants.CENTER);
		txtSal4.setEditable(false);
		txtSal4.setColumns(10);
		txtSal4.setBounds(1020, 274, 60, 21);
		frame.getContentPane().add(txtSal4);
		cajasResultados.get(4).add(txtSal4);
		
		txtCal4 = new JTextField();
		txtCal4.setText("0");
		txtCal4.setHorizontalAlignment(SwingConstants.CENTER);
		txtCal4.setEditable(false);
		txtCal4.setColumns(10);
		txtCal4.setBounds(1161, 276, 60, 21);
		frame.getContentPane().add(txtCal4);
		cajasResultados.get(4).add(txtCal4);
		
		// FIN FILA 5 ///////////////////////////////////////////////////////////////////////////////
		
		
		JButton btnValidarDieta = new JButton("Validar dieta");
		btnValidarDieta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				calcularValoresNutricionales(alimentosAL);
			}
		});
		btnValidarDieta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnValidarDieta.setBounds(589, 459, 114, 27);
		frame.getContentPane().add(btnValidarDieta);
		
		lblgr1 = new JLabel("g");
		lblgr1.setBounds(274, 103, 18, 17);
		frame.getContentPane().add(lblgr1);
		
		lblgr2 = new JLabel("g");
		lblgr2.setBounds(274, 147, 8, 17);
		frame.getContentPane().add(lblgr2);
		
		lblgr3 = new JLabel("g");
		lblgr3.setBounds(274, 188, 18, 17);
		frame.getContentPane().add(lblgr3);
		
		lblgr4 = new JLabel("g");
		lblgr4.setBounds(274, 232, 18, 17);
		frame.getContentPane().add(lblgr4);
		
		lblgr5 = new JLabel("g");
		lblgr5.setBounds(274, 278, 18, 17);
		frame.getContentPane().add(lblgr5);	
	}
	
	/**
	 * Metodo para calcular los valores nutricionales
	 */
	private void calcularValoresNutricionales (ArrayList<Alimento> alimentos)
	{				
		for (int i=0; i< cajasCantidades.size(); i++)
		{
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
					resultadoActual = (cantidadActual * alimentos.get(i).getGrasas()) /100;
					resultadoEnTexto = Double.toString(resultadoActual);
					cajasResultados.get(i).get(j).setText(resultadoEnTexto);
					break;
				case 1:
					resultadoActual = (cantidadActual * alimentos.get(i).getGrasasSat()) /100;
					resultadoEnTexto = Double.toString(resultadoActual);
					cajasResultados.get(i).get(j).setText(resultadoEnTexto);
					break;
				case 2:
					resultadoActual = (cantidadActual * alimentos.get(i).getHidratosCarbono()) /100;
					resultadoEnTexto = Double.toString(resultadoActual);
					cajasResultados.get(i).get(j).setText(resultadoEnTexto);
					break;
				case 3:
					resultadoActual = (cantidadActual * alimentos.get(i).getAzucar()) /100;
					resultadoEnTexto = Double.toString(resultadoActual);
					cajasResultados.get(i).get(j).setText(resultadoEnTexto);
					break;
				case 4:
					resultadoActual = (cantidadActual * alimentos.get(i).getProteinas()) /100;
					resultadoEnTexto = Double.toString(resultadoActual);
					cajasResultados.get(i).get(j).setText(resultadoEnTexto);
					break;
				case 5:
					resultadoActual = (cantidadActual * alimentos.get(i).getSal()) /100;
					resultadoEnTexto = Double.toString(resultadoActual);
					cajasResultados.get(i).get(j).setText(resultadoEnTexto);
					break;
				case 6:
					resultadoActual = (cantidadActual * alimentos.get(i).getKiloCalorias()) /100;
					resultadoEnTexto = Double.toString(resultadoActual);
					cajasResultados.get(i).get(j).setText(resultadoEnTexto);
					break;
				}
			}
		}
	}
}
