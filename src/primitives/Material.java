package primitives;


public class Material {

	public Double3 kD; //diffuse
	public Double3 kS; //specular
	public int shininess;
	
	public Material() {
		kD = Double3.ZERO;
		kS = Double3.ZERO;
		shininess = 0;
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
	
	
}
