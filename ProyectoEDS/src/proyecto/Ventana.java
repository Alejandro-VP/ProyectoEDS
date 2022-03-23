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

public class Ventana {

	private JFrame frame;
	private JTextField txtCantAlim1;
	// Creamos un ArrayList donde iremos añadiendo los alimentos
	private ArrayList <Alimento> alimentosAL = new ArrayList <> ();
	private JTextField txtCantAlim2;
	
	private JTextField txtCantAlim3;
	private JTextField txtGrasas0;
	private JTextField txtCantAlim4;
	private JTextField txtCantAlim5;
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
		// Creamos los alimentos que introduciremos en el ArrayList
		// Orden: Nombre, Grasas, Grasas Saturadas, Hidratos de carbono, Azucar, Proteínas, Sal, Calorías
		Alimento pera = new Alimento ("Pera", 20, 10, 30, 15, 5, 2, 2000);
		Alimento manzana = new Alimento ("Manzana",58,15,23,15,96,200,455);
		Alimento macarrones = new Alimento ("Macarrones",4,2,8,7,58,4,500);
		
		
		
		// Llenamos el ArrayList con los Alimentos
		alimentosAL.add(pera);
		alimentosAL.add(manzana);
		alimentosAL.add(macarrones);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 950, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAlimentos = new JLabel("Alimentos");
		lblAlimentos.setBounds(55, 62, 73, 17);
		frame.getContentPane().add(lblAlimentos);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(187, 62, 60, 17);
		frame.getContentPane().add(lblCantidad);
		
		JLabel lblAlimento1 = new JLabel("");
		lblAlimento1.setBounds(55, 103, 60, 17);
		frame.getContentPane().add(lblAlimento1);
		// Añadimos el 1er alimento a la etiqueta de alimento
		lblAlimento1.setText(alimentosAL.get(0).getNombre());
		
		
		
		JCheckBox chckAlim1 = new JCheckBox("");
		chckAlim1.setBounds(23, 97, 18, 25);
		frame.getContentPane().add(chckAlim1);
		
		txtCantAlim1 = new JTextField();
		txtCantAlim1.setBounds(158, 101, 114, 21);
		frame.getContentPane().add(txtCantAlim1);
		txtCantAlim1.setColumns(10);
		
		JCheckBox chckAlim2 = new JCheckBox("");
		chckAlim2.setBounds(23, 139, 21, 25);
		frame.getContentPane().add(chckAlim2);
		
		JLabel lblAlimento2 = new JLabel("");
		lblAlimento2.setBounds(55, 145, 60, 17);
		frame.getContentPane().add(lblAlimento2);
		// Añadimos el segundo alimento a la etiqueta
		lblAlimento2.setText(alimentosAL.get(1).getNombre());
		
		
		
		txtCantAlim2 = new JTextField();
		txtCantAlim2.setBounds(158, 143, 114, 21);
		frame.getContentPane().add(txtCantAlim2);
		txtCantAlim2.setColumns(10);
		
		JCheckBox chckAlim3 = new JCheckBox("New check box");
		chckAlim3.setBounds(23, 186, 18, 21);
		frame.getContentPane().add(chckAlim3);
		
		JLabel lblAlimento3 = new JLabel((String) null);
		lblAlimento3.setBounds(55, 188, 73, 17);
		frame.getContentPane().add(lblAlimento3);
		// Añadimos el tercer alimento a su respectiva etiqueta
		lblAlimento3.setText(alimentosAL.get(2).getNombre());
		
		txtCantAlim3 = new JTextField();
		txtCantAlim3.setBounds(158, 186, 114, 21);
		frame.getContentPane().add(txtCantAlim3);
		txtCantAlim3.setColumns(10);
		
		JLabel lblGrasas = new JLabel("Grasas");
		lblGrasas.setBounds(357, 62, 51, 17);
		frame.getContentPane().add(lblGrasas);
		
		JLabel lblGsaturadas = new JLabel("G.Saturadas");
		lblGsaturadas.setBounds(420, 62, 78, 17);
		frame.getContentPane().add(lblGsaturadas);
		
		JLabel lblHidratosCarbono = new JLabel("H. Carbono");
		lblHidratosCarbono.setBounds(510, 62, 73, 17);
		frame.getContentPane().add(lblHidratosCarbono);
		
		JLabel lblAzcar = new JLabel("Azúcar");
		lblAzcar.setBounds(599, 62, 51, 17);
		frame.getContentPane().add(lblAzcar);
		
		JLabel lblProtenas = new JLabel("Proteínas");
		lblProtenas.setBounds(672, 62, 60, 17);
		frame.getContentPane().add(lblProtenas);
		
		JLabel lblSal = new JLabel("Sal");
		lblSal.setBounds(773, 62, 40, 17);
		frame.getContentPane().add(lblSal);
		
		JLabel lblCaloras = new JLabel("Calorías");
		lblCaloras.setBounds(837, 62, 51, 17);
		frame.getContentPane().add(lblCaloras);
		
