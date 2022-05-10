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

	public static JFrame frame;
	private static ButtonGroup radios = new ButtonGroup();
	private static double altura;
	private static double peso;
	private static int edad;
	private static double actividadFisica;
	private JTextField txtResultadoIMC;
	private static JTextField txtCalBajarPeso;
	private static JTextField txtEdad;
	private static JRadioButton rdbtnMujer;
	private static JRadioButton rdbtnHombre;
	private static JTextField txtPeso;
	private static JTextField txtAltura;
	private JTextField txtCaloriasRecomendadas;
	private JTextField txtCalSubirPeso;
	private static JComboBox comboActividad;
	
	public Persona(double peso, double altura) {
		this.peso = peso;
		this.altura = altura;
	}

	public double getAltura() {
		return altura;
	}

	public double getPeso() {
		return peso;
	}

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
		frame.setBounds(100, 100, 588, 514);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(10, 25, 46, 14);
		frame.getContentPane().add(lblSexo);
		
		rdbtnMujer = new JRadioButton("Mujer");
		rdbtnMujer.setBounds(62, 21, 58, 23);
		rdbtnMujer.setBackground(new Color(216, 191, 216));
		frame.getContentPane().add(rdbtnMujer);
		radios.add(rdbtnMujer);
		
		rdbtnHombre = new JRadioButton("Hombre");
		rdbtnHombre.setBounds(122, 21, 71, 23);
		rdbtnHombre.setBackground(new Color(216, 191, 216));
		frame.getContentPane().add(rdbtnHombre);
		radios.add(rdbtnHombre);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setBounds(10, 67, 46, 14);
		frame.getContentPane().add(lblPeso);
		
		
		txtPeso = new JTextField();
		txtPeso.setBounds(62, 64, 46, 20);
		frame.getContentPane().add(txtPeso);
		txtPeso.setColumns(10);

		
		JLabel lblKGramos = new JLabel(" kg");
		lblKGramos.setBounds(115, 67, 21, 14);
		frame.getContentPane().add(lblKGramos);
		
		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setBounds(10, 107, 46, 14);
		frame.getContentPane().add(lblAltura);
		
		
		txtAltura = new JTextField();
		txtAltura.setBounds(62, 104, 46, 20);
		frame.getContentPane().add(txtAltura);
		txtAltura.setColumns(10);
		
		JLabel lblMetros = new JLabel("m");
		lblMetros.setBounds(115, 107, 46, 14);
		frame.getContentPane().add(lblMetros);
		
		
		JLabel lblActividad = new JLabel("Actividad f\u00EDsica:");
		lblActividad.setBounds(10, 192, 104, 14);
		frame.getContentPane().add(lblActividad);
		
		JLabel lblEjercicioXSemana = new JLabel("");
		lblEjercicioXSemana.setBounds(218, 192, 227, 14);
		frame.getContentPane().add(lblEjercicioXSemana);
		
		comboActividad = new JComboBox();
		actividadFisica = 1.2;
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
		comboActividad.setBounds(115, 188, 93, 22);
		frame.getContentPane().add(comboActividad);
		
		JLabel lblIMC = new JLabel("IMC:");
		lblIMC.setBounds(10, 235, 46, 14);
		frame.getContentPane().add(lblIMC);
		
		JLabel lblEstadoIMC = new JLabel("");
		lblEstadoIMC.setBounds(122, 235, 126, 14);
		frame.getContentPane().add(lblEstadoIMC);
		
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
					if (resultadoIMC < 18.5) {
						lblEstadoIMC.setText("Peso insuficiente");
						lblEstadoIMC.setForeground(new Color(220,20,60));
					}else if (resultadoIMC >= 18.5 && resultadoIMC <= 24.9) {
						lblEstadoIMC.setText("Peso saludable");
						lblEstadoIMC.setForeground(new Color(34,139,34));
					}else if (resultadoIMC >= 25.0 && resultadoIMC <= 29.9) {
						lblEstadoIMC.setText("Sobrepeso");
						lblEstadoIMC.setForeground(new Color(255,140,0));
					}else if (resultadoIMC > 30.0) {
						lblEstadoIMC.setText("Obesidad");
						lblEstadoIMC.setForeground(new Color(220,20,60));
					}

				}
			}
		});
		btnCalcularIMC.setBounds(10, 272, 110, 23);
		frame.getContentPane().add(btnCalcularIMC);
		
		txtResultadoIMC = new JTextField();
		txtResultadoIMC.setEditable(false);
		txtResultadoIMC.setBounds(62, 232, 46, 20);
		frame.getContentPane().add(txtResultadoIMC);
		txtResultadoIMC.setColumns(10);
		
		txtCalBajarPeso = new JTextField();
		txtCalBajarPeso.setVisible(false);
		txtCalBajarPeso.setEditable(false);
		txtCalBajarPeso.setBounds(227, 405, 93, 20);
		frame.getContentPane().add(txtCalBajarPeso);
		txtCalBajarPeso.setColumns(10);
	
		JLabel lblKCalAdecuadas = new JLabel("Seg\u00FAn sus datos, deber\u00EDa consumir:");
		lblKCalAdecuadas.setVisible(false);
		lblKCalAdecuadas.setBounds(10, 376, 214, 17);
		frame.getContentPane().add(lblKCalAdecuadas);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(10, 148, 46, 14);
		frame.getContentPane().add(lblEdad);
		
		txtEdad = new JTextField();
		txtEdad.setBounds(62, 145, 46, 20);
		frame.getContentPane().add(txtEdad);
		txtEdad.setColumns(10);
		
		JLabel lblMantenerPeso = new JLabel("para mantener su peso.");
		lblMantenerPeso.setVisible(false);
		lblMantenerPeso.setBounds(330, 377, 141, 14);
		frame.getContentPane().add(lblMantenerPeso);
		
		txtCaloriasRecomendadas = new JTextField();
		txtCaloriasRecomendadas.setVisible(false);
		txtCaloriasRecomendadas.setEditable(false);
		txtCaloriasRecomendadas.setBounds(227, 374, 93, 20);
		frame.getContentPane().add(txtCaloriasRecomendadas);
		txtCaloriasRecomendadas.setColumns(10);
		
		JLabel lblBajarPeso = new JLabel("para bajar su peso.");
		lblBajarPeso.setVisible(false);
		lblBajarPeso.setBounds(330, 408, 115, 14);
		frame.getContentPane().add(lblBajarPeso);
		
		txtCalSubirPeso = new JTextField();
		txtCalSubirPeso.setVisible(false);
		txtCalSubirPeso.setEditable(false);
		txtCalSubirPeso.setBounds(227, 436, 93, 20);
		frame.getContentPane().add(txtCalSubirPeso);
		txtCalSubirPeso.setColumns(10);
		
		JLabel lblSubirPeso = new JLabel("para subir su peso.");
		lblSubirPeso.setVisible(false);
		lblSubirPeso.setBounds(330, 439, 115, 14);
		frame.getContentPane().add(lblSubirPeso);

		JButton btnRecordatorio = new JButton("?");
		btnRecordatorio.setVisible(false);
		btnRecordatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "Estas indicaciones aplican sobre una persona media, si tiene alguna patología o condición, consulte un doctor", "Recordatorio", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnRecordatorio.setBounds(487, 404, 46, 23);
		frame.getContentPane().add(btnRecordatorio);
		
		JButton btnCalcularKCalAdecuadas = new JButton("<html><body align=center>Calcular KCal<br>Adecuadas</body></html>");
		btnCalcularKCalAdecuadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if (txtPeso.getText().equals("") || txtAltura.getText().equals("") || txtEdad.getText().equals("") || (!rdbtnMujer.isSelected() && !rdbtnHombre.isSelected()))
				{
					if (txtPeso.getText().equals("")) {
						JOptionPane.showMessageDialog(frame, "El peso no puede estar vacio", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					
					if (txtAltura.getText().equals("")) {
						JOptionPane.showMessageDialog(frame, "La altura no puede estar vacia", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					
					if (txtEdad.getText().equals("")) {
						JOptionPane.showMessageDialog(frame, "La edad no puede estar vacia", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					
					if (!rdbtnMujer.isSelected() && !rdbtnHombre.isSelected()) {
						JOptionPane.showMessageDialog(frame, "Debe seleccionar su sexo", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					
				}else {
					lblKCalAdecuadas.setVisible(true);
					txtCaloriasRecomendadas.setVisible(true);
					lblMantenerPeso.setVisible(true);
					txtCalBajarPeso.setVisible(true);
					lblBajarPeso.setVisible(true);
					txtCalSubirPeso.setVisible(true);
					lblSubirPeso.setVisible(true);
					btnRecordatorio.setVisible(true);
					txtCaloriasRecomendadas.setText(String.valueOf(calcularCaloriasAdecuadas()) + " Cal");
					txtCalBajarPeso.setText(String.valueOf(calcularCaloriasAdelgazar()) + " Cal");
					txtCalSubirPeso.setText(String.valueOf(calcularCaloriasEngordar()) + " Cal");
				}	
			}
		});
		btnCalcularKCalAdecuadas.setBounds(10, 306, 110, 51);
		frame.getContentPane().add(btnCalcularKCalAdecuadas);
		
		
	
	}
	
	private static double calcularCaloriasAdecuadas() {
			peso=Double.valueOf(txtPeso.getText());
			altura=Double.valueOf(txtAltura.getText());
			edad= Integer.valueOf(txtEdad.getText());
			rdbtnHombre.setActionCommand("Hombre");
			rdbtnMujer.setActionCommand("Mujer");
			double caloriasSinRedondear = 0;
			double caloriasAdecuadas;
			
			if (radios.getSelection().getActionCommand().equals("Hombre")) {
				caloriasSinRedondear = (88 + (13.4 * peso) + (4.8 * (altura*100)) - (5.7 * edad)) * actividadFisica;
				caloriasAdecuadas = Math.round(caloriasSinRedondear*100.00)/100.00;
			}else {
				caloriasSinRedondear = (448 + (9.3 * peso) + (3.1 * (altura*100)) - (4.3 * edad)) * actividadFisica;
				caloriasAdecuadas = Math.round(caloriasSinRedondear*100.00)/100.00;
			}
			return caloriasAdecuadas;
		}
		
	private static double calcularCaloriasAdelgazar() {
		double caloriasAdelgazar = calcularCaloriasAdecuadas()*0.85;
		double caloriasAdelgazarRedondeado = Math.round(caloriasAdelgazar*100.00)/100.00;
		return caloriasAdelgazarRedondeado;
	}
	
	private static double calcularCaloriasEngordar() {
		double caloriasEngordar = calcularCaloriasAdecuadas() + (calcularCaloriasAdecuadas()*0.15);
		double caloriasEngordarRedondeado = Math.round(caloriasEngordar*100.00)/100.00;
		return caloriasEngordarRedondeado;
	}
}

