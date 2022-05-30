package primitives;


public class Material {

	/**
	 * diffuse
	 */
	public Double3 kD;
	/**
	 * specular
	 */
	public Double3 kS;
	/**
	 * shininess
	 */
	public int shininess;
	/**
	 * transparency coefficient
	 */
	public Double3 kT;
	/**
	 * reflection coefficient
	 */
	public Double3 kR;
	
	
	public Material() {
		kD = Double3.ZERO;
		kS = Double3.ZERO;
		shininess = 0;
		kT = Double3.ZERO;
		kR = Double3.ZERO;
	}
	
	/**
	 * setter
	 * @param kD
	 * @return this
	 */
	public Material setKD(Double3 kD) {
		this.kD = kD;
		return this;
	}
	/**
	 * setter with double
	 * @param kD
	 * @return this
	 */
	public Material setKD(double kD) {
		this.kD = new Double3(kD);
		return this;
	}
	
	/**
	 * setter
	 * @param kS
	 * @return this
	 */
	public Material setKS(Double3 kS) {
		this.kS = kS;
		return this;
	}
	
	/**
	 * setter with double
	 * @param kS
	 * @return this
	 */
	public Material setKS(double kS) {
		this.kS = new Double3(kS);
		return this;
	}
	
	/**
	 * setter
	 * @param nShininess
	 * @return this
	 */
	public Material setShininess(int shininess) {
		this.shininess = shininess;
		return this;
	}
	
	/**
	 * setter
	 * @param kT transparency coeff
	 * @return this
	 */
	public Material setKT(Double3 kT) {
		this.kT = kT;
		return this;
	}
	
	/**
	 * setter
	 * @param kR reflection coeff
	 * @return this
	 */
	public Material setKR(Double3 kR) {
		this.kR = kR;
		return this;
	}
	
	
}