		JLabel lblCantidadesIngeridas = new JLabel("Cantidades ingeridas");
		lblCantidadesIngeridas.setForeground(new Color(30, 144, 255));
		lblCantidadesIngeridas.setBounds(532, 26, 147, 17);
		frame.getContentPane().add(lblCantidadesIngeridas);
		
		txtGrasas0 = new JTextField();
		txtGrasas0.setEditable(false);
		txtGrasas0.setBounds(348, 101, 60, 21);
		frame.getContentPane().add(txtGrasas0);
		txtGrasas0.setColumns(10);
		
		txtCantAlim4 = new JTextField();
		txtCantAlim4.setColumns(10);
		txtCantAlim4.setBounds(158, 230, 114, 21);
		frame.getContentPane().add(txtCantAlim4);
		
		JLabel lblAlimento4 = new JLabel((String) null);
		lblAlimento4.setBounds(55, 232, 73, 17);
		frame.getContentPane().add(lblAlimento4);
		
		JCheckBox chckAlim4 = new JCheckBox("New check box");
		chckAlim4.setBounds(23, 228, 18, 21);
		frame.getContentPane().add(chckAlim4);
		
		JLabel lblAlimento5 = new JLabel((String) null);
		lblAlimento5.setBounds(55, 278, 73, 17);
		frame.getContentPane().add(lblAlimento5);
		
		txtCantAlim5 = new JTextField();
		txtCantAlim5.setColumns(10);
		txtCantAlim5.setBounds(158, 274, 114, 21);
		frame.getContentPane().add(txtCantAlim5);
		
		JCheckBox chckAlim5 = new JCheckBox("New check box");
		chckAlim5.setBounds(23, 274, 18, 21);
		frame.getContentPane().add(chckAlim5);
		
		txtGSat0 = new JTextField();
		txtGSat0.setEditable(false);
		txtGSat0.setColumns(10);
		txtGSat0.setBounds(430, 101, 60, 21);
		frame.getContentPane().add(txtGSat0);
		
		txtHCarb0 = new JTextField();
		txtHCarb0.setEditable(false);
		txtHCarb0.setColumns(10);
		txtHCarb0.setBounds(510, 101, 60, 21);
		frame.getContentPane().add(txtHCarb0);
		
		txtAzucar0 = new JTextField();
		txtAzucar0.setEditable(false);
		txtAzucar0.setColumns(10);
		txtAzucar0.setBounds(590, 101, 60, 21);
		frame.getContentPane().add(txtAzucar0);
		
		txtProt0 = new JTextField();
		txtProt0.setEditable(false);
		txtProt0.setColumns(10);
		txtProt0.setBounds(672, 101, 60, 21);
		frame.getContentPane().add(txtProt0);
		
		txtSal0 = new JTextField();
		txtSal0.setEditable(false);
		txtSal0.setColumns(10);
		txtSal0.setBounds(755, 101, 60, 21);
		frame.getContentPane().add(txtSal0);
		
		txtCal0 = new JTextField();
		txtCal0.setEditable(false);
		txtCal0.setColumns(10);
		txtCal0.setBounds(837, 101, 60, 21);
		frame.getContentPane().add(txtCal0);
		
		txtGrasas1 = new JTextField();
		txtGrasas1.setEditable(false);
		txtGrasas1.setColumns(10);
		txtGrasas1.setBounds(348, 143, 60, 21);
		frame.getContentPane().add(txtGrasas1);
		
		txtGrasas2 = new JTextField();
		txtGrasas2.setEditable(false);
		txtGrasas2.setColumns(10);
		txtGrasas2.setBounds(348, 186, 60, 21);
		frame.getContentPane().add(txtGrasas2);
		
		txtGrasas3 = new JTextField();
		txtGrasas3.setEditable(false);
		txtGrasas3.setColumns(10);
		txtGrasas3.setBounds(348, 230, 60, 21);
		frame.getContentPane().add(txtGrasas3);
		
		txtGrasas4 = new JTextField();
		txtGrasas4.setEditable(false);
		txtGrasas4.setColumns(10);
		txtGrasas4.setBounds(348, 274, 60, 21);
		frame.getContentPane().add(txtGrasas4);
		
		txtGSat1 = new JTextField();
		txtGSat1.setEditable(false);
		txtGSat1.setColumns(10);
		txtGSat1.setBounds(430, 143, 60, 21);
		frame.getContentPane().add(txtGSat1);
		
		txtGSat2 = new JTextField();
		txtGSat2.setEditable(false);
		txtGSat2.setColumns(10);
		txtGSat2.setBounds(430, 186, 60, 21);
		frame.getContentPane().add(txtGSat2);
		
		txtGSat3 = new JTextField();
		txtGSat3.setEditable(false);
		txtGSat3.setColumns(10);
		txtGSat3.setBounds(430, 230, 60, 21);
		frame.getContentPane().add(txtGSat3);
		
