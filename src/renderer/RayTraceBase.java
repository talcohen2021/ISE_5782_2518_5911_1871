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
	
	protected Scene scene;

	/**
	 * 
	 */
	public RayTraceBase(Scene s) {
		this.scene = scene;
	}
	
	public Scene getScene() {return scene;}
	/**
	 * @param ray
	 * @return color
	 */
	public abstract Color traceRay(Ray ray);
	

}


