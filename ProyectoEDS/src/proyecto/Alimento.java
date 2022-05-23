/* Clase Alimento  
	Versión 1.3
	2022-03-30
 */

package proyecto;

/**
 * 
 * @author restr, AlexVP, AlexMP
 *
 */

public class Alimento {
	protected String nombre;
	protected double grasas;
	protected double grasasSat;
	protected double hidratosCarbono;
	protected double azucar;
	protected double proteinas;
	protected double sal;
	protected double kiloCalorias;

	/**
	 * Crea un alimento recibiendo como parametro valores nutricionales
	 * 
	 * @param nombre
	 * @param grasas
	 * @param grasasSat
	 * @param hidratosCarbono
	 * @param azucar
	 * @param proteinas
	 * @param sal
	 * @param kiloCalorias
	 */
	Alimento (String nombre, double grasas, double grasasSat, double hidratosCarbono, double azucar, double proteinas, double sal, double kiloCalorias){
		this.nombre = nombre;
		this.grasas = grasas;
		this.grasasSat = grasasSat;
		this.hidratosCarbono = hidratosCarbono;
		this.azucar = azucar;
		this.proteinas = proteinas;
		this.sal = sal;
		this.kiloCalorias = kiloCalorias;
	}

	public String getNombre() {
		return nombre;
	}

	public double getGrasas() {
		return grasas;
	}

	public double getGrasasSat() {
		return grasasSat;
	}

	public double getHidratosCarbono() {
		return hidratosCarbono;
	}

	public double getAzucar() {
		return azucar;
	}

	public double getProteinas() {
		return proteinas;
	}

	public double getSal() {
		return sal;
	}

	public double getKiloCalorias() {
		return kiloCalorias;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setGrasas(double grasas) {
		this.grasas = grasas;
	}

	public void setGrasasSat(double grasasSat) {
		this.grasasSat = grasasSat;
	}

	public void setHidratosCarbono(double hidratosCarbono) {
		this.hidratosCarbono = hidratosCarbono;
	}

	public void setAzucar(double azucar) {
		this.azucar = azucar;
	}

	public void setProteinas(double proteinas) {
		this.proteinas = proteinas;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}

	public void setCalorias(double calorias) {
		this.kiloCalorias = calorias;

	}

	@Override
	public String toString() {
		return nombre;
	}

	
}