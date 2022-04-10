/**
 * 
 */
package elements;

import primitives.Color;
import primitives.Double3;

/**
 * @author Yaakovah
 *
 */
public class AmbientLight { //AmbientLight is like the background light..Think light on phone that can be brightened
	
	Color intensity; //since this is artificial lighting, it is the same at every point
	
	
	public AmbientLight() {
		
		this.intensity = Color.BLACK;
	}

	/**
	 * @param color - the original color of the light (the intensity of the light according to RGB) - IA
	 * @param d - contains the attenuation factor of the original light - KA
	 */
	public AmbientLight(Color color, Double3 d) {
		// IP (intensity of a point) = KA * IA
		this.intensity = color.scale(d);
	}
	
	/**
	 * @return the value of the intensity of the ambient light (aka a Color)
	 */
	Color getIntensity(){
		return this.intensity;	
	}

}
