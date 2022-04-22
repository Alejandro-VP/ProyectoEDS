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

public class Ventana {

	
	/**
	 * Metodos calcular grasas
	 */
	
	
	
	/*
	private void calcularGrasas(Alimento alimento)
	{		
		
	
		for (int i=0; i<5; i++)
		{
			if (i==0)
			{
				String textoCantidad=txtCantAlim1.getText();
				double numeroCantidad=Double.valueOf(textoCantidad);
				return numeroCantidad*alimento.getGrasas();
			}
			else if(i==1)
			{

			}
		}
	}
*/
	
	
	
	
	private JFrame frame;
	
	/**
	 *  Creamos un ArrayList donde iremos añadiendo los alimentos
	 */
	private ArrayList <Alimento> alimentosAL = new ArrayList <> ();
	private JTextField txtCantAlim1;
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
		// Creamos los alimentos que introduciremos en el ArrayList
		// Orden: Nombre, Grasas, Grasas Saturadas, Hidratos de carbono, Azucar, Proteínas, Sal, kiloCalorías
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
		
		lblErrorAzucar = new JLabel("");
		lblErrorAzucar.setBounds(466, 406, 360, 17);
		frame.getContentPane().add(lblErrorAzucar);
		
		
		/**
		 * En este bucle se comprueba que las grasas saturadas no sean mayores que las totales y que los azucares no sean mayores que los hidratos de carbono
		 */
		for (int i = 0; i < alimentosAL.size(); i++) {
			if (alimentosAL.get(i).getGrasasSat() > alimentosAL.get(i).getGrasas()) {
				lblErrorSaturadas.setText("Las grasas saturadas no pueden ser mayores que las totales");
				}
			if (alimentosAL.get(i).getAzucar() > alimentosAL.get(i).getHidratosCarbono()) {
				lblErrorAzucar.setText("Los azucares no pueden superar los hidratos"+alimentosAL.get(i).getNombre());
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
		// Añadimos el 1er alimento a la etiqueta de alimento
		lblAlimento1.setText(alimentosAL.get(0).getNombre());
		
		
		
		JCheckBox chckAlim1 = new JCheckBox("");
		chckAlim1.setBounds(23, 97, 18, 25);
		frame.getContentPane().add(chckAlim1);
		
		txtCantAlim1 = new JTextField();
		txtCantAlim1.setBounds(196, 101, 67, 21);
		frame.getContentPane().add(txtCantAlim1);
		txtCantAlim1.setColumns(10);
		
		JCheckBox chckAlim2 = new JCheckBox("");
		chckAlim2.setBounds(23, 139, 21, 25);
		frame.getContentPane().add(chckAlim2);
		
		JLabel lblAlimento2 = new JLabel("");
		lblAlimento2.setBounds(55, 145, 131, 17);
		frame.getContentPane().add(lblAlimento2);
		// Añadimos el segundo alimento a la etiqueta
		lblAlimento2.setText(alimentosAL.get(1).getNombre());
		
		txtCantAlim2 = new JTextField();
		txtCantAlim2.setBounds(196, 143, 67, 21);
		frame.getContentPane().add(txtCantAlim2);
		txtCantAlim2.setColumns(10);
		
		JCheckBox chckAlim3 = new JCheckBox("New check box");
		chckAlim3.setBounds(23, 186, 18, 21);
		frame.getContentPane().add(chckAlim3);
		
		JLabel lblAlimento3 = new JLabel((String) null);
		lblAlimento3.setBounds(55, 188, 131, 17);
		frame.getContentPane().add(lblAlimento3);
		// Añadimos el tercer alimento a su respectiva etiqueta
		lblAlimento3.setText(alimentosAL.get(2).getNombre());
		
		txtCantAlim3 = new JTextField();
		txtCantAlim3.setBounds(196, 186, 67, 21);
		frame.getContentPane().add(txtCantAlim3);
		txtCantAlim3.setColumns(10);
		
		JLabel lblGrasas = new JLabel("Grasas");
		lblGrasas.setBounds(329, 62, 67, 17);
		frame.getContentPane().add(lblGrasas);
		
		JLabel lblGsaturadas = new JLabel("G.Saturadas");
		lblGsaturadas.setBounds(466, 62, 94, 17);
		frame.getContentPane().add(lblGsaturadas);
		
		JLabel lblHidratosCarbono = new JLabel("H. Carbono");
		lblHidratosCarbono.setBounds(600, 62, 94, 17);
		frame.getContentPane().add(lblHidratosCarbono);
		
		JLabel lblAzcar = new JLabel("Azucar");
		lblAzcar.setBounds(752, 62, 74, 17);
		frame.getContentPane().add(lblAzcar);
		
		JLabel lblProtenas = new JLabel("Proteinas");
		lblProtenas.setBounds(880, 62, 94, 17);
		frame.getContentPane().add(lblProtenas);
		
		JLabel lblSal = new JLabel("Sal");
		lblSal.setBounds(1042, 62, 18, 17);
		frame.getContentPane().add(lblSal);
		
		JLabel lblCaloras = new JLabel("KiloCalorias");
		lblCaloras.setBounds(1161, 62, 82, 17);
		frame.getContentPane().add(lblCaloras);
		
		JLabel lblCantidadesIngeridas = new JLabel("Valores nutricionales");
		lblCantidadesIngeridas.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidadesIngeridas.setForeground(new Color(30, 144, 255));
		lblCantidadesIngeridas.setBounds(572, 22, 147, 17);
		frame.getContentPane().add(lblCantidadesIngeridas);
		
		txtGrasas0 = new JTextField();
		txtGrasas0.setHorizontalAlignment(SwingConstants.CENTER);
		txtGrasas0.setEditable(false);
		txtGrasas0.setBounds(320, 101, 60, 21);
		frame.getContentPane().add(txtGrasas0);
		txtGrasas0.setColumns(10);
		
		JLabel lblAlimento4 = new JLabel((String) null);
		lblAlimento4.setBounds(55, 232, 131, 17);
		frame.getContentPane().add(lblAlimento4);
		lblAlimento4.setText(alimentosAL.get(3).getNombre());
		
		txtCantAlim4 = new JTextField();
		txtCantAlim4.setColumns(10);
		txtCantAlim4.setBounds(196, 230, 67, 21);
		frame.getContentPane().add(txtCantAlim4);
		
		JCheckBox chckAlim4 = new JCheckBox("New check box");
		chckAlim4.setBounds(23, 228, 18, 21);
		frame.getContentPane().add(chckAlim4);
		
		JLabel lblAlimento5 = new JLabel((String) null);
		lblAlimento5.setBounds(55, 278, 131, 17);
		frame.getContentPane().add(lblAlimento5);
		lblAlimento5.setText(alimentosAL.get(4).getNombre());
		
		txtCantAlim5 = new JTextField();
		txtCantAlim5.setColumns(10);
		txtCantAlim5.setBounds(196, 276, 67, 21);
		frame.getContentPane().add(txtCantAlim5);
		
		JCheckBox chckAlim5 = new JCheckBox("New check box");
		chckAlim5.setBounds(23, 274, 18, 21);
		frame.getContentPane().add(chckAlim5);
		
		txtGSat0 = new JTextField();
		txtGSat0.setHorizontalAlignment(SwingConstants.CENTER);
		txtGSat0.setEditable(false);
		txtGSat0.setColumns(10);
		txtGSat0.setBounds(460, 101, 60, 21);
		frame.getContentPane().add(txtGSat0);
		
		txtHCarb0 = new JTextField();
		txtHCarb0.setHorizontalAlignment(SwingConstants.CENTER);
		txtHCarb0.setEditable(false);
		txtHCarb0.setColumns(10);
		txtHCarb0.setBounds(600, 101, 60, 21);
		frame.getContentPane().add(txtHCarb0);
		
		txtAzucar0 = new JTextField();
		txtAzucar0.setHorizontalAlignment(SwingConstants.CENTER);
		txtAzucar0.setEditable(false);
		txtAzucar0.setColumns(10);
		txtAzucar0.setBounds(740, 101, 60, 21);
		frame.getContentPane().add(txtAzucar0);
		
		txtProt0 = new JTextField();
		txtProt0.setHorizontalAlignment(SwingConstants.CENTER);
		txtProt0.setEditable(false);
		txtProt0.setColumns(10);
		txtProt0.setBounds(880, 101, 60, 21);
		frame.getContentPane().add(txtProt0);
		
		txtSal0 = new JTextField();
		txtSal0.setHorizontalAlignment(SwingConstants.CENTER);
		txtSal0.setEditable(false);
		txtSal0.setColumns(10);
		txtSal0.setBounds(1020, 101, 60, 21);
		frame.getContentPane().add(txtSal0);
		
		txtCal0 = new JTextField();
		txtCal0.setHorizontalAlignment(SwingConstants.CENTER);
		txtCal0.setEditable(false);
		txtCal0.setColumns(10);
		txtCal0.setBounds(1160, 101, 60, 21);
		frame.getContentPane().add(txtCal0);
		
		txtGrasas1 = new JTextField();
		txtGrasas1.setHorizontalAlignment(SwingConstants.CENTER);
		txtGrasas1.setEditable(false);
		txtGrasas1.setColumns(10);
		txtGrasas1.setBounds(320, 143, 60, 21);
		frame.getContentPane().add(txtGrasas1);
		
		txtGrasas2 = new JTextField();
		txtGrasas2.setHorizontalAlignment(SwingConstants.CENTER);
		txtGrasas2.setEditable(false);
		txtGrasas2.setColumns(10);
		txtGrasas2.setBounds(320, 186, 60, 21);
		frame.getContentPane().add(txtGrasas2);
		
		txtGrasas3 = new JTextField();
		txtGrasas3.setHorizontalAlignment(SwingConstants.CENTER);
		txtGrasas3.setEditable(false);
		txtGrasas3.setColumns(10);
		txtGrasas3.setBounds(320, 230, 60, 21);
		frame.getContentPane().add(txtGrasas3);
		
		txtGrasas4 = new JTextField();
		txtGrasas4.setHorizontalAlignment(SwingConstants.CENTER);
		txtGrasas4.setEditable(false);
		txtGrasas4.setColumns(10);
		txtGrasas4.setBounds(320, 276, 60, 21);
		frame.getContentPane().add(txtGrasas4);
		
		txtGSat1 = new JTextField();
		txtGSat1.setHorizontalAlignment(SwingConstants.CENTER);
		txtGSat1.setEditable(false);
		txtGSat1.setColumns(10);
		txtGSat1.setBounds(460, 143, 60, 21);
		frame.getContentPane().add(txtGSat1);
		
		txtGSat2 = new JTextField();
		txtGSat2.setHorizontalAlignment(SwingConstants.CENTER);
		txtGSat2.setEditable(false);
		txtGSat2.setColumns(10);
		txtGSat2.setBounds(460, 186, 60, 21);
		frame.getContentPane().add(txtGSat2);
		
		txtGSat3 = new JTextField();
		txtGSat3.setHorizontalAlignment(SwingConstants.CENTER);
		txtGSat3.setEditable(false);
		txtGSat3.setColumns(10);
		txtGSat3.setBounds(460, 230, 60, 21);
		frame.getContentPane().add(txtGSat3);
		
		txtGSat4 = new JTextField();
		txtGSat4.setHorizontalAlignment(SwingConstants.CENTER);
		txtGSat4.setEditable(false);
		txtGSat4.setColumns(10);
		txtGSat4.setBounds(460, 274, 60, 21);
		frame.getContentPane().add(txtGSat4);
		
		txtHCarb1 = new JTextField();
		txtHCarb1.setHorizontalAlignment(SwingConstants.CENTER);
		txtHCarb1.setEditable(false);
		txtHCarb1.setColumns(10);
		txtHCarb1.setBounds(600, 143, 60, 21);
		frame.getContentPane().add(txtHCarb1);
		
		txtHCarb2 = new JTextField();
		txtHCarb2.setHorizontalAlignment(SwingConstants.CENTER);
		txtHCarb2.setEditable(false);
		txtHCarb2.setColumns(10);
		txtHCarb2.setBounds(600, 186, 60, 21);
		frame.getContentPane().add(txtHCarb2);
		
		txtHCarb3 = new JTextField();
		txtHCarb3.setHorizontalAlignment(SwingConstants.CENTER);
		txtHCarb3.setEditable(false);
		txtHCarb3.setColumns(10);
		txtHCarb3.setBounds(600, 228, 60, 21);
		frame.getContentPane().add(txtHCarb3);
		
		txtHCarb4 = new JTextField();
		txtHCarb4.setHorizontalAlignment(SwingConstants.CENTER);
		txtHCarb4.setEditable(false);
		txtHCarb4.setColumns(10);
		txtHCarb4.setBounds(600, 276, 60, 21);
		frame.getContentPane().add(txtHCarb4);
		
		txtAzucar1 = new JTextField();
		txtAzucar1.setHorizontalAlignment(SwingConstants.CENTER);
		txtAzucar1.setEditable(false);
		txtAzucar1.setColumns(10);
		txtAzucar1.setBounds(740, 143, 60, 21);
		frame.getContentPane().add(txtAzucar1);
		
		txtAzucar2 = new JTextField();
		txtAzucar2.setHorizontalAlignment(SwingConstants.CENTER);
		txtAzucar2.setEditable(false);
		txtAzucar2.setColumns(10);
		txtAzucar2.setBounds(740, 186, 60, 21);
		frame.getContentPane().add(txtAzucar2);
		
		txtAzucar3 = new JTextField();
		txtAzucar3.setHorizontalAlignment(SwingConstants.CENTER);
		txtAzucar3.setEditable(false);
		txtAzucar3.setColumns(10);
		txtAzucar3.setBounds(740, 230, 60, 21);
		frame.getContentPane().add(txtAzucar3);
		
		txtAzucar4 = new JTextField();
		txtAzucar4.setHorizontalAlignment(SwingConstants.CENTER);
		txtAzucar4.setEditable(false);
		txtAzucar4.setColumns(10);
		txtAzucar4.setBounds(740, 276, 60, 21);
		frame.getContentPane().add(txtAzucar4);
		
		txtProt1 = new JTextField();
		txtProt1.setHorizontalAlignment(SwingConstants.CENTER);
		txtProt1.setEditable(false);
		txtProt1.setColumns(10);
		txtProt1.setBounds(880, 139, 60, 21);
		frame.getContentPane().add(txtProt1);
		
		txtProt2 = new JTextField();
		txtProt2.setHorizontalAlignment(SwingConstants.CENTER);
		txtProt2.setEditable(false);
		txtProt2.setColumns(10);
		txtProt2.setBounds(880, 186, 60, 21);
		frame.getContentPane().add(txtProt2);
		
		txtProt3 = new JTextField();
		txtProt3.setHorizontalAlignment(SwingConstants.CENTER);
		txtProt3.setEditable(false);
		txtProt3.setColumns(10);
		txtProt3.setBounds(880, 230, 60, 21);
		frame.getContentPane().add(txtProt3);
		
		txtProt4 = new JTextField();
		txtProt4.setHorizontalAlignment(SwingConstants.CENTER);
		txtProt4.setEditable(false);
		txtProt4.setColumns(10);
		txtProt4.setBounds(880, 276, 60, 21);
		frame.getContentPane().add(txtProt4);
		
		txtSal1 = new JTextField();
		txtSal1.setHorizontalAlignment(SwingConstants.CENTER);
		txtSal1.setEditable(false);
		txtSal1.setColumns(10);
		txtSal1.setBounds(1020, 139, 60, 21);
		frame.getContentPane().add(txtSal1);
		
		txtSal2 = new JTextField();
		txtSal2.setHorizontalAlignment(SwingConstants.CENTER);
		txtSal2.setEditable(false);
		txtSal2.setColumns(10);
		txtSal2.setBounds(1020, 186, 60, 21);
		frame.getContentPane().add(txtSal2);
		
		txtSal3 = new JTextField();
		txtSal3.setHorizontalAlignment(SwingConstants.CENTER);
		txtSal3.setEditable(false);
		txtSal3.setColumns(10);
		txtSal3.setBounds(1020, 230, 60, 21);
		frame.getContentPane().add(txtSal3);
		
		txtSal4 = new JTextField();
		txtSal4.setHorizontalAlignment(SwingConstants.CENTER);
		txtSal4.setEditable(false);
		txtSal4.setColumns(10);
		txtSal4.setBounds(1020, 274, 60, 21);
		frame.getContentPane().add(txtSal4);
		
		txtCal1 = new JTextField();
		txtCal1.setHorizontalAlignment(SwingConstants.CENTER);
		txtCal1.setEditable(false);
		txtCal1.setColumns(10);
		txtCal1.setBounds(1160, 143, 60, 21);
		frame.getContentPane().add(txtCal1);
		
		txtCal2 = new JTextField();
		txtCal2.setHorizontalAlignment(SwingConstants.CENTER);
		txtCal2.setEditable(false);
		txtCal2.setColumns(10);
		txtCal2.setBounds(1160, 186, 60, 21);
		frame.getContentPane().add(txtCal2);
		
		txtCal3 = new JTextField();
		txtCal3.setHorizontalAlignment(SwingConstants.CENTER);
		txtCal3.setEditable(false);
		txtCal3.setColumns(10);
		txtCal3.setBounds(1160, 230, 60, 21);
		frame.getContentPane().add(txtCal3);
		
		txtCal4 = new JTextField();
		txtCal4.setHorizontalAlignment(SwingConstants.CENTER);
		txtCal4.setEditable(false);
		txtCal4.setColumns(10);
		txtCal4.setBounds(1161, 276, 60, 21);
		frame.getContentPane().add(txtCal4);
		
		JButton btnValidarDieta = new JButton("Validar dieta");
		btnValidarDieta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
				//jyjgjyjyt
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
}
