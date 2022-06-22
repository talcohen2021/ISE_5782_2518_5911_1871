/**
 * 
 */
package renderer;

import java.util.List;

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
	
	/**
	 * 
	 * @param ray
	 * @return color of the intersection point of the ray
	 * @throws Exception
	 */
	public abstract Color traceRay(Ray ray) throws Exception;
	
	/**
	 * 
	 * @param rays
	 * @return average of the colors at the intersection points of the rays
	 * @throws Exception
	 */
	public abstract Color traceRaySuperSample(List<Ray> rays) throws Exception;
	
	/**
	 *
	 * @param ray = original ray from pixel to picture
	 * @return if the point that the ray intersects is in the conservative bounding region
	 * @throws Exception
	 */
	public abstract boolean inConservativeBoundingRegion(Ray ray) throws Exception;

}


