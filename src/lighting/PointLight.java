/**
 * 
 */
package lighting;

import primitives.Color;
import primitives.Point;
import primitives.Vector;

/**
 * @author Yaakovah
 *
 */
public class PointLight extends Light implements LightSource {

	/**
	 * @param intensity
	 */
	public PointLight(Color intensity) {
		super(intensity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Color getIntensity(Point p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector getL(Point p) {
		// TODO Auto-generated method stub
		return null;
	}

}
