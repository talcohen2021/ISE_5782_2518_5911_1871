package geometries;

import primitives.Point;
import primitives.Vector;

public class Sphere implements Geometry {
	final Point centre;
	final double radius;
	
	@Override
	public Vector getNormal(Point point) {
		return null;
		/* Maybe?
		 * 
		 * Vector v = new Vector(point.xyz.subtract(centre));
		 * Vector u = v.normalize();
		 * return u;
		 * 
		 */
	}

}
