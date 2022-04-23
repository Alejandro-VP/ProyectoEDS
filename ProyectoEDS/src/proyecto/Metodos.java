package proyecto;

import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

public class Metodos {

	public static void comprobarCheck(JCheckBox checkbox, JTextField textfield) {
		if (checkbox.isSelected()) {
			textfield.setEnabled(true);
		}
		else {
			textfield.setEnabled(false);
		}
	}

}
