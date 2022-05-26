/**
 * 
 */
package lighting;

import primitives.Color;

/**
 * @author Yaakovah, Meira, Tali
 *
 */
public class Light {
	
	private Color intensity; //since this is artificial lighting, it is the same at every point
	
	/**
	 * @param intensity - the color to set intensity to
	 */
	protected Light(Color intensity) {
		this.intensity = intensity;
	}

	public Color getIntensity()
	{
		return intensity;
	}
}
