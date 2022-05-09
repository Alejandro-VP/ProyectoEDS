package proyecto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.TextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Persona {

	public JFrame frame;
	private ButtonGroup radios = new ButtonGroup();
	private int sexo;
	private double altura;
	private double peso;
	private double actividadFisica;
	private JTextField txtResultadoIMC;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Persona window = new Persona();
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
	public Persona() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(216, 191, 216));
		frame.setBounds(100, 100, 645, 441);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(10, 46, 46, 14);
		frame.getContentPane().add(lblSexo);
		
		JRadioButton rdbtnMujer = new JRadioButton("Mujer");
		rdbtnMujer.setBounds(62, 42, 58, 23);
		rdbtnMujer.setBackground(new Color(216, 191, 216));
		frame.getContentPane().add(rdbtnMujer);
		radios.add(rdbtnMujer);
		
		JRadioButton rdbtnHombre = new JRadioButton("Hombre");
		rdbtnHombre.setBounds(122, 42, 71, 23);
		rdbtnHombre.setBackground(new Color(216, 191, 216));
		frame.getContentPane().add(rdbtnHombre);
		radios.add(rdbtnHombre);
		
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setBounds(10, 88, 46, 14);
		frame.getContentPane().add(lblPeso);
		
		
		JTextField txtPeso = new JTextField();
		txtPeso.setBounds(62, 85, 46, 20);
		frame.getContentPane().add(txtPeso);
		txtPeso.setColumns(10);

		
		JLabel lblKGramos = new JLabel(" kg");
		lblKGramos.setBounds(115, 88, 21, 14);
		frame.getContentPane().add(lblKGramos);
		
		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setBounds(10, 128, 46, 14);
		frame.getContentPane().add(lblAltura);
		
		
		JTextField txtAltura = new JTextField();
		txtAltura.setBounds(62, 125, 46, 20);
		frame.getContentPane().add(txtAltura);
		txtAltura.setColumns(10);
		
		JLabel lblMetros = new JLabel("m");
		lblMetros.setBounds(115, 128, 46, 14);
		frame.getContentPane().add(lblMetros);
		
		
		JLabel lblActividad = new JLabel("Actividad f\u00EDsica:");
		lblActividad.setBounds(10, 166, 104, 14);
		frame.getContentPane().add(lblActividad);
		
		JLabel lblEjercicioXSemana = new JLabel("");
		lblEjercicioXSemana.setBounds(218, 166, 227, 14);
		frame.getContentPane().add(lblEjercicioXSemana);
		
		JComboBox comboActividad = new JComboBox();
		comboActividad.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int indiceCombo=comboActividad.getSelectedIndex();
				switch (indiceCombo)
				{
				case 0:
						actividadFisica=1.2;
						lblEjercicioXSemana.setText("");
				break;
				case 1:
						actividadFisica=1.375;
						lblEjercicioXSemana.setText("1-3 veces por semana");
				break;
				case 2:
						actividadFisica=1.55;
						lblEjercicioXSemana.setText("4-5 veces por semana");
				break;
				case 3:
						actividadFisica=1.725;
						lblEjercicioXSemana.setText("6-7 veces por semana");
				break;
				}
			
			}
		});
		comboActividad.setBackground(Color.WHITE);
		comboActividad.setModel(new DefaultComboBoxModel(new String[] {"Ninguna", "Leve", "Moderada", "Intensa"}));
		comboActividad.setBounds(115, 162, 93, 22);
		frame.getContentPane().add(comboActividad);
		
		
		JLabel lblIMC = new JLabel("IMC:");
		lblIMC.setBounds(10, 209, 46, 14);
		frame.getContentPane().add(lblIMC);
		
		JButton btnCalcularIMC = new JButton("Calcular IMC");
		btnCalcularIMC.setBackground(Color.WHITE);
		btnCalcularIMC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (txtPeso.getText().equals("") || txtAltura.getText().equals(""))
				{
					JOptionPane.showMessageDialog(frame, "El peso y la altura no pueden estar vacios", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					peso=Double.valueOf(txtPeso.getText());
					altura=Double.valueOf(txtAltura.getText());
					double resultadoIMC=Math.round((peso/Math.pow(altura, 2))*100.00)/100.00;
					txtResultadoIMC.setText(Double.toString(resultadoIMC));
				}
			}
		});
		btnCalcularIMC.setBounds(10, 235, 110, 23);
		frame.getContentPane().add(btnCalcularIMC);
		
		txtResultadoIMC = new JTextField();
		txtResultadoIMC.setEditable(false);
		txtResultadoIMC.setBounds(62, 206, 46, 20);
		frame.getContentPane().add(txtResultadoIMC);
		txtResultadoIMC.setColumns(10);
		
		
	}
}
