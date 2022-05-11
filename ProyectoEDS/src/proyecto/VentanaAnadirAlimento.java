package proyecto;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPanel;

public class VentanaAnadirAlimento {

	public JFrame frmAnadirAlimento;
	private JTextField txtRecogerNombre;
	private JTextField txtRecogerGrasas;
	private JTextField txtRecogerGSat;
	private JTextField txtRecogerHCarb;
	private JTextField txtRecogerAzucar;
	private JTextField txtRecogerProteinas;
	private JTextField txtRecogerSal;
	private JTextField txtRecogerKCal;
	private Alimento nuevoAlimento;
	private JButton btnGuardar;
	private JLabel lblTitulo;
	private JButton btnAyuda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAnadirAlimento window = new VentanaAnadirAlimento();
					window.frmAnadirAlimento.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaAnadirAlimento() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAnadirAlimento = new JFrame();
		frmAnadirAlimento.setTitle("A\u00F1adir alimento");
		frmAnadirAlimento.setBounds(100, 100, 377, 443);
		frmAnadirAlimento.getContentPane().setLayout(null);
		frmAnadirAlimento.getContentPane().setBackground(new Color(216, 191, 216));
		frmAnadirAlimento.setLocationRelativeTo(null);


		JLabel lblNombreAlimento = new JLabel("Nombre:");
		lblNombreAlimento.setBounds(88, 69, 76, 14);
		frmAnadirAlimento.getContentPane().add(lblNombreAlimento);

		txtRecogerNombre = new JTextField();
		txtRecogerNombre.setBounds(162, 66, 116, 20);
		frmAnadirAlimento.getContentPane().add(txtRecogerNombre);
		txtRecogerNombre.setColumns(10);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(Color.WHITE);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					/**
					 * CREAMOS LO QUE SER� EL NUEVO ALIMENTO AL PULSAR EL BOT�N
					 */
					String nombreAlimento = txtRecogerNombre.getText();
					double grasasEnNum = Double.valueOf(txtRecogerGrasas.getText());
					double grasasSatEnNum = Double.valueOf(txtRecogerGSat.getText());
					double hCarbEnNum = Double.valueOf(txtRecogerHCarb.getText());
					double azucarEnNum = Double.valueOf(txtRecogerAzucar.getText());
					double proteinasEnNum = Double.valueOf(txtRecogerProteinas.getText());
					double salEnNum = Double.valueOf(txtRecogerSal.getText());
					double kCalEnNum = Double.valueOf(txtRecogerKCal.getText());

