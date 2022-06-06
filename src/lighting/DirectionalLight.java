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
public class DirectionalLight extends Light implements LightSource {

	private Vector direction;
	
	/**
	 * 
	 * @param intensity
	 * @param direction
	 * @throws Exception
	 */
	public DirectionalLight(Color intensity, Vector direction) throws Exception {
		super(intensity);
		this.direction = direction;
	}
	
	
	@Override
	public Color getIntensity(Point p) {
		return super.getIntensity();
	}

	@Override
	public Vector getL(Point p) {
		return direction.normalize();
	}

	public double getDistance(Point point)
	{
		return Double.POSITIVE_INFINITY;
	}
}
