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
	private JTextField txtKCal0;
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
		 * Inizializamos cada fila del ArrayList de los resultados
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
		lblAlimentos.setBounds(100, 66, 73, 17);
		frmInutritionist.getContentPane().add(lblAlimentos);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(253, 66, 51, 17);
		frmInutritionist.getContentPane().add(lblCantidad);
		
		
		
		
		/**
		 * Se crean las cajas de texto de las cantidades y rellenamos el ArrayList
		 */
		
		txtCantAlim1 = new JTextField();
		txtCantAlim1.setText("0");
		txtCantAlim1.setHorizontalAlignment(SwingConstants.CENTER);
		txtCantAlim1.setBounds(241, 105, 67, 21);
		frmInutritionist.getContentPane().add(txtCantAlim1);
		txtCantAlim1.setColumns(10);
		cajasCantidades.add(txtCantAlim1);
		
		txtCantAlim2 = new JTextField();
		txtCantAlim2.setText("0");
		txtCantAlim2.setHorizontalAlignment(SwingConstants.CENTER);
		txtCantAlim2.setBounds(241, 147, 67, 21);
		frmInutritionist.getContentPane().add(txtCantAlim2);
		txtCantAlim2.setColumns(10);
		cajasCantidades.add(txtCantAlim2);
		
		txtCantAlim3 = new JTextField();
		txtCantAlim3.setText("0");
		txtCantAlim3.setHorizontalAlignment(SwingConstants.CENTER);
		txtCantAlim3.setBounds(241, 190, 67, 21);
		frmInutritionist.getContentPane().add(txtCantAlim3);
		txtCantAlim3.setColumns(10);
		cajasCantidades.add(txtCantAlim3);
		
		txtCantAlim4 = new JTextField();
		txtCantAlim4.setText("0");
		txtCantAlim4.setHorizontalAlignment(SwingConstants.CENTER);
		txtCantAlim4.setColumns(10);
		txtCantAlim4.setBounds(241, 234, 67, 21);
		frmInutritionist.getContentPane().add(txtCantAlim4);
		cajasCantidades.add(txtCantAlim4);
		
		txtCantAlim5 = new JTextField();
		txtCantAlim5.setText("0");
		txtCantAlim5.setHorizontalAlignment(SwingConstants.CENTER);
		txtCantAlim5.setColumns(10);
		txtCantAlim5.setBounds(241, 280, 67, 21);
		frmInutritionist.getContentPane().add(txtCantAlim5);
		cajasCantidades.add(txtCantAlim5);

		JLabel lblAlimento1 = new JLabel("");
		lblAlimento1.setBounds(100, 107, 131, 17);
		frmInutritionist.getContentPane().add(lblAlimento1);
		// Anadimos el primer alimento a la etiqueta de alimento
		lblAlimento1.setText(alimentosAL.get(0).getNombre());
		
		JLabel lblAlimento2 = new JLabel("");
		lblAlimento2.setBounds(100, 149, 131, 17);
		frmInutritionist.getContentPane().add(lblAlimento2);
		// Anadimos el segundo alimento a la etiqueta
		lblAlimento2.setText(alimentosAL.get(1).getNombre());
		
		JLabel lblAlimento3 = new JLabel((String) null);
		lblAlimento3.setBounds(100, 192, 131, 17);
		frmInutritionist.getContentPane().add(lblAlimento3);
		// Anadimos el tercer alimento a su respectiva etiqueta
		lblAlimento3.setText(alimentosAL.get(2).getNombre());
		
		JLabel lblAlimento4 = new JLabel((String) null);
		lblAlimento4.setBounds(100, 236, 131, 17);
		frmInutritionist.getContentPane().add(lblAlimento4);
		// Anadimos el cuarto alimento a su respectiva etiqueta
		lblAlimento4.setText(alimentosAL.get(3).getNombre());
		
		JLabel lblAlimento5 = new JLabel((String) null);
		lblAlimento5.setBounds(100, 282, 131, 17);
		frmInutritionist.getContentPane().add(lblAlimento5);
		// Anadimos el quinto alimento a su respectiva etiqueta
		lblAlimento5.setText(alimentosAL.get(4).getNombre());
		
		// Etiquetas para indicar a qué corresponde cada columna
		JLabel lblGrasas = new JLabel("Grasas");
		lblGrasas.setBounds(374, 66, 67, 17);
		frmInutritionist.getContentPane().add(lblGrasas);
		
		JLabel lblGsaturadas = new JLabel("G.Saturadas");
		lblGsaturadas.setBounds(511, 66, 94, 17);
		frmInutritionist.getContentPane().add(lblGsaturadas);
		
		JLabel lblHidratosCarbono = new JLabel("H. Carbono");
		lblHidratosCarbono.setBounds(645, 66, 94, 17);
		frmInutritionist.getContentPane().add(lblHidratosCarbono);
		
		JLabel lblAzucar = new JLabel("Azucar");
		lblAzucar.setBounds(797, 66, 74, 17);
		frmInutritionist.getContentPane().add(lblAzucar);
		
		JLabel lblProteinas = new JLabel("Proteinas");
		lblProteinas.setBounds(925, 66, 94, 17);
		frmInutritionist.getContentPane().add(lblProteinas);
		
		JLabel lblSal = new JLabel("Sal");
		lblSal.setBounds(1087, 66, 18, 17);
		frmInutritionist.getContentPane().add(lblSal);
		
		JLabel lblKiloCalorias = new JLabel("KiloCalorias");
		lblKiloCalorias.setBounds(1205, 66, 60, 17);
		frmInutritionist.getContentPane().add(lblKiloCalorias);
		
		JLabel lblCantidadesIngeridas = new JLabel("Valores nutricionales");
		lblCantidadesIngeridas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCantidadesIngeridas.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidadesIngeridas.setForeground(new Color(0, 0, 0));
		lblCantidadesIngeridas.setBounds(562, 22, 199, 17);
		frmInutritionist.getContentPane().add(lblCantidadesIngeridas);

		/**
		 * Creamos las cajas de texto de los resultados y las anadimos al ArrayList
		 */
		
		// FILA 1
		txtGrasas0 = new JTextField();
		txtGrasas0.setEditable(false);
		txtGrasas0.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtGrasas0.setHorizontalAlignment(SwingConstants.CENTER);
		txtGrasas0.setBounds(365, 105, 60, 21);
		frmInutritionist.getContentPane().add(txtGrasas0);
		txtGrasas0.setColumns(10);
		//Se anade al ArrayList
		cajasResultados.get(0).add(txtGrasas0);
		
		txtGSat0 = new JTextField();
		txtGSat0.setEditable(false);
		txtGSat0.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtGSat0.setHorizontalAlignment(SwingConstants.CENTER);
		txtGSat0.setColumns(10);
		txtGSat0.setBounds(505, 105, 60, 21);
		frmInutritionist.getContentPane().add(txtGSat0);
		//Se anade al ArrayList
		cajasResultados.get(0).add(txtGSat0);
		
		txtHCarb0 = new JTextField();
		txtHCarb0.setEditable(false);
		txtHCarb0.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtHCarb0.setHorizontalAlignment(SwingConstants.CENTER);
		txtHCarb0.setColumns(10);
		txtHCarb0.setBounds(645, 105, 60, 21);
		frmInutritionist.getContentPane().add(txtHCarb0);
		//Se anade al ArrayList
		cajasResultados.get(0).add(txtHCarb0);
		
		txtAzucar0 = new JTextField();
		txtAzucar0.setEditable(false);
		txtAzucar0.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtAzucar0.setHorizontalAlignment(SwingConstants.CENTER);
		txtAzucar0.setColumns(10);
		txtAzucar0.setBounds(785, 105, 60, 21);
		frmInutritionist.getContentPane().add(txtAzucar0);
		//Se anade al ArrayList
		cajasResultados.get(0).add(txtAzucar0);
		
		txtProt0 = new JTextField();
		txtProt0.setEditable(false);
		txtProt0.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtProt0.setHorizontalAlignment(SwingConstants.CENTER);
		txtProt0.setColumns(10);
		txtProt0.setBounds(925, 105, 60, 21);
		frmInutritionist.getContentPane().add(txtProt0);
		//Se anade al ArrayList
		cajasResultados.get(0).add(txtProt0);
		
		txtSal0 = new JTextField();
		txtSal0.setEditable(false);
		txtSal0.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtSal0.setHorizontalAlignment(SwingConstants.CENTER);
		txtSal0.setColumns(10);
		txtSal0.setBounds(1065, 105, 60, 21);
		frmInutritionist.getContentPane().add(txtSal0);
		//Se anade al ArrayList
		cajasResultados.get(0).add(txtSal0);
		
		txtKCal0 = new JTextField();
		txtKCal0.setEditable(false);
		txtKCal0.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtKCal0.setHorizontalAlignment(SwingConstants.CENTER);
		txtKCal0.setColumns(10);
		txtKCal0.setBounds(1205, 105, 60, 21);
		frmInutritionist.getContentPane().add(txtKCal0);
		//Se anade al ArrayList
		cajasResultados.get(0).add(txtKCal0);
		
		// FIN FILA 1 ///////////////////////////////////////////////////////////////////////////////
		
		// FILA 2
		txtGrasas1 = new JTextField();
		txtGrasas1.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtGrasas1.setHorizontalAlignment(SwingConstants.CENTER);
		txtGrasas1.setEditable(false);
		txtGrasas1.setColumns(10);
		txtGrasas1.setBounds(365, 147, 60, 21);
		frmInutritionist.getContentPane().add(txtGrasas1);
		//Se anade al ArrayList
		cajasResultados.get(1).add(txtGrasas1);
		
		txtGSat1 = new JTextField();
		txtGSat1.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtGSat1.setHorizontalAlignment(SwingConstants.CENTER);
		txtGSat1.setEditable(false);
		txtGSat1.setColumns(10);
		txtGSat1.setBounds(505, 147, 60, 21);
		frmInutritionist.getContentPane().add(txtGSat1);
		//Se anade al ArrayList
		cajasResultados.get(1).add(txtGSat1);
		
		txtHCarb1 = new JTextField();
		txtHCarb1.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtHCarb1.setHorizontalAlignment(SwingConstants.CENTER);
		txtHCarb1.setEditable(false);
		txtHCarb1.setColumns(10);
		txtHCarb1.setBounds(645, 147, 60, 21);
		frmInutritionist.getContentPane().add(txtHCarb1);
		//Se anade al ArrayList
		cajasResultados.get(1).add(txtHCarb1);
		
		txtAzucar1 = new JTextField();
		txtAzucar1.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtAzucar1.setHorizontalAlignment(SwingConstants.CENTER);
		txtAzucar1.setEditable(false);
		txtAzucar1.setColumns(10);
		txtAzucar1.setBounds(785, 147, 60, 21);
		frmInutritionist.getContentPane().add(txtAzucar1);
		//Se anade al ArrayList
		cajasResultados.get(1).add(txtAzucar1);
		
		txtProt1 = new JTextField();
		txtProt1.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtProt1.setHorizontalAlignment(SwingConstants.CENTER);
		txtProt1.setEditable(false);
		txtProt1.setColumns(10);
		txtProt1.setBounds(925, 147, 60, 21);
		frmInutritionist.getContentPane().add(txtProt1);
		//Se anade al ArrayList
		cajasResultados.get(1).add(txtProt1);
		
		txtSal1 = new JTextField();
		txtSal1.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtSal1.setHorizontalAlignment(SwingConstants.CENTER);
		txtSal1.setEditable(false);
		txtSal1.setColumns(10);
		txtSal1.setBounds(1065, 147, 60, 21);
		frmInutritionist.getContentPane().add(txtSal1);
		//Se anade al ArrayList
		cajasResultados.get(1).add(txtSal1);
		
		txtCal1 = new JTextField();
		txtCal1.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtCal1.setHorizontalAlignment(SwingConstants.CENTER);
		txtCal1.setEditable(false);
		txtCal1.setColumns(10);
		txtCal1.setBounds(1205, 147, 60, 21);
		frmInutritionist.getContentPane().add(txtCal1);
		//Se anade al ArrayList
		cajasResultados.get(1).add(txtCal1);
		
		// FIN FILA 2 ///////////////////////////////////////////////////////////////////////////////
		
		// FILA 3
		
		txtGrasas2 = new JTextField();
		txtGrasas2.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtGrasas2.setHorizontalAlignment(SwingConstants.CENTER);
		txtGrasas2.setEditable(false);
		txtGrasas2.setColumns(10);
		txtGrasas2.setBounds(365, 190, 60, 21);
		frmInutritionist.getContentPane().add(txtGrasas2);
		//Se anade al ArrayList
		cajasResultados.get(2).add(txtGrasas2);
		
		txtGSat2 = new JTextField();
		txtGSat2.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtGSat2.setHorizontalAlignment(SwingConstants.CENTER);
		txtGSat2.setEditable(false);
		txtGSat2.setColumns(10);
		txtGSat2.setBounds(505, 190, 60, 21);
		frmInutritionist.getContentPane().add(txtGSat2);
		//Se anade al ArrayList
		cajasResultados.get(2).add(txtGSat2);
		
		txtHCarb2 = new JTextField();
		txtHCarb2.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtHCarb2.setHorizontalAlignment(SwingConstants.CENTER);
		txtHCarb2.setEditable(false);
		txtHCarb2.setColumns(10);
		txtHCarb2.setBounds(645, 190, 60, 21);
		frmInutritionist.getContentPane().add(txtHCarb2);
		//Se anade al ArrayList
		cajasResultados.get(2).add(txtHCarb2);
		
		txtAzucar2 = new JTextField();
		txtAzucar2.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtAzucar2.setHorizontalAlignment(SwingConstants.CENTER);
		txtAzucar2.setEditable(false);
		txtAzucar2.setColumns(10);
		txtAzucar2.setBounds(785, 190, 60, 21);
		frmInutritionist.getContentPane().add(txtAzucar2);
		//Se anade al ArrayList
		cajasResultados.get(2).add(txtAzucar2);
		
		txtProt2 = new JTextField();
		txtProt2.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtProt2.setHorizontalAlignment(SwingConstants.CENTER);
		txtProt2.setEditable(false);
		txtProt2.setColumns(10);
		txtProt2.setBounds(925, 190, 60, 21);
		frmInutritionist.getContentPane().add(txtProt2);
		//Se anade al ArrayList
		cajasResultados.get(2).add(txtProt2);
		
		txtSal2 = new JTextField();
		txtSal2.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtSal2.setHorizontalAlignment(SwingConstants.CENTER);
		txtSal2.setEditable(false);
		txtSal2.setColumns(10);
		txtSal2.setBounds(1065, 190, 60, 21);
		frmInutritionist.getContentPane().add(txtSal2);
		//Se anade al ArrayList
		cajasResultados.get(2).add(txtSal2);
		
		txtCal2 = new JTextField();
		txtCal2.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtCal2.setHorizontalAlignment(SwingConstants.CENTER);
		txtCal2.setEditable(false);
		txtCal2.setColumns(10);
		txtCal2.setBounds(1205, 190, 60, 21);
		frmInutritionist.getContentPane().add(txtCal2);
		//Se anade al ArrayList
		cajasResultados.get(2).add(txtCal2);
		
		// FIN FILA 3 ///////////////////////////////////////////////////////////////////////////////
		
		// FILA 4
		
		txtGrasas3 = new JTextField();
		txtGrasas3.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtGrasas3.setHorizontalAlignment(SwingConstants.CENTER);
		txtGrasas3.setEditable(false);
		txtGrasas3.setColumns(10);
		txtGrasas3.setBounds(365, 234, 60, 21);
		frmInutritionist.getContentPane().add(txtGrasas3);
		//Se anade al ArrayList
		cajasResultados.get(3).add(txtGrasas3);
		
		txtGSat3 = new JTextField();
		txtGSat3.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtGSat3.setHorizontalAlignment(SwingConstants.CENTER);
		txtGSat3.setEditable(false);
		txtGSat3.setColumns(10);
		txtGSat3.setBounds(505, 234, 60, 21);
		frmInutritionist.getContentPane().add(txtGSat3);
		//Se anade al ArrayList
		cajasResultados.get(3).add(txtGSat3);
		
		txtHCarb3 = new JTextField();
		txtHCarb3.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtHCarb3.setHorizontalAlignment(SwingConstants.CENTER);
		txtHCarb3.setEditable(false);
		txtHCarb3.setColumns(10);
		txtHCarb3.setBounds(645, 232, 60, 21);
		frmInutritionist.getContentPane().add(txtHCarb3);
		//Se anade al ArrayList
		cajasResultados.get(3).add(txtHCarb3);
		
		txtAzucar3 = new JTextField();
		txtAzucar3.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtAzucar3.setHorizontalAlignment(SwingConstants.CENTER);
		txtAzucar3.setEditable(false);
		txtAzucar3.setColumns(10);
		txtAzucar3.setBounds(785, 234, 60, 21);
		frmInutritionist.getContentPane().add(txtAzucar3);
		//Se anade al ArrayList
		cajasResultados.get(3).add(txtAzucar3);
		
		txtProt3 = new JTextField();
		txtProt3.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtProt3.setHorizontalAlignment(SwingConstants.CENTER);
		txtProt3.setEditable(false);
		txtProt3.setColumns(10);
		txtProt3.setBounds(925, 234, 60, 21);
		frmInutritionist.getContentPane().add(txtProt3);
		//Se anade al ArrayList
		cajasResultados.get(3).add(txtProt3);
		
		txtSal3 = new JTextField();
		txtSal3.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtSal3.setHorizontalAlignment(SwingConstants.CENTER);
		txtSal3.setEditable(false);
		txtSal3.setColumns(10);
		txtSal3.setBounds(1065, 234, 60, 21);
		frmInutritionist.getContentPane().add(txtSal3);
		//Se anade al ArrayList
		cajasResultados.get(3).add(txtSal3);
		
		txtCal3 = new JTextField();
		txtCal3.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtCal3.setHorizontalAlignment(SwingConstants.CENTER);
		txtCal3.setEditable(false);
		txtCal3.setColumns(10);
		txtCal3.setBounds(1205, 234, 60, 21);
		frmInutritionist.getContentPane().add(txtCal3);
		//Se anade al ArrayList
		cajasResultados.get(3).add(txtCal3);
		
		// FIN FILA 4 ///////////////////////////////////////////////////////////////////////////////
		
		// FILA 5
	
		txtGrasas4 = new JTextField();
		txtGrasas4.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtGrasas4.setHorizontalAlignment(SwingConstants.CENTER);
		txtGrasas4.setEditable(false);
		txtGrasas4.setColumns(10);
		txtGrasas4.setBounds(365, 280, 60, 21);
		frmInutritionist.getContentPane().add(txtGrasas4);
		//Se anade al ArrayList
		cajasResultados.get(4).add(txtGrasas4);
		
		txtGSat4 = new JTextField();
		txtGSat4.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtGSat4.setHorizontalAlignment(SwingConstants.CENTER);
		txtGSat4.setEditable(false);
		txtGSat4.setColumns(10);
		txtGSat4.setBounds(505, 278, 60, 21);
		frmInutritionist.getContentPane().add(txtGSat4);
		//Se anade al ArrayList
		cajasResultados.get(4).add(txtGSat4);
		
		txtHCarb4 = new JTextField();
		txtHCarb4.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtHCarb4.setHorizontalAlignment(SwingConstants.CENTER);
		txtHCarb4.setEditable(false);
		txtHCarb4.setColumns(10);
		txtHCarb4.setBounds(645, 280, 60, 21);
		frmInutritionist.getContentPane().add(txtHCarb4);
		//Se anade al ArrayList
		cajasResultados.get(4).add(txtHCarb4);
		
		txtAzucar4 = new JTextField();
		txtAzucar4.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtAzucar4.setHorizontalAlignment(SwingConstants.CENTER);
		txtAzucar4.setEditable(false);
		txtAzucar4.setColumns(10);
		txtAzucar4.setBounds(785, 280, 60, 21);
		frmInutritionist.getContentPane().add(txtAzucar4);
		//Se anade al ArrayList
		cajasResultados.get(4).add(txtAzucar4);
		
		txtProt4 = new JTextField();
		txtProt4.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtProt4.setHorizontalAlignment(SwingConstants.CENTER);
		txtProt4.setEditable(false);
		txtProt4.setColumns(10);
		txtProt4.setBounds(925, 280, 60, 21);
		frmInutritionist.getContentPane().add(txtProt4);
		//Se anade al ArrayList
		cajasResultados.get(4).add(txtProt4);
		
		txtSal4 = new JTextField();
		txtSal4.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtSal4.setHorizontalAlignment(SwingConstants.CENTER);
		txtSal4.setEditable(false);
		txtSal4.setColumns(10);
		txtSal4.setBounds(1065, 280, 60, 21);
		frmInutritionist.getContentPane().add(txtSal4);
		//Se anade al ArrayList
		cajasResultados.get(4).add(txtSal4);
		
		txtCal4 = new JTextField();
		txtCal4.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtCal4.setHorizontalAlignment(SwingConstants.CENTER);
		txtCal4.setEditable(false);
		txtCal4.setColumns(10);
		txtCal4.setBounds(1206, 280, 60, 21);
		frmInutritionist.getContentPane().add(txtCal4);
		//Se anade al ArrayList
		cajasResultados.get(4).add(txtCal4);

		/**
		 * Aquí tenemos el botón y las acciones que desencadena
		 */
		
		JButton btnValidarDieta = new JButton("Validar dieta");
		btnValidarDieta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/**
				 * Controlamos que las cajas de texto solo tengan numeros manejando la excepcion
				 */
				try {
					/**
					 * Aqui comprobamos que las cantidades son adecuadas nutricionalmente o no y coloreamos las cajas
					 */
					double treintaPorCienIngCalorica = ((calcularIngestaCalorica(alimentosAL)*30.0)/100.0);
					System.out.println(treintaPorCienIngCalorica);
					double diezPorCienIngCalorica = ((calcularIngestaCalorica(alimentosAL)*10)/100);
					System.out.println(diezPorCienIngCalorica);
					System.out.println(calcularGrasasTotales(alimentosAL));
					boolean valoresSaludables = calcularGrasasTotales(alimentosAL)< treintaPorCienIngCalorica && calcularAzucarTotal(alimentosAL)< diezPorCienIngCalorica && (calcularSalTotal(alimentosAL) < 5);
					for (int i= 0; i < cajasResultados.size(); i++) {
						if (Double.valueOf(cajasCantidades.get(i).getText()) > 0) {
							for (int j = 0; j < cajasResultados.get(i).size(); j++) {
								if (valoresSaludables) {
									cajasResultados.get(i).get(j).setBackground(new Color(0,255,0));
								}else {
									{
										cajasResultados.get(i).get(j).setBackground(new Color(255,0,0));
									}
									
								}
							}
						}
					}
					
					/**
					 * Aqui llamamos al metodo que realiza todos los cálculos
					 */
					calcularValoresNutricionales(alimentosAL);
					
				}

				catch (NumberFormatException e1){
					JOptionPane.showMessageDialog(frmInutritionist, "Solo numeros admitidos!", "Error", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnValidarDieta.setBackground(new Color(255, 255, 255));
		btnValidarDieta.setBounds(600, 459, 114, 27);
		frmInutritionist.getContentPane().add(btnValidarDieta);
		
		lblgr1 = new JLabel("g");
		lblgr1.setBounds(319, 107, 18, 17);
		frmInutritionist.getContentPane().add(lblgr1);
		
		lblgr2 = new JLabel("g");
		lblgr2.setBounds(319, 151, 8, 17);
		frmInutritionist.getContentPane().add(lblgr2);
		
		lblgr3 = new JLabel("g");
		lblgr3.setBounds(319, 192, 18, 17);
		frmInutritionist.getContentPane().add(lblgr3);
		
		lblgr4 = new JLabel("g");
		lblgr4.setBounds(319, 236, 18, 17);
		frmInutritionist.getContentPane().add(lblgr4);
		
		lblgr5 = new JLabel("g");
		lblgr5.setBounds(319, 282, 18, 17);
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
				JOptionPane.showMessageDialog(frmInutritionist, "Seleccione que alimentos consume, indique cuanta cantidad y pulse el bot�n", "Help", JOptionPane.INFORMATION_MESSAGE);
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
			if (Double.valueOf(cajasCantidades.get(i).getText()) > 0) {
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
			if (Double.valueOf(cajasCantidades.get(i).getText()) > 0) {
				totalKCal+=alimentos.get(i).getKiloCalorias()*(Double.valueOf(cajasCantidades.get(i).getText())/100);
				
			}
		}
		return totalKCal;
	}

	/**
	 *  Metodo para calcular las grasas totales
	 */
	private static double calcularGrasasTotales(ArrayList <Alimento> alimentos) {
		double totalGrasas=0;
		for (int i=0;i<alimentos.size();i++) {
			if (Double.valueOf(cajasCantidades.get(i).getText()) > 0) {
				totalGrasas+=alimentos.get(i).getGrasas()*(Double.valueOf(cajasCantidades.get(i).getText())/100);
				
			}
		}
		return totalGrasas;
	}

	/**
	 * Metodo para calcular el azucar total
	 */
	private static double calcularAzucarTotal(ArrayList <Alimento> alimentos) {
		double totalAzucar=0;
		for (int i=0;i<alimentos.size();i++) {
			if (Double.valueOf(cajasCantidades.get(i).getText()) > 0) {
				totalAzucar+=alimentos.get(i).getAzucar()*(Double.valueOf(cajasCantidades.get(i).getText())/100);
			
			}
		}
		return totalAzucar;
	}

	/**
	 * Metodo para calcular la sal total
	 */
	private static double calcularSalTotal(ArrayList <Alimento> alimentos) {
		double totalSal=0;
		for (int i=0;i<alimentos.size();i++) {
			if (Double.valueOf(cajasCantidades.get(i).getText()) > 0) {
				totalSal+=alimentos.get(i).getSal()*(Double.valueOf(cajasCantidades.get(i).getText())/100);
				
			}
		}
		return totalSal;
	}
	
}
