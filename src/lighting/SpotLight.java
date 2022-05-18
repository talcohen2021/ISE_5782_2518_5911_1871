/**
 * 
 */
package lighting;

import primitives.Color;
import primitives.Double3;
import primitives.Point;
import primitives.Vector;

import static primitives.Util.*;

/**
 * @author Yaakovah
 *
 */
public class SpotLight extends PointLight {

	private Vector direction;
	
	/**
	 * 
	 * @param intensity
	 * @param position
	 * @param kC
	 * @param kL
	 * @param kQ
	 * @param direction
	 */
	public SpotLight(Color intensity, Point position, double kC, double kL, double kQ, Vector direction) {
		super(intensity, position, kC, kL, kQ);
		this.direction = direction;
	}

	@Override
	public Color getIntensity(Point p) {
		return super.getIntensity(p).scale(direction.dotProduct(getL(p)));
		
	}
	
	
	
}
