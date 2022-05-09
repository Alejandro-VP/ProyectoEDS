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
		frmAnadirAlimento.setBounds(100, 100, 693, 437);
		frmAnadirAlimento.getContentPane().setLayout(null);
		frmAnadirAlimento.getContentPane().setBackground(new Color(216, 191, 216));

		JLabel lblNombreAlimento = new JLabel("Nombre:");
		lblNombreAlimento.setBounds(63, 77, 76, 14);
		frmAnadirAlimento.getContentPane().add(lblNombreAlimento);

		txtRecogerNombre = new JTextField();
		txtRecogerNombre.setBounds(140, 77, 113, 20);
		frmAnadirAlimento.getContentPane().add(txtRecogerNombre);
		txtRecogerNombre.setColumns(10);

		txtRecogerGrasas = new JTextField();
		txtRecogerGrasas.setBounds(507, 77, 113, 20);
		frmAnadirAlimento.getContentPane().add(txtRecogerGrasas);
		txtRecogerGrasas.setColumns(10);

		txtRecogerGSat = new JTextField();
		txtRecogerGSat.setBounds(140, 127, 113, 20);
		frmAnadirAlimento.getContentPane().add(txtRecogerGSat);
		txtRecogerGSat.setColumns(10);

		txtRecogerHCarb = new JTextField();
		txtRecogerHCarb.setBounds(507, 127, 113, 20);
		frmAnadirAlimento.getContentPane().add(txtRecogerHCarb);
		txtRecogerHCarb.setColumns(10);

		txtRecogerAzucar = new JTextField();
		txtRecogerAzucar.setBounds(140, 179, 113, 20);
		frmAnadirAlimento.getContentPane().add(txtRecogerAzucar);
		txtRecogerAzucar.setColumns(10);

		txtRecogerProteinas = new JTextField();
		txtRecogerProteinas.setBounds(507, 179, 113, 20);
		frmAnadirAlimento.getContentPane().add(txtRecogerProteinas);
		txtRecogerProteinas.setColumns(10);

		txtRecogerSal = new JTextField();
		txtRecogerSal.setBounds(140, 238, 113, 20);
		frmAnadirAlimento.getContentPane().add(txtRecogerSal);
		txtRecogerSal.setColumns(10);

		txtRecogerKCal = new JTextField();
		txtRecogerKCal.setBounds(507, 238, 113, 20);
		frmAnadirAlimento.getContentPane().add(txtRecogerKCal);
		txtRecogerKCal.setColumns(10);

		JLabel lblGrasas = new JLabel("Grasas:");
		lblGrasas.setBounds(430, 80, 76, 14);
		frmAnadirAlimento.getContentPane().add(lblGrasas);

		JLabel lblGSat = new JLabel("G. Saturadas:");
		lblGSat.setBounds(42, 130, 97, 14);
		frmAnadirAlimento.getContentPane().add(lblGSat);

		JLabel lblHidCarb = new JLabel("Hidratos de Carbono:");
		lblHidCarb.setBounds(379, 130, 127, 14);
		frmAnadirAlimento.getContentPane().add(lblHidCarb);

		JLabel lblAzucar = new JLabel("Azucar:");
		lblAzucar.setBounds(70, 179, 73, 14);
		frmAnadirAlimento.getContentPane().add(lblAzucar);

		JLabel lblProteinas = new JLabel("Prote\u00EDnas:");
		lblProteinas.setBounds(427, 182, 83, 14);
		frmAnadirAlimento.getContentPane().add(lblProteinas);

		JLabel lblSal = new JLabel("Sal:");
		lblSal.setBounds(85, 241, 58, 14);
		frmAnadirAlimento.getContentPane().add(lblSal);

		JLabel lblKCal = new JLabel("KCalor\u00EDas:");
		lblKCal.setBounds(421, 241, 89, 14);
		frmAnadirAlimento.getContentPane().add(lblKCal);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(Color.WHITE);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					/**
					 * CREAMOS LO QUE SERÁ EL NUEVO ALIMENTO AL PULSAR EL BOTÓN
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
					 * Comprobación de que las grasas saturadas no superen las grasas normales y que el azucar no supere los hidratos de carbono 
					 */
					if (grasasSatEnNum > grasasEnNum) {
						JOptionPane.showMessageDialog(frmAnadirAlimento, "Las grasas saturadas no pueden ser mayores que las grasas", "Error", JOptionPane.ERROR_MESSAGE);
					}else if (azucarEnNum > hCarbEnNum) {
						JOptionPane.showMessageDialog(frmAnadirAlimento, "El azucar no puede ser mayor que los hidratos de carbono", "Error", JOptionPane.ERROR_MESSAGE);
					}else {
						nuevoAlimento = new Alimento(nombreAlimento, grasasEnNum, grasasSatEnNum, hCarbEnNum, azucarEnNum,proteinasEnNum,salEnNum,kCalEnNum);
						Ventana.comboNuevosAlimentos.addItem(nuevoAlimento);
						Ventana.comboNuevosAlimentos.setEnabled(true);
					}
				}

				catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(frmAnadirAlimento, "No pueden quedar campos vacíos y no se pueden introducir letras", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnGuardar.setBounds(299, 328, 89, 23);
		frmAnadirAlimento.getContentPane().add(btnGuardar);

		lblTitulo = new JLabel("A\u00F1adir alimento");
		lblTitulo.setForeground(new Color(123, 104, 238));
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitulo.setBounds(268, 21, 145, 23);
		frmAnadirAlimento.getContentPane().add(lblTitulo);
		
		btnAyuda = new JButton("?");
		btnAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frmAnadirAlimento, "Introduzca el nombre del alimento y sus valores nutricionales por cada 100gr", "Help", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnAyuda.setForeground(Color.BLACK);
		btnAyuda.setBackground(Color.WHITE);
		btnAyuda.setBounds(625, 369, 46, 22);
		frmAnadirAlimento.getContentPane().add(btnAyuda);
		
		JLabel lblGramosGrasasS = new JLabel("g");
		lblGramosGrasasS.setBounds(263, 130, 14, 14);
		frmAnadirAlimento.getContentPane().add(lblGramosGrasasS);
		
		JLabel lblGramosAzucar = new JLabel("g");
		lblGramosAzucar.setBounds(263, 182, 14, 14);
		frmAnadirAlimento.getContentPane().add(lblGramosAzucar);
		
		JLabel lblGramosSal = new JLabel("g");
		lblGramosSal.setBounds(263, 241, 14, 14);
		frmAnadirAlimento.getContentPane().add(lblGramosSal);
		
		JLabel lblGramosGrasas = new JLabel("g");
		lblGramosGrasas.setBounds(630, 83, 14, 14);
		frmAnadirAlimento.getContentPane().add(lblGramosGrasas);
		
		JLabel lblGramosHidCarb = new JLabel("g");
		lblGramosHidCarb.setBounds(630, 130, 14, 14);
		frmAnadirAlimento.getContentPane().add(lblGramosHidCarb);
		
		JLabel lblGramosProteinas = new JLabel("g");
		lblGramosProteinas.setBounds(630, 182, 14, 14);
		frmAnadirAlimento.getContentPane().add(lblGramosProteinas);
		
		JLabel lblKcalKCalorias = new JLabel("kcal");
		lblKcalKCalorias.setBounds(630, 241, 37, 14);
		frmAnadirAlimento.getContentPane().add(lblKcalKCalorias);
	}
}
