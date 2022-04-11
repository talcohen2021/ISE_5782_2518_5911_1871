/**
 * 
 */
package renderer;

import primitives.Color;
import primitives.Ray;
import scene.Scene;

/**
 * @author Yaakovah
 *
 */
public abstract class RayTraceBase {
	
	protected Scene s;

	/**
	 * 
	 */
	public RayTraceBase(Scene s) {
		this.s = s;
	}
	
	/**
	 * @param ray
	 * @return color
	 */
	public abstract Color traceRay(Ray ray);

}


