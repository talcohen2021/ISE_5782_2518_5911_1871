package geometries;

import java.util.List;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

public class Sphere implements Geometry {
	final Point centre;
	final double radius;
	
	public Sphere(Point p, double r) {
		this.centre = p;
		this.radius = r;
	}
	
	@Override
	public Vector getNormal(Point point) throws Exception {
		//return null; 
		Vector v ;
		v = point.subtract(centre);
		Vector u = v.normalize();
		return u;
		   
	}
	
	public Point getCentre() {
		return this.centre;
	}

	public double getRadius() {
		return this.radius;
	}

	@Override
	public List<Point> findIntsersections(Ray ray) {
		// TODO Auto-generated method stub
		return null;
	}
}
