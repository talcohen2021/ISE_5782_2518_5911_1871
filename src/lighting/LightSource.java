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
public interface LightSource {

	public Color getIntensity(Point p);
	public Vector getL(Point p) throws Exception;

}
