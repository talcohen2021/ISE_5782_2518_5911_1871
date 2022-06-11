/**
 * 
 */
package renderer;

import primitives.Color;
import primitives.Ray;
import scene.Scene;

/**
 * @author Yaakovah, meira, Tali
 *
 */
public abstract class RayTraceBase {
	
	protected Scene scene;

	
	public RayTraceBase(Scene s) {
		this.scene = s;
	}
	
	public Scene getScene() {return scene;}
	
	public abstract Color traceRay(Ray ray) throws Exception;
	

}