					/**
					 * Comprobaci�n de que las grasas saturadas no superen las grasas normales y que el azucar no supere los hidratos de carbono 
					 */
					if (grasasSatEnNum > grasasEnNum) {
						JOptionPane.showMessageDialog(frmAnadirAlimento, "Las grasas saturadas no pueden ser mayores que las grasas", "Error", JOptionPane.ERROR_MESSAGE);
					}else if (azucarEnNum > hCarbEnNum) {
						JOptionPane.showMessageDialog(frmAnadirAlimento, "El azucar no puede ser mayor que los hidratos de carbono", "Error", JOptionPane.ERROR_MESSAGE);
					}else {
						nuevoAlimento = new Alimento(nombreAlimento, grasasEnNum, grasasSatEnNum, hCarbEnNum, azucarEnNum,proteinasEnNum,salEnNum,kCalEnNum);
						Ventana.comboNuevosAlimentos.addItem(nuevoAlimento);
						Ventana.comboNuevosAlimentos.setEnabled(true);
						frmAnadirAlimento.setVisible(false);
					}
				}

				catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(frmAnadirAlimento, "No pueden quedar campos vac�os y no se pueden introducir letras", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnGuardar.setBounds(140, 355, 89, 23);
		frmAnadirAlimento.getContentPane().add(btnGuardar);

		lblTitulo = new JLabel("A\u00F1adir alimento");
		lblTitulo.setForeground(Color.BLACK);
		lblTitulo.setFont(new Font("Bitstream Vera Serif", Font.PLAIN, 20));
		lblTitulo.setBounds(104, 12, 161, 23);
		frmAnadirAlimento.getContentPane().add(lblTitulo);

		btnAyuda = new JButton("?");
		btnAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frmAnadirAlimento, "Introduzca el nombre del alimento y sus valores nutricionales por cada 100gr", "Help", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnAyuda.setForeground(Color.BLACK);
		btnAyuda.setBackground(Color.WHITE);
		btnAyuda.setBounds(311, 376, 46, 22);
		frmAnadirAlimento.getContentPane().add(btnAyuda);

		JPanel panelValores = new JPanel();
		panelValores.setBackground(new Color(244, 238, 244));
		panelValores.setBounds(12, 112, 345, 231);
		frmAnadirAlimento.getContentPane().add(panelValores);
		panelValores.setLayout(null);

		txtRecogerGrasas = new JTextField();
		txtRecogerGrasas.setBounds(106, 12, 142, 20);
		panelValores.add(txtRecogerGrasas);
		txtRecogerGrasas.setColumns(10);

		txtRecogerGSat = new JTextField();
		txtRecogerGSat.setBounds(170, 44, 78, 20);
		panelValores.add(txtRecogerGSat);
		txtRecogerGSat.setColumns(10);

		txtRecogerHCarb = new JTextField();
		txtRecogerHCarb.setBounds(191, 76, 57, 20);
		panelValores.add(txtRecogerHCarb);
		txtRecogerHCarb.setColumns(10);

		txtRecogerAzucar = new JTextField();
		txtRecogerAzucar.setBounds(142, 105, 106, 20);
		panelValores.add(txtRecogerAzucar);
		txtRecogerAzucar.setColumns(10);

		txtRecogerProteinas = new JTextField();
		txtRecogerProteinas.setBounds(125, 137, 123, 20);
		panelValores.add(txtRecogerProteinas);
		txtRecogerProteinas.setColumns(10);

		txtRecogerSal = new JTextField();
		txtRecogerSal.setBounds(90, 166, 158, 20);
		panelValores.add(txtRecogerSal);
		txtRecogerSal.setColumns(10);

		txtRecogerKCal = new JTextField();
		txtRecogerKCal.setBounds(125, 198, 123, 20);
		panelValores.add(txtRecogerKCal);
		txtRecogerKCal.setColumns(10);

		JLabel lblGrasas = new JLabel("Grasas:");
		lblGrasas.setBounds(59, 15, 44, 14);
		panelValores.add(lblGrasas);

		JLabel lblGSat = new JLabel("G. Saturadas:");
		lblGSat.setBounds(90, 47, 83, 14);
		panelValores.add(lblGSat);

		JLabel lblHidCarb = new JLabel("Hidratos de Carbono:");
		lblHidCarb.setBounds(59, 79, 127, 14);
		panelValores.add(lblHidCarb);

		JLabel lblAzucar = new JLabel("Azucar:");
		lblAzucar.setBounds(90, 108, 46, 14);
		panelValores.add(lblAzucar);

		JLabel lblProteinas = new JLabel("Prote\u00EDnas:");
		lblProteinas.setBounds(59, 140, 66, 14);
		panelValores.add(lblProteinas);

		JLabel lblSal = new JLabel("Sal:");
		lblSal.setBounds(59, 169, 28, 14);
		panelValores.add(lblSal);

		JLabel lblKCal = new JLabel("KCalor\u00EDas:");
		lblKCal.setBounds(59, 201, 66, 14);
		panelValores.add(lblKCal);

		JLabel lblGramosGrasasS = new JLabel("g");
		lblGramosGrasasS.setBounds(252, 44, 14, 20);
		panelValores.add(lblGramosGrasasS);

		JLabel lblGramosAzucar = new JLabel("g");
		lblGramosAzucar.setBounds(252, 107, 14, 17);
		panelValores.add(lblGramosAzucar);

		JLabel lblGramosSal = new JLabel("g");
		lblGramosSal.setBounds(252, 168, 14, 17);
		panelValores.add(lblGramosSal);

		JLabel lblGramosGrasas = new JLabel("g");
		lblGramosGrasas.setBounds(252, 12, 14, 20);
		panelValores.add(lblGramosGrasas);

		JLabel lblGramosHidCarb = new JLabel("g");
		lblGramosHidCarb.setBounds(252, 78, 14, 17);
		panelValores.add(lblGramosHidCarb);

		JLabel lblGramosProteinas = new JLabel("g");
		lblGramosProteinas.setBounds(252, 139, 14, 17);
		panelValores.add(lblGramosProteinas);

		JLabel lblKcalKCalorias = new JLabel("kcal");
		lblKcalKCalorias.setBounds(252, 201, 37, 14);
		panelValores.add(lblKcalKCalorias);

		JPanel panelNombre = new JPanel();
		panelNombre.setBackground(new Color(244, 238, 244));
		panelNombre.setBounds(12, 55, 345, 39);
		frmAnadirAlimento.getContentPane().add(panelNombre);
	}
}
