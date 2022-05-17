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
public class SpotLight extends PointLight {

	private Vector direction;
	/**
	 * @param intensity
	 */
	public SpotLight(Color intensity, Point position, double kC, double kL, double kQ, Vector direction) {
		super(intensity, position, kC, kL, kQ);
		this.direction = direction;
		
		// TODO Auto-generated constructor stub
	}

}