		txtGSat4 = new JTextField();
		txtGSat4.setEditable(false);
		txtGSat4.setColumns(10);
		txtGSat4.setBounds(430, 274, 60, 21);
		frame.getContentPane().add(txtGSat4);
		
		txtHCarb1 = new JTextField();
		txtHCarb1.setEditable(false);
		txtHCarb1.setColumns(10);
		txtHCarb1.setBounds(510, 143, 60, 21);
		frame.getContentPane().add(txtHCarb1);
		
		txtHCarb2 = new JTextField();
		txtHCarb2.setEditable(false);
		txtHCarb2.setColumns(10);
		txtHCarb2.setBounds(510, 186, 60, 21);
		frame.getContentPane().add(txtHCarb2);
		
		txtHCarb3 = new JTextField();
		txtHCarb3.setEditable(false);
		txtHCarb3.setColumns(10);
		txtHCarb3.setBounds(510, 230, 60, 21);
		frame.getContentPane().add(txtHCarb3);
		
		txtHCarb4 = new JTextField();
		txtHCarb4.setEditable(false);
		txtHCarb4.setColumns(10);
		txtHCarb4.setBounds(510, 274, 60, 21);
		frame.getContentPane().add(txtHCarb4);
		
		txtAzucar1 = new JTextField();
		txtAzucar1.setEditable(false);
		txtAzucar1.setColumns(10);
		txtAzucar1.setBounds(590, 143, 60, 21);
		frame.getContentPane().add(txtAzucar1);
		
		txtAzucar2 = new JTextField();
		txtAzucar2.setEditable(false);
		txtAzucar2.setColumns(10);
		txtAzucar2.setBounds(590, 186, 60, 21);
		frame.getContentPane().add(txtAzucar2);
		
		txtAzucar3 = new JTextField();
		txtAzucar3.setEditable(false);
		txtAzucar3.setColumns(10);
		txtAzucar3.setBounds(590, 230, 60, 21);
		frame.getContentPane().add(txtAzucar3);
		
		txtAzucar4 = new JTextField();
		txtAzucar4.setEditable(false);
		txtAzucar4.setColumns(10);
		txtAzucar4.setBounds(590, 274, 60, 21);
		frame.getContentPane().add(txtAzucar4);
		
		txtProt1 = new JTextField();
		txtProt1.setEditable(false);
		txtProt1.setColumns(10);
		txtProt1.setBounds(672, 143, 60, 21);
		frame.getContentPane().add(txtProt1);
		
		txtProt2 = new JTextField();
		txtProt2.setEditable(false);
		txtProt2.setColumns(10);
		txtProt2.setBounds(672, 186, 60, 21);
		frame.getContentPane().add(txtProt2);
		
		txtProt3 = new JTextField();
		txtProt3.setEditable(false);
		txtProt3.setColumns(10);
		txtProt3.setBounds(672, 230, 60, 21);
		frame.getContentPane().add(txtProt3);
		
		txtProt4 = new JTextField();
		txtProt4.setEditable(false);
		txtProt4.setColumns(10);
		txtProt4.setBounds(672, 274, 60, 21);
		frame.getContentPane().add(txtProt4);
		
		txtSal1 = new JTextField();
		txtSal1.setEditable(false);
		txtSal1.setColumns(10);
		txtSal1.setBounds(753, 143, 60, 21);
		frame.getContentPane().add(txtSal1);
		
		txtSal2 = new JTextField();
		txtSal2.setEditable(false);
		txtSal2.setColumns(10);
		txtSal2.setBounds(753, 186, 60, 21);
		frame.getContentPane().add(txtSal2);
		
		txtSal3 = new JTextField();
		txtSal3.setEditable(false);
		txtSal3.setColumns(10);
		txtSal3.setBounds(753, 230, 60, 21);
		frame.getContentPane().add(txtSal3);
		
		txtSal4 = new JTextField();
		txtSal4.setEditable(false);
		txtSal4.setColumns(10);
		txtSal4.setBounds(753, 274, 60, 21);
		frame.getContentPane().add(txtSal4);
		
		txtCal1 = new JTextField();
		txtCal1.setEditable(false);
		txtCal1.setColumns(10);
		txtCal1.setBounds(837, 143, 60, 21);
		frame.getContentPane().add(txtCal1);
		
		txtCal2 = new JTextField();
		txtCal2.setEditable(false);
		txtCal2.setColumns(10);
		txtCal2.setBounds(837, 186, 60, 21);
		frame.getContentPane().add(txtCal2);
		
		txtCal3 = new JTextField();
		txtCal3.setEditable(false);
		txtCal3.setColumns(10);
		txtCal3.setBounds(837, 230, 60, 21);
		frame.getContentPane().add(txtCal3);
		
		txtCal4 = new JTextField();
		txtCal4.setEditable(false);
		txtCal4.setColumns(10);
		txtCal4.setBounds(837, 274, 60, 21);
		frame.getContentPane().add(txtCal4);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(420, 353, 105, 27);
		frame.getContentPane().add(btnNewButton);
		
	}
}
