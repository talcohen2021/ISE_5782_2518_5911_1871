/**
 * 
 */
package lighting;

import primitives.Color;
import primitives.Point;
import primitives.Vector;

/**
 * @author Yaakovah, Meira, Tali
 *
 */
public class PointLight extends Light implements LightSource {

	private Point position;
	private double kC, kL, kQ;
	
	/**
	 * 
	 * @param intensity
	 * @param position
	 * @param kC
	 * @param kL
	 * @param kQ
	 */
	public PointLight(Color intensity, Point position, double kC, double kL, double kQ) {
		super(intensity);
		this.position = position;
		this.kC = kC;
		this.kL = kL;
		this.kQ = kQ;
		
	}
	
	/**
	 * 
	 * @param intensity
	 * @param position
	 */
	public PointLight(Color intensity, Point position) {
		super(intensity);
		this.position = position;
		kC = 1;
		kL = 0;
		kQ = 0;
				
	}
	
	public PointLight setKC(double kC) {
		this.kC = kC;
		return this;
	}
	
	public PointLight setKL(double kL) {
		this.kL = kL;
		return this;
	}
	public PointLight setKQ(double kQ) {
		this.kQ = kQ;
		return this;
	}
	
	

	@Override
	public Color getIntensity(Point p) {
		double d = position.distance(p);
	    return (getIntensity().reduce(kC + (d*kL) + (d*kQ) * d));
	}

	@Override
	public Vector getL(Point p) {
		if ( p.equals(position))
			return null;
		try {

			return p.subtract(position).normalize();
		}
		catch(Exception e) {
			System.out.println("there's an exception here");
		}
		return null;
	}

}
