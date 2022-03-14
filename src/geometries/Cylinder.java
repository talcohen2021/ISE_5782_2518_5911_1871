package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

public class Cylinder extends Tube{
	
	final double height;
	
	public Cylinder(Ray axisRay, double radius, double height) {
		super(axisRay, radius);
		this.height = height;
	}
	
	@Override
	public Vector getNormal(Point point) throws Exception {
		return super.getNormal(point);
	}
	
	/**
	 * @brief returns the normal at the base of the cylinder., we don't have to normalize it because it is already
	 * Normalised in the constructor of Ray
	 * 
	 * @return the normal at the base
	 */
	public Vector getNormalTop() {
		return this.axisRay.getDir(); 
	}
	
	public Vector getNormalBase() throws Exception {
		return this.axisRay.getDir().scale(-1); 
	}

}

