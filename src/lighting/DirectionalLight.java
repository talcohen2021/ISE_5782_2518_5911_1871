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
public class DirectionalLight extends Light implements LightSource {

	private Vector direction;
	
	public DirectionalLight(Color intensity, Vector direction) throws Exception {
		super(intensity);
		this.direction = direction.normalize();
	}
	
	@Override
	public Color getIntensity(Point p) {
		return super.getIntensity();
	}

	@Override
	public Vector getL(Point p) {
		return direction;
	}

}
