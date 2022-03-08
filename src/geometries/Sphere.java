package geometries;

import primitives.Point;
import primitives.Vector;

public class Sphere implements Geometry {
	final Point centre;
	final double radius;
	
	public Sphere(Point p, double r) {
		this.centre = p;
		this.radius = r;
	}
	
	@Override
	public Vector getNormal(Point point) {
		//return null; 
		Vector v = new Vector(point.xyz.subtract(centre));
		Vector u = v.normalize();
		return u;
		   
	}
	
	public Point getCentre() {
		return this.centre;
	}

	public double getRadius() {
		return this.radius;
	}
}
